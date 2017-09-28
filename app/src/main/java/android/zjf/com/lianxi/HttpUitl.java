package android.zjf.com.lianxi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 破音D弦 on 2017/9/27.
 */

public class HttpUitl {
    public static void sendHttpRequest(final String adress, final HttpCallbackListenter listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                java.net.HttpURLConnection connection = null;
                try {
                    URL url = new URL(adress);
                    connection = (java.net.HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(8000);
                    connection.setConnectTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine())!= null){
                        response.append(line);
                    }
                    if(listener!=null){
                        //回调onFinish()方法
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                   if(listener!=null){
                       listener.onError(e);
                   }
                }finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }

    public static void sendOKHttpRequest(String adress,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(adress)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
