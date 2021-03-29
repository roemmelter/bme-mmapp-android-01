package org.mmapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * <p><br>
 * <b>RecordVideoActivity</b><br>
 * This activity passes the user to standard video recording activity and
 * upon return shows the path to the video file.
 * </p><br>
 * @author Erik Roemmelt
 */
public class RecordVideoActivity extends Activity {
    private TextView tvPathToVideo;
    private final String labelTVPathToVideo = "Path to Video: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout.LayoutParams paramsMatchParent = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        final Typeface regularSansSerif = Typeface.create("sans-serif", Typeface.NORMAL);

        LinearLayout rootLayout = createLinearLayout(this,
                                                           paramsMatchParent,
                                                           0x20FFFFFF,
                                                           LinearLayout.VERTICAL);

        Button btnRecordVideo = createButton(this, regularSansSerif, "Record Video",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoVideoCapture = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                        if (gotoVideoCapture.resolveActivityInfo(getPackageManager(), 0) != null) {
                            startActivityForResult(gotoVideoCapture, 1);
                        } else {
                            Toast.makeText(v.getContext(), "Package/App not installed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        rootLayout.addView(btnRecordVideo);

        tvPathToVideo = createTextView(this,
                                       paramsMatchParent,
                                       regularSansSerif,
                                       String.format("%s-", labelTVPathToVideo));
        rootLayout.addView(tvPathToVideo);

        setContentView(rootLayout);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                Uri pathToVideo = data.getData();
                tvPathToVideo.setText(String.format("%s%s", labelTVPathToVideo, pathToVideo));
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this,
                        "Recording was canceled.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private LinearLayout createLinearLayout(Context context, LayoutParams layoutParams, Integer bgColor, Integer orientation) {
        LinearLayout ll = new LinearLayout(context);
        ll.setLayoutParams(layoutParams);
        ll.setBackgroundColor(bgColor);
        ll.setOrientation(orientation);
        return ll;
    }

    private Button createButton(Context context, Typeface typeface, String label, View.OnClickListener onClickListenerMethod) {
        Button btn = new Button(context);
        btn.setTypeface(typeface);
        btn.setTransformationMethod(null); // disables capitalization of all letters
        btn.setText(label);
        btn.setOnClickListener(onClickListenerMethod);
        return btn;
    }

    private TextView createTextView(Context context, LayoutParams layoutParams, Typeface typeface, String label) {
        TextView tv = new TextView(context);
        tv.setLayoutParams(layoutParams);
        tv.setTypeface(typeface);
        tv.setText(label);
        return tv;
    }
}
