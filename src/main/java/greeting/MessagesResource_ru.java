package greeting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * russian messages
 * Created by cdc89 on 07.12.2016.
 */
public class MessagesResource_ru extends MessagesResource{
    private static final Logger logger = LogManager.getLogger(MessagesResource_ru.class.getName());
    @Override
    protected void init(){
        logger.debug("init()");
        messages.put("morning","Доброе утро, Мир!");
        messages.put("day","Добрый день, Мир!");
        messages.put("evening","Добрый вечер, Мир!");
        messages.put("night","Доброй ночи, Мир" +
                "!");
    }
}
