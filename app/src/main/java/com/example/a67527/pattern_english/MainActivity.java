package com.example.a67527.pattern_english;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import Fragment_home.MyFragmentAdpter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,ViewPager.OnPageChangeListener {

    //UI Objects
    private TextView textView;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_recommend;
    private RadioButton rb_word;
    private RadioButton rb_hear;
    private RadioButton rb_pk;
    private RadioButton rb_pet;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MenuItem menuItem;
    private MyFragmentAdpter myFragmentAdpter;


    //页面
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    public static final int PAGE_FIVE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        myFragmentAdpter = new MyFragmentAdpter(getSupportFragmentManager());
        bindView();
        //rb_recommend.setChecked(true);

        //设置标题头像

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        //设置bottomNavigationView监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.recommend_buttom:
                        viewPager.setCurrentItem(PAGE_ONE);
                        break;
                    case R.id.word_buttom:
                        viewPager.setCurrentItem(PAGE_TWO);
                        break;
                    case R.id.hear_buttom:
                        viewPager.setCurrentItem(PAGE_THREE);
                        break;
                    case R.id.pk_buttom:
                        viewPager.setCurrentItem(PAGE_FOUR);
                        break;
                    case R.id.pet_buttom:
                        viewPager.setCurrentItem(PAGE_FIVE);
                        break;
                }
                return false;
            }
        });


        //设置icon的颜色
        @SuppressLint("ResourceType") ColorStateList colorStateList = getResources().getColorStateList(R.drawable.tab_bar_color);
        bottomNavigationView.setItemIconTintList(colorStateList);
        bottomNavigationView.setItemTextColor(colorStateList);
        //设置menu
        toolbar.inflateMenu(R.menu.main);
        Menu menu = toolbar.getMenu();
        MenuItem item = menu.findItem(R.id.action_settings);
        item.setVisible(false);
        //设置icon
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏标题
        toolbar.setNavigationIcon(new ImageHelper(getResources().getDrawable(R.mipmap.head_photo)).getCircle(180));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //初始化viewpager
    private void bindView(){


        /*rb_word = findViewById(R.id.word_buttom);
        rb_hear = findViewById(R.id.hear_buttom);
        rb_pk = findViewById(R.id.pk_buttom);
        rb_pet = findViewById(R.id.pet_buttom);*/


        bottomNavigationView =findViewById(R.id.main_buttomnav);
        viewPager = findViewById(R.id.content_viewpager);
        viewPager.setAdapter(myFragmentAdpter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        //设置初始选项
        if(menuItem!=null){
            menuItem.setChecked(false);
        }else {
            bottomNavigationView.getMenu().getItem(0).setChecked(false);
        }
        menuItem = bottomNavigationView.getMenu().getItem(i);
        menuItem.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
     /*   if(i==2){
            switch (viewPager.getCurrentItem()){
                case PAGE_ONE:
                    rb_recommend.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_word.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_hear.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_pk.setChecked(true);
                    break;
                case PAGE_FIVE:
                    rb_pet.setChecked(true);
                    break;
            }
        }*/
    }


    public void onCheckedChanged(RadioGroup group, int checkedId) {
 /* switch (checkedId){
            case R.id.recommend_buttom:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.word_buttom:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.hear_buttom:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.pk_buttom:
                viewPager.setCurrentItem(PAGE_FOUR);
                break;
            case R.id.pet_buttom:
                viewPager.setCurrentItem(PAGE_FIVE);
                break;
        }*/
    }

    private void setupViewPager(ViewPager viewPager){
        //myFragmentAdpter
    }
}
