package com.example.practicesession.ui.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.practicesession.R
import com.example.practicesession.di.component.ActivityComponent
import com.example.practicesession.ui.base.BaseActivity
import com.example.practicesession.ui.dashborad.DashboardActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel>() {
    override fun provideLayoutId(): Int = R.layout.activity_login

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        tv_mobileNumber?.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onPhoneNumberChange(s.toString())
            }
        })

        btn_send_otp.setOnClickListener()
        {
            viewModel.onSendOtp()
        }

        tv_otp_number.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onOtpVerification(s.toString())
            }
        })

        btn_verify_otp.setOnClickListener {
            viewModel.onVerifyOtp()
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.sendOtp.observe(this, Observer {
            Toast.makeText(applicationContext,"Request for otp is sent", Toast.LENGTH_SHORT).show()
        })

        viewModel.failOtp.observe(this, Observer {
            Toast.makeText(applicationContext,"Otp is not correct", Toast.LENGTH_SHORT).show()
        })

        viewModel.successOtp.observe(this, Observer {
            val intent=Intent(this,DashboardActivity::class.java)
            intent.putExtra("report","success")
            startActivity(intent)
        })
    }
}