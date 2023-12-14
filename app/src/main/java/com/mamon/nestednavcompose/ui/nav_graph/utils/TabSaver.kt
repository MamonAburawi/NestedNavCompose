package com.mamon.nestednavcompose.ui.nav_graph.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TabSaver @Inject constructor(
    @ApplicationContext context: Context
){
    private val pre = context.getSharedPreferences("TabSaver",Context.MODE_PRIVATE)
    private val editor = pre.edit()

    object KEY {
        const val POSITION = "Position"
    }

    fun storeTabPosition(index: Int) {
        editor.putInt(KEY.POSITION,index)
        editor.apply()
    }

    fun fetchTabPosition() = pre.getInt(KEY.POSITION,0)
}