package greeting;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;


/**
 * Created by cdc89 on 07.12.2016.
 */
public class MessageResourcesTest {
    ResourceBundle messagesResource=ResourceBundle.getBundle("MessagesResource", new Locale("en","EN"));

    @Test
    public void handleGetObjectTest(){
        assertEquals("Good night, World!",messagesResource.getString("night"));
        assertEquals("Good day, World!",messagesResource.getString("day"));
        assertEquals("Good morning, World!", messagesResource.getString("morning"));
        assertNotEquals(messagesResource.getString("evening"),"Good night, World!",messagesResource.getString("evening"));
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
