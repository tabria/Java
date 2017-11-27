package pet_clinics.engine;

import pet_clinics.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class EngineImpl implements Engine {

    private PetManager petManager;
    private BufferedReader reader;

    public EngineImpl() {
        this.petManager = new PetManager();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() throws IOException {

        int cycles = Integer.parseInt(reader.readLine());

        for (int i = 0; i <cycles ; i++) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));

            this.dispatcher(input);
        }
    }

    private void dispatcher(List<String> input) {
        switch(input.get(0)){
            case "Create":
                this.create(input);
                break;
            case "Add":
                try {
                    System.out.println(this.petManager.addPet(input.get(1), input.get(2)));
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
                break;
            case "Release":
                System.out.println(this.petManager.releasePet(input.get(1)));
                break;
            case "HasEmptyRooms":
                System.out.println(this.petManager.HasEmptyRooms(input.get(1)));
                break;
            case "Print":
                    String info ="";
                    if (input.size() == 2){
                        info = this.petManager.printAllRooms(input.get(1));
                    } else if (input.size() == 3){
                        info = this.petManager.printRoom(input.get(1), Integer.parseInt(input.get(2)));
                    }
                    if (!info.isEmpty()){
                        System.out.println(info);
                    }
                break;
        }
    }

    private void create(List<String> input) {
        switch(input.get(1)){
            case "Pet":
                this.petManager.createPet(input.get(2), Integer.parseInt(input.get(3)), input.get(4));
                break;
            case "Clinic":
                try {
                this.petManager.createClinic(input.get(2), Integer.parseInt(input.get(3)));
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
                break;
        }
    }
}

