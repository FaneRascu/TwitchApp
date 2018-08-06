package rascu.stefan.twitchapp.controller.event;

public class ErrorEvent {

    private final String message;

    public ErrorEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}