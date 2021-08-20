package com.example.hackerthonproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class PopupActivity extends Activity implements View.OnClickListener {

    Button myPage, level, Description_Level;
    ImageButton imageButton;
    EditText message, point, wallet, breakdown, profile, image, phoneNum, setting, settings, logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // 등급와 등급별 혜택 버튼
        level = findViewById(R.id.level);
        Description_Level = findViewById(R.id.Description_Level);


        message = findViewById(R.id.message);
        point = findViewById(R.id.point);
        wallet = findViewById(R.id.wallet);
        breakdown = findViewById(R.id.breakdown);
        profile = findViewById(R.id.profile);
        image = findViewById(R.id.image);
        phoneNum = findViewById(R.id.phoneNum);
        setting = findViewById(R.id.setting);
        settings = findViewById(R.id.settings);
        logOut = findViewById(R.id.logOut);


    }

    public void onClick(View view) {

        if (view == myPage) { //view가 alert 이면 팝업실행 즉 버튼을 누르면 팝업창이 뜨는 조건
            Context mContext = getApplicationContext();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            //R.layout.dialog는 xml 파일명이고  R.id.popup은 보여줄 레이아웃 아이디
            View layout = inflater.inflate(R.layout.activity_mypage, (ViewGroup) findViewById(R.id.popup));
            AlertDialog.Builder aDialog = new AlertDialog.Builder(PopupActivity.this);


            //그냥 닫기버튼을 위한 부분
            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int useless) {
                }
            });

        }

//        // 조회란에서 조작 방지를 위한 키보드 숨기기
//        message.setShowSoftInputOnFocus(false);
//        point.setShowSoftInputOnFocus(false);
//        wallet.setShowSoftInputOnFocus(false);
//        breakdown.setShowSoftInputOnFocus(false);
//        profile.setShowSoftInputOnFocus(false);
//        image.setShowSoftInputOnFocus(false);
//        phoneNum.setShowSoftInputOnFocus(false);
//        setting.setShowSoftInputOnFocus(false);
//        settings.setShowSoftInputOnFocus(false);
//        logOut.setShowSoftInputOnFocus(false);

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

}

