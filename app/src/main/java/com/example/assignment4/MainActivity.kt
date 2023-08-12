/* Assignment 4

    Name: Ricky Nguyen
    ONID: nguyrick
    Email: nguyrick@oregonstate.edu
    Course: CS 492

    MainActivity.kt

*/

package com.example.assignment4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.assignment4.ui.theme.Assignment4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment4Theme() {
                MainApp()
            }
        }
    }
}