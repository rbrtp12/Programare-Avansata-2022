package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class TestingCommands {
    public static void getSalut(MessageReceivedEvent event) {
        event.getChannel().sendMessage("sal").queue();

    }

    public static void getInfo(MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Dorel Bot", "https://github.com/luputeodor2/discordel");
        info.setDescription("Commands:\n $salut - Dorel says hi \n" + "$horoscope - your horoscope today\n" + "$horoscope + zodiac sign - any zodiac sign's horoscope\n" + "$search - searches for the next word on stackoverflow\n");
        info.addField("Creators: ", "Pinzaru Robert & Lupu Teodor", false);
        event.getChannel().sendMessageEmbeds(info.build()).queue();
        info.clear();
    }
}
