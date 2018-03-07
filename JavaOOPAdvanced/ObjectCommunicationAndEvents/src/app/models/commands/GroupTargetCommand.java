package app.models.commands;


import app.interfaces.command.Command;
import app.interfaces.AttackGroup;
import app.interfaces.observer.ObservableTarget;

public class GroupTargetCommand implements Command {

    private ObservableTarget target;
    private AttackGroup group;

    public GroupTargetCommand(AttackGroup group, ObservableTarget target) {
        this.target = target;
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupTarget(target);
    }
}