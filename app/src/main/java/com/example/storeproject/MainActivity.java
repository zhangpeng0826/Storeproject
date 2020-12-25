package com.example.storeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.storeproject.fragment.ClassifyFragment;
import com.example.storeproject.fragment.HomeFragment;
import com.example.storeproject.fragment.MyFragment;
import com.example.storeproject.fragment.ShopcalFragment;
import com.example.storeproject.fragment.SpecialFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup rgMain;
    private RadioButton rbHomeMain;
    private RadioButton rbSpecialMain;
    private RadioButton rbClassifyMain;
    private RadioButton rbShopcalMain;
    private RadioButton rbMyMain;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private ClassifyFragment classifyFragment;
    private ShopcalFragment shopcalFragment;
    private MyFragment myFragment;
    private LinearLayout llSearchMain;
    private FrameLayout flMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        iniData();
    }

    private void iniData() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        shopcalFragment = new ShopcalFragment();
        myFragment = new MyFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_main, homeFragment)
                .add(R.id.fl_main, specialFragment)
                .add(R.id.fl_main, classifyFragment)
                .add(R.id.fl_main, shopcalFragment)
                .add(R.id.fl_main, myFragment)
                .hide(specialFragment)
                .hide(classifyFragment)
                .hide(shopcalFragment)
                .hide(myFragment).commit();
    }

    private void initView() {
        llSearchMain = findViewById(R.id.ll_search_main);
        rgMain = findViewById(R.id.rg_main);
        rbHomeMain = findViewById(R.id.rb_home_main);
        rbSpecialMain = findViewById(R.id.rb_special_main);
        rbClassifyMain = findViewById(R.id.rb_classify_main);
        rbShopcalMain = findViewById(R.id.rb_shopcal_main);
        rbMyMain = findViewById(R.id.rb_my_main);
        rgMain.setOnCheckedChangeListener(this);
        llSearchMain.setOnClickListener(this);
        flMain = findViewById(R.id.fl_main);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home_main:
                fragmentManager.beginTransaction()
                        .show(homeFragment)
                        .hide(specialFragment)
                        .hide(classifyFragment)
                        .hide(shopcalFragment)
                        .hide(myFragment).commit();
                break;
            case R.id.rb_special_main:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .show(specialFragment)
                        .hide(classifyFragment)
                        .hide(shopcalFragment)
                        .hide(myFragment).commit();
                break;
            case R.id.rb_classify_main:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .show(classifyFragment)
                        .hide(shopcalFragment)
                        .hide(myFragment).commit();
                break;
            case R.id.rb_shopcal_main:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .hide(classifyFragment)
                        .show(shopcalFragment)
                        .hide(myFragment).commit();
                break;
            case R.id.rb_my_main:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .hide(classifyFragment)
                        .hide(shopcalFragment)
                        .show(myFragment).commit();
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_search_main:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}