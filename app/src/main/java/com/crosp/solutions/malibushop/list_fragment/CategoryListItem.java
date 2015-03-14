package com.crosp.solutions.malibushop.list_fragment;

import android.graphics.drawable.Drawable;

/**
 * Created by crosp on 23.02.15.
 */
public class CategoryListItem extends ShopItem {
    private int mProductCount = 0;
    public CategoryListItem(Drawable icon, String title, String description) {
        super(icon, title, description);
    }
    public int getProductCount() {
        return this.mProductCount;
    }
}
