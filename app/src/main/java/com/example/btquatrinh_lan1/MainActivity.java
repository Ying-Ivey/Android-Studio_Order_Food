package com.example.btquatrinh_lan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup radgroupTra;
    RadioButton sizeS, sizeM, sizeL, tralai, traden, tradao, trasen, trapbt, trasuamc;
    CheckBox tranchau, tranchautrang, kemcheese, puddingtrung, puddingtrasua;
    EditText soLuong, ghiChu;
    List<String> strTopping;
    String strLoaiTra, strSize, urlTra;
    Button btnHienThi, btnThongTin;
    ImageView imgTra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Đặt Đồ Uống");
        strTopping = new ArrayList<>();

        sizeS = (RadioButton) findViewById(R.id.radSizeS);
        sizeM = (RadioButton) findViewById(R.id.radSizeM);
        sizeL = (RadioButton) findViewById(R.id.radSizeL);

        radgroupTra = (RadioGroup) findViewById(R.id.radGroupTra);

        tralai = (RadioButton) findViewById(R.id.radTraLai);
        traden = (RadioButton) findViewById(R.id.radTraDen);
        tradao = (RadioButton) findViewById(R.id.radTraDao);
        trasen = (RadioButton) findViewById(R.id.radTraSen);
        trapbt = (RadioButton) findViewById(R.id.radTraPBT);
        trasuamc = (RadioButton) findViewById(R.id.radTraSuaMacCa);

        imgTra = (ImageView) findViewById(R.id.imgTra);

        tranchau = (CheckBox) findViewById(R.id.chkTC);
        tranchautrang = (CheckBox) findViewById(R.id.chkTCT);
        kemcheese = (CheckBox) findViewById(R.id.chkKC);
        puddingtrung = (CheckBox) findViewById(R.id.chkPT);
        puddingtrasua = (CheckBox) findViewById(R.id.chkPTS);
        soLuong = (EditText) findViewById(R.id.inputSoLuong);

        ghiChu = (EditText) findViewById(R.id.editTextGhiChu);
        soLuong = (EditText) findViewById(R.id.inputSoLuong);
        btnHienThi = (Button) findViewById(R.id.btnHienThiTraSuaDaDat);
        btnThongTin= (Button) findViewById(R.id.btnChiTiet);

        String sl = soLuong.getText().toString();
        if (TextUtils.isEmpty(sl)) {
            soLuong.setError("Vui lòng nhập số lượng.");
            return;
        }

    }


    public void onSizeClicked(View v) {

        switch (v.getId()) {
            case R.id.radSizeS:
                if (sizeS.isChecked()) {
                    strSize = "S";
                }
                break;
            case R.id.radSizeM:
                if (sizeM.isChecked()) {
                    strSize = "M";
                }
                break;
            case R.id.radSizeL:
                if (sizeL.isChecked()) {
                    strSize = "L";
                }
                break;
        }
    }

    public void onToppingClicked(View v) {
        switch (v.getId()) {
            case R.id.chkTC:
                if (tranchau.isChecked()) {
                    strTopping.add("Trân Châu \t");
                } else {
                    strTopping.remove("Trân Châu \t");
                }
                break;
            case R.id.chkTCT:
                if (tranchautrang.isChecked()) {
                    strTopping.add("Trân Châu Trắng \t");
                } else {
                    strTopping.remove("Trân Châu Trắng \t");
                }
                break;
            case R.id.chkKC:
                if (kemcheese.isChecked()) {
                    strTopping.add("Kem Cheese \t");
                } else {
                    strTopping.remove("Kem Cheese \t");
                }
                break;
            case R.id.chkPT:
                if (puddingtrung.isChecked()) {
                    strTopping.add("Pudding Trứng \t");
                } else {
                    strTopping.remove("Pudding Trứng \t");
                }
                break;
            case R.id.chkPTS:
                if (puddingtrasua.isChecked()) {
                    strTopping.add("Pudding Trà Sữa \t");
                } else {
                    strTopping.remove("Pudding Trà Sữa \t");
                }
                break;
        }

    }


    public void onTraClicked(View v) {

        switch (v.getId()) {
            case R.id.radTraDen:
                if (traden.isChecked()) {
                    strLoaiTra = "Trà Đen Macchiaato";
                    imgTra.setImageDrawable(getResources().getDrawable(R.drawable.tradenmacchiato, getApplicationContext().getTheme()));
                    urlTra = "https://www.thecoffeehouse.com/products/tra-den-macchiato";
                }
                break;
            case R.id.radTraDao:
                if (tradao.isChecked()) {
                    strLoaiTra = "Trà Đào Cam Sả";
                    imgTra.setImageDrawable(getResources().getDrawable(R.drawable.tradaocamsapng, getApplicationContext().getTheme()));
                    urlTra = "https://www.thecoffeehouse.com/products/tra-dao-cam-sa";
                }
                break;
            case R.id.radTraLai:
                if (tralai.isChecked()) {
                    strLoaiTra = "Trà Lài Macchiato";
                    imgTra.setImageDrawable(getResources().getDrawable(R.drawable.tralai, getApplicationContext().getTheme()));
                    urlTra = "https://www.thecoffeehouse.com/products/tra-lai-macchiato";
                }
                break;
            case R.id.radTraSen:
                if (trasen.isChecked()) {
                    strLoaiTra = "Trà Hạt Sen";
                    imgTra.setImageDrawable(getResources().getDrawable(R.drawable.trahatsenpng, getApplicationContext().getTheme()));
                    urlTra = "https://www.thecoffeehouse.com/products/tra-oolong-sen-an-nhien";
                }
                break;
            case R.id.radTraPBT:
                if (trapbt.isChecked()) {
                    strLoaiTra = "Trà Phúc Bồn Tử";
                    imgTra.setImageDrawable(getResources().getDrawable(R.drawable.traphucbontupng, getApplicationContext().getTheme()));
                    urlTra = "https://www.thecoffeehouse.com/products/tra-phuc-bon-tu";
                }
                break;
            case R.id.radTraSuaMacCa:
                if (trasuamc.isChecked()) {
                    strLoaiTra = "Trà Sữa Mắc Ca Trân Châu";
                    imgTra.setImageDrawable(getResources().getDrawable(R.drawable.trasuamaccapng, getApplicationContext().getTheme()));
                    urlTra = "https://www.thecoffeehouse.com/products/tra-sua-mac-ca-tran-chau-trang";
                }
                break;
        }

    }

    public void onChiTietTraClicked(View v) {

        switch (v.getId()) {
            case R.id.radTraDen:
                if (traden.isChecked()) {
                    urlTra = "https://www.thecoffeehouse.com/products/tra-den-macchiato";
                }
                break;
            case R.id.radTraDao:
                if (tradao.isChecked()) {
                    urlTra = "https://www.thecoffeehouse.com/products/tra-dao-cam-sa";
                }
                break;
            case R.id.radTraLai:
                if (tralai.isChecked()) {
                    urlTra = "https://www.thecoffeehouse.com/products/tra-lai-macchiato";
                }
                break;
            case R.id.radTraSen:
                if (trasen.isChecked()) {
                    urlTra = "https://www.thecoffeehouse.com/products/tra-oolong-sen-an-nhien";
                }
                break;
            case R.id.radTraPBT:
                if (trapbt.isChecked()) {
                    urlTra = "https://www.thecoffeehouse.com/products/tra-phuc-bon-tu";
                }
                break;
            case R.id.radTraSuaMacCa:
                if (trasuamc.isChecked()) {
                    urlTra = "https://www.thecoffeehouse.com/products/tra-sua-mac-ca-tran-chau-trang";
                }
                break;
        }

        Intent intentTra = new Intent(getApplicationContext(), webViewThongTinTra.class);
        intentTra.putExtra("UrlTra", urlTra);
        startActivity(intentTra);
    }

    public void ButtonClick(View v) {

        String strSoLuong = soLuong.getText().toString();
        String strGhiChu = ghiChu.getText().toString();
        Intent intent = new Intent(getApplicationContext(), hienThiThongTin.class);

        intent.putExtra("SizeLy", strSize);
        intent.putExtra("ToppingTra", (Serializable) strTopping);
        intent.putExtra("LoaiTra", strLoaiTra);

        intent.putExtra("SoLuong", strSoLuong);
        intent.putExtra("GhiChu", strGhiChu);
        startActivity(intent);
    }

}
