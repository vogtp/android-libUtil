package ch.almana.android.util;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

public abstract class TouchRepeatListener implements View.OnTouchListener {
    private Handler mHandler;
    private long nextUpdate = Long.MIN_VALUE;
    private long updateSpeed;
    private long currentUpdateSpeed;

    public TouchRepeatListener(long updateSpeed){
        super();
        this.updateSpeed = updateSpeed;
    }


    final Runnable mUpdateTask = new Runnable() {
        public void run() {
            process();
            currentUpdateSpeed = Math.round(Math.floor(currentUpdateSpeed*.9));
            nextUpdate = SystemClock.uptimeMillis() + currentUpdateSpeed;
            mHandler.postAtTime(this, nextUpdate);
        }
    };

    public abstract void process();

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                handleDeleteDown();
                return true;
            }

            case MotionEvent.ACTION_UP: {
                handleDeleteUp();
                return true;
            }

            default:
                return false;
        }
    }


    private void handleDeleteDown() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        currentUpdateSpeed = updateSpeed;
        mHandler.post(mUpdateTask);
    }

    private void handleDeleteUp() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mUpdateTask);
            mHandler = null;
            nextUpdate = Long.MIN_VALUE;
        }
    }

}
