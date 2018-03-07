package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {


	private String[] data;
	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter commandInterpreter;

	public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter commandInterpreter) {
		this.repository = repository;
		this.unitFactory = unitFactory;
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				if ("fight".equals(input)) {
					break;
				}
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable command = this.commandInterpreter.interpretCommand(commandName);
				this.data = data;
				this.dependencyInjector(command
				);
				String result = command.execute();
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void dependencyInjector(Executable command) throws IllegalAccessException {
		Field[] commandFields = command.getClass().getSuperclass().getDeclaredFields();
		Field[] engineFields = this.getClass().getDeclaredFields();

		for (Field commandField:commandFields) {
			if (commandField.isAnnotationPresent(Inject.class)){
				for (Field engineField:engineFields) {
					if (engineField.getName().equals(commandField.getName())
							&& engineField.getType().equals(commandField.getType()) ){
						commandField.setAccessible(true);
						engineField.setAccessible(true);
						commandField.set(command, engineField.get(this));
						break;
					}
				}
			}
		}

	}
}
