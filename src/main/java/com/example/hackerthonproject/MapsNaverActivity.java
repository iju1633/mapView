package com.example.hackerthonproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MapsNaverActivity extends Activity implements OnMapReadyCallback {

    MapView mapView;
    EditText mapInfo_MyPage;
    Button home, QR_Scan, myPage;


    IntentIntegrator integrator;
    private int point = 1000;
    private int bonus = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naver_activity_maps);

        mapView = findViewById(R.id.mapView);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Marker marker = new Marker();
        marker.setPosition(new LatLng(37.5670135, 126.9783740));
        marker.setMap(naverMap);
    }

    public void onClick(View view){

    }

    public void home(View view){

    }

    public void QR_Scan(View view){
        integrator = new IntentIntegrator(this);

        integrator.setPrompt("QR 코드를 사각형 안에 위치 시켜주세요");

        //QR 코드 인식 시에 삐- 소리가 나게 할것인지 여부
        integrator.setBeepEnabled(true);

        integrator.setBarcodeImageEnabled(true);

        integrator.setCaptureActivity(CaptureActivity.class);

        //스캐너 시작 메소드
        integrator.initiateScan();
    }

    public void myPage(View view){
        mapInfo_MyPage.setText(" ");
    }

    public int getPoint() {
        return point;
    }

    // 적립될 포인트
    public void setPoint(int point) {
        this.point = point;
    }

    public void addPoint() {
        this.point += getBonus();
    }

    public String printInfo(){
        return "  적립된 Point : " + getBonus() + "원";
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
