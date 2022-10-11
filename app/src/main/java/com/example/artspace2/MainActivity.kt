package com.example.artspace2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace2.ui.theme.ArtSpace2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpace2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentStep by remember { mutableStateOf(1) }

    when (currentStep) {
        1 -> {
            // Display Twilight
            ArtSpaceScreen(
                titleResourceId = stringResource(R.string.magical_time),
                drawableResourceId = R.drawable.twilight,
                albumTitleResourceId = stringResource(R.string.nature),
                onNextImageClick = { currentStep = 2 },
                onPreviousImageClick = { currentStep = 5 },
                contentDescriptionResourceId = stringResource(R.string.twilight)
            )

        }
        2 -> {
            // Display Flowers
            ArtSpaceScreen(
                titleResourceId = stringResource(R.string.peace),
                drawableResourceId = R.drawable.flowers,
                albumTitleResourceId = stringResource(R.string.nature),
                onNextImageClick = { currentStep = 3 },
                onPreviousImageClick = { currentStep = 1 },
                contentDescriptionResourceId = "Flowers"
            )

        }
        3 -> {
            // Display Trees
            ArtSpaceScreen(
                titleResourceId = stringResource(R.string.majestic),
                drawableResourceId = R.drawable.trees,
                albumTitleResourceId = stringResource(R.string.nature),
                onNextImageClick = { currentStep = 4 },
                onPreviousImageClick = { currentStep = 2 },
                contentDescriptionResourceId = stringResource(R.string.trees)
            )

        }
        4 -> {
            // Display Green Garden
            ArtSpaceScreen(
                titleResourceId = stringResource(R.string.infinite_green),
                drawableResourceId = R.drawable.green_garden,
                albumTitleResourceId = stringResource(R.string.nature),
                onNextImageClick = { currentStep = 5 },
                onPreviousImageClick = { currentStep = 3 },
                contentDescriptionResourceId = stringResource(R.string.green_garden)
            )

        }
        5 -> {
            // Display Field
            ArtSpaceScreen(
                titleResourceId = stringResource(R.string.just_beautiful),
                drawableResourceId = R.drawable.field,
                albumTitleResourceId = stringResource(R.string.nature),
                onNextImageClick = { currentStep = 6 },
                onPreviousImageClick = { currentStep = 4 },
                contentDescriptionResourceId = stringResource(R.string.field)
            )

        }
        6 -> {
            // Display Field
            ArtSpaceScreen(
                titleResourceId = stringResource(R.string.beautiful_ending),
                drawableResourceId = R.drawable.sunset,
                albumTitleResourceId = stringResource(R.string.nature),
                onNextImageClick = { currentStep = 1 },
                onPreviousImageClick = { currentStep = 5 },
                contentDescriptionResourceId = stringResource(R.string.sunset)
            )

        }


    }
}
//}

@Composable
fun ArtSpaceScreen(
    titleResourceId: String,
    drawableResourceId: Int,
    albumTitleResourceId: String,
    onNextImageClick: () -> Unit,
    onPreviousImageClick: () -> Unit,
    // onMoreOptionsClick: () -> Unit,
    contentDescriptionResourceId: String

) {
    val fontFamily = FontFamily(
        Font(R.font.lexend_light, FontWeight.Thin)
    )
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFf7f7f7))
    ) {
        //for more options
        /*  Box(
              modifier = Modifier
                  .fillMaxSize()
                  .weight(3f)
          ) {
              Image(
                  painter = painterResource(R.drawable.more_icon),
                  contentDescription = stringResource(R.string.more_options),
                  modifier = Modifier.padding(top = 30.dp, start = 10.dp),
                     /* .clickable (
                          onClick = onMoreOptionsClick
                              ),*/
                  alignment = Alignment.Center

              )*/
        // for text
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .weight(3f),
            elevation = 10.dp,


            ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = titleResourceId,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = "Darshana Das K",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,

                    )
                Text(
                    text = "Album Title: $albumTitleResourceId",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,

                    )
            }


        }
        //  }
        // for image
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = contentDescriptionResourceId,
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        BorderStroke(3.dp, Color.Gray),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(10.dp)
            )
        }
        // for next and previous buttons
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(bottom = 30.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.previous_icon),
                contentDescription = stringResource(R.string.previous_icon),
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        onClick = onPreviousImageClick
                    )
            )
            Image(
                painter = painterResource(R.drawable.next_icon2),
                contentDescription = stringResource(R.string.next_icon),
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        onClick = onNextImageClick
                    )


            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpace2Theme {
        ArtSpaceApp()
    }
}