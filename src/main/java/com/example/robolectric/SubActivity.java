package com.example.robolectric;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import com.example.R;

public class SubActivity extends Activity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        text = (TextView) this.findViewById(R.id.textview);

        Intent intent = getIntent();

        // message extra
        if(intent.hasExtra("message")) {
            text.setText(intent.getStringExtra("message"));
        } else {
            text.setText("not found message extra");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        text.setText("onPause");
    }
}
