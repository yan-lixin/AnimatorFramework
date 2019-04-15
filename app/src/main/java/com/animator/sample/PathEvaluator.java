package com.animator.sample;

import android.animation.TypeEvaluator;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/15
 * Description: 自定义估值器
 */
public class PathEvaluator implements TypeEvaluator<PathPoint> {

    /**
     * @param t   动画指定的百分比 t ∈[0,1]
     * @param startValue
     * @param endValue
     * @return
     */
    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x = 0, y = 0;

        switch (endValue.mOperation) {
            case PathPoint.MOVE:
                x = endValue.mX;
                y = endValue.mY;
                break;
            case PathPoint.Line:
                //x,y= 起始点坐标 + t*(起始点到终点的距离)
                x = startValue.mX + t * (endValue.mX - startValue.mX);
                y = startValue.mY + t * (endValue.mY - startValue.mY);
                break;
            case PathPoint.CUBIC:
                float oneMinusT = 1 - t;
                x = oneMinusT * oneMinusT * oneMinusT * startValue.mX +
                        3 * oneMinusT * oneMinusT * t * endValue.mControl0X +
                        3 * oneMinusT * t * t * endValue.mControl1X +
                        t * t * t * endValue.mX;
                y = oneMinusT * oneMinusT * oneMinusT * startValue.mY +
                        3 * oneMinusT * oneMinusT * t * endValue.mControl0Y +
                        3 * oneMinusT * t * t * endValue.mControl1Y +
                        t * t * t * endValue.mY;
                break;

            default:

                break;
        }

        return new PathPoint(PathPoint.MOVE, x, y);
    }

}
