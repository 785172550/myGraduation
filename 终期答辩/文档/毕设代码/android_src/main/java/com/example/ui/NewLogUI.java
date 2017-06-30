package com.example.ui;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.com.example.base.BaseActivity;
import com.example.sean.liontest1.R;

import java.io.IOException;

/**
	* Created by Administrator on 2016/5/25.
	*/
public class NewLogUI extends BaseActivity implements View.OnClickListener {

				private SurfaceView surfaceview;
				private Button vip_log_btn, log_btn, reg_btn, forget_btn;
				private MediaPlayer mediaPlayer;

				@Override
				public void onCreate(Bundle savedInstanceState) {
								super.onCreate(savedInstanceState);
								requestWindowFeature(Window.FEATURE_NO_TITLE);
								getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
																WindowManager.LayoutParams.FLAG_FULLSCREEN);
								setContentView(R.layout.new_activity_log);
								surfaceview = (SurfaceView) findViewById(R.id.surfaceview);
								vip_log_btn = (Button) findViewById(R.id.log_1);
								log_btn = (Button) findViewById(R.id.log_2);
								reg_btn = (Button) findViewById(R.id.reg_new);
								forget_btn = (Button) findViewById(R.id.forget_new);
								initview();
				}

				private void initview() {
								mediaPlayer = new MediaPlayer();
								surfaceview.getHolder().setKeepScreenOn(true);
								surfaceview.getHolder().addCallback(new SurfaceViewLis());
								//btnGo.setOnClickListener(this);
				}

				// 点击事件
				@Override
				public void onClick(View v) {
								switch (v.getId()) {
												case R.id.log_1:
																break;
												case R.id.log_2:
																break;
												case R.id.reg_new:
																break;
												case R.id.forget_new:
																break;
								}
				}

				private void paly_video() {
								mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
								AssetFileDescriptor fd = null;
								try {
												fd = this.getAssets().openFd("bg-video.mp4");
												mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),
																				fd.getLength());
								} catch (IOException e) {
												e.printStackTrace();
								}
								mediaPlayer.setLooping(true);
								mediaPlayer.setDisplay(surfaceview.getHolder());
								// 通过异步的方式装载媒体资源
								mediaPlayer.prepareAsync();
								mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
												@Override
												public void onPrepared(MediaPlayer mp) {
																// 装载完毕回调
																mediaPlayer.start();
												}
								});
				}

				private void stop_video() {
								if (this.mediaPlayer != null) {
												this.mediaPlayer.release();
												this.mediaPlayer = null;
								}
				}

				// surfaceview 实现
				private class SurfaceViewLis implements SurfaceHolder.Callback {

								@Override
								public void surfaceCreated(SurfaceHolder holder) {
												paly_video();
								}

								@Override
								public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
								}

								@Override
								public void surfaceDestroyed(SurfaceHolder holder) {
												stop_video();
								}
				}
}
