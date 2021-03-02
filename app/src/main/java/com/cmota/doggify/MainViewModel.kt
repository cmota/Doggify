package com.cmota.doggify

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cmota.doggify.model.Doggo
import com.google.gson.Gson
import java.io.IOException

private const val TAG = "MainViewModel"

class MainViewModel: ViewModel() {

    private val _doggos = MutableLiveData<Doggo>()
    val doggos: LiveData<Doggo>
        get() = _doggos

    fun getDoggos(resources: Resources) {
        try {
            val inputStream = resources.openRawResource(R.raw.doggify_data)
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)

            val doggos = Gson().fromJson(String(bytes), Doggo::class.java)
            _doggos.postValue(doggos)
        } catch (e: IOException) {
            Log.e(TAG, "Doggo, where are thou?")
        }
    }
}