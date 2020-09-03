package com.example.practicesession.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.practicesession.di.ViewModelScope
import com.example.practicesession.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}