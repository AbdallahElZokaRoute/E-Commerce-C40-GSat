package com.route.e_commerce_c40_gsat.Screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce_c40_gsat.R
import com.route.e_commerce_c40_gsat.model.Categroies


@Composable
fun HomeScreen(categoriesList: List<Categroies>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.route_logo),
            contentDescription = "Route",
            modifier = modifier
                .padding(top = 50.dp, start = 17.dp)
                .width(66.dp)
                .height(22.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SearchBar()
            Image(
                painter = painterResource(id = R.drawable.icon__shopping_cart_),
                contentScale = ContentScale.Inside,
                contentDescription = "cart",
                modifier = modifier.clickable { }


            )
        }
        DealsBanner()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Categories",
                fontSize = 20.sp,
                color = colorResource(id = R.color.blue),
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(start = 22.dp)

            )
            Text(
                text = "view all",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = colorResource(id = R.color.blue),
                modifier = Modifier.padding(end = 22.dp)
            )

        }

        CategoriesHorizontalList(categroiesList = categoriesList)
        Text(
            text = "Home Appliance",
            fontSize = 20.sp,
            color = colorResource(id = R.color.blue),
            fontWeight = FontWeight.W500,
            modifier = modifier
                .padding(start = 22.dp, top = 12.dp)
        )


    }


}


@Composable
fun CategoryItem(categroies: Categroies, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 16.dp)
    ) {

        Image(
            painter = painterResource(id = categroies.categoriesImg), // Sample image
            contentDescription = "Circular Image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(1.dp, Color.Gray),
                    CircleShape
                )
        )

        Text(
            text = categroies.categoriesName,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(top = 8.dp)
                .width(95.dp)
        )
    }

}


@Composable
fun CategoriesHorizontalList(categroiesList: List<Categroies>, modifier: Modifier = Modifier) {

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth()
            .height(355.dp)
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categroiesList) { item ->
            CategoryItem(item)
        }
    }


}

@Preview
@Composable
private fun CategroiesHorizontalListPreview() {
    CategoriesHorizontalList(categroiesList = listOf())
}

@Composable
fun DealsBanner(modifier: Modifier = Modifier) {
    val items = listOf(
        R.drawable.img_banner_1,
        R.drawable.img_banner_2,
        R.drawable.img_banner_3
    )
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = item),
                    contentDescription = "image banner",
                    contentScale = ContentScale.Crop,
                    modifier = modifier.fillMaxWidth()
                )
            }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DealsBannerPreview() {
    DealsBanner()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query,
        onValueChange = { newQuery -> query = newQuery },
        placeholder = { Text(text = "What do you search for") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.icon__search_),
                contentDescription = "search",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .width(24.dp)
                    .height(24.dp)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            focusedPlaceholderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
 

        ),
        modifier = modifier
            .fillMaxWidth(0.90f)
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.blue),
                shape = RoundedCornerShape(25.dp)
            )


    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchBarPreview() {
    SearchBar()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    // HomeScreen(categroiesList1 = listOf())
}