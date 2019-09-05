package com.pomelojiang.lifecycledemo.lifecycle;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.jetbrains.annotations.NotNull;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public class LifecycleFragment extends Fragment {

    private ActivityFragmentLifecycle lifecycle;

    public LifecycleFragment() {
        this(new ActivityFragmentLifecycle());
    }

    public LifecycleFragment(ActivityFragmentLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @NotNull
    public ActivityFragmentLifecycle getAppLifecycle() {
        return lifecycle;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        lifecycle.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycle.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycle.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.onDestroy();
    }
}
