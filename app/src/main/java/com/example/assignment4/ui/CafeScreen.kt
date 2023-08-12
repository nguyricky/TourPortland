/* Assignment 4

    Name: Ricky Nguyen
    ONID: nguyrick
    Email: nguyrick@oregonstate.edu
    Course: CS 492

    CafeScreen.kt

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
import com.example.assignment4.data.DataSource.C1
import com.example.assignment4.data.DataSource.C2
import com.example.assignment4.data.DataSource.C3
import com.example.assignment4.data.DataSource.C4

@Composable
fun RecommendationRows(title: Int, onClick: () -> Unit,){
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
fun CafeScreen(
    modifier: Modifier = Modifier,
    onR1Click: (Int) -> Unit,
    onR2Click: (Int) -> Unit,
    onR3Click: (Int) -> Unit,
    onR4Click: (Int) -> Unit,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            C1.forEach { item ->
                RecommendationRows(
                    title = item,
                    onClick = { onR1Click(item) }
                )
            }
            C2.forEach { item ->
                RecommendationRows(
                    title = item,
                    onClick = { onR2Click(item) }
                )
            }
            C3.forEach { item ->
                RecommendationRows(
                    title = item,
                    onClick = { onR3Click(item) }
                )
            }
            C4.forEach { item ->
                RecommendationRows(
                    title = item,
                    onClick = { onR4Click(item) }
                )
            }
        }
    }
}