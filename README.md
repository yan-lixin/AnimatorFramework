实现路径动画
```
findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AnimatorPath animatorPath = new AnimatorPath();
        animatorPath.moveTo(0, 0);
        animatorPath.lineTo(600, 600);
        animatorPath.cubicTo(600, 600, -200, 200, -300, 0);
        animatorPath.startAnimation(v, 5 * 1000);
    }
});
```