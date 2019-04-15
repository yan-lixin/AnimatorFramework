package com.animator.sample;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/15
 * Description: 具体指令
 */
public class PathPoint {
    public static final int MOVE = 0;
    public static final int Line = 1;
    public static final int CUBIC = 2;

    /**
     * 具体操作指令
     */
    int mOperation;

    /**
     * 坐标
     */
    float mX, mY;

    /**
     * 控制点
     */
    float mControl0X, mControl0Y;
    float mControl1X, mControl1Y;

    public PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    public PathPoint(int operation, float x, float y, float control0X, float control0Y, float control1X, float control1Y) {
        mOperation = operation;
        mX = x;
        mY = y;
        mControl0X = control0X;
        mControl0Y = control0Y;
        mControl1X = control1X;
        mControl1Y = control1Y;
    }
}
