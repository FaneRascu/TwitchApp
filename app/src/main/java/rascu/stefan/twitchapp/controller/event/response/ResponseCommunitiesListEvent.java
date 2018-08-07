package rascu.stefan.twitchapp.controller.event.response;

import rascu.stefan.twitchapp.model.communities.CommunityListContent;

public class ResponseCommunitiesListEvent {
    private int offset;

    private final CommunityListContent communityListContent;

    public ResponseCommunitiesListEvent(CommunityListContent communityListContent, int offset) {
        this.communityListContent = communityListContent;
        this.offset = offset;
    }

    public CommunityListContent getCommunityListContent() {
        return this.communityListContent;
    }

    public int getOffset() {
        return this.offset;
    }
}