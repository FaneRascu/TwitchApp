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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.adapter.CommunityAdapter;

import rascu.stefan.twitchapp.controller.event.ErrorEvent;
import rascu.stefan.twitchapp.controller.event.EventManagerCommunities;

import rascu.stefan.twitchapp.controller.event.request.RequestCommunitiesListEvent;

import rascu.stefan.twitchapp.controller.event.response.ResponseCommunitiesListEvent;

import rascu.stefan.twitchapp.controller.event.response.ResponseStreamsListEvent;
import rascu.stefan.twitchapp.model.communities.TopCommunity;



@EActivity(R.layout.activity_top_communities)
@OptionsMenu(R.menu.menu_topcommunity)
public class TopCommunitiesActivity extends AppCompatActivity {

    private CommunityAdapter adapter;

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
        EventManagerCommunities.getInstance().init();
    }

    @AfterViews
    protected void afterViews() {
        Log.d("AFTERVIEWS","intra aici");
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        this.progressBar = findViewById(R.id.progressBar);

        this.gamesRecyclerView.setLayoutManager(layoutManager);
        this.gamesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.adapter = new CommunityAdapter(this);
        this.gamesRecyclerView.setAdapter(this.adapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(true);
                EventBus.getDefault().post(new RequestCommunitiesListEvent(TopCommunitiesActivity.this, 0));
            }
        });

        EventBus.getDefault().post(new RequestCommunitiesListEvent(TopCommunitiesActivity.this, 0));
    }

    @OptionsItem(R.id.menuExit)
    protected void onMenuExit() {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topgames);
        EventManagerCommunities.getInstance().init();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.progressBar = findViewById(R.id.progressBar);
        this.gamesRecyclerView = findViewById(R.id.gamesRecyclerView);
        this.gamesRecyclerView.setLayoutManager(layoutManager);
        this.gamesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.adapter = new CommunityAdapter(this);
        this.gamesRecyclerView.setAdapter(this.adapter);


        swipeLayout = findViewById(R.id.swipeLayout);

        EventBus.getDefault().register(this);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(true);
                EventBus.getDefault().post(new RequestCommunitiesListEvent(TopCommunitiesActivity.this, 0));
            }
        });

        EventBus.getDefault().post(new RequestCommunitiesListEvent(TopCommunitiesActivity.this, 0));

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!EventBus.getDefault().isRegistered(this)) {
            Log.d("TopCommunitiesActivity", "[onResume]EventBus.register");
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        if (EventBus.getDefault().isRegistered(this)) {
            Log.d("TopCommunitiesActivity", "[onPause]EventBus.unregister");
            EventBus.getDefault().unregister(this);
        }
        super.onPause();
    }

    @Subscribe
    public void onEvent(RequestCommunitiesListEvent event) {
        Log.i("TopCommunitiesActivity", "[onEvent]RequestCommunitiesListEvent");
    }

    @Subscribe
    public void onEvent(ResponseCommunitiesListEvent event) {
        this.showProgressBar(false);
        clearAndFillAdapter(adapter, event.getCommunityListContent().getCommunities());
    }

    @Subscribe
    public void onEvent(final ErrorEvent event) {
        swipeLayout.setRefreshing(false);
        this.showToast(event.getMessage());
    }

    @UiThread
    protected void clearAndFillAdapter(final CommunityAdapter adapter, final List<TopCommunity> topCommunities) {
        // fill adapter with TopGames
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);
                adapter.clearAll();
                adapter.addAll(topCommunities);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @UiThread
    protected void showToast(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @UiThread
    public void showProgressBar(final boolean show) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                int visibility = show ? View.VISIBLE : View.GONE;
                findViewById(R.id.progressBar).setVisibility(visibility);

            }
        });
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        EventManagerCommunities.getInstance().destroy();
        super.onDestroy();
    }

}