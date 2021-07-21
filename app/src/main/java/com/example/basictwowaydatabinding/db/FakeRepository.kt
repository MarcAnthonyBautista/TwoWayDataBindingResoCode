package com.example.basictwowaydatabinding.db

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val movieList : List<String> = listOf("Titanic","Men in Black","Spiderman","X-men")

    private val _nowShowing = MutableLiveData<String> ()
    val nowShowing : LiveData<String> get() = _nowShowing


    init {
        _nowShowing.value = movieList.first()
    }

    fun randomize() : String{
        val random = Random()
        return movieList[random.nextInt(movieList.size)]
    }

    fun getRandomizeMovie () {
        _nowShowing.value = randomize()
    }



}