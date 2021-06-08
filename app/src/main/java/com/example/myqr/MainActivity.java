package com.example.myqr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // java의 main 메서드 개념, 레이아웃 생성하고 초기화 컴포넌트 불러온다
        super.onCreate(savedInstanceState); // 상위 클래스의 onCreate 메서드를 먼저 호출하여 실행하고 오버라이드된 메서드 처리, Activity의 기본 초기화를 수행
        // setContentView(R.layout.activity_main); // 화면 디자인(xml 파일)을 불러온다.

        new IntentIntegrator(this).initiateScan(); // QR 리더기를 만든다
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 액티비티 호출 결과를 받아온다
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) { // 결과값의 내용이 null이면 Cancelled 출력
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else { // 결과값의 내용이 있으면 결과값 출력
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}