package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

import java.io.IOException;

public class ChangeRelativePathCommand extends Command {
    public ChangeRelativePathCommand(String input, String[] data, StudentsRepository repository, Tester tester, IOManager ioManager, DownloadManager downloadManager) {
        super(input, data, repository, tester, ioManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
            if (data.length != 2) {
                throw  new InvalidCommandException(this.getInput());
            }

            String relativePath = data[1];
            this.getIoManager().changeCurrentDirRelativePath(relativePath);
    }
}
