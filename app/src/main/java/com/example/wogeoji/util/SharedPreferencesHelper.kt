package com.example.wogeoji.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesHelper {
    private val PREF_NAME = "LoginPrefs"
    private val KEY_USERID = "userId"

    private lateinit var sharedPreferences: SharedPreferences
    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    private fun checkInitialized() {
        if (!::sharedPreferences.isInitialized) {
            throw IllegalStateException("SharedPreferencesHelper must be initialized before use")
        }
    }

    fun saveLoginInfo(userPk: String) {
        checkInitialized()
        val editor = sharedPreferences.edit()
        editor.putString(this.KEY_USERID, userPk)
        editor.apply()
    }

    fun getUserPk(): String {
        checkInitialized()
        return sharedPreferences.getString(this.KEY_USERID, "") ?: ""
    }

    fun containsUserPk(): Boolean {
        checkInitialized()
        return sharedPreferences.contains(this.KEY_USERID)
    }

    fun clear() {
        checkInitialized()
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}