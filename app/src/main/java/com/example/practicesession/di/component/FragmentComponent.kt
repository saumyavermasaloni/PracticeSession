package com.example.practicesession.di


import com.example.practicesession.di.component.ApplicationComponent
import com.example.practicesession.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {


}