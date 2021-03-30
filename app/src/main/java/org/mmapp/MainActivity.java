package org.mmapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 *
 * MainActivity
 *
 * @author Erik Roemmelt
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        ll.setBackgroundColor(0x20FFFFFF);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(createButtonForActivity(this, "SimpleActivity", SimpleActivity.class));
        ll.addView(createButtonForActivity(this, "ButtonActivity", ButtonActivity.class));
        ll.addView(createButtonForActivity(this, "StateSwitchingActivity", StateSwitchingActivity.class));
        ll.addView(createButtonForActivity(this, "RotationActivity", RotationActivity.class));
        ll.addView(createButtonForActivity(this, "GeoActivity", GeoActivity.class));
        ll.addView(createButtonForActivity(this, "SMSActivity", SMSActivity.class));
        ll.addView(createButtonForActivity(this, "EmailActivity", EmailActivity.class));
        ll.addView(createButtonForActivity(this, "CalendarActivity", CalendarActivity.class));
        ll.addView(createButtonForActivity(this, "BarcodeActivity", BarcodeActivity.class));
        ll.addView(createButtonForActivity(this, "RecordVideoActivity", RecordVideoActivity.class));
        ll.addView(createButtonForActivity(this, "NumpadDemoActivity", NumpadDemoActivity.class));

        setContentView(ll);
    }

    protected Button createButtonForActivity(Context ctx, String btnLabel, Class activityClass) {
        Button btn = new Button(ctx);
        btn.setTypeface(Typeface.create(
                "sans-serif", Typeface.NORMAL));
        //btn.setTransformationMethod(null);
        btn.setText(btnLabel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Button '" + btnLabel + "' was clicked",
                        Toast.LENGTH_SHORT)
                        .show();
                startActivity(new Intent(ctx, activityClass));
            }
        });
        return btn;
    }
}
