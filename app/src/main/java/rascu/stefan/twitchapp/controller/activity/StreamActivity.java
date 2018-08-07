package rascu.stefan.twitchapp.controller.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.model.streams.TopStreams;
import rascu.stefan.twitchapp.util.Constant;

@EActivity(R.layout.activity_stream)
@OptionsMenu(R.menu.menu_stream)
public class StreamActivity extends AppCompatActivity {

    @ViewById
    protected Toolbar toolbar;

    @ViewById
    protected ImageView contentImageView;

    @ViewById
    protected TextView nameTextView;

    @ViewById
    protected TextView channelTextView;

    @ViewById
    protected TextView viewerTextView;

    @ViewById
    protected TextView gameNameTextView;

    @ViewById
    protected TextView positionTextView;

    private DisplayMetrics metrics;
    private Display display;

    private TopStreams topStreams;


    @AfterViews
    protected void afterViews() {
        this.metrics = new DisplayMetrics();
        this.display = this.getWindowManager().getDefaultDisplay();

        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OptionsItem(R.id.menuShare)
    protected void onMenuShare() {
        this.shareGameInformation(topStreams);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        topStreams = (TopStreams) this.getIntent().getSerializableExtra(Constant.GAME_INFORMATION);
        init(topStreams);
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @UiThread
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void loadImage(ImageView imageView) {
        DrawableTypeRequest<String> drawableTypeRequest = Glide.with(this).load(topStreams.getImage());

        drawableTypeRequest.placeholder(R.mipmap.ic_placeholder)
                .override(Constant.GAME_BOX_LARGE_WIDTH, Constant.GAME_BOX_LARGE_HEIGHT)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .animate(android.R.anim.fade_in)
                .into(imageView);
    }

    private void init(@NonNull TopStreams topStreams) {
        if (topStreams != null) {
            loadImage(this.contentImageView);
            this.nameTextView.setText(topStreams.getStream().getChannel().getName());
            this.gameNameTextView.setText(String.format(Constant.GAME_NAME, topStreams.getStream().getChannel().getGame()));
            this.channelTextView.setText(String.format(Constant.FOLLOWERS, topStreams.getStream().getChannel().getFollowers()));
            this.viewerTextView.setText(String.format(Constant.VIEWERS, topStreams.getStream().getViewers()));
            this.positionTextView.setText(String.format(Constant.POSITION, this.topStreams.getPosition()));;
        }
    }

    private void shareGameInformation(@NonNull TopStreams topStreams) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(topStreams.getStream().getChannel().getName())
                .append(Constant.LINE_FEED)
                .append(String.format(Constant.GAME_NAME, topStreams.getStream().getChannel().getGame()))
                .append(Constant.LINE_FEED)
                .append(String.format(Constant.FOLLOWERS, topStreams.getStream().getChannel().getFollowers()))
                .append(Constant.LINE_FEED)
                .append(String.format(Constant.VIEWERS, topStreams.getStream().getViewers()))
                .append(Constant.LINE_FEED)
                .append(String.format(Constant.POSITION, this.topStreams.getPosition()));

        intent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString());

        this.startActivity(Intent.createChooser(intent, this.getString(R.string.shareOffer)));
    }


}