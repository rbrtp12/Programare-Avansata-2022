package Utils;

import java.io.IOException;

import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Log
public class Crawler {

    public static void getDailyHoroscope(int singIndex) throws IOException {
        final Document doc = Jsoup.connect("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=9").get();
        Element paragraph = doc.select("p").first(); // today's horoscope for a certain zodiac sign
        System.out.println(paragraph);
    }

}
