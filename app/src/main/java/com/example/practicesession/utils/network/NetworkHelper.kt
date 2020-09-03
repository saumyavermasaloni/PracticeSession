package com.example.practicesession.di.module

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log.e
import com.example.practicesession.utils.network.NetworkError
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import timber.log.Timber.e
import java.io.IOException
import java.net.ConnectException
import java.util.logging.Logger
import javax.inject.Singleton

@Singleton
class NetworkHelper constructor(private val context: Context) {

    companion object {
        private const val TAG = "NetworkHelper"
    }

    fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }

    fun castToNetworkError(throwable: Throwable): NetworkError {
        val defaultNetworkError = NetworkError()
        try {
            if (throwable is ConnectException) return NetworkError(0, "0")
            if (throwable !is HttpException) return defaultNetworkError
            val error = GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
                .fromJson(throwable.response().errorBody()?.string(), NetworkError::class.java)
            return NetworkError(throwable.code(), error.statusCode, error.message)
        } catch (e: IOException) {

        } catch (e: JsonSyntaxException) {

        } catch (e: NullPointerException) {

        }
        return defaultNetworkError
    }
}