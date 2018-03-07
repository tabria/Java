package app.waste_disposal.engines;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.*;
import app.waste_disposal.enums.WasteList;
import app.waste_disposal.factories.DisposalStrategyFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Engine implements Runnable {

    private static final String WASTE_PATH = "app.waste_disposal.models.wastes.";
    private static final String EXIT_COMMAND = "TimeToRecycle";
    private static final double START_ENERGY = 0;
    private static final double START_CAPITAL = 0;

    private double energy;
    private double capital;
    private GarbageProcessor garbageProcessor;
    private Interpreter interpreter;
    private Manageble manageble;

    public Engine(GarbageProcessor garbageProcessor, Interpreter interpreter) {
        this.energy = START_ENERGY;
        this.capital = START_CAPITAL;
        this.garbageProcessor = garbageProcessor;
        this.interpreter = interpreter;
        this.manageble = null;
    }

    public double getEnergy() {
        return this.energy;
    }

    public double getCapital() {
        return this.capital;
    }

    public GarbageProcessor getGarbageProcessor() {
        return this.garbageProcessor;
    }

    public Manageble getManageble() {
        return this.manageble;
    }

    @Override
    public void run() {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            this.fillStrategyHolder();

            while(true){

                String line = reader.readLine();
                if (EXIT_COMMAND.equals(line)) {
                    break;
                }

                Executable command = this.interpreter.makeCommand(line, this);
                System.out.println(command.execute());
            }



        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | IOException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void fillStrategyHolder() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        for (WasteList waste:WasteList.values()) {
            String wasteType = waste.toString();
            GarbageDisposalStrategy garbageStrategy = DisposalStrategyFactory.create(wasteType);
            Annotation[] strategyAnnotations = Class.forName(WASTE_PATH + wasteType).getDeclaredAnnotations();
            Class disposableAnnotation = null;
            outerLoop:
            for (Annotation annotation : strategyAnnotations ) {
                Annotation[] annotations = annotation.annotationType().getAnnotations();
                for (Annotation ano:annotations) {
                    if(Disposable.class == ano.annotationType()){
                        disposableAnnotation = annotation.annotationType();
                        break outerLoop;
                    }
                }
            }
            this.garbageProcessor.getStrategyHolder().addStrategy(disposableAnnotation, garbageStrategy);
        }

    }

}
