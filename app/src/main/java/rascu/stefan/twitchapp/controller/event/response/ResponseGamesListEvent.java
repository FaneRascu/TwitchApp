package rascu.stefan.twitchapp.controller.event.response;

import rascu.stefan.twitchapp.model.GamesListContent;

public class ResponseGamesListEvent {

    private int offset;

    private final GamesListContent gamesListContent;

    public ResponseGamesListEvent(GamesListContent gamesListContent, int offset) {
        this.gamesListContent = gamesListContent;
        this.offset = offset;
    }

    public GamesListContent getGamesListContent() {
        return this.gamesListContent;
    }

    public int getOffset() {
        return this.offset;
    }
}
