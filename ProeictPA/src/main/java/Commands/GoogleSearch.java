package Commands;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearch {
    public static List<Result> searchOnStackOverflow(String searchQuery) throws GeneralSecurityException, IOException, GeneralSecurityException, IOException {

        List<Result> results = new ArrayList<>();

        // search engine-ul facut cu google
        String cx = "537b194d55d2a8783";

        // fac o instanta de Customsearch
        Customsearch cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                .setApplicationName("ProiectPA")
                .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer("AIzaSyAka4sGwyzEtk-UepYY8YL5Zz0ZxLgKYrE")) // my API-key
                .build();

        // aici ii dau dupa ce sa caute basically
        Customsearch.Cse.List list = cs.cse().list(searchQuery).setCx(cx);

        // execut cautarea
        Search result = list.execute();
        if (result.getItems() != null) {
            for (Result ri : result.getItems()) {
                results.add(ri);
            }
        }

        return results;
    }
}
