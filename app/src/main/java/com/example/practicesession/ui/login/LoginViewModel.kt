package com.example.practicesession.ui.login

import com.example.practicesession.di.module.NetworkHelper
import com.example.practicesession.ui.base.BaseViewModel
import com.example.practicesession.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
):BaseViewModel(schedulerProvider,compositeDisposable,networkHelper) {

    override fun onCreate() {
    }
}