package com.mamon.nestednavcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NestedNavComposeApp(): Application(){
    override fun onCreate() {
        super.onCreate()
    }
}