package com.elifinur.lepsworld;

import android.os.Bundle;
import android.view.MotionEvent;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.elifinur.lepsworld.LepsWorld;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		initialize(new LepsWorld(), config);

	}

}
