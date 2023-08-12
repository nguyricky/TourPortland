/* Assignment 4

    Name: Ricky Nguyen
    ONID: nguyrick
    Email: nguyrick@oregonstate.edu
    Course: CS 492

    StartScreen.kt

*/

package com.example.assignment4.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.assignment4.R
import com.example.assignment4.data.DataSource.categoryOptionOne
import com.example.assignment4.data.DataSource.categoryOptionTwo
import com.example.assignment4.data.DataSource.categoryOptionThree

@Composable
fun CategoryRows(title: Int, picture: Int, onClick: () -> Unit,){
    Box(
        modifier = Modifier
            .clickable{ onClick.invoke()}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(picture),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
            )
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
    Divider(color = Color.Black)
}

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onCafeClick: (Int) -> Unit,
    onRestaurantClick: (Int) -> Unit,
    onShoppingClick: (Int) -> Unit,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            categoryOptionOne.forEach { item ->
                CategoryRows(
                    title = item.first,
                    picture = item.second,
                    onClick = { onCafeClick(item.first) }
                )
            }
            categoryOptionTwo.forEach { item ->
                CategoryRows(
                    title = item.first,
                    picture = item.second,
                    onClick = { onRestaurantClick(item.first) }
                )
            }
            categoryOptionThree.forEach { item ->
                CategoryRows(
                    title = item.first,
                    picture = item.second,
                    onClick = { onShoppingClick(item.first) }
                )
            }
        }
    }
}