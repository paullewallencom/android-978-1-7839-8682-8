package com.gradleforandroid.robolectric;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml", sdk = 18)
public class MainActivityTest {
    @Test
    public void clickingButtonShouldChangeText() {
        AppCompatActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        Button button = (Button) activity.findViewById(R.id.button);
        TextView textView = (TextView) activity.findViewById(R.id.label);

        button.performClick();

        assertThat(textView.getText().toString(), equalTo(activity.getString(R.string.hello_robolectric)));
    }
}
