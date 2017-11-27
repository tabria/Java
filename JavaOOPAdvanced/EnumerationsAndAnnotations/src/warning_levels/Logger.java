package warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private Importance importanceLevel;
    private List<Message> messages;

    public Logger(Importance level) {
        this.importanceLevel = level;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        if (message.getType().compareTo(this.importanceLevel) >= 0){
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
