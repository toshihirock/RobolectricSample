package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.example.R;
import com.example.robolectric.SubActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Config(manifest = "./src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class SubActivityTest {

    @Test
    public void messageというIntentが設定された場合にTextviewに内容を表示すること() throws Exception {
        Intent intent = new Intent();
        intent.putExtra("message", "FromDeckardActivity");

        Activity activity = Robolectric.buildActivity(SubActivity.class).withIntent(intent).create().get();

        TextView text = (TextView) activity.findViewById(R.id.textview);
        String actual = text.getText().toString();
        assertThat(actual, is("FromDeckardActivity"));
    }

    @Test
    public void messageというIntentが設定されていない場合にTextViewに設定されていない旨が表示されること() throws Exception {
        Activity activity = Robolectric.buildActivity(SubActivity.class).create().visible().get();

        TextView text = (TextView) activity.findViewById(R.id.textview);
        String actual = text.getText().toString();
        assertThat(actual, is("not found message extra"));
    }

    @Test
    public void onPauseメソッドが呼ばれたタイミングでTextViewが変更できていること() throws Exception {
        Activity activity = Robolectric.buildActivity(SubActivity.class).create().start().resume().pause().get();

        TextView text = (TextView) activity.findViewById(R.id.textview);
        String actual = text.getText().toString();
        assertThat(actual, is("onPause"));
    }
}
