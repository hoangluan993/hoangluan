package mediaplayer;

import java.util.Random;

import mymusic.PhatnhacActivity;
import mymusic.PlaybotFragment;
import adapter.MymusicAdapter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.mp3zing.MainActivity;

public class MyMediaPlayer extends AsyncTask<Void, String, Void> {
	static MediaPlayer mp;
	MainActivity activity;
//	static Context context;
//	public static void setContext(Context ct) {
//		context = ct;
//	}

	//
	MyMediaPlayer(MainActivity activity) {
		this.activity = activity;
	}

	public static void play(String path) {
		setDataSource(path);
		start();
	}

	public static void setDataSource(String path) {
		try {
			if (mp == null)
				mp = new MediaPlayer();
			mp.setDataSource(path);
		} catch (Exception ex) {
			Log.d("mp setDataSource", "faile");
		}
	}

	public static void start() {
		try {
			if (mp != null) {
				mp.start();
				PhatnhacActivity.btnplay.setVisibility(ImageView.INVISIBLE);
				PhatnhacActivity.btnpause.setVisibility(ImageView.VISIBLE);
				PlaybotFragment.pbplay.setVisibility(ImageView.INVISIBLE);
				PlaybotFragment.pbpause.setVisibility(ImageView.VISIBLE);
				// NotificationView.noti_play.setVisibility(ImageView.INVISIBLE);
				// NotificationView.noti_pause.setVisibility(ImageView.VISIBLE);
				// Notification.setContext(context);
				// Notification.CustomNotification();
			}
		} catch (Exception ex) {
			Log.d("mp play", "fail");
		}

	}

	public static void stop() {
		mp.stop();
	}

	public static void pause() {
		mp.pause();
		PhatnhacActivity.btnplay.setVisibility(ImageView.VISIBLE);
		PhatnhacActivity.btnpause.setVisibility(ImageView.INVISIBLE);
		PlaybotFragment.pbplay.setVisibility(ImageView.VISIBLE);
		PlaybotFragment.pbpause.setVisibility(ImageView.INVISIBLE);
		// NotificationView.noti_play.setVisibility(ImageView.VISIBLE);
		// NotificationView.noti_pause.setVisibility(ImageView.INVISIBLE);
	}

	public static void reset() {
		if (mp != null)
			mp.reset();
	}

	public static boolean isNull() {
		return (mp == null);
	}

	public static boolean isPlaying() {

		if (mp != null)
			return mp.isPlaying();
		else
			return false;
	}

	public static void prepare() {
		try {
			mp.prepare();
		} catch (Exception ex) {
			Log.d("mp prepare", "fail");
		}
	}

	public static int getCurrentPosition() {
		return mp.getCurrentPosition();
	}

	public static int getCurrentPosition_Percent() {
		return mp.getCurrentPosition() / mp.getDuration() * 100;
	}

	public static int getDuration() {
		return mp.getDuration();
	}

	public static void seekTo(int time) {
		mp.seekTo(time);
		// if (mp.getCurrentPosition() + time < 0)
		// mp.seekTo(0);
		// else if (mp.getCurrentPosition() + time > mp.getDuration())
		// mp.seekTo(mp.getDuration());
		// else mp.seekTo(mp.getCurrentPosition() + time);
	}

	public static void setoncompletion() {

		OnCompletionListener cListener = new OnCompletionListener() {

			public void onCompletion(MediaPlayer mp) {
				PhatnhacActivity.next();
			}
		};
		mp.setOnCompletionListener(cListener);

	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setoncompletionrandom() {

		OnCompletionListener cListener = new OnCompletionListener() {

			public void onCompletion(MediaPlayer mp) {
				int rand = rand(0, MymusicAdapter.mylist1.size()-1);
	        	PhatnhacActivity.nextrandom(rand);
			}
		};
		mp.setOnCompletionListener(cListener);

	}

	public static int rand(int min, int max) {
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
	public static void setoncompletionrepeat_one() {

		OnCompletionListener cListener = new OnCompletionListener() {

			public void onCompletion(MediaPlayer mp) {
//				int rand = rand(0, MymusicAdapter.mylist1.size()-1);
	        	PhatnhacActivity.nextrepeat_one();
			}
		};
		mp.setOnCompletionListener(cListener);

	}
	public static void setoncompletionrepeat_off() {

		OnCompletionListener cListener = new OnCompletionListener() {

			public void onCompletion(MediaPlayer mp) {
//				int rand = rand(0, MymusicAdapter.mylist1.size()-1);
	        	PhatnhacActivity.nextrepeat_off();
			}
		};
		mp.setOnCompletionListener(cListener);

	}
//	public static void setoncompletionrepeat_off1() {
//
//		OnCompletionListener cListener = new OnCompletionListener() {
//
//			public void onCompletion(MediaPlayer mp) {
//				MyPlayer.pause();
//			}
//		};
//		mp.setOnCompletionListener(cListener);
//
//	}
}
