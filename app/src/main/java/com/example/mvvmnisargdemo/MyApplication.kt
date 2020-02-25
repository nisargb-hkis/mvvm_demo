package com.example.mvvmnisargdemo

import android.app.Application
import com.example.mvvmnisargdemo.data.db.AppDatabase
import com.example.mvvmnisargdemo.data.network.MoviesApi
import com.example.mvvmnisargdemo.data.network.MyApi
import com.example.mvvmnisargdemo.data.network.NetworkConnectionInterceptor
import com.example.mvvmnisargdemo.data.repositories.MoviesRepository
import com.example.mvvmnisargdemo.data.repositories.QuotesRepository
import com.example.mvvmnisargdemo.data.repositories.UserRepository
import com.example.mvvmnisargdemo.ui.auth.AuthViewModelFactory
import com.example.mvvmnisargdemo.ui.home.movies.MoviesViewModelFactory
import com.example.mvvmnisargdemo.ui.home.profile.ProfileViewModelFactory
import com.example.mvvmnisargdemo.ui.home.quotes.QuotesViewModelFactory
import net.simplifiedcoding.mvvmsampleapp.data.preferences.PreferenceProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

        bind() from singleton { MoviesApi() }
        bind() from singleton { MoviesRepository(instance()) }
        bind() from provider { MoviesViewModelFactory(instance()) }

    }
}