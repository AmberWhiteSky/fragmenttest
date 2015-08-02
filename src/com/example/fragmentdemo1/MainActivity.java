package com.example.fragmentdemo1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

@SuppressLint("CommitTransaction")
public class MainActivity extends Activity implements OnClickListener {
	private Button one, two, three, four;
	private ContantFragment contantFragment;
	private FriendFragment friendFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		one = (Button) findViewById(R.id.but1);
		two = (Button) findViewById(R.id.but2);
		three = (Button) findViewById(R.id.but3);
		four = (Button) findViewById(R.id.but4);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);

		// 设置默认Fragment
		setDefaultFragment();
	}

	private void setDefaultFragment() {
		FragmentManager fManager = getFragmentManager();
		FragmentTransaction transaction = fManager.beginTransaction();
		contantFragment = new ContantFragment();
		transaction.replace(R.id.frame_layout, contantFragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();

		switch (id) {
		case R.id.but1:
			if (contantFragment == null) {
				contantFragment = new ContantFragment();

			}
			transaction.replace(R.id.frame_layout, contantFragment);
			break;
		case R.id.but2:
			if (friendFragment == null) {
				friendFragment = new FriendFragment();
			}
			transaction.replace(R.id.frame_layout, friendFragment);
			break;

		case R.id.but3:

			break;

		case R.id.but4:

			break;

		default:
			break;
		}
		transaction.commit();
	}
}
