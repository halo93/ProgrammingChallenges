package behavioral_patterns.template_method;

import java.nio.charset.StandardCharsets;

public abstract class Network {
    String username;
    String password;

    public boolean post(String message) {
        if (logIn(username, password)) {
            boolean result = sendData(message.getBytes(StandardCharsets.UTF_8));
            logout();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String username, String password);
    abstract boolean sendData(byte[] data);
    abstract void logout();

}
