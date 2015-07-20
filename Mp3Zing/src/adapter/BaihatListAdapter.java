package adapter;

import java.util.ArrayList;

import sdcard.MyFile;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mp3zing.R;

@SuppressLint("InflateParams")
public class BaihatListAdapter extends BaseAdapter{

	ArrayList<MyFile> mlist = new ArrayList<MyFile>();
	LayoutInflater inflater;
	Context context;
	ImageView anh;
	public BaihatListAdapter(Context context,ArrayList<MyFile> mylist) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.mlist=mylist;
		inflater=LayoutInflater.from(this.context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlist.size()+1;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return mlist.get(position).getName();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	    myHolder myholder;
		if (position != 0) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_list_baihat, null);
				myholder = new myHolder();
				convertView.setTag(myholder);
			} else {
				myholder = (myHolder) convertView.getTag();
				if (((TextView)convertView.findViewById(R.id.tacgia)) == null){
					convertView = inflater.inflate(R.layout.item_list_baihat, null);
					myholder = new myHolder();
					convertView.setTag(myholder);
				}
			}
			// set gia tri cho listView
			myholder.textbh = setTextView(convertView, R.id.tenbh,
					mlist.get(position-1).getName().toString());
			myholder.textbh = setTextView(convertView, R.id.tacgia,
					mlist.get(position-1).getArtist().toString());
		}else{
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_list1_baihat, null);
			myholder = new myHolder();
			convertView.setTag(myholder);
		}
	   return convertView;
	}
	public TextView setTextView(View view ,int id,String text){
		TextView tv=(TextView) view.findViewById(id);
		tv.setText(text);
		return tv;
	}
	public static class myHolder{
		TextView textbh,tentacgia;
	}
	
	
}
