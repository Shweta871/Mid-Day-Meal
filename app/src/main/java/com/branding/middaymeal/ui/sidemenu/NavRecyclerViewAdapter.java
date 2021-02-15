
package com.branding.middaymeal.ui.sidemenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.branding.middaymeal.ui.dashboard.IDashboardCallback;
import com.branding.middaymeal.R;
import com.branding.middaymeal.pojo.DrawerItem;
import com.branding.middaymeal.ui.dummy.DummyContent.DummyItem;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class NavRecyclerViewAdapter extends RecyclerView.Adapter<NavRecyclerViewAdapter.ViewHolder> {

    private final List<DrawerItem> mValues;
    private final IDashboardCallback mListener;

    public NavRecyclerViewAdapter(List<DrawerItem> items, IDashboardCallback listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nav_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.itemIcon.setImageDrawable(ContextCompat.getDrawable((Context) mListener,holder.mItem.getDrawerMenuItem()));
        holder.itemName.setText(holder.mItem.getMenuName());

        if(holder.mItem.isActive()) {
            holder.mView.setBackgroundColor(ContextCompat.getColor((Context) mListener,R.color.colorveryLightGray));
        } else {
            holder.mView.setBackgroundColor(ContextCompat.getColor((Context) mListener,R.color.colorWhite));
        }


        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.selectItemInDrawer(holder.mItem,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView itemIcon;
        public final TextView itemName;
        public DrawerItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            itemIcon = view.findViewById(R.id.itemIcon);
            itemName = view.findViewById(R.id.itemName);
        }

    }
}
