package Fragment_home;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.a67527.pattern_english.*;

public class MyFragmentAdpter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 5;
    private Fragment_recommend recommend=null;
    private Fragment_word word = null;
    private Fragment_hear hear = null;
    private Fragment_pk pk = null;
    private Fragment_pet pet = null;

    public MyFragmentAdpter(FragmentManager fm) {
        super(fm);
        recommend = new Fragment_recommend();
        word = new Fragment_word();
        hear = new Fragment_hear();
        pk = new Fragment_pk();
        pet = new Fragment_pet();
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position,  Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        switch (i){
            case MainActivity.PAGE_ONE:
                fragment = recommend;
                break;
            case MainActivity.PAGE_TWO:
                fragment = word;
                break;
            case MainActivity.PAGE_THREE:
                fragment = hear;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = pk;
                break;
            case MainActivity.PAGE_FIVE:
            {
                fragment = pet;

            }
                break;
        }
        return fragment;
    }

}
