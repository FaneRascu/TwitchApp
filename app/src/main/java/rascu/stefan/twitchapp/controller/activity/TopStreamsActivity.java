package rascu.stefan.twitchapp.controller.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import de.greenrobot.event.EventBus;
import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.adapter.StreamAdapter;
import rascu.stefan.twitchapp.controller.event.ErrorEvent;
import rascu.stefan.twitchapp.controller.event.EventManagerStreams;
import rascu.stefan.twitchapp.controller.event.request.RequestStreamsListEvent;
import rascu.stefan.twitchapp.controller.event.response.ResponseStreamsListEvent;
import rascu.stefan.twitchapp.model.streams.TopStreams;

@EActivity(R.layout.activity_top_streams)
@OptionsMenu(R.menu.menu_topstreams)
public class TopStreamsActivity extends AppCompatActivity {

    private StreamAdapter adapter;

    @ViewById
    protected ProgressBar progressBar;

    @ViewById
    protected RecyclerView gamesRecyclerView;

    @ViewById
    protected SwipeRefreshLayout swipeLayout;

    @ViewById(android.R.id.list)
    protected ListView listView;

    @OptionsMenuItem
    protected MenuItem menuExit;

    @AfterInject
    protected void afterInjected() {
        EventManagerStreams.getInstance().init();
    }

    @AfterViews
    protected void afterViews() {
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        this.gamesRecyclerView.setLayoutManager(layoutManager);
        this.gamesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.adapter = new StreamAdapter(this);
        this.gamesRecyclerView.setAdapter(this.adapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(true);
                EventBus.getDefault().post(new RequestStreamsListEvent(TopStreamsActivity.this, 0));
            }
        });

        EventBus.getDefault().post(new RequestStreamsListEvent(TopStreamsActivity.this, 0));
    }

    @OptionsItem(R.id.menuExit)
    protected void onMenuExit() {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!EventBus.getDefault().isRegistered(this)) {
            Log.d("MainActivity", "[onResume]EventBus.register");
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        if (EventBus.getDefault().isRegistered(this)) {
            Log.d("MainActivity", "[onPause]EventBus.unregister");
            EventBus.getDefault().unregister(this);
        }
        super.onPause();
    }

    public void onEvent(RequestStreamsListEvent event) {
        Log.i("MainActivity", "[onEvent]RequestGameListEvent");
    }

    public void onEvent(ResponseStreamsListEvent event) {
        this.showProgressBar(false);
        clearAndFillAdapter(event.getStreamsListContent().getFeatured());
    }

    public void onEvent(final ErrorEvent event) {
        swipeLayout.setRefreshing(false);
        this.showToast(event.getMessage());
    }

    @UiThread
    protected void clearAndFillAdapter(List<TopStreams> streams) {
        // fill adapter with TopGames
        swipeLayout.setRefreshing(false);
        this.adapter.clearAll();
        this.adapter.addAll(streams);
        this.adapter.notifyDataSetChanged();
    }

    @UiThread
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @UiThread
    public void showProgressBar(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        this.progressBar.setVisibility(visibility);
    }

    @Override
    protected void onDestroy() {
        EventManagerStreams.getInstance().destroy();
        super.onDestroy();
    }

}
