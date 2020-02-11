package com.a33y.jo.guinexams;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.FirebaseDatabase;

public class SplashActivity extends AppCompatActivity implements DataHelper.DataChangedListener  {
    private static int  splashTime = 5000;
    private SharedPreferences firstTime;
    public static Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_container);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment fragment = new splash_frag();
        ft.add(R.id.frag,fragment);
        ft.commit();
        c = SplashActivity.this;
        new Handler().postDelayed(new Runnable(){
            @Override
            public  void run() {
                try{
                    FirebaseDatabase.getInstance().setPersistenceEnabled(true);
                }catch (Exception e){

                }
                // test.create(this);
                if(checkFirstTime()){
                    if(Connectivity.checkNetwork(SplashActivity.this,findViewById(R.id.frag))) {
                        DataHelper.setDataChangedListener(SplashActivity.this);
                        DataHelper.getNewData(SplashActivity.this);
                    }

                }else {
                    DataHelper.setDataChangedListener(SplashActivity.this);
                    DataHelper.getNewData(SplashActivity.this);
                }
            }},2000);



    }



    private boolean checkFirstTime(){
        firstTime = this.getSharedPreferences("FirstTime",this.MODE_PRIVATE);
        return  firstTime.getBoolean("first",true);
    }

    @Override
    public void onDataAdded() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment fragment1 = new splash_second_frag();
        ft.setCustomAnimations(R.animator.enter_anim_right, R.animator.exit_anim_left, R.animator.enter_anim_left, R.animator.exit_anim_right);
        ft.replace(R.id.frag, fragment1);
        ft.commit();
        SharedPreferences.Editor editor = firstTime.edit();
        editor.putBoolean("first", false);
        editor.commit();

    }

    @Override
    public void onFileDownloaded(int pos , LinearLayout loading) {

    }

    @Override
    public void onFileDownloadedfailed() {

    }
}
