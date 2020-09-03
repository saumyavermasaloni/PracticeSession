package com.example.practicesession.ui.login

import android.os.Bundle
import com.example.practicesession.R
import com.example.practicesession.di.component.ActivityComponent
import com.example.practicesession.ui.base.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel>() {
    override fun provideLayoutId(): Int = R.layout.activity_login

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }
}