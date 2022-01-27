package `in`.co.logicsoft.sharedpreference

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedPreferenceViewModel(application: Application) : AndroidViewModel(application) {
    val firstName = MutableLiveData<String>()
    val secondName = MutableLiveData<String>()
    val outputFirstName = MutableLiveData<String>()
    val outputSecondName = MutableLiveData<String>()
    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences("sharedPrefFile", Context.MODE_PRIVATE)

    fun save() {
        val firstName = firstName.value.toString()
        val secondName = secondName.value.toString()
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("first_name_key", firstName)
        editor.putString("second_name_key", secondName)
        editor.apply()
    }

    fun view() {
        val sharedFirstNameValue = sharedPreferences.getString("first_name_key", "Aravindhan")
        val sharedSecondNameValue = sharedPreferences.getString("second_name_key", "Athmanathan")
        if (sharedFirstNameValue.equals("Aravindhan") && sharedSecondNameValue.equals("Athmanathan")) {
            outputFirstName.value = sharedFirstNameValue!!
            outputSecondName.value = sharedSecondNameValue!!
        } else {
            outputFirstName.value = sharedFirstNameValue!!
            outputSecondName.value = sharedSecondNameValue!!
        }
    }
    fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
        outputSecondName.value = ""
        outputFirstName.value = ""
    }

}

