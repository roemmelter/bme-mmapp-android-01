package org.mmapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        ll.setBackgroundColor(0x200000FF);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(createButtonForActivity(this, "SimpleActivity", SimpleActivity.class));
        ll.addView(createButtonForActivity(this, "ButtonActivity", ButtonActivity.class));
        ll.addView(createButtonForActivity(this, "StateSwitchingActivity", StateSwitchingActivity.class));
        ll.addView(createButtonForActivity(this, "RotationActivity", RotationActivity.class));
        ll.addView(createButtonForActivity(this, "GeoActivity", GeoActivity.class));
        ll.addView(createButtonForActivity(this, "SMSActivity", SMSActivity.class));
        ll.addView(createButtonForActivity(this, "EmailActivity", EmailActivity.class));

        setContentView(ll);
    }

    protected Button createButtonForActivity(Context ctx, String btnLabel, Class activityClass) {
        Button btn = new Button(ctx);
        btn.setTypeface(Typeface.create(
                "sans-serif", Typeface.NORMAL));
        btn.setTransformationMethod(null);
        btn.setText(btnLabel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "ButtonTel was clicked",
                        Toast.LENGTH_SHORT)
                        .show();
                startActivity(new Intent(ctx, activityClass));
            }
        });
        return btn;
    }
}