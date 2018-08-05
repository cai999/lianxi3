package com.bwie.lainxi2.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ll on 2018/7/14.
 */

public class XlistUtils {

    private static XlistUtils xlistUtils;
    private static xlister xlister;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                String json = (String) msg.obj;
                xlister.getjson(json);
            }
        }
    };

    public static XlistUtils getxlist(){
        if(xlistUtils == null){
            xlistUtils = new XlistUtils();
        }
        return xlistUtils;
    }
    public void getdata(final String path){
      new Thread(){
          @Override
          public void run() {
              super.run();
              try {
                  URL url = new URL(path);
                  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                  connection.setReadTimeout(5000);
                  connection.setConnectTimeout(5000);
                  connection.setRequestMethod("GET");
                  if(connection.getResponseCode()==200){
                      InputStream inputStream = connection.getInputStream();
                      ByteArrayOutputStream bos = new ByteArrayOutputStream();
                      byte[] by = new byte[1024];
                      int len = 0;
                      while((len = inputStream.read(by))!=-1){
                          bos.write(by,0,len);
                      }
                      inputStream.close();
                      bos.close();
                      String json = bos.toString();
                      Log.i("aa",json);
                      Message message = new Message();
                      message.obj = json;
                      message.what = 0;
                      handler.sendMessage(message);
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      }.start();
    }
    public interface xlister{
        public void getjson(String json);
    }
    public void setxlister(xlister xlister){
        this.xlister = xlister;
    }
}
