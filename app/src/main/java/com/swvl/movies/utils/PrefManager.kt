package com.swvl.movies.utils

import android.content.SharedPreferences

class PrefManager {

    companion object {
        /**
         * Save date in preferences
         */
        fun savePreferences(key: String, value: String, sp: SharedPreferences) {
            val edit = sp.edit()
            edit.putString(key, value)
            edit.apply()
        }

        /**
         * Save boolean date in preferences
         */
        fun saveBooleanPreferences(key: String, value: Boolean, sp: SharedPreferences) {
            val edit = sp.edit()
            edit.putBoolean(key, value)
            edit.apply()
        }

        /**
         * Load date in preferences
         */
        fun loadPreferences(Key: String, sp: SharedPreferences): String {
            return sp.getString(Key, "0")!!
        }

        /**
         * Load boolean date in preferences
         */
        fun loadBooleanPreferences(Key: String, sp: SharedPreferences): Boolean {
            return sp.getBoolean(Key, false)

        }

        /**
         * Remove specific date from preferences
         */
        fun removePrefrence(key: String, sp: SharedPreferences) {
            val editor = sp.edit()
            editor.remove(key)
            editor.apply()
        }
    }

}