package Commands;

import DAO.DbSelect;
import Utils.Crawler;
import Utils.HoroscopeRelated;
import lombok.extern.java.Log;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
@Log
public class HoroscopeCommand extends ListenerAdapter {
    public static void getHoroscopeCommand(MessageReceivedEvent event, String[] args) {
        User user = event.getMember().getUser();
        Executer executer = null;
        EmbedBuilder horoscope = new EmbedBuilder();

        try {
            String username = user.getName();
            int signIndex = DbSelect.getZodiacIndex(user);

            if (signIndex == -1) {
                System.out.println(DbSelect.getZodiacIndex(user));;
                HoroscopeRelated.sendHoroscopeMessage(user);
                event.getChannel().sendMessage("Please select a zodiac sign, then try again! ").queue();
            } else if (args.length == 1) {
                // embed:

                String sign = DbSelect.getZodiacSignFromIndex(signIndex);
                String embedTitle = Crawler.getDailyHoroscope(signIndex).split("[<>]")[4] + " - " + sign;
                String embedBody = Crawler.getDailyHoroscope(signIndex).split("[<>]")[6];
                horoscope.setTitle(embedTitle);
                horoscope.setDescription(embedBody);
                horoscope.addField("This horoscope was curated especially for " + username, "", false);
                event.getChannel().sendMessageEmbeds(horoscope.build()).queue();
                horoscope.clear();
            } else {
                signIndex = DbSelect.getZodiacIndexForOther(args[1]);
                if(signIndex == -1)
                {
                    horoscope.setTitle("Invalid zodiac sign. Try again!");
                }
                else {
                    String signOther = DbSelect.getZodiacSignFromIndex(signIndex);
                    String embedTitleOther = Crawler.getDailyHoroscope(signIndex).split("[<>]")[4] + " - " + signOther;
                    String embedBodyOther = Crawler.getDailyHoroscope(signIndex).split("[<>]")[6];

                    // embed;
                    horoscope.setTitle(embedTitleOther);
                    horoscope.setDescription(embedBodyOther);
                    horoscope.addField("This horoscope was curated especially for " + username, "", false);
                }

                event.getChannel().sendMessageEmbeds(horoscope.build()).queue();
                horoscope.clear();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scheduleHoroscope(MessageReceivedEvent event) throws IOException {
        User user = event.getMember().getUser();
        int signIndex = DbSelect.getZodiacIndex(user);
        String username = user.getName();
        String sign = DbSelect.getZodiacSignFromIndex(signIndex);
        try {
            String embedTitle = Crawler.getDailyHoroscope(signIndex).split("[<>]")[4] + " - " + sign;
            String embedBody = Crawler.getDailyHoroscope(signIndex).split("[<>]")[6];

            ZonedDateTime scheduledTime = ZonedDateTime.now(ZoneId.of("Europe/Bucharest")).withHour(19).withMinute(55).withSecond(0);
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                        EmbedBuilder horoscope = new EmbedBuilder();
                        horoscope.setTitle(embedTitle);
                        horoscope.setDescription(embedBody);
                        horoscope.addField("This was sent to you because you are subscribed to Dorel's horoscope ", "", false);
                        user.openPrivateChannel().queue((channel) -> channel.sendMessageEmbeds(horoscope.build()).queue());
                    }, scheduledTime.getSecond(), TimeUnit.DAYS.toSeconds(1),
                    TimeUnit.SECONDS);
            sleep(120 * 1000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
