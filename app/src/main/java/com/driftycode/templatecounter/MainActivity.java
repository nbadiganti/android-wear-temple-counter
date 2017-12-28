package com.driftycode.templatecounter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends WearableActivity {

    private static final String TAG = "MainActivity";
    TextView mTextView;
    @BindView(R.id.btn_minus)
    Button btnMinus;
    @BindView(R.id.btn_plus)
    Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTextView = findViewById(R.id.tv_counter);
        // Enables Always-on
        setAmbientEnabled();
    }

    @SuppressLint("SetTextI18n")
    @OnClick(R.id.btn_minus)
    public void countDecrement(View view) {
        // TODO submit data to server...
        int count = Integer.parseInt(mTextView.getText().toString());
        Log.d(TAG, "count " + count);
        if(count != 0 && !(count < 0)){
            count = count - 1;
            mTextView.setText(count + "");
        } else {
            Log.d(TAG, "Count is already 0 ");
        }
    }

    @SuppressLint("SetTextI18n")
    @OnClick(R.id.btn_plus)
    public void countIncrement(View view) {
        int count = Integer.parseInt(mTextView.getText().toString());
        Log.d(TAG, "count " + count);
        if(count >= 0){
            count = count + 1;
            mTextView.setText(count + "");
        } else {
            Log.d(TAG, "Count is already 0 ");
        }
    }
}
