package com.pomelojiang.lifecycledemo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public class LifecycleHelper {

    private static final String LIFECYCLE_FRAGMENT = "com.pomelojiang.lifecycle.fragment";
    private volatile static LifecycleHelper sInstance;

    private LifecycleHelper() {
    }

    public static LifecycleHelper getInstance() {
        if (sInstance == null) {
            synchronized (LifecycleHelper.class) {
                if (sInstance == null) {
                    sInstance = new LifecycleHelper();
                }
            }
        }
        return sInstance;
    }

    public void register(AppCompatActivity activity, LifecycleListener listener) {
        registerWithAppCompatActivity(activity, listener);
    }

    public void register(Fragment fragment, LifecycleListener listener) {
        registerWithFragment(fragment, listener);
    }

    private void registerWithAppCompatActivity(AppCompatActivity activity, LifecycleListener listener) {
        FragmentManager fm = activity.getSupportFragmentManager();
        LifecycleFragment fragment = getLifecycleFragment(fm);
        fragment.getAppLifecycle().addListener(listener);
    }

    private void registerWithFragment(Fragment fragment, LifecycleListener listener) {
        FragmentManager fm = fragment.getChildFragmentManager();
        LifecycleFragment lifecycleFragment = getLifecycleFragment(fm);
        lifecycleFragment.getAppLifecycle().addListener(listener);
    }

    private LifecycleFragment getLifecycleFragment(FragmentManager fm) {
        LifecycleFragment fragment = (LifecycleFragment) fm.findFragmentByTag(LIFECYCLE_FRAGMENT);
        if (fragment == null) {
            fragment = new LifecycleFragment();
            fm.beginTransaction().add(fragment, LIFECYCLE_FRAGMENT).commitAllowingStateLoss();
            fm.executePendingTransactions();
        }
        return fragment;
    }
}
