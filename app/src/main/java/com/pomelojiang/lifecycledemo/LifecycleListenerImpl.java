package com.pomelojiang.lifecycledemo;

import android.util.Log;
import com.pomelojiang.lifecycledemo.lifecycle.LifecycleListener;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public class LifecycleListenerImpl implements LifecycleListener {

    private static final String TAG = LifecycleListener.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.d(TAG,"LifecycleListenerImpl::onCreate");
    }

    @Override
    public void onResume() {
        Log.d(TAG,"LifecycleListenerImpl::onResume");
    }

    @Override
    public void onStop() {
        Log.d(TAG,"LifecycleListenerImpl::onStop");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"LifecycleListenerImpl::onDestroy");
    }
}
