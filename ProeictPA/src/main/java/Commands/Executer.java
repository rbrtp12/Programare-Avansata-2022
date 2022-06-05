package Commands;

import DAO.DbInsert;
import Utils.Constants;
import com.google.api.services.customsearch.model.Result;
import lombok.extern.java.Log;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

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
            List<Result> results = new ArrayList<>();

            try {
                results = GoogleSearch.searchOnStackOverflow(args[1]);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int numberOfResults = results.size();
            if (numberOfResults > 3)
                numberOfResults = 3;

            if (numberOfResults != 0) {
                event.getChannel().sendMessage("Your top " + numberOfResults + " results are: ").queue();
                for (int i = 0; i < numberOfResults; i++) {
                    event.getChannel().sendMessage(results.get(i).getTitle() + "\n" + results.get(i).getLink()).queue();
                }
            } else event.getChannel().sendMessage("I found nothing to help you with.").queue();
        }

    }

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        User user = event.getMember().getUser();
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


    }

    public void onMessageReactionAdd(MessageReactionAddEvent event){
        String username = event.getUser().getName();
        if (username.equals("Dorel"))
            return;
        if(event.getReactionEmote().getName().equals("♈")) {
                String zodiacName = event.getReactionEmote().getName();
                DbInsert.insertMembers(username, 1);
                System.out.println("Added " + username + zodiacName + " to the db");
            }
        if(event.getReactionEmote().getName().equals("♉")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 2);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♊")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 3);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♋")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 4);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♌")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 5);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♍")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 6);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♎")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 7);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♏")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 8);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♐")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 9);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♑")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 10);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♒")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 11);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
        if(event.getReactionEmote().getName().equals("♓")) {
            String zodiacName = event.getReactionEmote().getName();
            DbInsert.insertMembers(username, 12);
            System.out.println("Added " + username + zodiacName + " to the db");
        }
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

