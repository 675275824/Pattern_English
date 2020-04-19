package Fragment_home;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.a67527.pattern_english.*;

import java.util.ArrayList;
import java.util.List;

import Hear_Listview.ItemBean;
import Hear_Listview.MyRecycleViewAdpter;

public class Fragment_hear extends Fragment {

    private RoundedBitmapDrawable circle_bitmap;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private List<ItemBean> list;
    private MyRecycleViewAdpter myAdapte1r;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate( R.layout.fg_hear,container,false);

        list = new ArrayList<ItemBean>();

        /*imageView = view.findViewById(R.id.iv_image);
        circle_bitmap = RoundedBitmapDrawableFactory.create(getActivity().getResources(),
                BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.item01));
        circle_bitmap.setCornerRadius(30);
        imageView.setImageDrawable(circle_bitmap);*/
        list.add(new ItemBean(
                R.drawable.item01,
                "明白事理的人使自己适应世界"
        ));
        list.add(new ItemBean(
                R.drawable.item02,
                "真相是一种美丽又可怕的东西"
        ));
        list.add(new ItemBean(
                R.drawable.item03,
                "所有幸福的家庭都相似"
        ));
        list.add(new ItemBean(
                R.drawable.item04,
                "失去的东西到最后总有办法"
        ));
        list.add(new ItemBean(
                R.drawable.item05,
                "如果世界上少一些同情。"
        ));
        list.add(new ItemBean(
                R.drawable.item06,
                "如果世界上少一些同情。"
        ));
        list.add(new ItemBean(
                R.drawable.item01,
                "失去的东西到最后总有办法"
        ));
        list.add(new ItemBean(
                R.drawable.item02,
                "尽管有时会出乎我们的意料"
        ));
        list.add(new ItemBean(
                R.drawable.item06,
                "如果世界上少一些同情"
        ));
        list.add(new ItemBean(
                R.drawable.item01,
                "失去的东西到最后总有办法"
        ));
        list.add(new ItemBean(
                R.drawable.item02,
                "尽管有时会出乎我们的意料"
        ));
        list.add(new ItemBean(
                R.drawable.item03,
                "所有幸福的家庭都相似。"
        ));
        list.add(new ItemBean(
                R.drawable.item04,
                "失去的东西到最后总有办法。"
        ));
        list.add(new ItemBean(
                R.drawable.item05,
                "如果世界上少一些同情。"
        ));
        myAdapte1r = new MyRecycleViewAdpter(list);
        recyclerView = (RecyclerView) view.findViewById(R.id.hear_recycleview);

        //纵向线性布局
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //纵向线性布局
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapte1r);
        return view;
    }
}
