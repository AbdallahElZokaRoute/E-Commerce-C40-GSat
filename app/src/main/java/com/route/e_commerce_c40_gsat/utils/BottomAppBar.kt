package com.route.e_commerce_c40_gsat.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce_c40_gsat.BottomAppBarTabs
import com.route.e_commerce_c40_gsat.Destination
import com.route.e_commerce_c40_gsat.R
import com.route.e_commerce_c40_gsat.ui.theme.Blue1

@Composable
fun ECommerceBottomAppBar(
    tabsList: List<BottomAppBarTabs>,
    onTabClick: (tabIndex: Int) -> Unit
) {
    var selectedItemIndex by remember {
        mutableIntStateOf(0)
    }

    BottomAppBar(
        containerColor = Blue1,
        contentColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1F)
            .clip(RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)),

        ) {

        tabsList.forEachIndexed { index, item ->
            val selectedModifier = Modifier
                .weight(1f)
                .height(40.dp)
                .background(Color.White, CircleShape)

            val unselectedModifier = Modifier
                .weight(1f)
                .height(40.dp)
                .clickable {
                    onTabClick(index)
                    selectedItemIndex = index
                }

            Icon(
                painter = painterResource(id = item.icon),
                tint = if (selectedItemIndex == index) Blue1 else Color.White,
                contentDescription = stringResource(R.string.bottom_navigation_description),
                modifier = if (selectedItemIndex == index) {
                    selectedModifier
                } else {
                    unselectedModifier
                },
            )
        }
    }
}

