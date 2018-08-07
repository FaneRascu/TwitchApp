package rascu.stefan.twitchapp.controller.event.request;

import android.content.Context;

public class RequestStreamsListEvent {

    private final Context context;

    private final int offset;

    public RequestStreamsListEvent(Context context, int offset) {
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
