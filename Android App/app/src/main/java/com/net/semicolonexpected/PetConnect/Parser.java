package com.net.semicolonexpected.PetConnect;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Krirk-Mac on 10/16/15.
 */
public class Parser extends ActionBarActivity {
    private PetArrayAdapter petArrayAdapter;
    private ArrayList<PetData> petDataArrayList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        listView = (ListView) findViewById(R.id.listView);
        petDataArrayList = new ArrayList<PetData>();

        try {
            String chatFileData = loadChatFile();
            JSONObject jsonData = new JSONObject(chatFileData);
            JSONArray jsonArray = jsonData.getJSONArray("post");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                PetData petData = new PetData(jsonObject);
                petDataArrayList.add(petData);
            }
        } catch (Exception e) {
           // Log.w(LOG_TAG, e);
        }
        petArrayAdapter = new PetArrayAdapter(this, R.layout.cell_pet, petDataArrayList);

        listView.setAdapter(petArrayAdapter);

        listView.setOnItemClickListener(new ListClickHandler());


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            this.closeOptionsMenu();

            Intent intent = new Intent (Parser.this, AddNewPost.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            // TODO Auto-generated method stub
            TextView listText = (TextView) view.findViewById(R.id.usernameTextView);
            String text = listText.getText().toString();


            // create intent to start another activity
            Intent intent = new Intent(Parser.this, PetArrayAdapter.class);
            // add the selected text item to our intent.
            intent.putExtra("selected-item", text);





            Toast toast = Toast.makeText(getApplicationContext(),
                 text, Toast.LENGTH_LONG);
            toast.show();

            startActivity(intent);

        }
    }

    private String loadChatFile() throws IOException {
        InputStream inputStream = getResources().openRawResource(R.raw.post);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String receiveString;
        StringBuilder stringBuilder = new StringBuilder();

        while ((receiveString = bufferedReader.readLine()) != null) {
            stringBuilder.append(receiveString);
            stringBuilder.append("\n");
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();


        return stringBuilder.toString();


    }
}