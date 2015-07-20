package Viewpagerdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mp3zing.R;

public class Myfragment extends Fragment{
	
	String nameFragment;
	
	public Myfragment(String nameFragment) {
		// TODO Auto-generated constructor stub
		this.nameFragment = nameFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		TextView tv = (TextView)view.findViewById(R.id.textView1);
		tv.setText(nameFragment);
		return view;
	}
	

}