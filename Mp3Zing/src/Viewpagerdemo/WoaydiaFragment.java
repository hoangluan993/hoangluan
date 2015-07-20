package Viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mp3zing.R;

public class WoaydiaFragment extends Fragment implements OnItemSelectedListener {
	public static TextView tenduoidia,tacgiaduoidia;
	Spinner spin;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_woaydia, container, false);
		tenduoidia = (TextView) view.findViewById(R.id.tenduoidia);
		tacgiaduoidia = (TextView) view.findViewById(R.id.tacgiaduoidia);
		spin = (Spinner) view.findViewById(R.id.spin);

		// Array of Months acting as a data pump
		String[] objects = { "Select Action", "Action 1", "Action 2", "Action 3" };

		// Declaring an Adapter and initializing it to the data pump
		ArrayAdapter adapter = new ArrayAdapter(
		getActivity(),android.R.layout.simple_list_item_1 ,objects);

		// Setting Adapter to the Spinner
		spin.setAdapter(adapter);

		// Setting OnItemClickListener to the Spinner
		spin.setOnItemSelectedListener(this);
		return view;
	}
	public static void setblabla(String a, String b){
		tenduoidia.setText(a);
		tacgiaduoidia.setText(b);
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			break;

		default:
			Toast.makeText(getActivity(),
					spin.getItemAtPosition(position).toString(), Toast.LENGTH_LONG)
					.show();
			break;
		}
		
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
