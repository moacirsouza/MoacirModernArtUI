package com.example.moacir.moacirmodernartui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuOverFlowArea){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return false;
                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv1 = (TextView) findViewById(R.id.textView01);
        tv2 = (TextView) findViewById(R.id.textView02);
        tv3 = (TextView) findViewById(R.id.textView03);
        tv4 = (TextView) findViewById(R.id.textView04);
        tv5 = (TextView) findViewById(R.id.textView05);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setBackgroundColor(getResources().getColor(R.color.textView01Color, getTheme())+progress);
                tv1.setText("Color \n#" + Integer.toHexString(getResources().getColor(R.color.textView01Color, getTheme())+progress));

                tv2.setBackgroundColor(getResources().getColor(R.color.textView02Color, getTheme())+progress^2);
                tv2.setText("Color \n#" + Integer.toHexString(getResources().getColor(R.color.textView02Color, getTheme())+progress));

                tv3.setBackgroundColor(getResources().getColor(R.color.textView03Color, getTheme())+progress^4);
                tv3.setText("Color \n#" + Integer.toHexString(getResources().getColor(R.color.textView03Color, getTheme())+progress));

                tv4.setBackgroundColor(getResources().getColor(R.color.textView04Color, getTheme())-progress^5);
                tv4.setText("Color \n#" + Integer.toHexString(getResources().getColor(R.color.textView04Color, getTheme())+progress));

                tv5.setBackgroundColor(getResources().getColor(R.color.textView05Color, getTheme())+progress^6);
                tv5.setText("Color \n#" + Integer.toHexString(getResources().getColor(R.color.textView05Color, getTheme())+progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}