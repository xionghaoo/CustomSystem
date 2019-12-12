package xh.zero.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.websocket.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatSession {
    private long sessionId;
    private String customerUsername;
    private Session customer;
    private String representativeUsername;
    private Session representative;
    private ChatMessage creationMessage;
    private final List<ChatMessage> chatLog = new ArrayList<>();

    @JsonIgnore
    public void log(ChatMessage message) {

    }

    @JsonIgnore
    public void writeChatLog(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try(FileOutputStream stream = new FileOutputStream(file)) {
            mapper.writeValue(stream, this.chatLog);
        }
    }
}
