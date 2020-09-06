package com.example.practicesession.data.repository

import com.example.practicesession.data.model.Otp
import com.example.practicesession.data.remote.NetworkService
import com.example.practicesession.data.remote.request.OtpRequest
import io.reactivex.Single
import javax.inject.Inject

class OtpRepository @Inject constructor(

    private val networkService: NetworkService
){

    fun fetchOtp(userNumber: String, type:Int):Single<Otp> =
        networkService.doOtpCall(OtpRequest(userNumber,type))
            .map {
                Otp(it.status,
                it.code)
            }


    fun verifyOtp(userNumber: String, otp:String):Single<Otp> =
        networkService.doOtpVerificationCall(userNumber,otp)
        .map {
            Otp(it.status,
                it.code)
        }
}