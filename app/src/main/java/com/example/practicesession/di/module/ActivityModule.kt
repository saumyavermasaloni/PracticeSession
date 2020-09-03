package com.example.practicesession.di.module

import androidx.lifecycle.ViewModelProviders
import com.example.practicesession.ui.base.BaseActivity
import com.example.practicesession.ui.login.LoginViewModel
import com.example.practicesession.utils.rx.SchedulerProvider
import com.mindorks.bootcamp.instagram.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLoginViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): LoginViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(LoginViewModel::class) {
            LoginViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(LoginViewModel::class.java)
}