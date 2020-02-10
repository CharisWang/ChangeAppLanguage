package com.guoguo.updateapplanguage

import android.content.Context
import android.content.SharedPreferences


object SharedPref {
    private const val SHARE_PREFERENCES_NAME = "update_app_language"
    private const val KEY_APP_LANGUAGE = "key_app_language"
    private var mSP: SharedPreferences? = null
    private fun init(context: Context): SharedPreferences {
        return mSP ?: let {
            val sp = context.applicationContext.getSharedPreferences(
                SHARE_PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
            mSP = sp
            sp
        }
    }

    fun getAppLanguage(context: Context): String {
        return init(context).getString(KEY_APP_LANGUAGE, "en") ?: "en"
    }

    fun setAppLanguage(context: Context, localString: String) {
        init(context).edit().putString(KEY_APP_LANGUAGE, localString).apply()
    }
}