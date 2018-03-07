package app.interfaces;

import app.interfaces.observer.ObservableTarget;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();
}