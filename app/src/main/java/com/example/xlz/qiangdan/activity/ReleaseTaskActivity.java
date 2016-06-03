package com.example.xlz.qiangdan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xlz.qiangdan.R;

/**
 * Created by xlz on 2016/5/27.
 */
public class ReleaseTaskActivity extends AppCompatActivity {

    private TextView tv_title;

    private TextView tv_cancel;

    private Button btn_send;

    private EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_task);

        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.toolbar_title);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        btn_send = (Button) findViewById(R.id.btn_send);
        et_input = (EditText) findViewById(R.id.et_input);
        tv_cancel.setVisibility(View.VISIBLE);
        btn_send.setVisibility(View.VISIBLE);

        tv_title.setText("发布任务");
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReleaseTaskActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
