package edu.uga.cs.restaurantchoicesinathensga;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView overviewTV = findViewById(R.id.overviewTV);
        overviewTV.setText(rawFileToString(R.raw.overview));

        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.foodTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button descBtn = findViewById(R.id.descBtn);
        Button restBtn = findViewById(R.id.restBtn);

        descBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = spinner.getSelectedItem().toString();

                Intent startIntent = new Intent(getApplicationContext(), DescriptionActivity.class);
                startIntent.putExtra("something", choice);
                startActivity(startIntent);
            }
        });

        restBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = spinner.getSelectedItem().toString();

                Intent startIntent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                startIntent.putExtra("something",choice);
                startActivity(startIntent);
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        ((TextView) adapterView.getChildAt(0)).setTextSize(24);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * takes a raw text file and returns it in string form
     * @param i the file id
     * @return s the string
     */
    public String rawFileToString(int i){
        try {
            Resources res = getResources();
            InputStream in_s= res.openRawResource(i);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String s = new String(b);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
