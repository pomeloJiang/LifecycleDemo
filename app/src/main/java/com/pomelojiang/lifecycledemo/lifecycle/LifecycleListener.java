package com.pomelojiang.lifecycledemo.lifecycle;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public interface LifecycleListener {
    void onCreate();

    void onResume();

    void onStop();

    void onDestroy();
}
