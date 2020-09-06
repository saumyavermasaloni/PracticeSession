package com.example.practicesession.data.remote

import com.example.practicesession.data.remote.request.ListItemRequest
import com.example.practicesession.data.remote.request.OtpRequest
import com.example.practicesession.data.remote.response.ListItemResponse
import com.example.practicesession.data.remote.response.OtpResponse
import com.example.practicesession.data.remote.response.OtpVerificationResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

interface NetworkService {

    @POST(Endpoints.OTP)
    fun doOtpCall(
        @Body request: OtpRequest
    ): Single<OtpResponse>

    @GET(Endpoints.OTP)
    fun doOtpVerificationCall(
        @Query("mobile") mobile:String?,
        @Query("otp") otp:String?
    ):Single<OtpVerificationResponse>

}
