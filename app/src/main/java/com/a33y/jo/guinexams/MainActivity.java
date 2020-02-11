package com.a33y.jo.guinexams;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements DataHelper.DataChangedListener {
     FrameLayout frag;
    private SharedPreferences firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        frag = findViewById(R.id.frag);
        try{
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }catch (Exception e){

        }
       // test.create(this);
      if(checkFirstTime()){
          if(Connectivity.checkNetwork(this,frag)) {
              DataHelper.setDataChangedListener(this);
              DataHelper.getNewData(this);
          }

      }else {
          DataHelper.setDataChangedListener(this);
          DataHelper.getNewData(this);
      }



    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().findFragmentByTag("main").isVisible())
        moveTaskToBack(true);
        else
            super.onBackPressed();
    }
    private boolean checkFirstTime(){
        firstTime = this.getSharedPreferences("FirstTime",this.MODE_PRIVATE);
        return  firstTime.getBoolean("first",true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                
            }
           return  true;
    }

    @Override
    public void onDataAdded() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment fragment = new Main_frag();
        ft.add(R.id.frag,fragment,"main");
        ft.commit();
        SharedPreferences.Editor editor = firstTime.edit();
        editor.putBoolean("first", false);
        editor.commit();
    }

    @Override
    public void onFileDownloaded(int pos, LinearLayout loading) {

    }

    @Override
    public void onFileDownloadedfailed() {

    }
}
