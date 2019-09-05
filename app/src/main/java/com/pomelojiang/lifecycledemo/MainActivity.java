package com.pomelojiang.lifecycledemo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.pomelojiang.lifecycledemo.lifecycle.LifecycleHelper;

/**
 * @author pomelojiang
 * @date 19-9-5
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册
        LifecycleHelper.getInstance().register(this,new LifecycleListenerImpl());
    }
}
