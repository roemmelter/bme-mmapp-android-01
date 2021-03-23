package org.mmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 *
 * GeoActivity
 *
 * @author Erik Roemmelt
 */
public class GeoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = Uri.parse("geo:0,0?q="+
                "Bahnhofstrasse%2090%2C"+
                "90402%20Nuremberg%2CGermany");
        Intent gotoLocation = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(gotoLocation);
    }
}