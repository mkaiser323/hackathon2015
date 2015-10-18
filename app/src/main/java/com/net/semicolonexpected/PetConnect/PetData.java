package com.net.semicolonexpected.PetConnect;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Krirk-Mac on 10/16/15.
 */
public class PetData {
    private static final String LOG_TAG = "PetData";

    public String content;
    public String name;
    public String avatarURL;
    public String title;

    public PetData(JSONObject jsonObject) {
        if (jsonObject != null) {
            try {
                name = jsonObject.getString("name");
                title = jsonObject.getString("title");
                avatarURL = jsonObject.getString("image");
                content = jsonObject.getString("content");

            }
            catch (JSONException e) {
                Log.w(LOG_TAG, e);

            }
        }
    }
}
