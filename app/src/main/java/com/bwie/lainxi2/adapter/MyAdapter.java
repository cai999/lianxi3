package com.bwie.lainxi2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.imageloaderlibrary.utils.ImageLoaderUtils;
import com.bwie.lainxi2.R;
import com.bwie.lainxi2.bean.News;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ll on 2018/7/15.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<News.DataBean> list;
    private int one = 0;
    private int two = 1;

    public MyAdapter(Context context, List<News.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        String pic_s = list.get(position).getThumbnail_pic_s();
        String pic_s1 = list.get(position).getThumbnail_pic_s02();
        String pic_s2 = list.get(position).getThumbnail_pic_s03();
        if(pic_s!=null&&pic_s1==null&&pic_s2==null){
           return one;
        }else if (pic_s!=null&&pic_s1!=null&&pic_s2!=null){
            return two;
        }else{
            return one;
        }
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        ViewHolder holder = null;
        if(itemViewType==one) {
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.adapter1, null);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.img = (ImageView) convertView.findViewById(R.id.img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(list.get(position).getTitle());
            DisplayImageOptions options = ImageLoaderUtils.getOptions();
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(), holder.img, options);
            return convertView;
        }else{
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.adapter2, null);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.img = (ImageView) convertView.findViewById(R.id.img);
                holder.img1 = (ImageView) convertView.findViewById(R.id.img1);
                holder.img2 = (ImageView) convertView.findViewById(R.id.img2);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(list.get(position).getTitle());
            DisplayImageOptions options = ImageLoaderUtils.getOptions();
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(), holder.img, options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(), holder.img1, options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(), holder.img2, options);
            return convertView;
        }
    }
    public class ViewHolder{
        TextView title;
        ImageView img;
        ImageView img1;
        ImageView img2;

    }
}
