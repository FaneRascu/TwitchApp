package rascu.stefan.twitchapp.controller.event.response;

import rascu.stefan.twitchapp.model.streams.FeaturedStreamsListContent;

public class ResponseFeaturedStreamsListEvent {
    private int offset;

    private final FeaturedStreamsListContent featuredStreamsListContent;

    public ResponseFeaturedStreamsListEvent(FeaturedStreamsListContent featuredStreamsListContent, int offset) {
        this.featuredStreamsListContent = featuredStreamsListContent;
        this.offset = offset;
    }

    public FeaturedStreamsListContent getFeaturedStreamsListContent() {
        return this.featuredStreamsListContent;
    }

    public int getOffset() {
        return this.offset;
    }
}
