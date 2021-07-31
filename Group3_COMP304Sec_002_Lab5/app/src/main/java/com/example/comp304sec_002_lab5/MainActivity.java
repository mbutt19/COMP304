package com.example.comp304sec_002_lab5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView_restaurants = (ListView)findViewById((R.id.list_restaurants));

        String[] cuisines_toronto = getResources().getStringArray(R.array.cuisines_toronto);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cuisines_toronto);
        listView_restaurants.setAdapter(arrayAdapter);

        listView_restaurants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent activity_italian = new Intent(getApplicationContext(), Activity_Italian.class);
                        startActivity(activity_italian);
                        break;
                    case 1:
                        Intent activity_greek = new Intent(getApplicationContext(), ActivityGreek.class);
                        startActivity(activity_greek);
                        break;
                    case 2:
                        Intent activity_chinese = new Intent(getApplicationContext(), ActivityChinese.class);
                        startActivity(activity_chinese);
                        break;
                    case 3:
                        Intent activity_indian = new Intent(getApplicationContext(), ActivityIndian.class);
                        startActivity(activity_indian);
                        break;
                }
            }
        });
    }
}