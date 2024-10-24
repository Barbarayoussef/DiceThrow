package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel:ViewModel() {
    //Mutable here like a wrapper , we make it private because the setter and the getter doing something different
    private val dieRoll =MutableLiveData<Int>()

    fun getDieRoll(): LiveData<Int>{
    //it works because a mutablelivedata is a live data but the reverse is not true
        return dieRoll

    }

    fun setDieRoll(newRoll:Int){
        dieRoll.value = newRoll
    }

}