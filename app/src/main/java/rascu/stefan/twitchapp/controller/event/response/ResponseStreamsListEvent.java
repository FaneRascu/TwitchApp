package rascu.stefan.twitchapp.controller.event.response;

import rascu.stefan.twitchapp.model.streams.StreamListContent;

public class ResponseStreamsListEvent {
    private int offset;

    private final StreamListContent streamsListContent;

    public ResponseStreamsListEvent(StreamListContent streamsListContent, int offset) {
        this.streamsListContent = streamsListContent;
        this.offset = offset;
    }

    public StreamListContent getStreamsListContent() {
        return this.streamsListContent;
    }

    public int getOffset() {
        return this.offset;
    }
}

