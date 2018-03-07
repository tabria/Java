package app.models.commands;
import app.interfaces.command.Command;
import app.interfaces.AttackGroup;

public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupAttack();
    }
}