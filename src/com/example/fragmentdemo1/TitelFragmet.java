package com.example.fragmentdemo1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class TitelFragmet extends Fragment {

	private ImageButton imageButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.titlefragment, container, false);
		imageButton = (ImageButton) view.findViewById(R.id.left_button);
		imageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "我是左边", Toast.LENGTH_SHORT)
						.show();
			}
		});
		return view;
	}

}
