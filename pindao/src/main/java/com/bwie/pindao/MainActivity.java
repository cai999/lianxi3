package com.bwie.pindao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.bwie.pindao.bean.ChnnelBean;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private String[] titles = {"推荐", "热点", "上海", "视频", "社会",
            "订阅", "娱乐", "图片", "科技", "汽车",
            "体育", "财经", "军事", "国际", "段子",
            "趣图", "美女", "健康", "正能量", "特卖",
            "中国好声音", "历史", "时尚", "辟谣", "探索", "美国",
            "搞笑", "故事", "奇葩", "情感"};
    private Button mBtnid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initview();
        //initdata();
        mBtnid = (Button) findViewById(R.id.btn);
        mBtnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ChannelBean> list = new ArrayList<>();
                for (int i = 0; i < titles.length; i++) {
                    //创建一个list需要的对象
                    ChannelBean bean = null;
                    if (i < 10) {
                        //前五个默认选中
                        bean = new ChannelBean(titles[i], true);
                    } else {
                        bean = new ChannelBean(titles[i], false);
                    }

                    list.add(bean);
                }
                ChannelActivity.startChannelActivity(MainActivity.this,list);
            }
        });
    }
}


 /*   private void initdata() {
        list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(new ChnnelBean(i+"",i<5 ?false:true));
        }
    }

    private void initview() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                ChannelActivity.startChannelActivity(this, String.valueOf(list));
                break;
        }
    }*/

