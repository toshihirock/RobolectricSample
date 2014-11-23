package com.example.robolectric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.R;

public class DeckardActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);
      setContentView(R.layout.deckard);

      Button button =  (Button)findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent();
              intent.setClass(DeckardActivity.this,SubActivity.class);
              intent.putExtra("message", "FromDeckardActivity");
              startActivity(intent);
          }
      });
  }

}
