package com.crosp.solutions.malibushop.list_fragment;

import android.graphics.drawable.Drawable;

/**
 * Created by crosp on 23.02.15.
 */
public abstract class ShopItem {
    private  Drawable mDrawable;       // the drawable for the ListView item ImageView
    private  String title;        // the text for the ListView item title
    private  String description;  // the text for the ListView item description

    public ShopItem(Drawable icon, String title, String description) {
        this.mDrawable = icon;
        this.title = title;
        this.description = description;
    }
    public Drawable getDrawable() {
        return mDrawable;
    }

    public void setDrawable(Drawable drawable) {
        mDrawable = drawable;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
