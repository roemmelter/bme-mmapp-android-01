package org.mmapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecordVideoActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        ll.setBackgroundColor(Color.parseColor("#20FFFFFF"));
        ll.setOrientation(LinearLayout.VERTICAL);

        Button btn = new Button(this);
        btn.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        btn.setTransformationMethod(null);
        btn.setText("Record Video");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoVideoCapture = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (gotoVideoCapture.resolveActivityInfo(getPackageManager(), 0) != null) {
                    startActivityForResult(gotoVideoCapture, 1);
                } else {
                    Toast.makeText(v.getContext(), "Package/App not installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll.addView(btn);

        tv = new TextView(this);
        tv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        tv.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        tv.setText("Path to Video: na");
        ll.addView(tv);

        setContentView(ll);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri videoLocation = data.getData();
                tv.setText("Path to Video: " + videoLocation);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Recording was canceled.", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}