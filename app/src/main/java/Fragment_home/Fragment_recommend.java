package Fragment_home;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.a67527.pattern_english.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import recommend_listview.CardListView;
import recommend_listview.Recommend_Adpter;

public class Fragment_recommend extends Fragment {

    private SliderLayout mDemoSlider;
    List<CardListView> cardListViews1;
    Recommend_Adpter myAdpter1;
    private ListView listView1;
    List<CardListView> cardListViews2;
    Recommend_Adpter myAdpter2;
    private ListView listView2;

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        if(myAdpter1 == null)
        {

        }
        if(myAdpter2 == null)
        {

        }
        super.onActivityCreated(savedInstanceState);
    }

    /**
     *第一个:它的作用类似于findViewById()。不同点是LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化；
     * 而findViewById()是找xml布局文件下的具体widget控件(如Button、TextView等)。第二个:是容器,View放在里面.
     * 第三个:保存当前状态,在activity的生命周期中，只要离开了可见阶段，或者说失去了焦点，
     * activity就很可能被进程终止了！，被KILL掉了，这时候，就需要有种机制，能保存当时的状态，这就是savedInstanceState的作用。
     */



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        //需要inflater.inflate来从XML创建视图。它就像解析或转换XML以生成UI一样。
        View view = inflater.inflate(R.layout.fg_reconnmend,container,false);
        Log.e("fragment1","recommend");
        mDemoSlider = view.findViewById(R.id.slider);
        HashMap<String,String> urlMaps = new HashMap<>();
        urlMaps.put("Hannibal", "https://i0.hippopx.com/photos/320/918/427/sky-clouds-sunlight-dark-thumb.jpg");
        urlMaps.put("Big Bang Theory", "https://i0.hippopx.com/photos/20/987/594/woman-young-rain-pond-thumb.jpg");
        urlMaps.put("House of Cards", "https://i0.hippopx.com/photos/927/785/142/book-read-old-literature-thumb.jpg");
        urlMaps.put("House of Card", "https://i0.hippopx.com/photos/583/885/292/tianjin-twilight-city-scenery-thumb.jpg");

        for(String name : urlMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());

            textSliderView
//                    .description(name)//描述
                    .image(urlMaps.get(name))//image方法可以传入图片url、资源id、File
                    .setScaleType(BaseSliderView.ScaleType.Fit)//图片缩放类型
                    .setOnSliderClickListener(onSliderClickListener);//图片点击
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);//传入参数
            mDemoSlider.addSlider(textSliderView);//添加一个滑动页面
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);//滑动动画
//        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);//默认指示器样式
        mDemoSlider.setCustomIndicator((PagerIndicator)view.findViewById(R.id.custom_indicator2));//自定义指示器
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());//设置图片描述显示动画
        mDemoSlider.setDuration(4000);//设置滚动时间，也是计时器时间
        mDemoSlider.addOnPageChangeListener(onPageChangeListener);
        init();
        cardListViews1 = new ArrayList<>();
        listView1 = view.findViewById(R.id.recycler_view);
        myAdpter1 = new Recommend_Adpter(getActivity(),cardListViews1);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(System.currentTimeMillis());
        String time_list = dateStr.substring(2,10);
        cardListViews1.add(new CardListView(R.drawable.item01,"最具有可塑性的寄生生物",time_list,"Imagination is not to be divorced from the facts."));
        cardListViews1.add(new CardListView(R.drawable.item02,"想象不应该脱离现实,脚踏实地",time_list,"WImportant principles may and must be flexible "));
        cardListViews1.add(new CardListView(R.drawable.item03,"重要的原则能够也必须是灵活的",time_list,"Time is a versatile performer. It flies, marches on, heals all wounds, runs out and will tell "));
        cardListViews1.add(new CardListView(R.drawable.item04,"把握时间就是节约时间",time_list,"Money can cure hunger, it cannot cure unhappiness. Food can satisfy the appetite, but not the soul.. "));
        cardListViews1.add(new CardListView(R.drawable.item05,"真理不需色彩，美丽不会被掩盖",time_list,"No pain, no palm; no thorns, no throne; no gall, no glory; no cross, no crown. "));
        cardListViews1.add(new CardListView(R.drawable.item06,"雨会停，夜有终，伤会消",time_list,"The rain will stop, the night will end, the hurt will fade. Hope is never so lost that it can't be found. "));



        //listview点击变色
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myAdpter1.selectedItemPosition(position);
                myAdpter1.notifyDataSetChanged();
            }
        });



        View footer = inflater.inflate(R.layout.recommend_footer,null);
        cardListViews2 = new ArrayList<>();
        listView2 = footer.findViewById(R.id.recycler_view2);
        myAdpter2 = new Recommend_Adpter(getActivity(),cardListViews2);
        cardListViews2.add(new CardListView(R.drawable.item11,"庆祝新中国成立70周年",time_list,"The guard of honor formation marches in front of Tian’anmen Square in Beijing on Oct 1 "));
        cardListViews2.add(new CardListView(R.drawable.item12,"辉煌70年: 我眼中的祖国巨变",time_list,"Chinese people have always been known for their building skills and wisdom.  "));
        cardListViews2.add(new CardListView(R.drawable.item13,"汉服为何在年轻人中这么火？",time_list,"Hanfu fashion has become trendy among young people. TUCHONG China has embraced  "));
        cardListViews2.add(new CardListView(R.drawable.item14,"北京2022年冬奥会和冬残奥会",time_list,"Mascots “Bing Dwen Dwen”and “Shuey Rhon Rhon” XINHUA Mascots are great ambassadors  "));
        cardListViews2.add(new CardListView(R.drawable.item15,"网络玄幻小说走红海外",time_list,"NEW CLASSICS MEDIA When online literature first came out in the 1990s, it was considered low-quality,  "));
        cardListViews2.add(new CardListView(R.drawable.item16,"马云卸任：走出半生，归来仍是老师",time_list,"CFP All eyes were on Jack Ma. The chairman of Alibaba Group Holding Ltd stepped down  "));
        listView2.setAdapter(myAdpter2);
        myAdpter2.notifyDataSetChanged();

        listView1.addFooterView(footer);
        listView1.setAdapter(myAdpter1);
        myAdpter1.notifyDataSetChanged();
        return view;
    }

    private void init() {

    }

    private BaseSliderView.OnSliderClickListener onSliderClickListener=new BaseSliderView.OnSliderClickListener() {
        @Override
        public void onSliderClick(BaseSliderView slider) {
            Toast.makeText(getActivity(),slider.getBundle().get("extra") + "",
                    Toast.LENGTH_SHORT).show();
        }
    };

    //页面改变监听
    private ViewPagerEx.OnPageChangeListener onPageChangeListener=new ViewPagerEx.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {
            Log.d("ansen", "Page Changed: " + position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {}
    };
}
