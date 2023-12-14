package com.mamon.nestednavcompose.di

import android.content.Context
import com.mamon.nestednavcompose.ui.nav_graph.utils.TabSaver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun getTabSever( @ApplicationContext context: Context): TabSaver = TabSaver(context)

}