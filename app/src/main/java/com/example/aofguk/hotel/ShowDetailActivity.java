package com.example.aofguk.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {
    private int resId;
    private String breed;
    private String description;
    private ImageView imageView;
    private TextView tvDescription;
    private TextView tvBreed;

    Button next_map_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        next_map_btn = (Button) findViewById(R.id.next_map_btn);

        next_map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowDetailActivity.this, MapsActivity.class);
                startActivity(intent);

                MapsActivity.lat = getIntent().getDoubleExtra("lat",0);;
                MapsActivity.lon = getIntent().getDoubleExtra("lon",0);;
                MapsActivity.titlez = getIntent().getStringExtra("breed");
            }
        });

        initInstances();
    }

    private void initInstances() {

        resId = getIntent().getIntExtra("resId",0);
        breed = getIntent().getStringExtra("breed");
        description = getIntent().getStringExtra("desc");

        tvDescription = (TextView) findViewById(R.id.desc);
        tvBreed = (TextView) findViewById(R.id.title);
        imageView = (ImageView) findViewById(R.id.image);

        tvDescription.setText(description);
        tvBreed.setText(breed);
        imageView.setImageResource(resId);
    }
}
