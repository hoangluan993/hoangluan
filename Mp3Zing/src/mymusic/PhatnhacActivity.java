package mymusic;

import java.util.ArrayList;
import java.util.Random;

import mediaplayer.MyMediaPlayer;
import mediaplayer.MyPlayer;
import mediaplayer.Utilities;
import sdcard.MyFile;
import Viewpagerdemo.AnimationChaychuFragment;
import Viewpagerdemo.ListChaynhacFragment;
import Viewpagerdemo.WoaydiaFragment;
import adapter.MymusicAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mp3zing.R;

public class PhatnhacActivity extends FragmentActivity implements OnClickListener {
	ViewPager viewPager;
	RelativeLayout back,hengio,find;
	public static ImageView btnplay;
	public static ImageView btnpause;
	ImageView next;
	ImageView prev;
	RelativeLayout rand_on,rand_off,repeat_off,repeat_one,repeat_all;
	static SeekBar seekbar;
	public static TextView fulltime,tenbaihat,tacgia;
	TextView time,a,b,c;
	static Utilities util;
	Handler seekHandler = new Handler();
	static ArrayList<MyFile> mylist;
	Intent intent;
	public static int vitri;
	public static String tenbh,tenbhnext,tenbhprev,pathnext,pathprev;
	public int rotation=0;
	public static void nextrepeat_off(){
		if(vitri==(mylist.size()-1)){
			MyPlayer.pause();
		}else{
		vitri+=1;
		PlaybotFragment.vitri+=1;
		pathnext=mylist.get(vitri).getFullPath().toString();
		PlaybotFragment.setNameArtist(mylist.get(vitri).getName(), mylist.get(vitri).getArtist());
		tenbaihat.setText(""+mylist.get(vitri).getName());
		tacgia.setText(""+mylist.get(vitri).getArtist());
		
		MyPlayer.next(pathnext);
		seekbar.setMax(MyMediaPlayer.getDuration());
    	fulltime.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getDuration()));
		}
		
	}
	public static void nextrepeat_one(){
		pathnext=mylist.get(vitri).getFullPath().toString();
		PlaybotFragment.setNameArtist(mylist.get(vitri).getName(), mylist.get(vitri).getArtist());
		tenbaihat.setText(""+mylist.get(vitri).getName());
		tacgia.setText(""+mylist.get(vitri).getArtist());
		
		MyPlayer.next(pathnext);
		seekbar.setMax(MyMediaPlayer.getDuration());
    	fulltime.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getDuration()));
	}
	public static void nextrandom(int rand){
		vitri=rand;
		PlaybotFragment.vitri=rand;
//		if(vitri==(mylist.size()-1)){
//			vitri=0;
//			PlaybotFragment.vitri=0;
//		}else{
//		vitri+=1;
//		PlaybotFragment.vitri+=1;
//		}
		pathnext=mylist.get(vitri).getFullPath().toString();
		PlaybotFragment.setNameArtist(mylist.get(vitri).getName(), mylist.get(vitri).getArtist());
		tenbaihat.setText(""+mylist.get(vitri).getName());
		tacgia.setText(""+mylist.get(vitri).getArtist());
		
		MyPlayer.next(pathnext);
		seekbar.setMax(MyMediaPlayer.getDuration());
    	fulltime.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getDuration()));
	}
	public static void next(){
		if(vitri==(mylist.size()-1)){
			vitri=0;
			PlaybotFragment.vitri=0;
		}else{
		vitri+=1;
		PlaybotFragment.vitri+=1;
		}
		pathnext=mylist.get(vitri).getFullPath().toString();
		PlaybotFragment.setNameArtist(mylist.get(vitri).getName(), mylist.get(vitri).getArtist());
		tenbaihat.setText(""+mylist.get(vitri).getName());
		tacgia.setText(""+mylist.get(vitri).getArtist());
		
		MyPlayer.next(pathnext);
		seekbar.setMax(MyMediaPlayer.getDuration());
    	fulltime.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getDuration()));
	}
	public static void prev(){
		if(vitri==0){
			vitri=mylist.size()-1;
			PlaybotFragment.vitri=mylist.size()-1;
		}else{
		vitri-=1;
		PlaybotFragment.vitri-=1;
		}
		pathprev=mylist.get(vitri).getFullPath().toString();
		PlaybotFragment.setNameArtist(mylist.get(vitri).getName(), mylist.get(vitri).getArtist());
		tenbaihat.setText(""+mylist.get(vitri).getName());
		tacgia.setText(""+mylist.get(vitri).getArtist());
		MyPlayer.prev(pathprev);
		//ktisplaying();
    	fulltime.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getDuration()));
	}
	public static int getposition(){
		return vitri;
	}
	public static void ktisplaying(){
		if(MyMediaPlayer.isPlaying()){
			btnplay.setVisibility(ImageView.INVISIBLE);
			btnpause.setVisibility(ImageView.VISIBLE);
			PlaybotFragment.pbplay.setVisibility(ImageView.INVISIBLE);
			PlaybotFragment.pbpause.setVisibility(ImageView.VISIBLE);
		}else{
			btnplay.setVisibility(ImageView.VISIBLE);
			btnpause.setVisibility(ImageView.INVISIBLE);
			PlaybotFragment.pbplay.setVisibility(ImageView.VISIBLE);
			PlaybotFragment.pbpause.setVisibility(ImageView.INVISIBLE);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phatnhac);
		
//		ListMp3.setContext(this);
//		mylist = ListMp3.scanSdcard();
//		
		mylist = MymusicAdapter.mylist1;
		
		util = new Utilities();
		back = (RelativeLayout) findViewById(R.id.back);
		btnplay=(ImageView) findViewById(R.id.btnplay);
		btnpause=(ImageView) findViewById(R.id.btnpause);
		next = (ImageView) findViewById(R.id.next);
		prev = (ImageView) findViewById(R.id.prev);
		tenbaihat = (TextView) findViewById(R.id.tenbh);
		tacgia = (TextView)findViewById(R.id.tacgia);
		hengio = (RelativeLayout) findViewById(R.id.hengio);
		find = (RelativeLayout) findViewById(R.id.find);
		rand_on = (RelativeLayout) findViewById(R.id.random_on);
		rand_off = (RelativeLayout) findViewById(R.id.random_off);
		repeat_off = (RelativeLayout) findViewById(R.id.repeat_off);
		repeat_one = (RelativeLayout) findViewById(R.id.repeat_one);
		repeat_all = (RelativeLayout) findViewById(R.id.repeat_all);
		
//		tenduoidia = (TextView) findViewById(R.id.tenduoidia);
//		tacgiaduoidia = (TextView) findViewById(R.id.tacgiaduoidia);
		ktisplaying();
		seekbar = (SeekBar) findViewById(R.id.seekbar);
		fulltime =(TextView)findViewById(R.id.fulltime);
		time = (TextView)findViewById(R.id.time);
		back.setOnClickListener(this);
		btnplay.setOnClickListener(this);
		btnpause.setOnClickListener(this);
		next.setOnClickListener(this);
		prev.setOnClickListener(this);
		hengio.setOnClickListener(this);
		find.setOnClickListener(this);
		
		kiemtratrangthai(PlaybotFragment.trangthai_rand,PlaybotFragment.trangthai_repeat);
		
		fulltime.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getDuration()));
		
		seekbar.setMax(MyMediaPlayer.getDuration());
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				MyMediaPlayer.start();
			}
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				time.setText(""+util.milliSecondsToTimer(progress));
				if (fromUser)
					MyMediaPlayer.seekTo(seekBar.getProgress());
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			MyMediaPlayer.pause();
			}
		});
		
		viewPager = (ViewPager)findViewById(R.id.view);
		//MyFragmentAdapter adapter = new MyFragmentAdapter(this);
		MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		a=(TextView)findViewById(R.id.a);
		b=(TextView)findViewById(R.id.b);
		c=(TextView)findViewById(R.id.c);
		b.setBackgroundColor(0xFFd668ff);
		
		viewPager.setCurrentItem(1, true);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					a.setBackgroundColor(0xFFd668ff);
					b.setBackgroundColor(0xFF808080);
					c.setBackgroundColor(0xFF808080);
					break;
				case 1:
					b.setBackgroundColor(0xFFd668ff);
					a.setBackgroundColor(0xFF808080);
					c.setBackgroundColor(0xFF808080);
					break;
				case 2:
					c.setBackgroundColor(0xFFd668ff);
					b.setBackgroundColor(0xFF808080);
					a.setBackgroundColor(0xFF808080);
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		new Thread(run).start();
		//Lay vitri
		intent=getIntent();
		vitri=intent.getIntExtra("position", 1);
		PlaybotFragment.vitri=vitri;
		tenbaihat =(TextView)findViewById(R.id.tenbh);
		PlaybotFragment.setNameArtist(mylist.get(vitri).getName(), mylist.get(vitri).getArtist());
		tenbaihat.setText(""+mylist.get(vitri).getName());
		tacgia.setText(""+mylist.get(vitri).getArtist());
		
