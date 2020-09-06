package com.example.practicesession.ui.dashborad

import android.content.Intent
import android.os.Bundle
import android.util.EventLog
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.practicesession.R
import com.example.practicesession.di.component.ActivityComponent
import com.example.practicesession.ui.base.BaseActivity
import com.example.practicesession.utils.common.Event
import com.example.practicesession.utils.display.Toaster
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity:BaseActivity<DashboardViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_dashboard

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        if(intent.getStringExtra("report").equals("success"))
            viewModel.showToast()
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.toastMsg.observe(this, Observer {
            Toaster.show(applicationContext,"Successfully Login!!")
        })
    }
}