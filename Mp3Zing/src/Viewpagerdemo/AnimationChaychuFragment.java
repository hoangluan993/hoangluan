package Viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mp3zing.R;

public class AnimationChaychuFragment extends Fragment {
	// TextView tv;
	// @Override
	// protected void onCreate(Bundle arg0) {
	// // TODO Auto-generated method stub
	// super.onCreate(arg0);
	// setContentView(R.layout.fragment_chaychu_animation);
	// tv = (TextView) findViewById(R.id.animation_txt);
	// // tv.setText(nameFragment);
	// AnimationSet animationSet = (AnimationSet)
	// AnimationUtils.loadAnimation(this, R.anim.set_anim);
	// tv.startAnimation(animationSet);
	// }

	String nameFragment;

	public AnimationChaychuFragment(String nameFragment) {
		// TODO Auto-generated constructor stub
		this.nameFragment = nameFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_chaychu_animation,
				container, false);
		TextView tv = (TextView) view.findViewById(R.id.animation_txt);
		tv.setText(nameFragment);
		// AnimationSet animationSet = (AnimationSet)
		// AnimationUtils.loadAnimation(getActivity(), R.anim.set_anim);
		// tv.startAnimation(animationSet);
		return view;
	}
}
