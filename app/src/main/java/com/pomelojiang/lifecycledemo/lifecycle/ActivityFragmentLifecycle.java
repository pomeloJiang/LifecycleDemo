package com.pomelojiang.lifecycledemo.lifecycle;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public class ActivityFragmentLifecycle implements Lifecycle {

    private static final int STATUS_CREATED = 1;
    private static final int STATUS_RESUMED = 1 << 1;
    private static final int STATUS_STOPED = 1 << 2;
    private static final int STATUS_DESTROYED = 1 << 3;
    private int lifecycleStatus = 0;

    private Set<LifecycleListener> listenerSet =
            Collections.newSetFromMap(new WeakHashMap<LifecycleListener, Boolean>());

    @Override
    public void addListener(@NonNull LifecycleListener listener) {
        listenerSet.add(listener);
        switch (lifecycleStatus) {
            case STATUS_CREATED:
                listener.onCreate();
                break;
            case STATUS_RESUMED:
                listener.onResume();
                break;
            case STATUS_STOPED:
                listener.onStop();
                break;
            case STATUS_DESTROYED:
                listener.onDestroy();
                break;
        }
    }

    @Override
    public void removeListener(@NonNull LifecycleListener listener) {
        listenerSet.remove(listener);
    }

    public void onCreate() {
        lifecycleStatus = STATUS_CREATED;
        for (LifecycleListener listener : listenerSet) {
            listener.onCreate();
        }
    }

    public void onResume() {
        lifecycleStatus = STATUS_RESUMED;
        for (LifecycleListener listener : listenerSet) {
            listener.onResume();
        }
    }

    public void onStop() {
        lifecycleStatus = STATUS_STOPED;
        for (LifecycleListener listener : listenerSet) {
            listener.onStop();
        }
    }

    public void onDestroy() {
        lifecycleStatus = STATUS_DESTROYED;
        for (LifecycleListener listener : listenerSet) {
            listener.onDestroy();
        }
    }
}
