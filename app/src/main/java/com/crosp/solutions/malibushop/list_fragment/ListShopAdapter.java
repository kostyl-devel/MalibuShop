package com.crosp.solutions.malibushop.list_fragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.crosp.solutions.malibushop.R;

import java.util.List;

/**
 * Created by crosp on 23.02.15.
 */
public class ListShopAdapter extends RecyclerView.Adapter<ListShopAdapter.ViewHolder> {


    private List<ShopItem> mData;
    private ListItemCallbacks mListItemCallbacks;
    private int mSelectedPosition;
    private int mTouchedPosition = -1;
    private int mItemLayoutResource = R.layout.list_item;
    public ListShopAdapter(List<ShopItem> data) {
        mData = data;
        this.selectPosition(-1);
    }
    public ListShopAdapter(List<ShopItem> data,int itemLayout) {
        mData = data;
        mItemLayoutResource = itemLayout;
        this.selectPosition(-1);
    }
    public ListItemCallbacks getListItemCallbacks() {
        return mListItemCallbacks;

    }
    public void setListItemCallbacks(ListItemCallbacks navigationDrawerCallbacks) {
        mListItemCallbacks = navigationDrawerCallbacks;

    }


    @Override
    public ListShopAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(this.mItemLayoutResource, viewGroup, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.titleTextView.setText(mData.get(i).getTitle());
        viewHolder.descriptionTextView.setText(mData.get(i).getDescription());
        viewHolder.imageView.setImageDrawable(mData.get(i).getDrawable());
        viewHolder.itemView.setOnTouchListener(new View.OnTouchListener() {
                                                   @Override
                                                   public boolean onTouch(View v, MotionEvent event) {

                                                       switch (event.getAction()) {
                                                           case MotionEvent.ACTION_DOWN:
                                                               touchPosition(i);
                                                               return false;
                                                           case MotionEvent.ACTION_CANCEL:
                                                               touchPosition(-1);
                                                               return false;
                                                           case MotionEvent.ACTION_MOVE:
                                                               return false;
                                                           case MotionEvent.ACTION_UP:
                                                               touchPosition(-1);
                                                               return false;
                                                       }
                                                       return true;
                                                   }
                                               }
        );
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       if (mListItemCallbacks != null)
                                                           mListItemCallbacks.onListItemClick(i);
                                                   }
                                               }
        );

        //TODO: selected menu position, change layout accordingly
        if (mSelectedPosition == i || mTouchedPosition == i) {
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(R.color.DeepSkyBlue));
        } else {
            viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void touchPosition(int position) {
        int lastPosition = mTouchedPosition;
        mTouchedPosition = position;
        if (lastPosition >= 0)
            notifyItemChanged(lastPosition);
        if (position >= 0)
            notifyItemChanged(position);
    }

    public void selectPosition(int position) {
        int lastPosition = mSelectedPosition;
        mSelectedPosition = position;
        notifyItemChanged(lastPosition);
        notifyItemChanged(position);
    }
    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public ImageView imageView;
        public TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.item_title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.item_description);
            imageView = (ImageView) itemView.findViewById(R.id.item_icon);
        }
    }
}