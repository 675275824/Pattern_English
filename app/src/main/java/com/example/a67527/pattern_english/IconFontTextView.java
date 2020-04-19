package com.example.a67527.pattern_english;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class IconFontTextView extends TextView {

    public IconFontTextView(Context context) {
        super(context);
        init(context);
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        setTypeface(getTypeFace(context));
    }

    private static Typeface tf;

    public static Typeface getTypeFace(Context ctx) {
        if (tf == null) {
            tf = Typeface.createFromAsset(ctx.getAssets(), "fonts/icomoon.ttf");//icomoon字体是在icomoon生成的字体，具体参考下文
        }
        return tf;
    }
}