package com.swvl.movies.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.swvl.movies.services.dataModels.movie.MovieItem;

/**
 ********************* Meta Data ***********************************
 *           MicroPOS                                              *
 *           IntentCall.java                                       *
 *                                                                 *
 *           Created by Muneeb Ali on 26/04/2019                    *
 *           Copyright © 2019 Vourity AB. All rights reserved.     *
 *******************************************************************
 */


public class IntentCall {

    /**
     * Move to the spicfic class passed in the function
     */
    public static void NavigateScreen(Context context, Class<?> c, boolean isFinish){

        Intent intent = new Intent(context, c);
        context.startActivity(intent);

        if (isFinish){
            ((Activity)context).finish();
        }

    }

    /**
     * Nevigate with bundles
     */
    public static void NavigateWithExtras(Context context, Class<?> c, boolean isFinish,
                                          String key, String value){

        Intent intent = new Intent(context, c);
        intent.putExtra(key, value);
        context.startActivity(intent);

        if (isFinish){
            ((Activity)context).finish();
        }

    }
    /**
     * Nevigate with bundles
     */
    public static void NavigateWithExtras(Context context, Class<?> c, boolean isFinish,
                                          String key, MovieItem value){

        Intent intent = new Intent(context, c);
        intent.putExtra(key, value);
        context.startActivity(intent);

        if (isFinish){
            ((Activity)context).finish();
        }

    }


}
