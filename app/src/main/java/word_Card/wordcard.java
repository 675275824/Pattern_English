package word_Card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.a67527.pattern_english.R;
import com.zc.swiple.SwipeFlingView;

public class wordcard extends AppCompatActivity implements SwipeFlingView.onSwipeListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_card);
    }

    @Override
    public void onStartDragCard() {

    }

    @Override
    public boolean canLeftCardExit() {


        return false;
    }

    @Override
    public boolean canRightCardExit() {
        return false;
    }

    @Override
    public void onPreCardExit() {

    }

    @Override
    public void onLeftCardExit(View view, Object o, boolean b) {

    }

    @Override
    public void onRightCardExit(View view, Object o, boolean b) {

    }

    @Override
    public void onSuperLike(View view, Object o, boolean b) {

    }

    @Override
    public void onTopCardViewFinish() {

    }

    @Override
    public void onAdapterAboutToEmpty(int i) {

    }

    @Override
    public void onAdapterEmpty() {

    }

    @Override
    public void onScroll(View view, float v) {

    }

    @Override
    public void onEndDragCard() {

    }
}
