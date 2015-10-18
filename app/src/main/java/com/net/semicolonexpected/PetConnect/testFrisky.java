package com.net.semicolonexpected.PetConnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Krirk-Mac on 10/17/15.
 */
public class testFrisky extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frisky);

        ImageButton btnEmail = (ImageButton)findViewById(R.id.imageButton1);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setData(Uri.parse("mailto:friskycat@gmail.com"));
//                startActivity(intent);


                String[] emails = {"youremail@gmail.com"};
                String subject = "your subject";
                String message = "your message";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, emails);
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                // need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }
        });





    }

}