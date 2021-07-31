package com.example.comp304sec_002_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ActivityChinese extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);

        intent = new Intent(ActivityChinese.this, ActivityChineseMap.class);

        Button btn =(Button)findViewById(R.id.all);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivityChinese.this, ActivityChineseMap.class);
                intent.putExtra(getString(R.string.intentName), 0);
                startActivity(intent);
            }
        });

        ListView lv = (ListView)findViewById(R.id.listView_chinese);
        final  String[] restNames = getResources().getStringArray(R.array.chinese_cuisines);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restNames);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        intent.putExtra(getString(R.string.intentName), 1);
                        break;
                    }
                    case 1:
                    {
                        intent.putExtra(getString(R.string.intentName), 2);
                        break;
                    }
                    case 2:
                    {
                        intent.putExtra(getString(R.string.intentName), 3);
                        break;
                    }
                }
                startActivity(intent);
            }
        });
    }
}