package Commands;

import com.google.api.services.customsearch.model.Result;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class SearchCommand {

    public static void getSearchCommand(MessageReceivedEvent event, String[] args) {
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
