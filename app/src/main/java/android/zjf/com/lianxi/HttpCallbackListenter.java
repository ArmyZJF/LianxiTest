package android.zjf.com.lianxi;

/**
 * Created by 破音D弦 on 2017/9/27.
 */

public interface HttpCallbackListenter {
    void onFinish(String response);
    void onError(Exception e);
}
