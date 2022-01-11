package com.appinion.pharma_force.di

import com.appinion.pharma_force.BuildConfig.*

import com.appinion.pharma_force.netowork.NetworkCallbackApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author MD. Masum Talukder
 *
 * @param Retrofit
 * @param OkHttpRequest provide okHttp instance
 * @param Moshi provide moshi instance
 * @param NetworkCallbackApi provide instance
 * @provider annotation provide instance of class
 * @provide moshi as a json converter
 * @provide Retrofit client for network call
 * @Access NetworkModule is access over the applicaiton level
 * @install in SingleTone component annotation provide applevel installation
 *

 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    val token: String = ""


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.MINUTES)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request: okhttp3.Request = if (token == "") {
                    chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("authorization", SECRETE_KEY)
                        .build()

                } else {
                    chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("token", "Bearer ${token}")
                        .build()
                }
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .add(KotlinJsonAdapterFactory())
        .build()


    @Provides
    @Singleton
    fun provideNetworkCallback(okHttpClient: OkHttpClient, moshi: Moshi): NetworkCallbackApi {
        val url = if (DEBUG) {
            BASE_URL_DEV
        } else {
            BASE_URL_LIVE
        }
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(url)
            .build()
            .create(NetworkCallbackApi::class.java)
    }


/*    @Provides
    @Singleton
    @Named("mis")
    fun provideNetworkCallbackMis(okHttpClient: OkHttpClient, moshi: Moshi): NetworkCallbackApi {

        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(MIS_URL)
            .build()
            .create(NetworkCallbackApi::class.java)
    }*/

}