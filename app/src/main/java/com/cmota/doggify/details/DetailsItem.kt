package com.cmota.doggify.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cmota.doggify.R
import com.cmota.doggify.components.Pager
import com.cmota.doggify.components.PagerState
import com.cmota.doggify.model.DoggoItem
import com.cmota.doggify.theme.*
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailsItem(doggo: DoggoItem) {

    LazyColumn(
        content = {
            item {

                val pagerState = remember { PagerState() }
                pagerState.maxPage = (doggo.images.size - 1).coerceAtLeast(0)

                Surface {
                    Pager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.0f)

                    ) {

                        val image = doggo.images[page]

                        Surface {

                            CoilImage(
                                data = image,
                                fadeIn = true,
                                contentScale = ContentScale.Crop,
                                contentDescription = stringResource(id = R.string.description_dog_image),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.0f)
                            )
                        }
                    }

                    if (pagerState.maxPage > 1) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.0f)
                                .padding(bottom = 16.dp),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Spacer(modifier = Modifier.width(8.dp))

                            for (index in 0..pagerState.maxPage) {

                                val color = if (pagerState.currentPage == index) {
                                    colorSecondary
                                } else {
                                    colorSecondaryTransparency
                                }

                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .clip(CircleShape)
                                        .background(color)
                                )

                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center) {

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = doggo.name,
                                style = typography.h1
                            )

                            Text(
                                text = doggo.breed,
                                style = typography.subtitle2
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.Center) {

                            val isFavorite = remember { mutableStateOf(false) }

                            val favorite = if(isFavorite.value) {
                                painterResource(R.drawable.ic_favorite)
                            } else {
                                painterResource(R.drawable.ic_favorite_outline)
                            }

                            val background = if(isFavorite.value) {
                                colorFavorite
                            } else {
                                Color.Transparent
                            }

                            val favoriteDescription = stringResource(id = R.string.description_favorite)

                            OutlinedButton(
                                onClick = {
                                          isFavorite.value = !isFavorite.value
                                },
                                border = BorderStroke(2.dp, colorFavorite),
                                colors = ButtonDefaults.buttonColors(backgroundColor = background),
                                shape = CircleShape,
                                modifier = Modifier.size(50.dp),
                                contentPadding = PaddingValues(0.dp)
                            ){
                                Image(
                                    painter = favorite,
                                    contentDescription = favoriteDescription,
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Row(modifier = Modifier.weight(1f)) {
                            AddDogInformation(
                                doggo.about.sex,
                                stringResource(id = R.string.details_sex))
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Row(modifier = Modifier.weight(1f)) {
                            AddDogInformation(
                                doggo.about.age,
                                stringResource(id = R.string.details_age))
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Row(modifier = Modifier.weight(1f)) {
                            AddDogInformation(
                                doggo.about.color,
                                stringResource(id = R.string.details_color))
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    AddDogAdditionalInformation(
                        stringResource(id = R.string.details_personality),
                        doggo.details.personality)
                    Spacer(modifier = Modifier.height(8.dp))

                    AddDogAdditionalInformation(
                        stringResource(id = R.string.details_size),
                        doggo.details.size)
                    Spacer(modifier = Modifier.height(8.dp))

                    AddDogAdditionalInformation(
                        stringResource(id = R.string.details_children),
                        doggo.details.childrens)
                    Spacer(modifier = Modifier.height(8.dp))

                    AddDogAdditionalInformation(
                        stringResource(id = R.string.details_life),
                        doggo.details.life)
                    Spacer(modifier = Modifier.height(8.dp))

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = doggo.description,
                        style = typography.subtitle2
                    )
                }
            }
        })
}

@Composable
fun AddDogInformation(title: String, subtitle: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        backgroundColor = colorSurface,
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = typography.body1
            )

            Text(
                text = subtitle,
                style = typography.subtitle2
            )
        }
    }
}

@Composable
fun AddDogAdditionalInformation(title: String, subtitle: String) {
    Row {

        Row(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = typography.subtitle2
            )
        }

        Row(modifier = Modifier.weight(2f)) {
            Text(
                text = subtitle,
                style = typography.subtitle1
            )
        }
    }
}

@Composable
fun AddContactAction(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier.height(48.dp),
        content = {

            Row (
                modifier = Modifier.padding(start = 32.dp, end = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                val icon = painterResource(R.drawable.ic_chat)
                val description = stringResource(id = R.string.description_chat)

                Icon(
                    painter = icon,
                    contentDescription = description
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = stringResource(id = R.string.action_contact),
                    style = typography.body2
                )
            }
        }
    )
}