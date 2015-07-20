package com.example.alarmdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.widget.Toast;



public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		  Calendar now = Calendar.getInstance();
		  java.text.DateFormat formatter = SimpleDateFormat.getTimeInstance();
	     Toast.makeText(context, formatter.format(now.getTime()), Toast.LENGTH_SHORT).show();
	}

}
