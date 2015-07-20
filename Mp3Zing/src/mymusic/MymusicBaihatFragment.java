package mymusic;

import java.util.ArrayList;
import java.util.Random;

import mediaplayer.MyPlayer;
import sdcard.MyFile;
import adapter.BaihatListAdapter;
import adapter.MymusicAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mp3zing.R;

public class MymusicBaihatFragment extends Fragment{
	ArrayList<MyFile> mylist;
	ListView list;
	ImageView test;
	RelativeLayout playbottom;
	FragmentTransaction fragtst;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//mylist = scanSdcard();
//		ListMp3.setContext(this.getActivity());
//		mylist = ListMp3.scanSdcard();
		mylist = MymusicAdapter.mylist1;
		
		View view = inflater.inflate(R.layout.fragment_viewpager_baihat, container, false);
		list=(ListView)view.findViewById(R.id.listbh);
		
		BaihatListAdapter adapter= new BaihatListAdapter(getActivity(), mylist);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			public int rand(int min, int max) {
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
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					if(MymusicAdapter.mylist1.size()==0){
						Toast.makeText(getActivity(), "Không tìm thấy nhạc :(", Toast.LENGTH_LONG).show();
					}else{
					fragtst = getActivity().getSupportFragmentManager().beginTransaction();
		        	fragtst.replace(R.id.playbot,new PlaybotFragment());
		        	fragtst.commit();
		        	int rand = rand(0, mylist.size()-1);
		        	String path1 = mylist.get(rand).getFullPath();
		        	MyPlayer.setContext(getActivity());
		        	MyPlayer.play(path1);
		        	
//		        	Notification.setContext(getActivity());
//		        	Notification.CustomNotification();
					Intent i1= new Intent(getActivity(),PhatnhacActivity.class);
					i1.putExtra("position", rand);
					startActivity(i1);
					}
					break;

				default:{
					fragtst = getActivity().getSupportFragmentManager().beginTransaction();
		        	fragtst.replace(R.id.playbot,new PlaybotFragment());
		        	fragtst.commit();
		        	
		        	String path = mylist.get(position-1).getFullPath();
		        	MyPlayer.setContext(getActivity());
//		        	Notification.CustomNotification();
		        	MyPlayer.play(path);
		        	
					Intent i= new Intent(getActivity(),PhatnhacActivity.class);
					i.putExtra("position", position-1);
					startActivity(i);
				}
					break;
				}
				
				
			}
		});
		return view;
	}
}
