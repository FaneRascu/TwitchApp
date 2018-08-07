package rascu.stefan.twitchapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import rascu.stefan.twitchapp.model.communities.TopCommunity;
import rascu.stefan.twitchapp.ui.CommunityItemView;
import rascu.stefan.twitchapp.ui.CommunityItemView_;
import rascu.stefan.twitchapp.ui.ViewWrapper;

public class CommunityAdapter extends RecyclerViewAdapterBase<TopCommunity, CommunityItemView> {

    protected Context context;

    public CommunityAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected CommunityItemView onCreateItemView(ViewGroup parent, int viewType) {
        CommunityItemView communityItemView = CommunityItemView_.build(this.context);
        return communityItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<CommunityItemView> viewHolder, int position) {
        CommunityItemView view = viewHolder.getView();
        if (position < this.items.size()) {
            TopCommunity topCommunity = this.items.get(position);
            topCommunity.setPosition(position + 1);
            view.bind(topCommunity);
        }
    }


    public void addAll(List<TopCommunity> streams) {
        for (TopCommunity topStreams: streams) {
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