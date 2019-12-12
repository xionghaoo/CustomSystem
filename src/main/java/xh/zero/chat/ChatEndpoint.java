package xh.zero.chat;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

@ServerEndpoint(
        value = "/chat/{sessionId}",
        encoders = ChatMessageCodec.class,
        decoders = ChatMessageCodec.class,
        configurator = ChatEndpoint.EndpointConfigurator.class
)
public class ChatEndpoint implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

    public static class EndpointConfigurator extends ServerEndpointConfig.Configurator {
        @Override
        public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
            super.modifyHandshake(sec, request, response);
        }
    }
}
