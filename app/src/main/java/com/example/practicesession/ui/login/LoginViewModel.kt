package com.example.practicesession.ui.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.practicesession.data.remote.response.OtpResponse
import com.example.practicesession.data.repository.OtpRepository
import com.example.practicesession.di.module.NetworkHelper
import com.example.practicesession.ui.base.BaseViewModel
import com.example.practicesession.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import com.example.practicesession.utils.common.Event
import com.example.practicesession.utils.common.Status
import io.reactivex.schedulers.Schedulers

class LoginViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val otpRepository: OtpRepository
):BaseViewModel(schedulerProvider,compositeDisposable,networkHelper) {

    val sendOtp: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val successOtp: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val failOtp: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    var userNumber: MutableLiveData<String> = MutableLiveData()
    var userOtp: MutableLiveData<String> = MutableLiveData()
    override fun onCreate() {}

    fun onPhoneNumberChange(number: String) {
        userNumber.postValue(number)
    }

    fun onOtpVerification(number: String) {
        userOtp.postValue(number)
    }

    fun onVerifyOtp() {

        val userNum = userNumber.value
        val otp=userOtp.value
       compositeDisposable.addAll(
           otpRepository.verifyOtp(userNum.toString(),otp.toString())
               .subscribeOn(Schedulers.io())
               .subscribe(
                   {
                       if(it.mobile=="success" && it.type=="200")
                       {
                           successOtp.postValue(Event(emptyMap()))
                       }
                       else
                       {
                           failOtp.postValue(Event(emptyMap()))
                       }
                   },
                   {
                       handleNetworkError(it)
                   }
               )
       )
    }

    fun onSendOtp() {

        if(checkInternetConnection())
        {
            val phoneNumber=userNumber.value
            compositeDisposable.addAll(
                otpRepository.fetchOtp(phoneNumber.toString(),2)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            sendOtp.postValue(Event(emptyMap()))
                        },
                        {
                            handleNetworkError(it)
                        }
                    )
            )
        }
    }


}