package Utils;

import DAO.DbInsert;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

public class HoroscopeRelated {

    public static void sendHoroscopeMessage(User user){
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



    public static void getReactionFromMessage(MessageReactionAddEvent event, String username){
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
        event.getChannel().deleteMessageById(event.getMessageId()).queue();
    }
    }

