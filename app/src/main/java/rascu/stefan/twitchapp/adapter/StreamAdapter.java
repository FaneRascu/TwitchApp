package rascu.stefan.twitchapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import rascu.stefan.twitchapp.model.streams.TopStreams;
import rascu.stefan.twitchapp.ui.StreamItemView;
import rascu.stefan.twitchapp.ui.StreamItemView_;
import rascu.stefan.twitchapp.ui.ViewWrapper;

public class StreamAdapter extends RecyclerViewAdapterBase<TopStreams, StreamItemView> {

    protected Context context;

    public StreamAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected StreamItemView onCreateItemView(ViewGroup parent, int viewType) {
        StreamItemView gameItemView = StreamItemView_.build(this.context);
        return gameItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<StreamItemView> viewHolder, int position) {
        StreamItemView view = viewHolder.getView();
        if (position < this.items.size()) {
            TopStreams topStreams = this.items.get(position);
            topStreams.setPosition(position + 1);
            view.bind(topStreams);
        }
    }


    public void addAll(List<TopStreams> streams) {
        for (TopStreams topStreams: streams) {
            this.items.add(topStreams);
        }
    }

    public void clearAll() {
        this.items.clear();
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

}
