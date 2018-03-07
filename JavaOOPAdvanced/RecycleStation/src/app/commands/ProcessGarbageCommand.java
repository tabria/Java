package app.commands;

import app.core.BalanceManager;
import app.factories.GarbageStrategyFactory;
import app.factories.WasteFactory;
import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.annotations.InjectBalance;
import app.waste_disposal.annotations.InjectGarbageProcessor;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ProcessGarbageCommand extends BaseCommand {

    private static final String GARBAGE_NOT_DISPOSABLE = "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.";

    private static final String GARBAGE_SUCCESS = "%.2f kg of %s successfully processed!";


    @InjectGarbageProcessor
    private GarbageProcessor garbageProcessor;
    @InjectBalance
    private BalanceManager balanceManager;


    @Override
    public String execute(String... args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String garbageName = args[0];
        double garbageWeight = Double.parseDouble(args[1]);

        Waste newWaste = WasteFactory.create(args);

        this.fillStrategies(newWaste);

        ProcessingData processingData = this.garbageProcessor.processWaste(newWaste);
        this.balanceManager.processData(processingData);

        return String.format(GARBAGE_SUCCESS, garbageWeight, garbageName);
    }

    private Class<? extends Annotation> getDisposableAnnotation(Waste waste){
        Annotation[] wasteAnnotations = waste.getClass().getAnnotations();

        for (Annotation annotation:wasteAnnotations) {
            if (annotation.annotationType().isAnnotationPresent(Disposable.class)){
                return annotation.annotationType();
            }
        }
        return null;
    }

    private void fillStrategies(Waste newWaste) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class <? extends Annotation> wasteAnnotation = this.getDisposableAnnotation(newWaste);
        if (wasteAnnotation == null){
            throw new IllegalArgumentException(GARBAGE_NOT_DISPOSABLE);
        }
        if (!this.garbageProcessor.getStrategyHolder().getDisposalStrategies().containsKey(wasteAnnotation)){
            this.garbageProcessor.getStrategyHolder().addStrategy(wasteAnnotation, GarbageStrategyFactory.create(wasteAnnotation.getSimpleName()));
        }
    }
}
