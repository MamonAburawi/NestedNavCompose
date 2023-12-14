@file:OptIn(ExperimentalFoundationApi::class)

package com.mamon.nestednavcompose.ui.screens.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mamon.nestednavcompose.ui.nav_graph.utils.TabItem


object TapHome {
    const val LOCATION = 0
    const val DETAILS = 1
    const val SECURITY = 2
}

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val lastTabPosition = viewModel.currentTapPosition.collectAsState().value
    var tapIndex by remember { mutableIntStateOf(lastTabPosition) }
    val pagerState = rememberPagerState(initialPage = tapIndex){
        tabItems.size
    }

    Log.d("Home","Current Tap: $lastTabPosition")

    LaunchedEffect(key1 = tapIndex) {
        pagerState.animateScrollToPage(tapIndex)
    }

    LaunchedEffect(
        key1 = pagerState.currentPage,
        key2 = pagerState.isScrollInProgress
    ) {
        if (!pagerState.isScrollInProgress) {
            tapIndex = pagerState.currentPage
        }
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TabRow(
            selectedTabIndex = tapIndex,
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    text = {
                        Text(text = item.title)
                    } ,
                    selected = tapIndex == index,
                    onClick = {
                        tapIndex = index
                        viewModel.updateTabPosition(index)
                    },
                    icon = {
                        Icon(
                            imageVector = if (tapIndex == index) item.selectedIcon else item.unSelectedIcon,
                            contentDescription = item.title
                        )
                    }
                )
            }

        }


        TabPager(
            modifier = Modifier.weight(1f),
            pagerState = pagerState,
            onScroll = { currentTap ->

                when(currentTap){
                    TapHome.LOCATION -> {
                        Text(text = "Location Tap")
                    }
                    TapHome.DETAILS -> {
                        Text(text = "Details Tap")
                    }
                    TapHome.SECURITY -> {
                        Text(text = "Security Tap")
                    }
                }
            }
        )

    }


}


@Composable
fun TabPager(
    modifier: Modifier,
    pagerState: PagerState,
    onScroll: @Composable (page: Int) -> Unit
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState
    ) { currentTap ->

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            onScroll(currentTap)
        }

    }
}


private val tabItems = listOf(
    TabItem(
        title = "Location",
        selectedIcon = Icons.Filled.LocationOn,
        unSelectedIcon = Icons.Outlined.LocationOn
    ),
    TabItem(
        title = "Details",
        selectedIcon = Icons.Filled.Edit,
        unSelectedIcon = Icons.Outlined.Edit
    ),
    TabItem(
        title = "Security",
        selectedIcon = Icons.Filled.Lock,
        unSelectedIcon = Icons.Outlined.Lock
    )
)
