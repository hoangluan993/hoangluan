package mymusic;

import Library.PagerSlidingTabStrip;
import Viewpager.SampleFragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mp3zing.R;

public class BaihatFragmentActivity extends Fragment {
	public static int trang;
	ViewPager viewPager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragmentactivity_baihat, container, false);
		ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		//RelativeLayout back = (RelativeLayout) findViewById(R.id.back);
		viewPager.setAdapter(new SampleFragmentPagerAdapter(
				getChildFragmentManager()));
		if(trang==1){
			viewPager.setCurrentItem(2, true);
		}else
		viewPager.setCurrentItem(1, true);
		PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
		tabsStrip.setViewPager(viewPager);
		return view;
	}
	

}
