package com.material.desing.navigationslider.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.material.desing.navigationslider.R;

public class ItemFirst extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View rootView = inflater.inflate(R.layout.fragment_items, container, false);
	     
		 TextView txt=(TextView)rootView.findViewById(R.id.txt);
		 txt.setText("Item First");
			return rootView;
			}

}
