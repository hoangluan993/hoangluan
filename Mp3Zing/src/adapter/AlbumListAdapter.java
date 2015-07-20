package adapter;

import java.util.ArrayList;

import sdcard.MyFile;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mp3zing.R;

public class AlbumListAdapter extends BaseAdapter{

	ArrayList<MyFile> mylist = new ArrayList<MyFile>();
	LayoutInflater inflater;
	Context context;
	ImageView anh;
	public AlbumListAdapter(Context context,ArrayList<MyFile> mylist) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.mylist=mylist;
		inflater=LayoutInflater.from(this.context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mylist.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return mylist.get(position).getName();
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
	    inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	    if(convertView==null){
	    	convertView=inflater.inflate(R.layout.item_list_album, null);
	    	myholder=new myHolder();
	    	convertView.setTag(myholder);
	    }
	    else{
	    	myholder=(myHolder) convertView.getTag();
	    }
	    //set gia tri cho listView
	   myholder.textbh=setTextView(convertView, R.id.tenalbum, mylist.get(position).getArtist().toString());
	   myholder.textbh=setTextView(convertView, R.id.nhacalbum, mylist.get(position).getName().toString());
	   return convertView;
	}
	public TextView setTextView(View view ,int id,String text){
		TextView tv=(TextView) view.findViewById(id);
		tv.setText(text);
		return tv;
	}
	public static class myHolder{
		TextView textbh;
	}
	
	
}


