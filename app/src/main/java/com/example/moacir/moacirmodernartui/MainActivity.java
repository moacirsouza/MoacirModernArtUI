package com.example.moacir.moacirmodernartui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView tv1, tv2, tv3, tv4, tv5;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void setVisibleElementsAttribrutes(int progress){
        tv1.setBackgroundColor(getResources().getColor(R.color.textView01Color, getTheme())+progress);
        //tv1.setText("Color\n#" + Integer.toHexString(getResources().getColor(R.color.textView01Color, getTheme())+progress));

        tv2.setBackgroundColor(getResources().getColor(R.color.textView02Color, getTheme())+progress^2);
        //tv2.setText("Color\n#" + Integer.toHexString(getResources().getColor(R.color.textView02Color, getTheme())+progress));

        tv3.setBackgroundColor(getResources().getColor(R.color.textView03Color, getTheme())+progress^4);
        //tv3.setText("Color\n#" + Integer.toHexString(getResources().getColor(R.color.textView03Color, getTheme())+progress));

        //tv4.setBackgroundColor(getResources().getColor(R.color.textView04Color, getTheme())-progress^5);
        //tv4.setText("Color\n#" + Integer.toHexString(getResources().getColor(R.color.textView04Color, getTheme())+progress));

        tv5.setBackgroundColor(getResources().getColor(R.color.textView05Color, getTheme())+progress^6);
        //tv5.setText("Color\n#" + Integer.toHexString(getResources().getColor(R.color.textView05Color, getTheme())+progress));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the Seek Bar and TextViews from the res class
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv1 = (TextView) findViewById(R.id.textView01);
        tv2 = (TextView) findViewById(R.id.textView02);
        tv3 = (TextView) findViewById(R.id.textView03);
        tv4 = (TextView) findViewById(R.id.textView04);
        tv5 = (TextView) findViewById(R.id.textView05);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setVisibleElementsAttribrutes(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    // Inflate the Menu on the overflow area
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    // Capture the click on the menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Diaglog implementation
        final Dialog dialog = new Dialog(this);
        dialog.setTitle(getResources().getString(R.string.dialogText));
        dialog.setContentView(R.layout.dialog_layout);

        // Treating the Button that goes to the MoMa website
        dialog.findViewById(R.id.buttonVisitMoMA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moma.org"));
                startActivity(intent);
            }
        });

        // Dismissing the Dialog
        dialog.findViewById(R.id.buttonNotNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        if (item.getItemId() == R.id.menuOverFlowArea){
            dialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


/*    // FrameDialog implementation
    public static class createMyDialogFragment extends DialogFragment {

        public static createMyDialogFragment newInstance(int title) {
            createMyDialogFragment frag = new createMyDialogFragment();
            Bundle args = new Bundle();
            args.putInt("Teste", title);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("Teste");

            return new AlertDialog.Builder(getActivity())
                    //.setIcon(R.drawable.alert_dialog_icon)
                    .setTitle(title)
                    .setPositiveButton(R.string.goToMoMA,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    ((MainActivity)getActivity()).doPositiveClick();
                                }
                            }
                    )
                    .setNegativeButton(R.string.cancelButton,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    ((MainActivity)getActivity()).doNegativeClick();
                                }
                            }
                    )
                    .create();
        }
    }

    void showDialog() {
        DialogFragment newFragment = createMyDialogFragment.newInstance(
                R.string.dialogTitle);
        newFragment.show(getFragmentManager(), "dialog");
        Log.i("FragmentAlertDialog", "Mostrou");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }*/

}