package mediaplayer;

import java.util.Random;

import mymusic.PhatnhacActivity;
import mymusic.PlaybotFragment;
import adapter.MymusicAdapter;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.mp3zing.R;

public class Notification {
	public static RemoteViews remoteViews;
	static int ispause=1; 
	
	private static Context context;
	public static void setContext(Context ct){
		context = ct;
	}
	public static void CustomNotification() {
		remoteViews = new RemoteViews(context.getPackageName(),
				R.layout.notification);
		
//		String strtitle = "lepdaica1";
//		String strtext = "lepdaica2";
		Intent intent = new Intent(context, NotificationView.class);
//		intent.putExtra("title", strtitle);
//		intent.putExtra("text", strtext);
		PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
				.setSmallIcon(R.drawable.ic_notification_small)
				.setTicker("Mp3 Zing")
				//.setAutoCancel(false)
				.setContentIntent(pIntent)
				.setContent(remoteViews);
				
		remoteViews.setImageViewResource(R.id.noti_pause,R.drawable.ic_notif_pause);
		
		 Intent prev = new Intent("prev");
		 PendingIntent pendingprevIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, prev, PendingIntent.FLAG_UPDATE_CURRENT);
		 remoteViews.setOnClickPendingIntent(R.id.noti_prev,pendingprevIntent);
		 
		 Intent pause = new Intent("pause");
		 PendingIntent pendingpauseIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, pause, PendingIntent.FLAG_UPDATE_CURRENT);
		 remoteViews.setOnClickPendingIntent(R.id.noti_pause,pendingpauseIntent);
		 Intent play = new Intent("play");
		 PendingIntent pendingplayIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, play, PendingIntent.FLAG_UPDATE_CURRENT);
		 remoteViews.setOnClickPendingIntent(R.id.noti_play,pendingplayIntent);
		 
		 Intent next = new Intent("next");
		 PendingIntent pendingnextIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, next, PendingIntent.FLAG_UPDATE_CURRENT);
		 remoteViews.setOnClickPendingIntent(R.id.noti_next,pendingnextIntent);
		 
		 Intent exit = new Intent("exit");
		 PendingIntent pendingexitIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, exit, PendingIntent.FLAG_UPDATE_CURRENT);
		 remoteViews.setOnClickPendingIntent(R.id.noti_exit,pendingexitIntent);
		 
		NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationmanager.notify(0, builder.build());
	

	}
	public static class switchButtonListener extends BroadcastReceiver {
	    @Override
	    public void onReceive(Context context, Intent intent) {
	    	String action = intent.getAction();
	    	Log.d("action",action);
	    	switch (action) {
			case "pause":
				if(ispause==1){
				MyMediaPlayer.pause();
				ispause=0;
				}else{
					MyMediaPlayer.start();
					ispause=1;
				}
//				MyMediaPlayer.pause();
//				CustomNotification();
				break;
			case "play":
				Log.d("action",action);
				break;	
			case "next":
				if(PlaybotFragment.trangthai_rand==0)
					PhatnhacActivity.next();
					else {
						int rand = rand(0, MymusicAdapter.mylist1.size()-1);
						PhatnhacActivity.nextrandom(rand);
					}
				break;
			case "prev":
				if(PlaybotFragment.trangthai_rand==0)
					PhatnhacActivity.prev();
					else {
						int rand = rand(0, MymusicAdapter.mylist1.size()-1);
						PhatnhacActivity.nextrandom(rand);
					}
				break;
			case "exit":
				MyPlayer.pause();
				break;
			default:
				break;
			}
			}
	    }
	public static void stopNotification(){
		NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationmanager.cancel(0);
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
}
