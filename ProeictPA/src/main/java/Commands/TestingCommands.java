package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class TestingCommands {
    public static void getSalut(MessageReceivedEvent event){
        event.getChannel().sendMessage("sal").queue();

    }

    public static void getInfo(MessageReceivedEvent event){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Dorel Bot Info");
        info.setDescription("A bot that does a little bit of everything and always asks 'who did the work here, ma'am?'");
        info.addField("Creators: ", "Pinzaru Robert & Lupu Teodor", false);
        event.getChannel().sendMessageEmbeds(info.build()).queue();
        info.clear();
    }
}
