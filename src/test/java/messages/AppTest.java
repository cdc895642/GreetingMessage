package messages;

import day.Day;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by cdc89 on 07.12.2016.
 */
public class AppTest {
    @Ignore
    @Test
    public void appTest(){
        Locale currentLocale=Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("greeting.MessagesResource", currentLocale);
        System.out.println(currentLocale.getCountry()+" - "+currentLocale.getDisplayLanguage());
        System.out.println(rb.getString("day"));
    }

    @Test
    public void getGreetingEngTest(){
        Locale locale=Locale.ENGLISH;//new Locale("en","US")
        Day day=new Day();
        day.setCurrentTime(LocalTime.of(6, 30));
        assertEquals(App.getGreeting(day, locale), "Good morning, World!");
        day.setCurrentTime(LocalTime.of(18, 30));
        assertEquals(App.getGreeting(day, locale), "Good day, World!");
        locale=new Locale("en","US");
        day.setCurrentTime(LocalTime.of(19, 30));
        assertEquals(App.getGreeting(day, locale), "Good evening, World!");
        day.setCurrentTime(LocalTime.of(0, 00));
        assertEquals(App.getGreeting(day, locale), "Good night, World!");
    }

    @Test
    public void getGreetingRuTest(){
        Locale locale=new Locale("ru","RU");
        Day day=new Day();
        day.setCurrentTime(LocalTime.of(6, 30));
        assertEquals(App.getGreeting(day, locale), "Доброе утро, Мир!");
        day.setCurrentTime(LocalTime.of(18, 30));
        assertEquals(App.getGreeting(day, locale), "Добрый день, Мир!");
        day.setCurrentTime(LocalTime.of(19, 30));
        assertEquals(App.getGreeting(day, locale), "Добрый вечер, Мир!");
        day.setCurrentTime(LocalTime.of(0, 00));
        assertEquals(App.getGreeting(day, locale), "Доброй ночи, Мир!");
    }
}
