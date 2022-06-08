package Commands;

import Utils.Constants;
import Utils.HoroscopeRelated;
import lombok.extern.java.Log;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Log
public class Executer extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Constants.prefix + "salut")) {
            TestingCommands.getSalut(event);
        }

        if (args[0].equalsIgnoreCase(Constants.prefix + "info")) {
            TestingCommands.getInfo(event);
        }

        if (args[0].equalsIgnoreCase(Constants.prefix + "search")) {
            SearchCommand.getSearchCommand(event, args);
        }
        if (args[0].equalsIgnoreCase(Constants.prefix + "horoscope")) {
            HoroscopeCommand.getHoroscopeCommand(event);
        }

    }

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        User user = event.getMember().getUser();
        HoroscopeRelated.sendHoroscopeMessage(user);


    }

    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        String username = event.getUser().getName();
        HoroscopeRelated.getReactionFromMessage(event, username);

    }
}


    /*public void onGuildJoin(GuildJoinEvent event) {
        List<User> users = event.getGuild().getJDA().getUsers();

        for (User user : users) {
            System.out.println(user);
            if (user.equals(event.getJDA().getSelfUser()))
                    return;
            else {
                try {
                    user.openPrivateChannel().queue((channel) -> channel.sendMessage("Hi, what's your zodiac sign ? ").queue((message) -> {
                        message.addReaction("♈").queue();
                        message.addReaction("♉").queue();
                        message.addReaction("♊").queue();
                        message.addReaction("♋").queue();
                        message.addReaction("♌").queue();
                        message.addReaction("♍").queue();
                        message.addReaction("♎").queue();
                        message.addReaction("♏").queue();
                        message.addReaction("♐").queue();
                        message.addReaction("♑").queue();
                        message.addReaction("♒").queue();
                        message.addReaction("♓").queue();
                    }));
                } catch (Exception e) {
                    log.severe(e.toString());
                }
            }
        }
    }*/

