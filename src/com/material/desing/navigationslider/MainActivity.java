package com.material.desing.navigationslider;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.material.desing.navigationslider.fragment.ItemFirst;
import com.material.desing.navigationslider.fragment.ItemFourth;
import com.material.desing.navigationslider.fragment.ItemSecond;
import com.material.desing.navigationslider.fragment.ItemThird;
import com.material.desing.navigationslider.navigationdrawer.DrawerCallbacks;
import com.material.desing.navigationslider.navigationdrawer.NavigationDrawerFragment;

public class MainActivity extends ActionBarActivity implements DrawerCallbacks {

	private Toolbar toolBar;

	private NavigationDrawerFragment navigationDrawerFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		toolBar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolBar);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.fragment_drawer);
		navigationDrawerFragment.setup(R.id.fragment_drawer,
				(DrawerLayout) findViewById(R.id.drawer), toolBar);

	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		/*
		 * Toast.makeText(this, "item no: " + position + "Selected",
		 * Toast.LENGTH_SHORT).show();
		 */
		Fragment fragment = null;

		switch (position) {
		case 0:

			fragment = new ItemFirst();
			break;
		case 1:

			fragment = new ItemSecond();
			break;
		case 2:

			fragment = new ItemThird();
			break;
		case 3:

			fragment = new ItemFourth();
			break;

		

		default:
			break;
		}
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, fragment).commit();

		}

	}

	@Override
	public void onBackPressed() {
		if (navigationDrawerFragment.isDrawerOpen())
			navigationDrawerFragment.closeDrawer();
		else
			super.onBackPressed();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// finish();
	}

}
