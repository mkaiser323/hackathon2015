package com.net.semicolonexpected.PetConnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by Krirk-Mac on 10/17/15.
 */
public class AddNewPost extends Activity {

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_post);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"We hope that we can find a terrific forever home for your pet.",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(AddNewPost.this, Parser.class);
                startActivity(intent);
            }
        });
    }
}
