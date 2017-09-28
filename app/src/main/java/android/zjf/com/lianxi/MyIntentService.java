package android.zjf.com.lianxi;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 破音D弦 on 2017/9/27.
 */

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    public MyIntentService(){
        super("MyIntentService");
    }
    
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: Thread id is "+ Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 执行了");
    }
}
