package com.yx.treasure.testtab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = getTabHost();

        addTab();// 添加标签
        // 设置TabHost背景颜色
        tabHost.setBackgroundColor(Color.argb(150, 20, 80, 150));
        // 设置TabHost背景图片资源
        tabHost.setBackgroundResource(R.drawable.ico_haiqian);
        // 设置当前显示哪一个标签 我的理解就是当你第一次启动程序默认显示那个标签 这里是指定的选项卡的ID从0开始
        tabHost.setCurrentTab(0);
        // 标签切换事件处理，setOnTabChangedListener 注意是标签切换事件不是点击事件，而是从一个标签切换到另外一个标签会触发的事件
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                Dialog dia;
                builder.setTitle("提示");
                builder.setMessage("当前选中了" + tabId + "标签");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dia = builder.create();
                dia.show();
            }
        });
    }

    // 为TabHost添加标签 新建一个newTabSped(new TabSpec) 设置其标签和图标（setIndicator）、设置内容(setContent)
    // TabSpec是TabHost的内部类 TabHost对象的 newTabSpec()方法返回一个TabSpec对象
    // 源码里边是这么写的 public TabSpec newTabSpec(String tag)
    // { return new TabSpec(tag); }
    private void addTab() {
        tabHost.addTab(tabHost
                .newTabSpec("tab1")
                .setIndicator("TAB1",
                        getResources().getDrawable(R.mipmap.ic_launcher))// setIndicator()此方法用来设置标签和图表
                .setContent(R.id.textview1));
        // 指定内容为一个TextView --->public TabHost.TabSpec setContent(int viewId) 此方法需要一个 viewId 作为参数
        tabHost.addTab(tabHost
                .newTabSpec("tab2")
                .setIndicator("TAB2",
                        getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(R.id.textview2));

        tabHost.addTab(tabHost
                .newTabSpec("tab3")
                .setIndicator("TAB3",
                        getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(R.id.textview3));
    }
}
