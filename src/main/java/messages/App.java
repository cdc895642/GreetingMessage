package messages;

import day.Day;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.StringBuilders;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by cdc89 on 07.12.2016.
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        Locale locale=Locale.getDefault();
        String greeting=getGreeting(locale);
        System.out.println(greeting);
    }

    public static String getGreeting(Locale locale){
        Day day = new Day();
        return getGreeting(day, locale);
    }

    public static String getGreeting(Day day, Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("greeting.MessagesResource", locale);
        logger.debug("getGreeting() - locale - "+locale.getDisplayLanguage());
        String greeting=rb.getString(day.getDayPeriod().toString());
        logger.debug("getGreeting() - greeting - "+greeting);
        return greeting;
    }
}
