package com.example.animalapps.views;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.animalapps.R;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;

import java.util.logging.Handler;

public class MusicObserverAudio implements LifecycleObserver {

    private String LOG_TAG = "DemoObserver";
    MediaPlayer mp;
    Context context;

    private SimpleExoPlayer mSimpleExoPlayer;

    private SimpleExoPlayerView mSimpleExoPlayerView;

    private Handler mMainHandler;
    private AdaptiveTrackSelection.Factory mAdaptiveTrackSelectionFactory;
    private TrackSelector mTrackSelector;
    private LoadControl mLoadControl;
    private DefaultBandwidthMeter mBandwidthMeter;
    private DataSource.Factory mDataSourceFactory;
    private SimpleCache mSimpleCache;
    private DataSource.Factory mFactory;
    private MediaSource mVideoSource;
    private LoopingMediaSource mLoopingMediaSource;
    private ProgressBar mProgressBar;




    public MusicObserverAudio(MediaPlayer mp, Context context) {
        this.mp = mp;
        this.context = context;
    }

    void playMusic()
    {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        mp = MediaPlayer.create(context, R.raw.meuo);
        mp.start();
        Log.i(LOG_TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.i(LOG_TAG, "onPause");
        mp.pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.i(LOG_TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.i(LOG_TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        mp.stop();
        mp.release();
        Log.i(LOG_TAG, "onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

        Log.i(LOG_TAG, "onDestroy");
    }



}
