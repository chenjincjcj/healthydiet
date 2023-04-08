package com.example.ccccccc.ui.jilu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JiluViewModel:ViewModel() {
 private val _text = MutableLiveData<String>().apply {
    value = "This is JILU Fragment"
}
val text: LiveData<String> = _text
}