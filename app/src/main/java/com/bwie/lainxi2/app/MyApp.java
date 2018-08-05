package com.bwie.lainxi2.app;

import android.app.Application;

import com.bwei.imageloaderlibrary.utils.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by ll on 2018/7/15.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = ImageLoaderUtils.getConfiguration(this);
        ImageLoader.getInstance().init(configuration);
    }
}
