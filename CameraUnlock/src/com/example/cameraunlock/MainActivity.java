package com.example.cameraunlock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		unlockphone();
goToCamera();
	}



	@SuppressLint("Wakelock")
	@SuppressWarnings("deprecation")
	private void unlockphone() {
		// TODO Auto-generated method stub
		KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE); 
		final KeyguardManager.KeyguardLock kl = km .newKeyguardLock("MyKeyguardLock"); 
		kl.disableKeyguard(); 

		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE); 
		WakeLock wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
		                                 | PowerManager.ACQUIRE_CAUSES_WAKEUP
		                                 | PowerManager.ON_AFTER_RELEASE, "MyWakeLock");
		wakeLock.acquire();

	}
	private void goToCamera() {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					Intent i = new Intent("com.example.cameraunlock.CAMERA");
					startActivity(i);

				}
			}

		};
		t.start();
		
	}

}
