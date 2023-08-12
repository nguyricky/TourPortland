/* Assignment 4

    Name: Ricky Nguyen
    ONID: nguyrick
    Email: nguyrick@oregonstate.edu
    Course: CS 492

    MainScreen.kt

*/

package com.example.assignment4

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assignment4.ui.CafeScreen
import com.example.assignment4.ui.RestaurantScreen
import com.example.assignment4.ui.ShoppingScreen
import com.example.assignment4.ui.StartScreen
import com.example.assignment4.ui.cafes.ProudMaryScreen
import com.example.assignment4.ui.cafes.SoroSoroScreen
import com.example.assignment4.ui.cafes.TanakaScreen
import com.example.assignment4.ui.cafes.UmamiScreen
import com.example.assignment4.ui.restaurants.ChimckingScreen
import com.example.assignment4.ui.restaurants.FireScreen
import com.example.assignment4.ui.restaurants.KkokiScreen
import com.example.assignment4.ui.restaurants.WaffleScreen
import com.example.assignment4.ui.shopping.ClackamasScreen
import com.example.assignment4.ui.shopping.LloydScreen
import com.example.assignment4.ui.shopping.PioneerScreen
import com.example.assignment4.ui.shopping.WashingtonScreen

enum class MainScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Cafes(title = R.string.c1),
    Restaurants(title = R.string.c2),
    Shopping(title = R.string.c3),
    SoroSoro(title = R.string.cafe1),
    Umami(title = R.string.cafe2),
    ProudMary(title = R.string.cafe3),
    Tanaka(title = R.string.cafe4),
    Waffle(title = R.string.restaurant1),
    ChimcKing(title = R.string.restaurant2),
    Kkoki(title = R.string.restaurant3),
    Fire(title = R.string.restaurant4),
    Washington(title = R.string.shopping1),
    Pioneer(title = R.string.shopping2),
    Lloyd(title = R.string.shopping3),
    Clackamas(title = R.string.shopping4)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    currentScreen: MainScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MainScreen.valueOf(
        backStackEntry?.destination?.route ?: MainScreen.Start.name
    )

    Scaffold(
        topBar = {
            MainAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ){ innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MainScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainScreen.Start.name) {
                StartScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    onCafeClick = {
                        navController.navigate(MainScreen.Cafes.name)
                    },
                    onRestaurantClick = {
                        navController.navigate(MainScreen.Restaurants.name)
                    },
                    onShoppingClick = {
                        navController.navigate(MainScreen.Shopping.name)
                    },
                )
            }
            composable(route = MainScreen.Cafes.name) {
                CafeScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    onR1Click = {
                        navController.navigate(MainScreen.SoroSoro.name)
                    },
                    onR2Click = {
                        navController.navigate(MainScreen.Umami.name)
                    },
                    onR3Click = {
                        navController.navigate(MainScreen.ProudMary.name)
                    },
                    onR4Click = {
                        navController.navigate(MainScreen.Tanaka.name)
                    }
                )
            }
            composable(route = MainScreen.SoroSoro.name) {
                SoroSoroScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Umami.name) {
                UmamiScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.ProudMary.name) {
                ProudMaryScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Tanaka.name) {
                TanakaScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Restaurants.name) {
                RestaurantScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    onR1Click = {
                        navController.navigate(MainScreen.Waffle.name)
                    },
                    onR2Click = {
                        navController.navigate(MainScreen.ChimcKing.name)
                    },
                    onR3Click = {
                        navController.navigate(MainScreen.Kkoki.name)
                    },
                    onR4Click = {
                        navController.navigate(MainScreen.Fire.name)
                    }
                )
            }
            composable(route = MainScreen.Waffle.name) {
                WaffleScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.ChimcKing.name) {
                ChimckingScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Kkoki.name) {
                KkokiScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Fire.name) {
                FireScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Shopping.name) {
                ShoppingScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    onS1Click = {
                        navController.navigate(MainScreen.Washington.name)
                    },
                    onS2Click = {
                        navController.navigate(MainScreen.Pioneer.name)
                    },
                    onS3Click = {
                        navController.navigate(MainScreen.Lloyd.name)
                    },
                    onS4Click = {
                        navController.navigate(MainScreen.Clackamas.name)
                    }
                )
            }
            composable(route = MainScreen.Washington.name) {
                WashingtonScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Pioneer.name) {
                PioneerScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Lloyd.name) {
                LloydScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
            composable(route = MainScreen.Clackamas.name) {
                ClackamasScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)))
            }
        }
    }
}
