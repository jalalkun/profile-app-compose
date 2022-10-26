package com.jalalkun.profileappcompose.utils

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
