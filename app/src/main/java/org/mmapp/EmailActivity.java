package org.mmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto",
                        "ralph@lano.de",
                        null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Android Book - Feedback");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Great book!");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}