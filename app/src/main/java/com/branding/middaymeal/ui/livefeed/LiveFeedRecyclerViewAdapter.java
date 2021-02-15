
/*

 */

package com.branding.middaymeal.ui.livefeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.branding.middaymeal.R;
import com.branding.middaymeal.pojo.LiveFeedItem;
import com.branding.middaymeal.ui.dummy.DummyContent.DummyItem;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class LiveFeedRecyclerViewAdapter extends RecyclerView.Adapter<LiveFeedRecyclerViewAdapter.ViewHolder> {

    private final List<LiveFeedItem> mValues;
    private final ILiveFeedActivityCallback mListener;

    public LiveFeedRecyclerViewAdapter(List<LiveFeedItem> items, ILiveFeedActivityCallback listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_live_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.itemRow.setText(holder.mItem.getLiveFeedData());
        if(holder.mItem.isDescrepancy()) {
            holder.itemRow.setTextColor(ContextCompat.getColor((Context)mListener,R.color.colorRed));
        }

//        holder.mView.setOnClickListener(v -> {
////            if (null != mListener) {
////                mListener.selectItemInDrawer(holder.mItem,position);
////            }
////        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView itemRow;
        public LiveFeedItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            itemRow = view.findViewById(R.id.itemRow);
        }

    }
}
