/*

 */

/*
 *
 */

package com.branding.middaymeal.ui.pastrecords;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.branding.middaymeal.R;
import com.branding.middaymeal.pojo.PastRecordFeedItem;
import com.branding.middaymeal.ui.downloadres.DowloadResourceDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PastRecords extends AppCompatActivity implements IPastRecordsCallback{
    Toolbar myChildToolbar;
    ImageView datebutton;
    TextView date_text;

    private int mYear, mMonth, mDay, mHour, mMinute;
    Calendar c;

    DateFormat dateFormat = new SimpleDateFormat("E, dd MMM, yyyy");


    RecyclerView discrepancyRV;
    PastRecordsFeedRecyclerViewAdapter pastRecordsFeedRecyclerViewAdapter;
    List<PastRecordFeedItem> pastRecordFeedItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_records);

        myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);

        datebutton = findViewById(R.id.datebutton);
        date_text = findViewById(R.id.date_text);

        discrepancyRV = findViewById(R.id.discrepancyRV);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setHomeAsUpIndicator(ContextCompat.getDrawable(PastRecords.this, R.drawable.ic_arrow_back_white_24dp));
            ab.setDisplayHomeAsUpEnabled(true);
        }

        pastRecordFeedItemList = new ArrayList<>();


        PastRecordFeedItem pastRecordFeedItem = new PastRecordFeedItem();
        pastRecordFeedItem.setDescrepancy(true);
        pastRecordFeedItem.setLiveFeedData("1:18 - Food served same as prescribed menu");
        pastRecordFeedItemList.add(pastRecordFeedItem);

        pastRecordFeedItem = new PastRecordFeedItem();
        pastRecordFeedItem.setDescrepancy(true);
        pastRecordFeedItem.setLiveFeedData("1:18 - Food served same as prescribed menu");
        pastRecordFeedItemList.add(pastRecordFeedItem);

        pastRecordFeedItem = new PastRecordFeedItem();
        pastRecordFeedItem.setDescrepancy(true);
        pastRecordFeedItem.setLiveFeedData("1:18 - Food served same as prescribed menu");
        pastRecordFeedItemList.add(pastRecordFeedItem);


        pastRecordsFeedRecyclerViewAdapter = new PastRecordsFeedRecyclerViewAdapter(pastRecordFeedItemList,this);
        discrepancyRV.setLayoutManager(new LinearLayoutManager(this));
        discrepancyRV.setAdapter(pastRecordsFeedRecyclerViewAdapter);





         c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        String dateStr = dateFormat.format(c.getTime());
        date_text.setText(dateStr);


        datebutton.setOnClickListener(v->{
            // Get Current Date



            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        c.set(Calendar.YEAR,year);
                        c.set(Calendar.MONTH,monthOfYear);
                        c.set(Calendar.DATE,dayOfMonth);

                        String dateStr1 = dateFormat.format(c.getTime());
                        date_text.setText(dateStr1);
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });


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

    @Override
    public void selectItemVisualProof(PastRecordFeedItem mItem, int position) {
        DowloadResourceDialog dialogFragment = new DowloadResourceDialog();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialogFragment.show(ft, "dialog");
    }
}
