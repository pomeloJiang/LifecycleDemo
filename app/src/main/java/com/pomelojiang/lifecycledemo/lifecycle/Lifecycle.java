package com.pomelojiang.lifecycledemo.lifecycle;

import androidx.annotation.NonNull;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public interface Lifecycle {

    void addListener(@NonNull LifecycleListener listener);

    void removeListener(@NonNull LifecycleListener listener);
}
