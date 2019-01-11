package com.arjun.seekbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.arjun.widget.RangeSeekBar;

/**
 * @author Arjun
 */
public class MyRangeSeekBar extends RangeSeekBar {
    public MyRangeSeekBar(Context context) {
        super(context);
    }

    public MyRangeSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }
}
