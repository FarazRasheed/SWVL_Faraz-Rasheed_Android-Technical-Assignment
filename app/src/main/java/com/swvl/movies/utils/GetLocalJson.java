package com.swvl.movies.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.swvl.movies.services.dataModels.movie.MoviesDTO;

import java.io.IOException;
import java.io.InputStream;

public class GetLocalJson {

    /**
     * Get json from assets folder
     */
    public static String loadJSONFromAsset(String Resource, Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open(Resource);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static MoviesDTO getLocalData (String Resource, Context context){

        Gson gson  = new Gson();
        return gson.fromJson(loadJSONFromAsset(Resource, context), MoviesDTO.class);

    }

}
