package rascu.stefan.twitchapp.controller.event.request;

import android.content.Context;

public class RequestFeaturedStreamsListEvent {

    private final Context context;

    private final int offset;

    public RequestFeaturedStreamsListEvent(Context context, int offset) {
        this.context = context;
        this.offset = offset;
    }

    public Context getContext() {
        return this.context;
    }

    public int getOffset() {
        return this.offset;
    }
}
