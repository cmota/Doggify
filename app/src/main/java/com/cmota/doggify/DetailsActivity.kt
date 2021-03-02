package com.cmota.doggify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.cmota.doggify.details.DetailsScreen
import com.cmota.doggify.model.DoggoItem
import com.cmota.doggify.theme.DoggifyTheme
import com.cmota.doggify.utils.ARG_EXTRA_DOG
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DoggifyTheme(
                window = window,
                content = {
                    ProvideWindowInsets {
                        val doggo = intent.extras!!.get(ARG_EXTRA_DOG) as DoggoItem

                        DetailsScreen(
                            doggo = doggo,
                            onBack = { finish() },
                            onClick = { onClickAction() }
                        )
                    }
                }
            )
        }
    }

    private fun onClickAction() {
        val intent = Intent(Intent.ACTION_DIAL)
        startActivity(intent)
    }
}