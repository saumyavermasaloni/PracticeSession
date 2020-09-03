package com.example.practicesession.di.component

import com.example.practicesession.di.ViewModelScope
import com.example.practicesession.di.module.ViewHolderModule

import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

}