package mymusic;

import java.util.ArrayList;

import sdcard.MyFile;
import mediaplayer.MyPlayer;
import adapter.AlbumListAdapter;
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
import android.widget.ListView;

import com.example.mp3zing.R;

public class MymusicAlbumFragment extends Fragment{
	ArrayList<MyFile> mylist;
	ListView listalbum;
	FragmentTransaction fragtst;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mylist=MymusicAdapter.mylist1;
		View view = inflater.inflate(R.layout.fragment_viewpager_album, container, false);
		listalbum = (ListView) view.findViewById(R.id.listalbum);
		AlbumListAdapter adapter= new AlbumListAdapter(getActivity(), MymusicAdapter.mylist1);
		listalbum.setAdapter(adapter);
		listalbum.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				fragtst = getActivity().getSupportFragmentManager().beginTransaction();
	        	fragtst.replace(R.id.playbot,new PlaybotFragment());
	        	fragtst.commit();
				String path = mylist.get(position).getFullPath();
				MyPlayer.setContext(getActivity());
	        	MyPlayer.play(path);
	        	Intent i= new Intent(getActivity(),PhatnhacActivity.class);
				i.putExtra("position", position);
				startActivity(i);
				
			}
		});
		return view;
	}
}
