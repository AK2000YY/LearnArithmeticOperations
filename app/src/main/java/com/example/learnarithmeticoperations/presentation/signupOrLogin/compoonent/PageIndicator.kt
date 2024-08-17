package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    listOfString: List<String>,
    listOfIcons: List<ImageVector>
) {
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    var pageNumber by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(6f)
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) { page ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = listOfIcons[page],
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 4.dp),
                    tint = Color.Black
                )
                Text(
                    text = listOfString[page],
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                )
            }
        }
    }
    LaunchedEffect(true) {
        while (true) {
            delay(3000)
            try {
                if(pageNumber != pagerState.currentPage) {
                    pageNumber = pagerState.currentPage
                }
                else {
                    pageNumber = (pageNumber+1)%3
                    pagerState.animateScrollToPage(pageNumber)
                }
            }catch(e: Exception) {
                continue
            }
        }
    }
}
