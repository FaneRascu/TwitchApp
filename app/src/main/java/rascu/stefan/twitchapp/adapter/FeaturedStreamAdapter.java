package rascu.stefan.twitchapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import rascu.stefan.twitchapp.model.streams.TopStreams;
import rascu.stefan.twitchapp.ui.FeaturedStreamItemView;
import rascu.stefan.twitchapp.ui.FeaturedStreamItemView_;
import rascu.stefan.twitchapp.ui.ViewWrapper;

public class FeaturedStreamAdapter extends RecyclerViewAdapterBase<TopStreams, FeaturedStreamItemView> {

    protected Context context;

    public FeaturedStreamAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected FeaturedStreamItemView onCreateItemView(ViewGroup parent, int viewType) {
        FeaturedStreamItemView gameItemView = FeaturedStreamItemView_.build(this.context);
        return gameItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<FeaturedStreamItemView> viewHolder, int position) {
        FeaturedStreamItemView view = viewHolder.getView();
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
