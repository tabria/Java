package inferno_infinity.engine;

import inferno_infinity.io.ConsoleInputReader;

import java.util.Arrays;

public class Engine implements Runnable {

    private ConsoleInputReader inputReader;
    private Commands commands;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.commands = new Commands();
    }

    @Override
    public void run() {

        String line = "";
        while(!"END".equals(line = this.inputReader.readLine())){
            String[] input = line.split(";");

            this.dispatch(input);

        }


    }

    private void dispatch(String[] input) {

        switch(input[0]){
            case "Create":
                this.commands.createWeapon(input[1], input[2]);
                break;
            case "Add":
                try {
                    this.commands.addGem(input[1], Integer.parseInt(input[2]), input[3]);
                } catch (IllegalArgumentException iae) {}

                break;
            case "Remove":
                try {
                    this.commands.removeGem(input[1], Integer.parseInt(input[2]));
                } catch (IllegalArgumentException iae) {}

                break;
            case "Compare":
                String bestWeapon = this.commands.compareWeapon(input[1], input[2]);
                if (!bestWeapon.isEmpty()){
                    System.out.println(bestWeapon);
                }
                break;
            case "Print":
                String weapon = this.commands.printWeapon(input[1]);
                if (!weapon.isEmpty()){
                    System.out.println(weapon);
                }
                break;
            case "Author":
                System.out.println(String.format("Author: %s",this.commands.getAnnotation().author()));
                break;
            case "Revision":
                System.out.println(String.format("Revision: %s",this.commands.getAnnotation().revision()));
                break;
            case "Description":
                System.out.println(String.format("Class description: %s",this.commands.getAnnotation().description()));
                break;
            case "Reviewers":
                System.out.println(String.format("Reviewers: %s", String.join(", ",Arrays.asList(this.commands.getAnnotation().reviewers()))));
                break;
        }

    }
}
