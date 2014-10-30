package com.isuacm.tuner2;


import com.isuacm.tuner2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PlayScreen extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activityplayscreen);
	
		Intent i = getIntent();
		String frequency = i.getStringExtra("FREQUENCY");
		
		Log.d("APP", "The frequency is: "+ frequency);
	}
}
