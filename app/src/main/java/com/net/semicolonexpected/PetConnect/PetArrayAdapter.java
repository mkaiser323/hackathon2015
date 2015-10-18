package com.net.semicolonexpected.PetConnect;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class PetArrayAdapter extends ArrayAdapter<PetData> {
    private int layout;


    public PetArrayAdapter(Context context, int resource, List<PetData> objects) {
        super(context, resource, objects);
        layout = resource;

    }

    static class ViewHolder {
        public TextView textView;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ChatCell chatCell = new ChatCell();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.cell_pet, parent, false);


        chatCell.usernameTextView = (TextView) convertView.findViewById(R.id.usernameTextView);

//2
        chatCell.messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);

        chatCell.button = (Button) convertView.findViewById(R.id.button);


        //3
        chatCell.avatarImageView = (ImageView) convertView.findViewById(R.id.avatarImageView);


        PetData petData = getItem(position);

        chatCell.usernameTextView.setText(petData.name);
        chatCell.messageTextView.setText(petData.title);

        chatCell.button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(getContext(),
//                        position, Toast.LENGTH_LONG);
//                toast.show();

                if (position == 0) {
                    Intent intent = new Intent (v.getContext(), Breadface.class);
                    v.getContext().startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent (v.getContext(), Fido.class);
                    v.getContext().startActivity(intent);
                }
                else if (position == 2) {

                    Intent intent = new Intent (v.getContext(), testFrisky.class);
                    v.getContext().startActivity(intent);

                }

            }
        });


        //gets avatars
        Picasso.with(getContext())
                .load(petData.avatarURL)
                .resize(420, 420)
                .into(chatCell.avatarImageView);

        return convertView;

    }



    private static class ChatCell {
        TextView usernameTextView;
        TextView messageTextView;
        ImageView avatarImageView;
        Button button;
    }
}