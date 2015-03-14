package com.crosp.solutions.malibushop.list_fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


import com.crosp.solutions.malibushop.R;
import com.crosp.solutions.malibushop.navigation_drawer.NavigationDrawerAdapter;
import com.crosp.solutions.malibushop.navigation_drawer.NavigationDrawerCallbacks;
import com.crosp.solutions.malibushop.navigation_drawer.NavigationItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crosp on 23.02.15.
 */
public class CategoryListFragment extends Fragment {
    private List<ShopItem> mItems;
    private RecyclerView mDrawerList;
    private int mCurrentSelectedPosition;
    private ListItemCallbacks mCallbacks;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_list, container, false);
        mDrawerList = (RecyclerView) view.findViewById(R.id.categoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDrawerList.setLayoutManager(layoutManager);
        mDrawerList.setHasFixedSize(true);
        ListShopAdapter adapter = new ListShopAdapter(this.getTestItems());
        adapter.setListItemCallbacks((ListItemCallbacks)getActivity());
        mDrawerList.setAdapter(adapter);
        return view;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    private List<ShopItem> getTestItems() {
        if (this.mItems==null || this.mItems.isEmpty()) {
            //TODO THIS HARDCODE IS JUST FOR TEST CHANGE IT
            mItems = new ArrayList<ShopItem>();
            Resources resources = getResources();

            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.card), "Cards", "Fucking cards"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.ic_ball), "Balls", "Fucking balls"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.dumbbell), "Dumbbells", "Fucking dumbbells"));

            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.card), "Cards", "Fucking cards"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.ic_ball), "Balls", "Fucking balls"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.dumbbell), "Dumbbells", "Fucking dumbbells"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.card), "Cards", "Fucking cards"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.ic_ball), "Balls", "Fucking balls"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.dumbbell), "Dumbbells", "Fucking dumbbells"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.card), "Cards", "Fucking cards"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.ic_ball), "Balls", "Fucking balls"));
            mItems.add(new CategoryListItem(resources.getDrawable(R.drawable.dumbbell), "Dumbbells", "Fucking dumbbells"));
        }
            return this.mItems;

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (ListItemCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

}