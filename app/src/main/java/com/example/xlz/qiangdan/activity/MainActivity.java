package com.example.xlz.qiangdan.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xlz.qiangdan.R;
import com.example.xlz.qiangdan.entity.CircleAvatar;
import com.example.xlz.qiangdan.fragment.FragmentController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private TextView tv_title;

    private Toolbar toolbar;

    private FragmentController controller;

    private Button btn_grab_order;
    private Button btn_release_task;
    private Button btn_place_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = FragmentController.getInstance(this, R.id.content);
        controller.showFragment(0);

        initView();
        setupDrawerLayout();

    }

    //初始化控件
    private void initView() {
        //初始化ToolBar标题栏,styles.xml文件中必须设置windowActionBar=false，即无ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //设置头像为圆角
        final ImageView avatar = (ImageView) findViewById(R.id.avatar);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.mipmap.avatar);
        avatar.setImageBitmap(CircleAvatar.toRoundCorner(b, 200));

        btn_grab_order = (Button) findViewById(R.id.tab_grab_order);
        btn_release_task = (Button) findViewById(R.id.tab_release_task);
        btn_place_order = (Button) findViewById(R.id.tab_place_order);
        btn_grab_order.setOnClickListener(this);
        btn_release_task.setOnClickListener(this);
        btn_place_order.setOnClickListener(this);
    }

    //底部导航栏点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_grab_order:
                Intent intent = new Intent(MainActivity.this, GrabbedOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.tab_release_task:
                Intent intent1 = new Intent(MainActivity.this, ReleaseTaskActivity.class);
                startActivity(intent1);
                break;
            case R.id.tab_place_order:
                Intent intent2 = new Intent(MainActivity.this, PlaceOrderActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    //初始化DrawerLayout
    private void setupDrawerLayout() {
        //显示左上角的三横线
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);

        tv_title = (TextView) findViewById(R.id.toolbar_title);

        //设置抽屉NavigationView的点击事件
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //设置Item中的图标为图标本身的颜色
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.drawer_personal_data:
                        Intent intent = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent.putExtra("title", "个人资料");
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this, R.string.personal_data, Toast.LENGTH_LONG).show();
                       // controller.showFragment(1);
                      //  tv_title.setText(R.string.personal_data);
                        break;
                    case R.id.drawer_my_collection:
                        Intent intent1 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent1.putExtra("title", "我的收藏");
                        startActivity(intent1);
                        //Toast.makeText(MainActivity.this, R.string.my_collection, Toast.LENGTH_LONG).show();
                       // controller.showFragment(1);
                     //   tv_title.setText(R.string.my_collection);
                        break;
                    case R.id.drawer_message_center:
                        Intent intent2 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent2.putExtra("title", "消息中心");
                        startActivity(intent2);
                        //Toast.makeText(MainActivity.this, R.string.message_center, Toast.LENGTH_LONG).show();
                      //  controller.showFragment(1);
                      //  tv_title.setText(R.string.message_center);
                        break;
                    case R.id.drawer_coupon:
                        Intent intent3 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent3.putExtra("title", "优惠券");
                        startActivity(intent3);
                       // Toast.makeText(MainActivity.this, R.string.coupon, Toast.LENGTH_LONG).show();
                      //  controller.showFragment(1);
                      //  tv_title.setText(R.string.coupon);
                        break;
                    case R.id.drawer_purse:
                        Intent intent4 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent4.putExtra("title", "钱包");
                        startActivity(intent4);
                       // Toast.makeText(MainActivity.this, R.string.purse, Toast.LENGTH_LONG).show();
                     //   controller.showFragment(1);
                    //    tv_title.setText(R.string.purse);
                        break;
                    case R.id.drawer_settings:
                        Intent intent5 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent5.putExtra("title", "设置");
                        startActivity(intent5);
                       // Toast.makeText(MainActivity.this, R.string.settings, Toast.LENGTH_LONG).show();
                      //  controller.showFragment(1);
                       // tv_title.setText(R.string.settings);
                        break;
                    case R.id.drawer_recommend_friends:
                        Intent intent6 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent6.putExtra("title", "推荐好友");
                        startActivity(intent6);
                        //Toast.makeText(MainActivity.this, R.string.recommend_friends, Toast.LENGTH_LONG).show();
                     //   controller.showFragment(1);
                       // tv_title.setText(R.string.recommend_friends);
                        break;
                    case R.id.drawer_about:
                        Intent intent7 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent7.putExtra("title", "关于");
                        startActivity(intent7);
                       // Toast.makeText(MainActivity.this, R.string.about, Toast.LENGTH_LONG).show();
                       // controller.showFragment(1);
                       // tv_title.setText(R.string.about);
                        break;
                    case R.id.drawer_user_agreement:
                        Intent intent8 = new Intent(MainActivity.this, PersonalDataActivity.class);
                        intent8.putExtra("title", "用户协议");
                        startActivity(intent8);
                       // Toast.makeText(MainActivity.this, R.string.user_agreement, Toast.LENGTH_LONG).show();
                       // controller.showFragment(1);
                       // tv_title.setText(R.string.user_agreement);
                        break;
                    case R.id.drawer_exit:
                        System.exit(0);
                        break;
                }
                //  Snackbar.make(content, menuItem.getTitle(), Snackbar.LENGTH_LONG).show();
                //点击了把它设为选中状态
                menuItem.setChecked(true);
                //关闭抽屉
                drawerLayout.closeDrawers();

                return true;
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.exit(0);
    }

}
