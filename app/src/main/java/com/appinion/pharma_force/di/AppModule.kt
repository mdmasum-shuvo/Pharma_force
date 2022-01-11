package com.appinion.pharma_force.di

import android.content.Context
import android.content.SharedPreferences

import com.appinion.pharma_force.feature.common.PharmaApplication

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

/**
 * @author MD. Masum Talukder
 *
 * @param applicaitonContext
 * @param sharedPrefrence
 *
 * create Singletone object
 * provide instance over the application
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): PharmaApplication {
        return app as PharmaApplication
    }

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE)
    }
}