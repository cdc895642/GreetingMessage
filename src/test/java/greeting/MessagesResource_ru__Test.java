package greeting;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by cdc89 on 07.12.2016.
 */
public class MessagesResource_ru__Test {
    ResourceBundle messagesResource=ResourceBundle.getBundle("MessagesResource", new Locale("ru","RU"));

    @Test
    public void handleGetObjectTest(){
        assertEquals("Доброй ночи, Мир!",messagesResource.getString("night"));
        assertEquals("Добрый день, Мир!",messagesResource.getString("day"));
        assertEquals("Доброе утро, Мир!", messagesResource.getString("morning"));
        assertNotEquals(messagesResource.getString("evening"),"Доброй ночи, Мир!",messagesResource.getString("evening"));
    }

    @Test(expected = java.util.MissingResourceException.class)
    public void noObjectTest(){
        assertEquals(null,messagesResource.getString("day1"));;
    }

    @Test
    public void getKeysTests(){
        Enumeration<String> keys=messagesResource.getKeys();
        int count=0;
        while(keys.hasMoreElements()){
            keys.nextElement();
            count++;
        }
        assertNotEquals(null,keys);
        assertEquals(4,count);
    }
}
