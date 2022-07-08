package Utils;

import java.io.IOException;

import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Log
public class Crawler {

    public static String getDailyHoroscope(int signIndex) throws IOException {
        final Document doc = Jsoup.connect("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=" + signIndex).get();
        Element dailyHoroscope; // today's horoscope for a certain zodiac sign
        dailyHoroscope = doc.select("p").first();
        return dailyHoroscope.toString();
    }

}
