import Commands.Executer;
import Commands.HoroscopeCommand;
import Utils.Crawler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws LoginException, IOException {
        JDA dorelBot = JDABuilder.createDefault("OTgyNjk3NzEzOTczOTk3NjA4.GiDH5r.mNm9PmIhzw-ugaaFPVAtjL3buqeTG1pCFI3AKg")
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.playing("Cine v-a facut doamna aicea ?")).build();

        dorelBot.addEventListener(new Executer());

        System.out.println(Crawler.getDailyHoroscope(9));
    }
}
