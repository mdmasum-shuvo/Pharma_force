package com.appinion.pharma_force.di

import androidx.lifecycle.AndroidViewModel
import com.appinion.pharma_force.netowork.NetworkCallbackApi
import com.appinion.pharma_force.netowork.repository_callback.AuthRepository
import com.appinion.pharma_force.netowork.repository_impl.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    @ViewModelScoped
    fun providesAuthRepository(api: NetworkCallbackApi) :AuthRepository {
        return AuthRepositoryImpl(api)
    }
}