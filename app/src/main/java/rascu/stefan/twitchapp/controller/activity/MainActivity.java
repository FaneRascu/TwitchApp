package rascu.stefan.twitchapp.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.ui.GameItemView;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTopGames = findViewById(R.id.buttonTopGames);
        Log.d("intra aci", "ye");
        buttonTopGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ore merge?", "da bineintazles");
                Intent intent = new Intent(MainActivity.this, TopGamesActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button buttonTopStreams = findViewById(R.id.buttonTopStreams);
        Log.d("intra aci", "ye");
        buttonTopStreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ore merge?", "da bineintazles");
                Intent intent = new Intent(MainActivity.this, TopStreamsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button buttonTopFeaturedStreams = findViewById(R.id.buttonTopFeaturedStreams);
        Log.d("intra aci", "ye");
        buttonTopFeaturedStreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ore merge?", "da bineintazles");
                Intent intent = new Intent(MainActivity.this, TopFeaturedStreams.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button buttonTopCommunities = findViewById(R.id.buttonTopCommunities);
        Log.d("intra aci", "ye");
        buttonTopCommunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ore merge?", "da bineintazles");
                Intent intent = new Intent(MainActivity.this, TopCommunitiesActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @OptionsItem(R.id.menuExit)
    protected void onMenuExit() {
        this.finish();
    }

}
