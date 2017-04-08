package com.example.aofguk.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    List<Dog> dogs = new ArrayList<>();
    int dataSize;
    public Dog listDog = new Dog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();


    }

    private void initInstances() {

        prepareData();

        ListAdapter adapter = new ListAdapter(MainActivity.this, listDog);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {

        //int resId[] = {R.drawable.dogspace, R.drawable.cotton};
        int resId[] = {R.drawable.dogspace, R.drawable.thedoghotel, R.drawable.cotton
                , R.drawable.xobboxdog, R.drawable.borderjack_doghotel, R.drawable.heartdog, R.drawable.bowwow, R.drawable.dog_hotel,
                R.drawable.dogs_sport, R.drawable.doggiedoo, R.drawable.donunited, R.drawable.dogs_cats, R.drawable.happy_richy
                , R.drawable.pet_paradise, R.drawable.phuket_dog, R.drawable.sabyjai, R.drawable.home_sweet, R.drawable.ohayodogie};
        int resId2[] = {R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
                R.drawable.dog_hotel_room,
        };

        //String breed[] = {"Dog space", "The Dog"};
        String breed[] = {"Dog space", "The Dog hotel bkk2", "Cotton dog hotel and care", "Box box dog hotel",
                "Borderjeck Dog hotel", "Heart Dog Cafe", "Bowwow Dog", "Dog hotel ลั่้ลลา", "Dog Sport Club",
                "Doggiedoo", "Dog United", "Dogs&Cats", "Happy Richy", "Pet Paradise",
                "Phuket dog", "Sabayjai Dog hotel", "Sweet Home Dog", "Ohayodogie Dog hotel"};


        String description[] = {getResources().getStringArray(R.array.dog_space)[0],
                getResources().getStringArray(R.array.the_dog)[0],
                getResources().getStringArray(R.array.Cotton_dog)[0],
                getResources().getStringArray(R.array.xob_box)[0],
                getResources().getStringArray(R.array.borderjeck_dog)[0],
                getResources().getStringArray(R.array.heart_dog)[0],
                getResources().getStringArray(R.array.bowwow_dog)[0],
                getResources().getStringArray(R.array.dog_hotel)[0],
                getResources().getStringArray(R.array.dog_sport)[0],
                getResources().getStringArray(R.array.doggie_doo)[0],
                getResources().getStringArray(R.array.dog_united)[0],
                getResources().getStringArray(R.array.dogs_cats)[0],
                getResources().getStringArray(R.array.happy_richy)[0],
                getResources().getStringArray(R.array.pet_paradise)[0],
                getResources().getStringArray(R.array.phuket_dog)[0],
                getResources().getStringArray(R.array.sabayjai_dog)[0],
                getResources().getStringArray(R.array.sweet_home)[0],
                getResources().getStringArray(R.array.ohyodgie_dog)[0],
        };

        Double lat[] = {Double.parseDouble(getResources().getStringArray(R.array.dog_space)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.the_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.Cotton_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.xob_box)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.borderjeck_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.heart_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.bowwow_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.dog_hotel)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.dog_sport)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.doggie_doo)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.dog_united)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.dogs_cats)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.happy_richy)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.pet_paradise)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.phuket_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.sabayjai_dog)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.sweet_home)[1]),
                Double.parseDouble(getResources().getStringArray(R.array.ohyodgie_dog)[1]),
        };

        Double lon[] = {Double.parseDouble(getResources().getStringArray(R.array.dog_space)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.the_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.Cotton_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.xob_box)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.borderjeck_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.heart_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.bowwow_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.dog_hotel)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.dog_sport)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.doggie_doo)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.dog_united)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.dogs_cats)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.happy_richy)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.pet_paradise)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.phuket_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.sabayjai_dog)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.sweet_home)[2]),
                Double.parseDouble(getResources().getStringArray(R.array.ohyodgie_dog)[2]),
        };

        dataSize = resId.length;


        Log.d("khem", "dataSize " + resId.length);
        Log.d("khem", "breed " + resId.length);
        Log.d("khem", "description " + resId.length);


        for (int i = 0; i < dataSize; i++) {
            Log.d("khem", " " + i);
            Dog dog = new Dog(resId[i],resId2[i] ,breed[i], description[i], lat[i], lon[i]);
            dogs.add(dog);
        }

        listDog.setDogs(dogs);

        //Log.d("khem",listDog);
    }

    /*************************
     * Listener
     ***************************/

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "POSITION:= " + position,
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, ShowDetailActivity.class);
            intent.putExtra("resId", listDog.getDogs().get(position).getResId2());
            intent.putExtra("breed", listDog.getDogs().get(position).getBreed());
            intent.putExtra("desc", listDog.getDogs().get(position).getDescription());
            intent.putExtra("lat", listDog.getDogs().get(position).getLat());
            intent.putExtra("lon", listDog.getDogs().get(position).getLon());
            startActivity(intent);
        }
    };

}
