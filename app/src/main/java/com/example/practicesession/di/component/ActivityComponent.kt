package com.example.practicesession.di.component

import com.example.practicesession.di.ActivityScope
import com.example.practicesession.di.module.ActivityModule
import com.example.practicesession.ui.dashborad.DashboardActivity
import com.example.practicesession.ui.login.LoginActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity:LoginActivity)

    fun inject(activity:DashboardActivity)
}