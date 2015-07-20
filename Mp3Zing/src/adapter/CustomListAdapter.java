package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mp3zing.R;

public class CustomListAdapter extends BaseAdapter {
	View rowView;

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

	private final Activity context;
	private final String[] name;
	private final Integer[] ic;

	public CustomListAdapter(Activity context, String[] name, Integer[] ic) {
		super();
		// TODO Auto-generated constructor stub
		this.context = context;
		this.name = name;
		this.ic = ic;
	}

	@Override
	public boolean isEnabled(int position) {
		return position == 2 || position == 10 ? false : true;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();

		if (name[position] == "ZING MP3" || name[position] == "CÔNG CỤ") {
			rowView = inflater.inflate(R.layout.item_customlist2_adapter,
					parent, false);
			TextView txtname = (TextView) rowView.findViewById(R.id.name2);

			txtname.setText(name[position]);

		} else {
			if (name[position] == "My Music"
					|| name[position] == "Zing Music Awards"
					|| name[position] == "Đóng Ứng Dụng") {
				rowView = inflater.inflate(R.layout.item_customlist3_adapter,
						parent, false);

				ImageView icon = (ImageView) rowView.findViewById(R.id.ic);
				TextView txtname = (TextView) rowView.findViewById(R.id.name);

				icon.setImageResource(ic[position]);
				txtname.setText(name[position]);
			}

			else {
				rowView = inflater.inflate(R.layout.item_customlist1_adapter,
						parent, false);

				ImageView icon = (ImageView) rowView.findViewById(R.id.ic);
				TextView txtname = (TextView) rowView.findViewById(R.id.name);

				icon.setImageResource(ic[position]);
				txtname.setText(name[position]);
			}
		}
		return rowView;

	};
}