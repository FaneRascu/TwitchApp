package rascu.stefan.twitchapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import rascu.stefan.twitchapp.model.games.TopGame;
import rascu.stefan.twitchapp.ui.GameItemView;
import rascu.stefan.twitchapp.ui.GameItemView_;
import rascu.stefan.twitchapp.ui.ViewWrapper;

public class GameAdapter extends RecyclerViewAdapterBase<TopGame, GameItemView> {

    protected Context context;

    public GameAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected GameItemView onCreateItemView(ViewGroup parent, int viewType) {
        GameItemView gameItemView = GameItemView_.build(this.context);
        return gameItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<GameItemView> viewHolder, int position) {
        GameItemView view = viewHolder.getView();
        if (position < this.items.size()) {
            TopGame topGame = this.items.get(position);
            topGame.setPosition(position + 1);
            view.bind(topGame);
        }
    }


    public void addAll(List<TopGame> games) {
        for (TopGame topGame: games) {
            this.items.add(topGame);
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