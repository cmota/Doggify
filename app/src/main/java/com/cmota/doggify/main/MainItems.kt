package com.cmota.doggify.main

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cmota.doggify.MainViewModel
import com.cmota.doggify.R
import com.cmota.doggify.components.StaggeredVerticalGrid
import com.cmota.doggify.model.Doggo
import com.cmota.doggify.model.DoggoItem
import com.cmota.doggify.theme.colorAccentSecondary
import com.cmota.doggify.theme.colorBorder
import com.cmota.doggify.theme.colorButton
import com.cmota.doggify.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

@ExperimentalFoundationApi
@Composable
fun MainScreenItems(viewModel: MainViewModel, openDetails: (doggo: DoggoItem) -> Unit) {

    val doggos = viewModel.doggos.observeAsState(Doggo())

    Column {

        val all = stringResource(id = R.string.filter_all)
        val (selected, onBreedChanged) = remember { mutableStateOf(all) }

        LazyColumn(
            content = {

                item {
                    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = stringResource(id = R.string.tagline_find_your),
                            style = typography.h1
                        )

                        Text(
                            text = stringResource(id = R.string.tagline_best_friend),
                            style = typography.h2
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                item {

                    LazyRow(
                        modifier = Modifier.padding(start = 16.dp),
                        content = {

                            item {
                                AddBreed(all, selected, onBreedChanged)
                                Spacer(modifier = Modifier.height(32.dp))
                            }

                            items(doggos.value) {
                                AddBreed(it.breed, selected, onBreedChanged)
                            }
                        })
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))

                    val filteredDoggos = if(selected == all) {
                        doggos.value
                    } else {
                        doggos.value.filter { it.breed == selected }
                    }

                    StaggeredVerticalGrid(
                        modifier = Modifier.padding(8.dp),
                        columns = 2) {
                        filteredDoggos.forEach {
                            DogPreview(it, openDetails)
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun AddBreed(breed: String, selected: String, onBreedChanged: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {

        val borderColor = if (breed == selected) {
            colorBorder
        } else {
            colorAccentSecondary
        }

        Card(
            modifier = Modifier
                .defaultMinSize(minWidth = 100.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, borderColor, RoundedCornerShape(10.dp))
                .clickable { onBreedChanged(breed) },
            backgroundColor = colorButton

        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {

                Text(
                    text = breed.capitalize(Locale.getDefault()),
                    style = typography.body2,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun DogPreview(doggo: DoggoItem, openDetails: (doggo: DoggoItem) -> Unit) {
    Log.d("MainScreenItems", "Dog: $doggo")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable { openDetails(doggo) },
        shape = RoundedCornerShape(30.dp)
    ) {
        CoilImage(
            data = doggo.featuredImg,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.description_dog_image)
        )
    }
}