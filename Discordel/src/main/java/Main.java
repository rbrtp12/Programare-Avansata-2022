import Commands.Executer;
import Utils.Constants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDA dorelBot = JDABuilder.createDefault(Constants.token)
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.playing("Cine v-a facut doamna aicea ?")).build();

        dorelBot.addEventListener(new Executer());

        // use 'heroku ps:scale worker=1 -a discordel' to start heroku app
        // use 'heroku ps:scale worker=1 -a discordel' to stop heroku app
    }
}
