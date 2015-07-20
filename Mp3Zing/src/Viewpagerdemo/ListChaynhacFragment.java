package Viewpagerdemo;

import mediaplayer.MyPlayer;
import mymusic.PhatnhacActivity;
import adapter.ChaynhacListAdapter;
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

public class ListChaynhacFragment extends Fragment {
	ListView listchaynhac;
	FragmentTransaction fragtst;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_chaynhac_list, container, false);
		listchaynhac=(ListView) view.findViewById(R.id.listchaynhac);
		ChaynhacListAdapter adapter = new ChaynhacListAdapter(getActivity(),MymusicAdapter.mylist1);
		listchaynhac.setAdapter(adapter);
		listchaynhac.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				fragtst = getActivity().getSupportFragmentManager().beginTransaction();
//	        	fragtst.replace(R.id.playbot,new PlaybotFragment());
//	        	fragtst.commit();
	        	
				getActivity().finish();
	        	String path = MymusicAdapter.mylist1.get(position).getFullPath();
	        	MyPlayer.play(path);
	        	
				Intent i= new Intent(getActivity(),PhatnhacActivity.class);
				i.putExtra("position", position);
				startActivity(i);
				
			}
		});
		return view;
	}
	
}
