package app;

import app.abstractClasses.AbstractLogger;
import app.models.commands.*;
import app.models.commands.GroupAttackCommand;
import app.models.commands.GroupTargetCommand;
import app.interfaces.command.Command;
import app.interfaces.command.Executor;
import app.models.logger.CombatLogger;
import app.models.logger.EventLogger;
import app.interfaces.AttackGroup;
import app.models.Group;
import app.models.Dragon;
import app.models.Warrior;
import app.interfaces.observer.ObservableTarget;

public class Main {
    public static void main(String[] args) {

        AbstractLogger combatLogger = new CombatLogger();
        AbstractLogger eventLogger = new EventLogger();
        //AbstractLogger targetLogger = new TargetLogger();

        combatLogger.setSuccessor(eventLogger);
        //eventLogger.setSuccessor(targetLogger);

        AttackGroup group = new Group();
        group.addMember(new Warrior("Warrior", 10 , combatLogger));
        group.addMember(new Warrior("ElderWarrior", 13, combatLogger));

        ObservableTarget dragon = new Dragon("Dragon", 10, 25, combatLogger);

        Executor commandExecutor = new CommandExecutor();
        Command groupTarget = new GroupTargetCommand(group, dragon);
        Command attackCommand = new GroupAttackCommand(group);

        commandExecutor.executeCommand(groupTarget);
        commandExecutor.executeCommand(attackCommand);
    }
}