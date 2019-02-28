package edu.uga.cs.restaurantchoicesinathensga;

import android.app.ActionBar;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        getSupportActionBar().setTitle("Restaurants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView img = findViewById(R.id.restIV);

        if(getIntent().hasExtra("something")){
            TextView tv = findViewById(R.id.restaurantsTV);
            String text = getIntent().getExtras().getString("something");

            switch(text){
                case "Mexican":
                    tv.setText(rawFileToString(R.raw.mexican_restaurants));
                    img.setImageResource(R.drawable.enchiladas);
                    break;
                case "American":
                    tv.setText(rawFileToString(R.raw.american_restaurants));
                    img.setImageResource(R.drawable.american_food);
                    break;
                case "Pizza":
                    tv.setText(rawFileToString(R.raw.pizza_restaurants));
                    img.setImageResource(R.drawable.pizza);
                    break;
                case "Asian":
                    tv.setText(rawFileToString(R.raw.asian_restaurants));
                    img.setImageResource(R.drawable.asian_food);
                    break;
                case "BBQ":
                    tv.setText(rawFileToString(R.raw.bbq_restaurants));
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
