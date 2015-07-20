package mymusic;

import java.util.ArrayList;
import java.util.Random;

import mediaplayer.MyMediaPlayer;
import mediaplayer.MyPlayer;
import sdcard.ListMp3;
import sdcard.MyFile;
import adapter.MymusicAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mp3zing.R;

public class PlaybotFragment extends Fragment implements OnClickListener{
	public static ImageView pbplay;
	public static ImageView pbpause;
	ImageView pbnext;
	ImageView pbprev;
	RelativeLayout playbot;
	ArrayList<MyFile> mylist;
	public static TextView tenbaihat,tacgia;
	public static int vitri;
	public static int trangthai_rand, trangthai_repeat;
	
	public static void isplay(){
		pbplay.setVisibility(ImageView.INVISIBLE);
		pbpause.setVisibility(ImageView.VISIBLE);
	}
	public static void ispause(){
		pbplay.setVisibility(ImageView.VISIBLE);
		pbpause.setVisibility(ImageView.INVISIBLE);
	}
	public static void setNameArtist(String name, String artist){
		tenbaihat.setText(name);
		tacgia.setText(artist);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		ListMp3.setContext(getActivity());
		mylist = ListMp3.scanSdcard();
		
		View view = inflater.inflate(R.layout.fragment_playbottom, container, false);
		playbot=(RelativeLayout)view.findViewById(R.id.playbottom);
		pbplay =(ImageView) view.findViewById(R.id.pbplay);
		pbpause =(ImageView) view.findViewById(R.id.pbpause);
		pbnext =(ImageView) view.findViewById(R.id.pbnext);
		pbprev =(ImageView) view.findViewById(R.id.pbprev);
		tenbaihat =(TextView) view.findViewById(R.id.tenbaihat);
		tacgia  =(TextView) view.findViewById(R.id.tacgia);

		
		playbot.setOnClickListener(this);
		pbplay.setOnClickListener(this);
		pbpause.setOnClickListener(this);
		pbnext.setOnClickListener(this);
		pbprev.setOnClickListener(this);
		
		return view;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.playbottom: {
			Intent i= new Intent(getActivity(),PhatnhacActivity.class);
			i.putExtra("position", vitri);
			startActivity(i);
			break;
			}
		case R.id.pbplay: {
			MyMediaPlayer.start();
			MyPlayer.setContext(getActivity());
			MyPlayer.start();
			break;
			}
		case R.id.pbpause: {
//			MyMediaPlayer.pause();
			MyPlayer.pause();
			break;
			}
		case R.id.pbnext: {
			if(PlaybotFragment.trangthai_rand==0)
				PhatnhacActivity.next();
				else {
					int rand = rand(0, MymusicAdapter.mylist1.size()-1);
					PhatnhacActivity.nextrandom(rand);
				}
			break;
			}
		case R.id.pbprev: {
			if(PlaybotFragment.trangthai_rand==0)
				PhatnhacActivity.prev();
				else {
					int rand = rand(0, MymusicAdapter.mylist1.size()-1);
					PhatnhacActivity.nextrandom(rand);
				}
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
	
	
}
