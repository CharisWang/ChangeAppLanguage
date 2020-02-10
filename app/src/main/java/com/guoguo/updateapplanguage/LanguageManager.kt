package com.guoguo.updateapplanguage

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import java.util.*

object LanguageManager {
    /**更新App内语言*/
    fun updateAppLanguage(context: Context): Context {
        val locale = Locale(SharedPref.getAppLanguage(context))
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            updateAppLanguageOnAPI17(context, locale)
        } else {
            updateAppLanguageBeforeAPI17(context, locale)
        }
    }

    /**更新App语言,API17以上*/
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun updateAppLanguageOnAPI17(context: Context, locale: Locale): Context {
        context.resources.configuration.run {
            setLocale(locale)
            return context.createConfigurationContext(this)
        }

    }

    /**更新App语言,API17以前*/
    private fun updateAppLanguageBeforeAPI17(context: Context, locale: Locale): Context {
        context.resources.run {
            configuration.locale = locale
            updateConfiguration(configuration, displayMetrics)
        }
        return context
    }
}