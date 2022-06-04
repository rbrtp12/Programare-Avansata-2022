package Commands;

import Utils.Constants;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Executer extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
    String[] args = event.getMessage().getContentRaw().split("\\s+");

    if(args[0].equalsIgnoreCase( Constants.prefix + "salut")){
        TestingCommands.getSalut(event);
    }

    if(args[0].equalsIgnoreCase(Constants.prefix + "info")){
           TestingCommands.getInfo(event);
        }
}
}
