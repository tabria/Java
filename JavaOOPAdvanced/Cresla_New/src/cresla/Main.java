package cresla;

import cresla.core.SupplyId;
import cresla.engines.Engine;
import cresla.core.SystemManager;
import cresla.interfaces.Identifiable;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.Reader;
import cresla.io.Writer;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        Identifiable id = new SupplyId();
        Manager manager = new SystemManager(id);
        Runnable engine = new Engine(reader, writer, manager);
        engine.run();


    }
}
