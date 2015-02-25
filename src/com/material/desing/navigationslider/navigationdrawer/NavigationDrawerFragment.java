package com.material.desing.navigationslider.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.material.desing.navigationslider.R;


public class NavigationDrawerFragment extends Fragment implements
		DrawerCallbacks {
	private RecyclerView recyclerviewDrawerList;
	private int navigationCurrentSelectedPosition;
	private DrawerCallbacks drawerCallbacks;
	private View drawerFragmentContainerView;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle actionBarDrawerToggle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_navigation_drawer,
				container, false);
		recyclerviewDrawerList = (RecyclerView) view
				.findViewById(R.id.drawerList);
		LinearLayoutManager layoutManager = new LinearLayoutManager(
				getActivity());
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerviewDrawerList.setLayoutManager(layoutManager);
		recyclerviewDrawerList.setHasFixedSize(true);
		
//		RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
		
	//	recyclerviewDrawerList.addItemDecoration(itemDecoration);
		
		final List<NavigationItem> navigationItems = getMenu();
		Navigationadapter navigationAdapter = new Navigationadapter(
				navigationItems);
		navigationAdapter.setNavigationDrawerCallbacks(this);
		recyclerviewDrawerList.setAdapter(navigationAdapter);
		selectItem(navigationCurrentSelectedPosition);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			drawerCallbacks = (DrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"Activity must implement NavigationDrawerCallbacks.");
		}

	}

	public void setup(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
		drawerFragmentContainerView = getActivity().findViewById(fragmentId);
		this.drawerLayout = drawerLayout;
		actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(),
				drawerLayout, toolbar, R.string.drawer_open,
				R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				if (!isAdded())
					return;
				getActivity().invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!isAdded())
					return;
				getActivity().invalidateOptionsMenu();
			}
		};

		drawerLayout.post(new Runnable() {
			@Override
			public void run() {
				actionBarDrawerToggle.syncState();
			}
		});

		drawerLayout.setDrawerListener(actionBarDrawerToggle);
	}

	public void openDrawer() {
		drawerLayout.openDrawer(drawerFragmentContainerView);
	}

	public void closeDrawer() {
		drawerLayout.closeDrawer(drawerFragmentContainerView);
	}

	@Override
	public void onDetach() {
		super.onDetach();
		drawerCallbacks = null;
	}

	public List<NavigationItem> getMenu() {
		List<NavigationItem> items = new ArrayList<NavigationItem>();
		items.add(new NavigationItem("Item First ", getResources().getDrawable(
				R.drawable.ic_launcher)));
		items.add(new NavigationItem("Item Second", getResources().getDrawable(
				R.drawable.ic_launcher)));
		items.add(new NavigationItem("Item Third", getResources().getDrawable(
				R.drawable.ic_launcher)));
		items.add(new NavigationItem("Item Fourth", getResources().getDrawable(
				R.drawable.ic_launcher)));
		return items;
	}

	void selectItem(int position) {
		navigationCurrentSelectedPosition = position;
		if (drawerLayout != null) {
			drawerLayout.closeDrawer(drawerFragmentContainerView);
		}
		if (drawerCallbacks != null) {
			drawerCallbacks.onNavigationDrawerItemSelected(position);
		}
		((Navigationadapter) recyclerviewDrawerList.getAdapter())
				.selectPosition(position);
	}

	public boolean isDrawerOpen() {
		return drawerLayout != null
				&& drawerLayout.isDrawerOpen(drawerFragmentContainerView);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		selectItem(position);
	}

	public DrawerLayout getDrawerLayout() {
		return drawerLayout;
	}

	public void setDrawerLayout(DrawerLayout drawerLayout) {
		this.drawerLayout = drawerLayout;
	}

}
