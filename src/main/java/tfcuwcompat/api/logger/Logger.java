package tfcuwcompat.api.logger;

import org.slf4j.LoggerFactory;

public class Logger {

    private static final int BUFFER = 100;

    private final String tag;
    private StringBuilder sb;
    private final org.slf4j.Logger logger;

    public Logger(String tag) {
        this(tag, BUFFER);
    }
    public Logger(String tag, int buffer) {
        this.tag = tag;
        this.sb = new StringBuilder(buffer);
        this.logger = LoggerFactory.getLogger(tag);
    }

    public void info(Object ... messages) {
        sb.append("[").append(tag).append("]");
        for (Object message : messages)
            sb.append(" ").append(message);
        logger.info(sb.toString());
        // Cleaning memory of sb + passing it to GC
        sb = new StringBuilder(BUFFER);
    }
}
