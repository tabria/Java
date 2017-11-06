package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public abstract class Command {

    private String input;
    private String[] data;

    private StudentsRepository repository;
    private Tester tester;
    private IOManager ioManager;
    private DownloadManager downloadManager;

    public Command(String input, String[] data, StudentsRepository repository, Tester tester, IOManager ioManager, DownloadManager downloadManager) {
        this.setInput(input);
        this.setData(data);
        this.repository = repository;
        this.tester = tester;
        this.ioManager = ioManager;
        this.downloadManager = downloadManager;
    }

    protected String getInput() {
        return this.input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")){
            throw new InvalidCommandException(this.input);
        }
        this.input = input;
    }

    protected String[] getData() {
        return this.data;
    }

    private void setData(String[] data) {
        if (data == null || data.length<1){
            throw new InvalidCommandException(this.input);
        }
        this.data = data;
    }

    protected StudentsRepository getRepository() {
        return this.repository;
    }

    protected Tester getTester() {
        return this.tester;
    }

    protected IOManager getIoManager() {
        return this.ioManager;
    }

    protected DownloadManager getDownloadManager() {
        return this.downloadManager;
    }

    public abstract void execute() throws Exception;


}
