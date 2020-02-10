package com.guoguo.updateapplanguage

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvChangeLanguage.setOnClickListener {
            //两种语言切换
            changeLanguage()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        if (newBase == null) {
            super.attachBaseContext(newBase)
        } else {
            super.attachBaseContext(LanguageManager.updateAppLanguage(newBase))
        }
    }

    private fun changeLanguage() {
        val updateLanguage = if (SharedPref.getAppLanguage(this) == "zh") "en" else "zh"
        SharedPref.setAppLanguage(this, updateLanguage)
        recreate()
    }
}
