package com.example.tipcalculator.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
    private static final String BILL_TOTAL = "BILL_TOTAL";
    private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT";
    private double currentBillTotal; //bill amount that will be entered by the user
    private int currentCustomPercent; //tip which is set by the user
    private EditText tip10EditText; //displays 10% tips
    private EditText tip15EditText; //displays 15% tips
    private EditText tip20EditText;
    private EditText total10EditText;//displays total with a 10% tip
    private EditText total15EditText;//displays total with a 15% tip
    private EditText total20EditText;//displays total with a 20% tip
    private EditText billEditText; //accepts user input for bill total
    private TextView customTipTextView; //displays custom tip percentage
    private EditText tipCustomEditText; //displays custom tip amount
    private EditText totalCustomEditText; //displays total with custom tip
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //call superclass's version
        setContentView(R.layout.activity_main); // Inflating the GUI

        //checking if the app is just being started or being restored from memory
        if(savedInstanceState == null) //if app has just started
        {
            currentBillTotal = 0.00;//
            currentCustomPercent = 18;//The Seek bar is set at 18% on initial start

        }
        else //if the app is being restored from memory.
        {
            //initialize the bill amount to be saved
            currentBillTotal = savedInstanceState.getDouble(BILL_TOTAL);

            //initialize the custom percent to the custom percentage that we just saved
            currentCustomPercent = savedInstanceState.getInt(CUSTOM_PERCENT);
        }
        //Get references to EditText variables
        tip10EditText = (EditText) findViewById(R.id.tip10editText);
        tip15EditText = (EditText) findViewById(R.id.tip15editText);
        tip20EditText = (EditText) findViewById(R.id.tip20editText);
        total10EditText = (EditText) findViewById(R.id.total10editText);
        total15EditText = (EditText) findViewById(R.id.total15editText);
        total20EditText = (EditText) findViewById(R.id.total20editText);
        customTipTextView = (TextView) findViewById(R.id.customtiptextView);
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomeditText);
        totalCustomEditText = (EditText) findViewById(R.id.totalcustomeditText);
        billEditText = (EditText) findViewById(R.id.billeditText);
        billEditText.addTextChangedListener(billEditTextWatcher);
        SeekBar customSeekBar = (SeekBar) findViewById(R.id.seekBar);
        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);


    }

    //update 10, 15, 20 percent tip Edittexts.
    private void updateStandard()
    {
        //calculate bill total with a 10% tip.
        double tenPercentTip = currentBillTotal * 0.1;
        double tenPercentTotal = currentBillTotal + tenPercentTip;
        //updating the text in tip10edittext
        tip10EditText.setText(String.format("0.2f",tenPercentTip));
        total10EditText.setText(String.format("0.2f",tenPercentTotal));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
