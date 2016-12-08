package greeting;

import day.Day;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ResourceBundle;

/**
 * don't use.
 * if need add new lang - use properties files
 * default english messages
 * Created by cdc89 on 07.12.2016.
 */
@Deprecated
public class MessagesResource  extends ResourceBundle {
    private static final Logger logger = LogManager.getLogger(MessagesResource.class.getName());
    protected Hashtable<String, String> messages;

    public MessagesResource(){
        messages=new Hashtable<>();
        init();
    }

    protected void init(){
        logger.debug("init()");
        messages.put("morning","Good morning, World!");
        messages.put("day","Good day, World!");
        messages.put("evening","Good evening, World!");
        messages.put("night","Good night, World!");
    }

    @Override
    protected Object handleGetObject(String key){
        return messages.get(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return messages.keys();
    }
}
