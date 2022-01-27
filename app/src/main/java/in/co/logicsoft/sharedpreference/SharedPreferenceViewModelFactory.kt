package `in`.co.logicsoft.sharedpreference

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SharedPreferenceViewModelFactory(val app:Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SharedPreferenceViewModel::class.java)) {
            SharedPreferenceViewModel(app) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}