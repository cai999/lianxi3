package com.bwie.lainxi2.actvity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bwie.lainxi2.R;
import com.bwie.lainxi2.adapter.MyPageAdapter;
import com.bwie.lainxi2.fragment.Fragment1;
import com.bwie.lainxi2.fragment.Fragment2;
import com.bwie.lainxi2.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager view_page;
    private RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_page = (ViewPager) findViewById(R.id.view_page);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
        List<Fragment> list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager(), list);
        view_page.setAdapter(adapter);
        view_page.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radio_group.check(radio_group.getChildAt(position).getId());
                
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.btn1:
                        view_page.setCurrentItem(0);
                        break;
                    case R.id.btn2:
                        view_page.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        view_page.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
