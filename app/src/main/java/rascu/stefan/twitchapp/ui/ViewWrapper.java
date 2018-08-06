package rascu.stefan.twitchapp.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V view) {
        super(view);
        this.view = view;
    }

    public V getView() {
        return this.view;
    }
}
