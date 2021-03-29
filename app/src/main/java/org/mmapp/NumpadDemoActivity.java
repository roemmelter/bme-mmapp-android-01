package org.mmapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * <p><br>
 * <b>NumpadDemoActivity</b><br>
 *
 * </p><br>
 * @author Erik Roemmelt
 */
public class NumpadDemoActivity extends Activity {
    private TextView tv;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int btnId = 42;
        Intent intent = new Intent(getApplicationContext(), NumpadActivity.class);
        intent.putExtra("id", btnId);

        createLinearLayoutWithTextView("Button ID: " + btnId);
        setContentView(ll);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int id = data.getIntExtra("id", -1);
                int num = data.getIntExtra("num", -1);
                Log.i("NumpadDemoActivity", "ButtonId: " + id + ", ButtonNumber: " + num);
                tv.setText(String.format("ButtonId: %d; ButtonNumber: %d", id, num));

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Action canceled.",
                               Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void createLinearLayoutWithTextView(String textViewContent) {
        final LinearLayout.LayoutParams paramsMatchParent = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        ll = new LinearLayout(this);
        ll.setLayoutParams(paramsMatchParent);
        ll.setGravity(Gravity.CENTER);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setBackgroundColor(0x20FFFFFF);

        tv = new TextView(this);
        tv.setLayoutParams(paramsMatchParent);
        tv.setGravity(Gravity.CENTER);
        tv.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        tv.setText(textViewContent);

        ll.addView(tv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //setContentView(ll);
    }
}
