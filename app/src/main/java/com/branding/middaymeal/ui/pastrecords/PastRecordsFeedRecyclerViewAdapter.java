
/*

 */

/*

 */

package com.branding.middaymeal.ui.pastrecords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.branding.middaymeal.R;
import com.branding.middaymeal.pojo.PastRecordFeedItem;
import com.branding.middaymeal.ui.dummy.DummyContent.DummyItem;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PastRecordsFeedRecyclerViewAdapter extends RecyclerView.Adapter<PastRecordsFeedRecyclerViewAdapter.ViewHolder> {

    private final List<PastRecordFeedItem> mValues;
    private final IPastRecordsCallback mListener;


    public PastRecordsFeedRecyclerViewAdapter(List<PastRecordFeedItem> items, IPastRecordsCallback listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_past_records_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.itemRow.setText(holder.mItem.getLiveFeedData());
        if(holder.mItem.isDescrepancy()) {
            holder.itemRow.setTextColor(ContextCompat.getColor((Context)mListener,R.color.colorRed));
        }

        holder.visualProofs.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.selectItemVisualProof(holder.mItem,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView itemRow;
        public PastRecordFeedItem mItem;
        public final Button visualProofs;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            itemRow = view.findViewById(R.id.itemRow);
            visualProofs = view.findViewById(R.id.visualProofs);
        }

    }
}
