package rascu.stefan.twitchapp.controller.event.response;

import rascu.stefan.twitchapp.model.streams.StreamsListContent;

public class ResponseStreamsListEvent {
    private int offset;

    private final StreamsListContent streamsListContent;

    public ResponseStreamsListEvent(StreamsListContent streamsListContent, int offset) {
        this.streamsListContent = streamsListContent;
        this.offset = offset;
    }

    public StreamsListContent getStreamsListContent() {
        return this.streamsListContent;
    }

    public int getOffset() {
        return this.offset;
    }
}
