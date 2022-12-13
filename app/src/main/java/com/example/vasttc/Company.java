package com.example.vasttc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Company extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "MainActivity"; //wtf is even this
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter =new RecyclerAdapter(this,viewItems);
        mRecyclerView.setAdapter(mAdapter);

        addItemsFromJSON();
    }

    private void addItemsFromJSON() {
        try {

            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i<jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);

                String name = itemObj.getString("name");
                String dept = itemObj.getString("branch");
                String comp = itemObj.getString("company");

                Data data = new Data(name, dept,comp);
                viewItems.add(data);
            }

        } catch (JSONException | IOException e) {
            Log.d(TAG, "addItemsFromJSON: ", e);
        }
    }

    private String readJSONDataFromFile() throws IOException{

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            Intent i =getIntent();
            String datapass = i.getStringExtra("NAME"); //datapass is data from pace_year
            String jsonString = null;
            switch (datapass){
                case "2017":
                    inputStream = getResources().openRawResource(R.raw.d2017);
                    break;
                case "2018":
                    inputStream = getResources().openRawResource(R.raw.d2018);
                    break;
                case "2019":
                    inputStream = getResources().openRawResource(R.raw.d2019);
                    break;
                case "2020":
                    inputStream = getResources().openRawResource(R.raw.d2020);
                    break;
                case "2021":
                    inputStream = getResources().openRawResource(R.raw.d2021);
                    break;
                case "2022":
                    inputStream = getResources().openRawResource(R.raw.d2022);
                    break;
                default:
                    inputStream = getResources().openRawResource(R.raw.ddefault);

            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }
}
