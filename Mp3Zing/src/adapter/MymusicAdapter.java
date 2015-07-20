package adapter;

import java.util.ArrayList;

import sdcard.ListMp3;
import sdcard.MyFile;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mp3zing.R;

public class MymusicAdapter extends BaseAdapter {
	View rowView;
	public static ArrayList<MyFile> mylist1;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return name[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public boolean isEnabled(int position) {
		return position == 0 || position == 1 || position == 8 ? false : true;
	}
	private final Activity context;
	private final String[] name;
	private final Integer[] ic;

	public MymusicAdapter(Activity context, String[] name, Integer[] ic) {
		super();
		// TODO Auto-generated constructor stub
		this.context = context;
		this.name = name;
		this.ic = ic;
		ListMp3.setContext(context);
		mylist1 = ListMp3.scanSdcard();
	}

	@Override
	public int getViewTypeCount() {
		return name.length;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();

		if (name[position] == "anh 1") {
			rowView = inflater.inflate(R.layout.item_mymusic1_adapter, parent, false);

			ImageView icon = (ImageView) rowView.findViewById(R.id.avatar);
			TextView txtname = (TextView) rowView.findViewById(R.id.text);
			TextView sobaihat = (TextView) rowView.findViewById(R.id.sobaihat);
			icon.setImageResource(ic[position]);
			txtname.setText("My Music");
			sobaihat.setText(""+mylist1.size());
		} else {
			if (name[position] == "Nhạc Offline"
					|| name[position] == "Nhạc Online") {

				rowView = inflater
						.inflate(R.layout.item_mymusic2_adapter, parent, false);

				TextView txtname = (TextView) rowView.findViewById(R.id.text);
				txtname.setText(name[position]);
			} else {
				if (name[position] == "Download"
						|| name[position] == "Nhạc upload") {

					rowView = inflater.inflate(R.layout.item_mymusic4_adapter, parent,
							false);
					ImageView icon = (ImageView) rowView.findViewById(R.id.ic);
					TextView txtname = (TextView) rowView
							.findViewById(R.id.text);

					icon.setImageResource(ic[position]);
					txtname.setText(name[position]);
				}else{
					if (name[position] == "Bài hát") {

						rowView = inflater.inflate(R.layout.item_mymusic3_adapter, parent,
								false);
						ImageView icon = (ImageView) rowView.findViewById(R.id.ic);
						TextView txtname = (TextView) rowView
								.findViewById(R.id.text);
						TextView sobh = (TextView) rowView
								.findViewById(R.id.sobh);

						icon.setImageResource(ic[position]);
						txtname.setText(name[position]);
						sobh.setText(""+mylist1.size());
					}
				else {

					rowView = inflater.inflate(R.layout.item_mymusic3_adapter, parent,
							false);

					ImageView icon = (ImageView) rowView.findViewById(R.id.ic);
					TextView txtname = (TextView) rowView
							.findViewById(R.id.text);

					icon.setImageResource(ic[position]);
					txtname.setText(name[position]);
				}
				}
			}
		}
		return rowView;

	};
}