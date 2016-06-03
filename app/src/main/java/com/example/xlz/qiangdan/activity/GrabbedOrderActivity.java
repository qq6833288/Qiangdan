package com.example.xlz.qiangdan.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xlz.qiangdan.R;

/**
 * Created by xlz on 2016/5/26.
 */
public class GrabbedOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;

    private ImageView iv_back;
    private ImageView iv_phone;
    private ImageView iv_share;

    private Button btn_cancel;
    private Button btn_determine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grabedorder_content);

        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.toolbar_title);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_phone = (ImageView) findViewById(R.id.iv_phone);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_determine = (Button) findViewById(R.id.btn_determine);

        btn_cancel.setOnClickListener(this);
        btn_determine.setOnClickListener(this);

        tv_title.setText("已抢订单");
        iv_back.setImageResource(R.mipmap.back);
        iv_share.setImageResource(R.mipmap.share);

        iv_back.setOnClickListener(this);
        iv_share.setOnClickListener(this);
        iv_phone.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                setDialog("确认取消订单？", "取消订单后，订单将不存在", "取消成功");
                break;
            case R.id.btn_determine:
                setDialog("确认收货？", "确认后钱将自动转入卖家账户中", "确认成功");
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_share:
                Toast.makeText(GrabbedOrderActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_phone:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0755 2916 6866"));
                startActivity(intent);
            default:
                break;
        }
    }

    //警告对话框设置
    private void setDialog(String title, String message, final String determineMsg) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(GrabbedOrderActivity.this);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setCancelable(false);

        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                //Toast.makeText(GrabbedOrderActivity.this, determineMsg, Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(GrabbedOrderActivity.this, determineMsg, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