//		WoaydiaFragment.setblabla(mylist.get(vitri).getName(),mylist.get(vitri).getArtist());
//		tenduoidia.setText(""+mylist.get(vitri).getName());
//		tacgiaduoidia.setText(""+mylist.get(vitri).getArtist());
		
		rand_on.setOnClickListener(this);
		rand_off.setOnClickListener(this);
		repeat_off.setOnClickListener(this);
		repeat_one.setOnClickListener(this);
		repeat_all.setOnClickListener(this);
		
		
	}
	
	Runnable run = new Runnable() { 
		@Override public void run() { 
			try{
				seekUpdation();
				time.setText(""+util.milliSecondsToTimer(MyMediaPlayer.getCurrentPosition()));
				ImageView wuaydia = (ImageView) findViewById(R.id.woaydia);
				if(MyMediaPlayer.isPlaying()){
				if (wuaydia != null)
					wuaydia.setRotation(rotation);
				rotation+=1.2;
				if(rotation>=360) rotation=0;
				}else{
					wuaydia.setRotation(rotation);
				}
			}
			catch(Exception ex){
				
			}
			} 
		}; 
	public void seekUpdation() { 
		seekbar.setProgress(MyMediaPlayer.getCurrentPosition()); 
		seekHandler.postDelayed(run, 50); 
		}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.back: {
				PhatnhacActivity.this.finish();
				break;
				}
			case R.id.btnplay: {
				
//				MyMediaPlayer.start();
				MyPlayer.setContext(getApplicationContext());
				MyPlayer.start();
				isplay();
				break;
				}
			case R.id.btnpause: {
				MyPlayer.setContext(getApplicationContext());
				MyPlayer.pause();
//				MyMediaPlayer.pause();
				ispause();
				break;
				}
			case R.id.next: {
				if(PlaybotFragment.trangthai_rand==0)
				next();
				else {
					int rand = rand(0, MymusicAdapter.mylist1.size()-1);
					nextrandom(rand);
				}
				break;
				}
			case R.id.prev: {
				if(PlaybotFragment.trangthai_rand==0)
					prev();
					else {
						int rand = rand(0, MymusicAdapter.mylist1.size()-1);
						nextrandom(rand);
					}
				break;
				}
			case R.id.hengio: {
				Toast.makeText(this, "hengio",Toast.LENGTH_LONG).show();
				break;
				}
			case R.id.find: {
				Toast.makeText(this, "find",Toast.LENGTH_LONG).show();
				break;
				}
			case R.id.random_off: {
				MyMediaPlayer.setoncompletionrandom();
				PlaybotFragment.trangthai_rand=1;
				rand_off.setVisibility(RelativeLayout.INVISIBLE);
				rand_on.setVisibility(RelativeLayout.VISIBLE);
				break;
				}
			case R.id.random_on: {
				MyMediaPlayer.setoncompletion();
				PlaybotFragment.trangthai_rand=0;
				rand_off.setVisibility(RelativeLayout.VISIBLE);
				rand_on.setVisibility(RelativeLayout.INVISIBLE);
				break;
				}
			case R.id.repeat_off: {
				PlaybotFragment.trangthai_repeat=1;
				MyMediaPlayer.setoncompletionrepeat_one();
				repeat_off.setVisibility(RelativeLayout.INVISIBLE);
				repeat_one.setVisibility(RelativeLayout.VISIBLE);
				repeat_all.setVisibility(RelativeLayout.INVISIBLE);
				break;
				}
			case R.id.repeat_one: {
				MyMediaPlayer.setoncompletion();
				PlaybotFragment.trangthai_repeat=2;
				repeat_off.setVisibility(RelativeLayout.INVISIBLE);
				repeat_one.setVisibility(RelativeLayout.INVISIBLE);
				repeat_all.setVisibility(RelativeLayout.VISIBLE);
				break;
				}
			case R.id.repeat_all: {
				MyMediaPlayer.setoncompletionrepeat_off();
				PlaybotFragment.trangthai_repeat=0;
				repeat_off.setVisibility(RelativeLayout.VISIBLE);
				repeat_one.setVisibility(RelativeLayout.INVISIBLE);
				repeat_all.setVisibility(RelativeLayout.INVISIBLE);
				break;
				}
		}
	}
	public static int rand(int min, int max) {
		try {
			Random rn = new Random();
			int range = max - min + 1;
			int randomNum = min + rn.nextInt(range);
			return randomNum;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	private void kiemtratrangthai(int trangthai_random,int trangthai_repeat){
		switch (trangthai_random) {
		case 0:
			MyMediaPlayer.setoncompletion();
			rand_off.setVisibility(RelativeLayout.VISIBLE);
			rand_on.setVisibility(RelativeLayout.INVISIBLE);
			break;
		case 1:
			MyMediaPlayer.setoncompletionrandom();
			rand_off.setVisibility(RelativeLayout.INVISIBLE);
			rand_on.setVisibility(RelativeLayout.VISIBLE);
			break;
		default:
			break;
		}
		switch (trangthai_repeat) {
		case 0:
			MyMediaPlayer.setoncompletionrepeat_off();
			repeat_off.setVisibility(RelativeLayout.VISIBLE);
			repeat_one.setVisibility(RelativeLayout.INVISIBLE);
			repeat_all.setVisibility(RelativeLayout.INVISIBLE);
			break;
		case 1:
			MyMediaPlayer.setoncompletionrepeat_one();
			repeat_off.setVisibility(RelativeLayout.INVISIBLE);
			repeat_one.setVisibility(RelativeLayout.VISIBLE);
			repeat_all.setVisibility(RelativeLayout.INVISIBLE);
			break;
		case 2:
			MyMediaPlayer.setoncompletion();
			repeat_off.setVisibility(RelativeLayout.INVISIBLE);
			repeat_one.setVisibility(RelativeLayout.INVISIBLE);
			repeat_all.setVisibility(RelativeLayout.VISIBLE);
			break;
		default:
			break;
		}
	}
	public static void isplay(){
		btnplay.setVisibility(ImageView.INVISIBLE);
		btnpause.setVisibility(ImageView.VISIBLE);
		PlaybotFragment.pbplay.setVisibility(ImageView.INVISIBLE);
		PlaybotFragment.pbpause.setVisibility(ImageView.VISIBLE);
	}
	public static void ispause(){
		btnplay.setVisibility(ImageView.VISIBLE);
		btnpause.setVisibility(ImageView.INVISIBLE);
		PlaybotFragment.pbplay.setVisibility(ImageView.VISIBLE);
		PlaybotFragment.pbpause.setVisibility(ImageView.INVISIBLE);
	}
	private class MyFragmentAdapter extends FragmentPagerAdapter{

		public MyFragmentAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:		
				return new ListChaynhacFragment();
			case 1:
				return new WoaydiaFragment();
			case 2:
				return new AnimationChaychuFragment("Hiện chưa có lời cho bài hát này. :)");
			}
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}
		
	}

}
