package edu.uga.cs.restaurantchoicesinathensga;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getSupportActionBar().setTitle("Cuisine Description");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView img = findViewById(R.id.descIV);

        if(getIntent().hasExtra("something")){
            TextView tv = findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("something");

            switch(text){
                case "Mexican":
                    tv.setText(rawFileToString(R.raw.mexican_description));
                    img.setImageResource(R.drawable.enchiladas);
                    break;
                case "American":
                    tv.setText(rawFileToString(R.raw.american_description));
                    img.setImageResource(R.drawable.american_food);
                    break;
                case "Pizza":
                    tv.setText(rawFileToString(R.raw.pizza_description));
                    img.setImageResource(R.drawable.pizza);
                    break;
                case "Asian":
                    tv.setText(rawFileToString(R.raw.asian_description));
                    img.setImageResource(R.drawable.asian_food);
                    break;
                case "BBQ":
                    tv.setText(rawFileToString(R.raw.bbq_description));
                    img.setImageResource(R.drawable.bbq);
                    break;
                default:
                    break;
            }


        }
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
