package com.example.assignment4.ui.restaurants

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment4.R

@Composable
fun WaffleScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Image(
                painter = painterResource(R.drawable.waffle),
                contentDescription = null,
                modifier = Modifier
                    .width(375.dp)
            )
            Text(
                text = stringResource(R.string.restaurant1),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(vertical = 6.dp)
            )
            Text(
                text = stringResource(R.string.r1Address),
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = stringResource(R.string.r1Desc),
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}