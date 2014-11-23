package com.example.activity;

import android.app.Activity;
import android.content.Intent;

import com.example.R;
import com.example.robolectric.DeckardActivity;
import com.example.robolectric.SubActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Config(manifest = "./src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class DeckardActivityRobolectricTest {

    @Test
    public void ボタン押下時にmessageというIntentでFromDeckardActivityと設定されている事() throws Exception {
        Activity activity = Robolectric.buildActivity(DeckardActivity.class).create().get();

        // click button
        activity.findViewById(R.id.button).performClick();
        ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
        Intent intent = shadowActivity.peekNextStartedActivity();

        String actual = intent.getStringExtra("message");
        assertThat(actual, is("FromDeckardActivity"));
    }

    @Test
    public void ボタン押下時にIntentにSubActivityクラスが設定されている事() throws Exception {
        Activity activity = Robolectric.buildActivity(DeckardActivity.class).create().get();

        // click button
        activity.findViewById(R.id.button).performClick();
        ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
        Intent intent = shadowActivity.peekNextStartedActivity();

        ShadowIntent shadowIntent = Robolectric.shadowOf(intent);
        String actualClassName = shadowIntent.getComponent().getClassName();
        assertThat(actualClassName, is(SubActivity.class.getName()));
    }
}
