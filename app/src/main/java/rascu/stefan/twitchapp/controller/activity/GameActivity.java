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
import rascu.stefan.twitchapp.model.games.TopGame;
import rascu.stefan.twitchapp.util.Constants;

@EActivity(R.layout.activity_game)
@OptionsMenu(R.menu.menu_game)
public class GameActivity extends AppCompatActivity {

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
    protected TextView positionTextView;

    private DisplayMetrics metrics;
    private Display display;

    private TopGame topGame;


    @AfterViews
    protected void afterViews() {
        this.metrics = new DisplayMetrics();
        this.display = this.getWindowManager().getDefaultDisplay();

        //this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OptionsItem(R.id.menuShare)
    protected void onMenuShare() {
        this.shareGameInformation(topGame);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        topGame = (TopGame) this.getIntent().getSerializableExtra(Constants.GAME_INFORMATION);
        init(topGame);
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
        DrawableTypeRequest<String> drawableTypeRequest = Glide.with(this).load(topGame.getGame().getBox().getLarge());

        drawableTypeRequest.placeholder(R.mipmap.ic_placeholder)
                .override(Constants.GAME_BOX_LARGE_WIDTH, Constants.GAME_BOX_LARGE_HEIGHT)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .animate(android.R.anim.fade_in)
                .into(imageView);
    }

    private void init(@NonNull TopGame topGame) {
        if (topGame != null) {
            loadImage(this.contentImageView);
            this.nameTextView.setText(topGame.getGame().getName());
            this.channelTextView.setText(String.format(Constants.CHANNELS, topGame.getChannels()));
            this.viewerTextView.setText(String.format(Constants.VIEWERS, topGame.getViewers()));
            this.positionTextView.setText(String.format(Constants.POSITION, this.topGame.getPosition()));;
        }
    }

    private void shareGameInformation(@NonNull TopGame topGame) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(topGame.getGame().getName())
                .append(Constants.LINE_FEED)
                .append(String.format(Constants.CHANNELS, topGame.getChannels()))
                .append(Constants.LINE_FEED)
                .append(String.format(Constants.VIEWERS, topGame.getViewers()))
                .append(Constants.LINE_FEED)
                .append(String.format(Constants.POSITION, this.topGame.getPosition()));

        intent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString());

        this.startActivity(Intent.createChooser(intent, this.getString(R.string.shareOffer)));
    }


}