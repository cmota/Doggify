package com.cmota.doggify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.cmota.doggify.main.MainScreen
import com.cmota.doggify.model.DoggoItem
import com.cmota.doggify.theme.DoggifyTheme
import com.cmota.doggify.utils.ARG_EXTRA_DOG

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DoggifyTheme(
                window = window,
                content = {
                    viewModel.getDoggos(resources)
                    MainScreen(viewModel = viewModel, openDetails = { doggo -> openDetails(doggo) })
                }
            )
        }
    }

    private fun openDetails(doggo: DoggoItem) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(ARG_EXTRA_DOG, doggo)
        startActivity(intent)
    }
}