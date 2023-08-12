/* Assignment 4

    Name: Ricky Nguyen
    ONID: nguyrick
    Email: nguyrick@oregonstate.edu
    Course: CS 492

    ShoppingScreen.kt

*/

package com.example.assignment4.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.assignment4.R
import com.example.assignment4.data.DataSource.S1
import com.example.assignment4.data.DataSource.S2
import com.example.assignment4.data.DataSource.S3
import com.example.assignment4.data.DataSource.S4

@Composable
fun RecommendationRowsThree(title: Int, onClick: () -> Unit,){
    Box(
        modifier = Modifier
            .clickable{ onClick.invoke()}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(12.dp)
            )
        }
    }
    Divider(color = Color.Black)
}

@Composable
fun ShoppingScreen(
    modifier: Modifier = Modifier,
    onS1Click: (Int) -> Unit,
    onS2Click: (Int) -> Unit,
    onS3Click: (Int) -> Unit,
    onS4Click: (Int) -> Unit,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            S1.forEach { item ->
                RecommendationRowsThree(
                    title = item,
                    onClick = { onS1Click(item) }
                )
            }
            S2.forEach { item ->
                RecommendationRowsThree(
                    title = item,
                    onClick = { onS2Click(item) }
                )
            }
            S3.forEach { item ->
                RecommendationRowsThree(
                    title = item,
                    onClick = { onS3Click(item) }
                )
            }
            S4.forEach { item ->
                RecommendationRowsThree(
                    title = item,
                    onClick = { onS4Click(item) }
                )
            }
        }
    }
}