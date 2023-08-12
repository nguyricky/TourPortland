/* Assignment 4

    Name: Ricky Nguyen
    ONID: nguyrick
    Email: nguyrick@oregonstate.edu
    Course: CS 492

    CategoryItem.kt

*/

package com.example.assignment4.model

sealed class CategoryItem(
    open val name: String,
    open val description: String
) {
    data class Categories(
        override val name: String,
        override val description: String,
    ) : CategoryItem(name, description)
}