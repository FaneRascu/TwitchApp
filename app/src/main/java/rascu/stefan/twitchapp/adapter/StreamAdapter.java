package rascu.stefan.twitchapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;


import rascu.stefan.twitchapp.model.streams.Stream;
import rascu.stefan.twitchapp.ui.StreamItemView;
import rascu.stefan.twitchapp.ui.StreamItemView_;
import rascu.stefan.twitchapp.ui.ViewWrapper;

public class StreamAdapter extends RecyclerViewAdapterBase<Stream, StreamItemView> {

    protected Context context;

    public StreamAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected StreamItemView onCreateItemView(ViewGroup parent, int viewType) {
        StreamItemView streamItemView = StreamItemView_.build(this.context);
        return streamItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<StreamItemView> viewHolder, int position) {
        StreamItemView view = viewHolder.getView();
        if (position < this.items.size()) {
            Stream stream = this.items.get(position);
            stream.setPosition(position + 1);
            view.bind(stream);
        }
    }


    public void addAll(List<Stream> streams) {
        for (Stream stream: streams) {
            this.items.add(stream);
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