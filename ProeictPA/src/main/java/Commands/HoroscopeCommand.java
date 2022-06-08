package Commands;

import DAO.DbSelect;
import Utils.Crawler;
import Utils.HoroscopeRelated;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

public class HoroscopeCommand extends ListenerAdapter {
    public static void getHoroscopeCommand(MessageReceivedEvent event){
        User user = event.getMember().getUser();
        Executer executer = null;
        try {
            if(DbSelect.getZodiacIndex(user) == -1)
            {
                HoroscopeRelated.sendHoroscopeMessage(user);
                event.getChannel().sendMessage("Please select a zodiac sign, then try again! ").queue();
            }
           else event.getChannel().sendMessage(Crawler.getDailyHoroscope(DbSelect.getZodiacIndex(user))).queue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
