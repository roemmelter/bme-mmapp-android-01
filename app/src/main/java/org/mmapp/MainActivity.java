package org.mmapp;

import android.app.Activity;
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

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        ll.setBackgroundColor(0x200000FF);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(createButtonGotoActivity(this, "Go to SimpleActivity", SimpleActivity.class));
        ll.addView(createButtonGotoActivity(this, "Go to ButtonActivity", ButtonActivity.class));
        ll.addView(createButtonGotoActivity(this, "Go to StateSwitchingActivity", StateSwitchingActivity.class));
        ll.addView(createButtonGotoActivity(this, "Go to RotationActivity", RotationActivity.class));

        setContentView(ll);
    }

    protected Button createButtonGotoActivity(Context ctx, String btnLabel, Class gotoActivityClass) {
        Button btn = new Button(ctx);
        btn.setTypeface(Typeface.create(
                "sans-serif", Typeface.NORMAL));
        btn.setText(btnLabel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "ButtonWeb was clicked",
                        Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(ctx, gotoActivityClass);
                startActivity(intent);
            }
        });
        return btn;
    }
}