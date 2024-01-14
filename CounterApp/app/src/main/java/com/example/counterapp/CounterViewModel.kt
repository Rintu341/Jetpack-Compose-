package com.example.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = mutableIntStateOf(0)

    //Expose to the user the immutable count
    var count:MutableState<Int> = _count

    fun increment()
    {
        _count.intValue++
    }
    fun decrement()
    {
        _count.intValue--
    }
}