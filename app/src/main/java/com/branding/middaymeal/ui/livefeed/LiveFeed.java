/*

 */

/*
 *
 */

package com.branding.middaymeal.ui.livefeed;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.branding.middaymeal.R;
import com.branding.middaymeal.pojo.LiveFeedItem;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LiveFeed extends AppCompatActivity implements ILiveFeedActivityCallback {

    Toolbar myChildToolbar;
    private RecyclerView feedRV;
    private LiveFeedRecyclerViewAdapter liveFeedRecyclerViewAdapter;
    private List<LiveFeedItem> liveFeedItemList;
    private Button sendAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_feed);

        myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setHomeAsUpIndicator(ContextCompat.getDrawable(LiveFeed.this, R.drawable.ic_arrow_back_white_24dp));
            ab.setDisplayHomeAsUpEnabled(true);
        }

        feedRV = findViewById(R.id.feedRV);
        sendAlert = findViewById(R.id.sendAlert);




        liveFeedItemList = new ArrayList<>();

        LiveFeedItem liveFeedItem = new LiveFeedItem();
        liveFeedItem.setLiveFeedData("1:04 - No of students detected : 37");
        liveFeedItem.setDescrepancy(false);
        liveFeedItemList.add(liveFeedItem);

        liveFeedItem = new LiveFeedItem();
        liveFeedItem.setLiveFeedData("1:12 - Food served to 37 students");
        liveFeedItem.setDescrepancy(false);
        liveFeedItemList.add(liveFeedItem);

        liveFeedItem = new LiveFeedItem();
        liveFeedItem.setLiveFeedData("1:18 - Food served same as prescribed menu");
        liveFeedItem.setDescrepancy(true);
        liveFeedItemList.add(liveFeedItem);

        liveFeedRecyclerViewAdapter = new LiveFeedRecyclerViewAdapter(liveFeedItemList,this);
        feedRV.setLayoutManager(new LinearLayoutManager(this));
        feedRV.setAdapter(liveFeedRecyclerViewAdapter);


        showSendAlertButton();

        sendAlert.setOnClickListener(v -> {
            // make send alert network call here coz there is a descrepancy in data
        });




    }

    private void showSendAlertButton() {

        boolean found = false;

        for(LiveFeedItem item : liveFeedItemList) {
            if(item.isDescrepancy()) {
                found = true;
                break;
            }
        }

        if(found) {
            sendAlert.setVisibility(View.VISIBLE);
        } else {
            sendAlert.setVisibility(View.GONE);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(0,R.anim.slide_down);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
