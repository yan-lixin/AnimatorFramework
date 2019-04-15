package com.animator.sample;

import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/15
 * Description: 仿Path系统工具类
 * 存储一系列的指令：moveTo/lineTo/cubicTo (x,y 等参数)
 */
public class AnimatorPath {

    /**
     * 定义容器存储操作指令
     */
    ArrayList<PathPoint> mPathPoints = new ArrayList<>();

    /**
     * 操作View
     */
    private View mView;

    /**
     * 移动坐标点
     * @param x
     * @param y
     */
    public void moveTo(float x, float y) {
        mPathPoints.add(new PathPoint(PathPoint.MOVE, x, y));
    }

    /**
     * 线性滑动
     * @param x
     * @param y
     */
    public void lineTo(float x, float y) {
        mPathPoints.add(new PathPoint(PathPoint.Line, x, y));
    }

    /**
     * 三阶贝塞尔曲线
     * @param x
     * @param y
     * @param c0x
     * @param c0y
     * @param c1x
     * @param c1y
     */
    public void cubicTo(float x, float y, float c0x, float c0y, float c1x, float c1y) {
        mPathPoints.add(new PathPoint(PathPoint.CUBIC, x, y, c0x, c0y, c1x, c1y));
    }

    /**
     * 开启属性动画
     * @param view
     * @param duration
     *
     * 属性动画原理：通过反射不断调用view.setTranslationX()等方法
     * 属性动画：本质是控件一个对象身上的任意属性值--反射setTranslationX()、setAlpha()等方法
     */
    public void startAnimation(View view, int duration) {
        this.mView = view;
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "pathAnimator", new PathEvaluator(), mPathPoints.toArray());
        animator.setDuration(duration);
        animator.start();
    }

    public void setPathAnimator(PathPoint point) {
        mView.setTranslationX(point.mX);
        mView.setTranslationY(point.mY);
    }

}
