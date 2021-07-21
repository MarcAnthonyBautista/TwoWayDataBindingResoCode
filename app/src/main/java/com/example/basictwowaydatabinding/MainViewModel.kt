package com.example.basictwowaydatabinding

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basictwowaydatabinding.db.FakeRepository

class MainViewModel : ViewModel() , Observable {
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }


    val nowShowing : LiveData<String> get() = FakeRepository.nowShowing

    val _whatsNext = MutableLiveData<String>()
    val whatsNext : LiveData<String> get()= _whatsNext

    fun getRandomMovieClick () {
        FakeRepository.getRandomizeMovie()
    }

    @Bindable
    val editTextContent = MutableLiveData<String>()

    fun insertToWN () {
        _whatsNext.value = editTextContent.value
    }

    fun randomToEditText() {
        editTextContent.value = FakeRepository.randomize()
    }






    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
       callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }
}