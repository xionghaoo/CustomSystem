package xh.zero.chat;

import java.time.OffsetDateTime;

public class ChatMessage {
    private OffsetDateTime timestamp;
    private Type type;
    private String user;
    private String content;

    public static enum Type {
        STARTED, JOINED, ERROR, LEFT, TEXT
    }
}
