package com.sunkai.popupwindowdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
    private PopupWindow mPopupWindow;
    private Dialog mDialog;
    private Button mButton;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View popupView = getLayoutInflater().inflate(R.layout.latyou_popunwindow, null);

        //方法一、最常用
        mPopupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);

        //方法二
        //mPopupWindow = new PopupWindow(popupView,LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        mPopupWindow.setFocusable(false);

        //方法三
//        mPopupWindow = new PopupWindow(popupView);
//        mPopupWindow.setWidth(LayoutParams.MATCH_PARENT);
//        mPopupWindow.setHeight(LayoutParams.WRAP_CONTENT);
//        mPopupWindow.setFocusable(true);

        //方法四
//        mPopupWindow = new PopupWindow();
//        mPopupWindow.setContentView(popupView);
//        mPopupWindow.setWidth(LayoutParams.MATCH_PARENT);
//        mPopupWindow.setHeight(LayoutParams.WRAP_CONTENT);
//        mPopupWindow.setFocusable(true);

//        mPopupWindow = new PopupWindow(this);
//        mPopupWindow.setContentView(popupView);
//        mPopupWindow.setWidth(LayoutParams.MATCH_PARENT);
//        mPopupWindow.setHeight(LayoutParams.WRAP_CONTENT);
//        mPopupWindow.setFocusable(true);


        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPopupWindow.showAsDropDown(v);

            }
        });

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);

                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    Log.d("TAG", " " + viewGroup.getChildAt(i).getId());
                }

                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.latyou_popunwindow, null);
                viewGroup.addView(view1);

                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    Log.d("TAG", " " + viewGroup.getChildAt(i).getId());
                }
            }
        });


        View DialogView = getLayoutInflater().inflate(R.layout.latyou_popunwindow, null);
        mDialog = new Dialog(this);
        mDialog.setContentView(DialogView);
        mDialog.setCancelable(true);
        mDialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, 300);

        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.show();

            }
        });

        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                Log.d("TAG", "Dialog:" + keyEvent.getKeyCode() + "");
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("TAG", "Activity:" + event.getKeyCode() + "");
        return super.onKeyDown(keyCode, event);
    }
}
