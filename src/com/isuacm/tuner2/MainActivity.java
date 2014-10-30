package com.isuacm.tuner2;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{

	private Button					playEButton;
	private Button			playAButton;
	private Button			playDButton;
	private Button			playGButton;
	private Button			playBButton;
	private Button			playESmallButton;
	private SoundPool				soundpool;
	private SparseIntArray	soundsmap;
	private int						SixthStringE		= 6;
	private int						FifthStringA		= 5;
	private int						FourthStringD		= 4;
	private int						ThirdStringG		= 3;
	private int						SecondStringB		= 2;
	private int						FirstStringESmall	= 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		playEButton = (Button) findViewById(R.id.playEButton);
		playAButton = (Button) findViewById(R.id.playAButton);
		playDButton = (Button) findViewById(R.id.playDButton);
		playGButton = (Button) findViewById(R.id.playGButton);
		playBButton = (Button) findViewById(R.id.playBButton);
		playESmallButton = (Button) findViewById(R.id.playESmallButton);

		soundpool = new SoundPool(6, AudioManager.STREAM_MUSIC, 100);
		soundsmap = new SparseIntArray();
		soundsmap
				.put(SixthStringE, soundpool.load(this, R.raw.six_string_e, 1));
		soundsmap.put(FifthStringA,
				soundpool.load(this, R.raw.fifth_string_a, 1));
		soundsmap.put(FourthStringD,
				soundpool.load(this, R.raw.fourth_string_d, 1));
		soundsmap.put(ThirdStringG,
				soundpool.load(this, R.raw.third_string_g, 1));
		soundsmap.put(SecondStringB,
				soundpool.load(this, R.raw.second_string_b, 1));
		soundsmap.put(FirstStringESmall,
				soundpool.load(this, R.raw.first_string_e, 1));


		playEButton.setOnClickListener(PlayNoteListener);
		playAButton.setOnClickListener(PlayNoteListener);
		playDButton.setOnClickListener(PlayNoteListener);
		playGButton.setOnClickListener(PlayNoteListener);
		playBButton.setOnClickListener(PlayNoteListener);
		playESmallButton.setOnClickListener(PlayNoteListener);

	}

	public void playSound(int sound)
	{
		AudioManager mgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		float streamVolumeCurrent = mgr
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		float streamVolumeMax = mgr
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		float volume = streamVolumeCurrent / streamVolumeMax;

		soundpool.play(soundsmap.get(sound), volume, volume, 1, 0, 1);
	}

	private OnClickListener	PlayNoteListener	= new OnClickListener()
												{

													@Override
													public void onClick(View v)
													{
														switch (v.getId())
														{
														case R.id.playEButton:
															playSound(SixthStringE);
															break;
														case R.id.playAButton:
															playSound(FifthStringA);
															break;
														case R.id.playDButton:
															playSound(FourthStringD);
															break;
														case R.id.playGButton:
															playSound(ThirdStringG);
															break;
														case R.id.playBButton:
															playSound(SecondStringB);
															break;
														case R.id.playESmallButton:
															playSound(FirstStringESmall);
															break;
														}

													};
												};


}
