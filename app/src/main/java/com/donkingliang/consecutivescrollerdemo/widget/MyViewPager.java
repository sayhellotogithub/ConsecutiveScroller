package com.donkingliang.consecutivescrollerdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.donkingliang.consecutivescroller.IConsecutiveScroller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author teach-梁任彦
 * @Description
 * @Date 2020/4/18
 */
public class MyViewPager extends ViewPager implements IConsecutiveScroller {
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public View getCurrentScrollerView() {

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            if (view.getX() == getScrollX()) {
                return view;
            }
        }

        return this;
    }

    @Override
    public List<View> getScrolledViews() {
        List<View> views = new ArrayList<>();
        int count = getChildCount();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                views.add(getChildAt(i));
            }
        } else {
            views.add(this);
        }
        return views;
    }
}
