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
import rascu.stefan.twitchapp.controller.activity.FeaturedStreamActivity_;
import rascu.stefan.twitchapp.model.streams.TopStreams;
import rascu.stefan.twitchapp.ui.transformation.CircleTransformation;
import rascu.stefan.twitchapp.util.Constants;

@EViewGroup(R.layout.list_stream_item)
public class FeaturedStreamItemView extends CardView implements View.OnClickListener {

    @ViewById
    protected ImageView contentImageView;

    @ViewById
    protected TextView nameTextView;

    @ViewById
    protected TextView positionTextView;

    private TopStreams topStreams;

    public FeaturedStreamItemView(Context context) {
        super(context);
        this.setOnClickListener(this);
    }

    public void bind(final TopStreams topStreams) {
        this.topStreams = topStreams;
        final Resources resources = this.getContext().getResources();

        Glide.clear(contentImageView);

        DrawableTypeRequest<String> drawableTypeRequest = Glide.with(this.getContext()).load(topStreams.getStream().getStreamPreview().getSmall());

        drawableTypeRequest.placeholder(R.mipmap.ic_placeholder)
                .override(Constants.GAME_BOX_MEDIUM_WIDTH, Constants.GAME_BOX_MEDIUM_HEIGHT)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .animate(android.R.anim.fade_in)
                .bitmapTransform(new CircleTransformation(this.getContext()))
                .into(this.contentImageView);

        this.contentImageView.setOnClickListener(this);

        this.nameTextView.setText(this.topStreams.getStream().getChannel().getName());

        this.positionTextView.setText(String.format(Constants.POSITION, this.topStreams.getPosition()));
    }

    @Override
    public void onClick(View v) {
        Intent goToStreamActivity = new Intent(this.getContext(), FeaturedStreamActivity_.class);
        goToStreamActivity.putExtra(Constants.GAME_INFORMATION, this.topStreams);
        this.getContext().startActivity(goToStreamActivity);
    }
}