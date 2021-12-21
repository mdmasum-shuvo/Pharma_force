package com.appinion.pharma_force.di

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPreference @Inject constructor(private val preference: SharedPreferences) {
    fun getSharedData(prefTag: String): String {
        return preference.getString(prefTag, "")!!
    }

    fun setSharedData(prefTag: String, data: String) {
        preference.edit().putString(prefTag, data).apply()
    }
}