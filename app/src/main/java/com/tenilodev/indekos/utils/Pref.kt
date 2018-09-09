
package com.tenilodev.indekos.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.tenilodev.indekos.Config
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by azisa on 1/5/2018.
 */
@Singleton
class Pref @Inject constructor(private val context: Context) {

    companion object {
        val PREF_USER = "pref.user"
        val PREF_LOGIN = "pref.login"
    }

    lateinit private var preference : SharedPreferences

    @Inject lateinit var gson : Gson

    init {
        preference = context.getSharedPreferences(Config.pref_name, Context.MODE_PRIVATE)
    }


    fun setLogin(isLogin: Boolean){
        val editor = preference.edit()
        editor.putBoolean(PREF_LOGIN,isLogin)
        editor.apply()
    }

    fun isLogin() : Boolean {
        return preference.getBoolean(PREF_LOGIN, false)
    }

    fun storeToken(token: String){
        val editor = preference.edit()
        editor.putString("pref.token",token)
        editor.apply()
    }

    fun getToken() :String? {
        return preference.getString("pref.token", null)
    }

    fun clearAll() {
        val edit = preference.edit()
        edit.clear().apply()
    }
}