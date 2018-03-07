package hell.io;

import hell.interfaces.OutputWriter;

public class Writer implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    //TODO refactor with format
    @Override
    public void writeLine(String format, Object... params) {

        for (Object param:params) {
            System.out.println(param);
        }

    }
}
