package sdcard;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class ListMp3{
	private static Context context;
	public static void setContext(Context ct){
		context = ct;
	}
	public static ArrayList<MyFile> scanSdcard() {
		//
		ArrayList<MyFile> mBaiHats = new ArrayList<MyFile>();
		String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
		String[] projection = { MediaStore.Audio.Media.TITLE,
				MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DATA,
				MediaStore.Audio.Media.DISPLAY_NAME,
				MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ALBUM };
		final String sortOrder = MediaStore.Audio.AudioColumns.TITLE
				+ " COLLATE LOCALIZED ASC";

		Cursor cursor = null;
		try {
			Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
			cursor = context.getContentResolver().query(uri, projection,
					selection, null, sortOrder);
			if (cursor != null) {
				cursor.moveToFirst();
				while (!cursor.isAfterLast()) {
					MyFile baiHat = new MyFile(cursor.getString(0), cursor.getString(3),
							cursor.getString(2), cursor.getString(1),
							cursor.getString(4));
					mBaiHats.add(baiHat);
//					Log.d("loaded",cursor.getString(2));
					
//					for (int i = 0; i < projection.length; i++){
//						Log.d(projection[i],cursor.getString(i));
//					}
					
					cursor.moveToNext();
				}
			}
			return mBaiHats;
		} catch (Exception e) {
			return null;
		}
	}
//	public static Context getContext() {
//		return context;
//	}
//	public static void setContext(Context context) {
//		ListMp3.context = context;
//	}
}
