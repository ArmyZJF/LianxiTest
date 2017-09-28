package android.zjf.com.servicebestpractice;

/**
 * Created by 破音D弦 on 2017/9/27.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPasused();
    void onCanceled();
}
