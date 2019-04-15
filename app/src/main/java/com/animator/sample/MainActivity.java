package com.animator.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
