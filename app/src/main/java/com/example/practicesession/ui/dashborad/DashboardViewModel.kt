package com.example.practicesession.ui.dashborad

import android.util.EventLog
import androidx.lifecycle.MutableLiveData
import com.example.practicesession.di.module.NetworkHelper
import com.example.practicesession.ui.base.BaseViewModel
import com.example.practicesession.utils.common.Event
import com.example.practicesession.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
):BaseViewModel(schedulerProvider,compositeDisposable,networkHelper) {

    val toastMsg:MutableLiveData<String> = MutableLiveData()
    override fun onCreate() {}

    fun showToast() {
        toastMsg.postValue("success")
    }
}