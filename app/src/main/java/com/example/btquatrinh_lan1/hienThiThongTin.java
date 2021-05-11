package com.example.btquatrinh_lan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class hienThiThongTin extends AppCompatActivity {
    TextView txtSize, txtLoai, txtTopping, txtSL, txtGhiChu;
    Button btnGuiSMS, btnDiaDiem;
    String sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthithongtin);
        getSupportActionBar().setTitle("Trà Bạn Đã Đặt");
        Intent intent = getIntent();

        List<String> listTopping = (List<String>) intent.getSerializableExtra("ToppingTra");
        txtSize = findViewById(R.id.textViewSize);
        txtLoai = findViewById(R.id.textViewLoai);

        txtTopping = findViewById(R.id.textViewTopping);
        String strTopping = "";
        for (String s : listTopping) {
            strTopping += s + "\t";
        }
        String txtStrTopping = strTopping;
        txtTopping.setText(strTopping);

        txtSL = findViewById(R.id.textViewSL);
        txtGhiChu = findViewById(R.id.textViewGhiChu);
        btnGuiSMS = findViewById(R.id.btnGuiTinNhan);
        btnDiaDiem = findViewById(R.id.btnDiaDiem);
        String size = intent.getStringExtra("SizeLy");
        String loaitra = intent.getStringExtra("LoaiTra");

        String soluong = intent.getStringExtra("SoLuong");
        String ghichu = intent.getStringExtra("GhiChu");
        txtSize.setText(size);
        txtLoai.setText(loaitra);
        txtSL.setText(soluong);
        txtGhiChu.setText(ghichu);

        sms = "Xin chào. Tôi muốn " + soluong + " ly " + loaitra + " size " + size + " với topping gồm: " + txtStrTopping + ". Ghi chú: " + ghichu + ".";
    }

    public void SendSMS(View v) {

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + "15555215556"));

        intent.putExtra("sms_body", sms);
        startActivity(intent);
    }

    public void DisplayMap(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://goo.gl/maps/pxiJoxyiXnoho2DL8"));
        startActivity(intent);
    }
}