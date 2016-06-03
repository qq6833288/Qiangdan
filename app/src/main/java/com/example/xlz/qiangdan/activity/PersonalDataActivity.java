package com.example.xlz.qiangdan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xlz.qiangdan.R;

/**
 * Created by xlz on 2016/5/28.
 */
public class PersonalDataActivity extends AppCompatActivity {

    private TextView tv_title;

    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order);

        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.toolbar_title);
        iv_back = (ImageView) findViewById(R.id.iv_back);

        tv_title.setText(getIntent().getStringExtra("title"));
        iv_back.setImageResource(R.mipmap.back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
