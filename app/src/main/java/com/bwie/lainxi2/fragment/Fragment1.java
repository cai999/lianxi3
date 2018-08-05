package com.bwie.lainxi2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lainxi2.R;
import com.bwie.lainxi2.adapter.MyAdapter;
import com.bwie.lainxi2.bean.News;
import com.bwie.lainxi2.utils.XlistUtils;
import com.google.gson.Gson;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * Created by ll on 2018/7/14.
 */

public class Fragment1 extends Fragment {

    private View view;
    private XListView xlist_view;
    private int num = 1;
    private String path = "http://www.xieast.com/api/news/news.php?page=";
    List<News.DataBean> list = new ArrayList<>();
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initfrom();
        getdatafrom();
    }

    private void initfrom() {
        xlist_view = (XListView) view.findViewById(R.id.xlist_view);
        xlist_view.setPullLoadEnable(true);
        xlist_view.setPullRefreshEnable(true);
        xlist_view.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                num = 1;
                getdatafrom();
            }

            @Override
            public void onLoadMore() {
                num += 1;
                getdatafrom();
            }
        });
        adapter = new MyAdapter(getActivity(),list);
        xlist_view.setAdapter(adapter);
    }

    private void getdatafrom() {
        String url = path + num;
        XlistUtils utils = XlistUtils.getxlist();
        utils.getdata(url);
        utils.setxlister(new XlistUtils.xlister() {
            @Override
            public void getjson(String json) {
                Gson gson = new Gson();
                News news = gson.fromJson(json, News.class);
                List<News.DataBean> data = news.getData();
                if (num == 1) {
                    list.clear();
                }
                list.addAll(data);
                adapter.notifyDataSetChanged();
                if (num == 1) {
                    xlist_view.stopRefresh();
                } else {
                    xlist_view.stopLoadMore();
                }
            }
        });
    }
}
