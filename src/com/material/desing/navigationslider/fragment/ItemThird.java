package com.material.desing.navigationslider.fragment;

import com.material.desing.navigationslider.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemThird extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View rootView = inflater.inflate(R.layout.fragment_items, container, false);
	     
		 TextView txt=(TextView)rootView.findViewById(R.id.txt);
		 txt.setText("Item Third");
			return rootView;
			}
}
