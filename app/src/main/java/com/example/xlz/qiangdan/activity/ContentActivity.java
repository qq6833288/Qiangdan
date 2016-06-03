package com.example.xlz.qiangdan.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xlz.qiangdan.R;
import com.example.xlz.qiangdan.entity.CircleAvatar;

/**
 * Created by xlz on 2016/5/25.
 */
public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;

    private ImageView iv_back;
    private ImageView iv_share;
    private ImageView iv_collection;
    private ImageView content_avatar;
    private ImageView iv_phone;
    private TextView tv_username;
    private TextView tv_activity_content;
    private TextView tv_activity_price;
    private Button time_grab_order;
    private TextView activity_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        initView();

        String content = getIntent().getStringExtra("content");
        String price = getIntent().getStringExtra("price");
        tv_activity_content.setText(content);
        tv_activity_price.setText(price);
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.toolbar_title);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_collection = (ImageView) findViewById(R.id.iv_collection);
        content_avatar = (ImageView) findViewById(R.id.content_avatar);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_activity_content = (TextView) findViewById(R.id.tv_activity_content);
        tv_activity_price = (TextView) findViewById(R.id.tv_activity_price);
        time_grab_order = (Button) findViewById(R.id.time_grab_order);
        activity_address = (TextView) findViewById(R.id.activity_address);
        iv_phone = (ImageView) findViewById(R.id.iv_phone);

        //设置头像为圆角
        final ImageView avatar = (ImageView) findViewById(R.id.content_avatar);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.mipmap.avatar);
        avatar.setImageBitmap(CircleAvatar.toRoundCorner(b, 200));

        tv_title.setText("查看抢单");
        iv_back.setImageResource(R.mipmap.back);
        iv_share.setImageResource(R.mipmap.share);
        iv_collection.setImageResource(R.mipmap.my_collection);

        iv_phone.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_share.setOnClickListener(this);
        iv_collection.setOnClickListener(this);
        time_grab_order.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_share:
                Toast.makeText(ContentActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_collection:
                Toast.makeText(ContentActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.time_grab_order:
                Toast.makeText(ContentActivity.this, "抢单成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_phone:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0755 2916 6866"));
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
