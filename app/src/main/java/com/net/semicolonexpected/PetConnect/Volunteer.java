package com.net.semicolonexpected.PetConnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by Ivan on 10/17/15.
 */
public class Volunteer extends Activity {

    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        submit = (Button)findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Thank you, Please allow 24hrs for us to review your application.",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Volunteer.this, Parser.class);
                startActivity(intent);
            }
        });
    }

}
