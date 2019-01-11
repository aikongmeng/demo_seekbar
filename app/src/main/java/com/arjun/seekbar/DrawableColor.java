package com.arjun.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Arjun
 */
public class DrawableColor extends View {
    private Context mContext;
    private Drawable mCurrentDrawable;
    private Paint paint;
    private int x = 100;
    private int y = 100;
    private int width = 300;
    private int height = 50;

    public DrawableColor(Context context) {
        super(context);
        init(context);
    }

    public DrawableColor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public DrawableColor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

    }

    public void setColor(Drawable drawable) {
        this.mCurrentDrawable = drawable;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Google search technology ... ", 100, 100, paint);
        final Drawable d = mCurrentDrawable;
        if (d != null) {
            final int saveCount = canvas.save();
            d.setBounds(x, y, x + width, y + height);
            d.draw(canvas);
            canvas.restoreToCount(saveCount);
        }

    }
}
