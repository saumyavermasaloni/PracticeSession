package com.example.practicesession.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicesession.data.repository.OtpRepository
import com.example.practicesession.ui.base.BaseActivity
import com.example.practicesession.ui.dashborad.DashboardViewModel
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
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideLoginViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        otpRepository: OtpRepository
    ): LoginViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(LoginViewModel::class) {
            LoginViewModel(schedulerProvider, compositeDisposable, networkHelper,otpRepository)
        }).get(LoginViewModel::class.java)

    @Provides
    fun provideDashboardViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): DashboardViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(DashboardViewModel::class) {
            DashboardViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(DashboardViewModel::class.java)

}