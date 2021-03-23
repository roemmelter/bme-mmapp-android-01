package org.mmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 *
 * NumpadActivity
 *
 * @author Erik Roemmelt
 */
public class NumpadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int[] NUMBERS = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        final int COLUMNS = 3;
        final int ROWS = NUMBERS.length / COLUMNS;

        GridLayout gl = new GridLayout(this);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params.width = GridLayout.LayoutParams.WRAP_CONTENT;
        gl.setLayoutParams(params);
        gl.removeAllViews();
        gl.setColumnCount(COLUMNS);
        gl.setRowCount( ROWS );
        gl.setBackgroundColor(0x20FFFFFF);

        for (int number : NUMBERS) {
            createButton(Integer.toString(number), gl);
        }

        setContentView(gl);
    }

    private void createButton(String btnLabel, ViewGroup layout) {
        Button btn = new Button(layout.getContext());
        btn.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        btn.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        btn.setText(btnLabel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = ((Button) v).getId();
                int num = Integer.parseInt(btnLabel);
                Intent intent = new Intent();
                Log.i("NumpadActivity", "btnId: " + id + ", btnNum: " + num);
                intent.putExtra("id", id);
                intent.putExtra("num", num);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        layout.addView(btn);
    }
}