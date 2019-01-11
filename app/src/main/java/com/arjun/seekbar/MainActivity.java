package com.arjun.seekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.arjun.widget.OnRangeChangedListener;
import com.arjun.widget.RangeSeekBar;


/**
 * @author Arjun
 */
public class MainActivity extends AppCompatActivity {

    private RangeSeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        seekbar = findViewById(R.id.seekbar);
        seekbar.setRange(0, 50);
        seekbar.setValue(16, 25);
        seekbar.setIndicatorTextDecimalFormat("0");
        seekbar.setIndicatorTextStringFormat("%s岁");

        seekbar.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {

//                seekbar.getRightSeekBar().setIndicatorText((int)rightValue+"岁");
//                seekbar.getLeftSeekBar().setIndicatorText((int)leftValue+"岁");
                String left = leftValue < 12 ? "12" : "" + (int) leftValue;
                String right = rightValue > 40 ? "40" : "" + (int) rightValue;

                if (leftValue < 12 && rightValue > 40) {
                    ((TextView) findViewById(R.id.tv)).setText("年龄不限");
                } else {
                    if (rightValue < leftValue) {
                        ((TextView) findViewById(R.id.tv)).setText(String.format("年龄：%s - %s", right, left));
                    } else {
                        ((TextView) findViewById(R.id.tv)).setText(String.format("年龄：%s - %s", left, right));
                    }
                }

            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });
    }
}
