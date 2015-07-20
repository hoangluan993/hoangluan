package mediaplayer;

import android.content.Context;



public class MyPlayer {
	private static Context context;
	public static void setContext(Context ct){
		context = ct;
	}
	public static void play(String path){
		MyMediaPlayer.reset();
    	MyMediaPlayer.setDataSource(path);
    	MyMediaPlayer.prepare();
    	MyMediaPlayer.start();
    	Notification.setContext(context);
    	Notification.CustomNotification();
	}
	public static void next(String path){
		MyMediaPlayer.reset();
    	MyMediaPlayer.setDataSource(path);
    	MyMediaPlayer.prepare();
    	MyMediaPlayer.start();
	}
	public static void prev(String path){
		MyMediaPlayer.reset();
    	MyMediaPlayer.setDataSource(path);
    	MyMediaPlayer.prepare();
    	MyMediaPlayer.start();
	}
	public static void pause(){
		MyMediaPlayer.pause();
		Notification.stopNotification();
	}
	public static void start(){
		MyMediaPlayer.start();
		Notification.setContext(context);
    	Notification.CustomNotification();
	}
	
}
