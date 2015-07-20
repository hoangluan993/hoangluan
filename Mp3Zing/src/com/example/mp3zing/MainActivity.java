package com.example.mp3zing;

import chucnangonline.OnlinePageFragment;
import mymusic.BaihatFragmentActivity;
import adapter.MymusicAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private CharSequence mTitle;
	ListView list;
	private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
	private long mBackPressed;
	
	static String name[]={"anh 1","Nhạc Offline", "Bài hát", "Album", "Nghệ sỹ", "Playlist", "Thư mục", "Download", "Nhạc Online", "Yêu thích", "PlayList", "Nhạc upload"};
	static Integer[] ic={R.drawable.default_avatar,R.color.trans,R.drawable.ic1,R.drawable.ic2,R.drawable.ic3, R.drawable.ic4, R.drawable.ic5, 
			R.drawable.ic6, R.color.trans, R.drawable.ic7, R.drawable.ic8, R.drawable.ic9};
	static FragmentManager fragmn;
//	LayoutInflater inflater;
//	ViewGroup container;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmn=getSupportFragmentManager();
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
//		Intent intent = new Intent(this, load_music.class);
//		this.startService(intent);
//		if(MyMediaPlayer.isPlaying()){
//			FragmentTransaction fragtst = getSupportFragmentManager().beginTransaction();
//        	fragtst.replace(R.id.playbot,new PlaybotFragment());
//        	fragtst.commit();
//		}
	}
	@Override
	public void onBackPressed() {	
		if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) 
	    { 
	        super.onBackPressed(); 
	        return;
	    }
	    else { Toast.makeText(getBaseContext(), "Click lần nữa để thoát.", Toast.LENGTH_SHORT).show(); }

	    mBackPressed = System.currentTimeMillis();
	};
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = "Zing mp3";
			break;
		case 5:{
			mTitle = "Chụp Ảnh";
//			FragmentTransaction fragtst = fragmn.beginTransaction();
//	    	fragtst.replace(R.id.container,new OnlinePageFragment("Nhạc HOT"));
//	    	fragtst.commit();
			}
			break;
		case 4:{
			mTitle = "Album";
			BaihatFragmentActivity.trang=1;
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new BaihatFragmentActivity());
	    	fragtst.commit();
		 	}
			break;
		case 6:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Video Clip"));
	    	fragtst.commit();
			mTitle = "Video Clip";
			}
			break;
		case 7:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Nghệ sĩ"));
	    	fragtst.commit();
			mTitle = "Nghệ Sĩ";
		}
			break;
		case 8:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Bảng xếp hạng"));
	    	fragtst.commit();
			mTitle = "Bảng Xếp Hạng";
		}
			break;
		case 9:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("TOP 100"));
	    	fragtst.commit();
			mTitle = "Top 100";
		}
			break;
		case 10:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Zing Music Awards"));
	    	fragtst.commit();
			mTitle = "Zing Music Awards";
		}
			break;
		case 11:
			mTitle = "Công Cụ";
			break;
		case 12:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Lyrics Any Where"));
	    	fragtst.commit();
			mTitle = "Lyrics Any Where";
		}
			break;
		case 13:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Restore"));
	    	fragtst.commit();
			mTitle = "Restore";
		}
		
			break;
		case 14:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Thông báo"));
	    	fragtst.commit();
			mTitle = "Thông báo";
		}
//			mTitle = "Thông báo";
			break;
		case 15:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Zing VIP"));
	    	fragtst.commit();
			mTitle = "Zing VIP";
		}
//			mTitle = "Zing VIP";
			break;
		case 16:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Ứng Dụng Liên Quan"));
	    	fragtst.commit();
			mTitle = "Ứng Dụng Liên Quan";
		}
//			mTitle = "Ứng Dụng Liên Quan";
			break;
		case 17:{
			FragmentTransaction fragtst = fragmn.beginTransaction();
	    	fragtst.replace(R.id.container,new OnlinePageFragment("Cài Đặt"));
	    	fragtst.commit();
			mTitle = "Cài Đặt";
		}
//			mTitle = "Cài Đặt";
			break;
		case 18:{
//			FragmentTransaction fragtst = fragmn.beginTransaction();
//	    	fragtst.replace(R.id.container,new OnlinePageFragment("Đóng Ứng Dụng"));
//	    	fragtst.commit();
			android.os.Process.killProcess(android.os.Process.myPid());
			super.onDestroy();
			mTitle = "Đóng Ứng Dụng";
		}
//			mTitle = "Đóng Ứng Dụng";
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//		actionBar.setBackgroundDrawable(new ColorDrawable(R.drawable.colorback));
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
//			MenuItem menuitem = menu.findItem(R.id.action_example);
//			SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuitem);
//			searchView.setQueryHint("Nhập thông tin tìm kiếm.");
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";
		public static ImageView test;
		
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			ListView list = (ListView) rootView.findViewById(R.id.listmymsic);
			//test = (ImageView)rootView.findViewById(R.id.test);
			MymusicAdapter adapter= new MymusicAdapter(getActivity(), name, ic);
			list.setAdapter(adapter);
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position==3){
						BaihatFragmentActivity.trang=1;
					}else
						BaihatFragmentActivity.trang=0;
					change();
						
				}
			});
//			
			return rootView;
		}
		public static void show(){
			test.setVisibility(ImageView.INVISIBLE);
		}
		private void change(){
			FragmentTransaction fragtst = fragmn.beginTransaction();
        	fragtst.replace(R.id.container,new BaihatFragmentActivity());
        	fragtst.commit();
//			Intent i= new Intent(getActivity(),BaihatFragmentActivity.class);
//			 i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			 startActivity(i);
		}
		
//		
		
		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
