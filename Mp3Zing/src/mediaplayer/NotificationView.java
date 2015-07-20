package mediaplayer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mp3zing.R;


public class NotificationView extends Activity {
	public static ImageView noti_play,noti_pause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		
//		noti_play = (ImageView) findViewById(R.id.noti_play);
//		noti_pause = (ImageView) findViewById(R.id.noti_pause);
//		if(MyMediaPlayer.isPlaying()){
//			noti_play.setVisibility(ImageView.INVISIBLE);
//			noti_pause.setVisibility(ImageView.VISIBLE);
//		}else{
//			noti_play.setVisibility(ImageView.VISIBLE);
//			noti_pause.setVisibility(ImageView.INVISIBLE);
//		}
	}
}