package rascu.stefan.twitchapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.controller.activity.GameActivity_;
import rascu.stefan.twitchapp.model.TopGame;
import rascu.stefan.twitchapp.ui.transformation.CircleTransformation;
import rascu.stefan.twitchapp.util.Constant;

@EViewGroup(R.layout.list_game_item)
public class GameItemView extends CardView implements View.OnClickListener {

    @ViewById
    protected ImageView contentImageView;

    @ViewById
    protected TextView nameTextView;

    @ViewById
    protected TextView positionTextView;

    private TopGame topGame;

    public GameItemView(Context context) {
        super(context);
        this.setOnClickListener(this);
    }

    public void bind(final TopGame topGame) {
        this.topGame = topGame;
        final Resources resources = this.getContext().getResources();

        Glide.clear(contentImageView);

        DrawableTypeRequest<String> drawableTypeRequest = Glide.with(this.getContext()).load(topGame.getGame().getBox().getSmall());

        drawableTypeRequest.placeholder(R.mipmap.ic_placeholder)
                .override(Constant.GAME_BOX_MEDIUM_WIDTH, Constant.GAME_BOX_MEDIUM_HEIGHT)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .animate(android.R.anim.fade_in)
                .bitmapTransform(new CircleTransformation(this.getContext()))
                .into(this.contentImageView);

        this.contentImageView.setOnClickListener(this);

        this.nameTextView.setText(this.topGame.getGame().getName());

        this.positionTextView.setText(String.format(Constant.POSITION, this.topGame.getPosition()));
    }

    @Override
    public void onClick(View v) {
        Intent goToGameActivity = new Intent(this.getContext(), GameActivity_.class);
        goToGameActivity.putExtra(Constant.GAME_INFORMATION, this.topGame);
        this.getContext().startActivity(goToGameActivity);
    }
}