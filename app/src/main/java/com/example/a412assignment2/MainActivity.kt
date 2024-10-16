package com.example.a412assignment2


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a412assignment2.ui.theme._412Assignment2Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        setContent {
            _412Assignment2Theme {
                ScaffoldMainActivity()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldMainActivity() {
    var presses by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {

                    Text(
                        textAlign = TextAlign.Center,
                        text ="Main Activity",

                    )
                },
//                navigationIcon = {
//                    IconButton(onClick = { val intent = Intent(context, MainActivity::class.java)
//                        context.startActivity(intent) }) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Localized description"
//                        )
//                    }
//                },

                )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "",
                )
            }
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Colin Campbell \nStudent ID: 1402334",
                    fontSize = 50.sp,
                    lineHeight = 116.sp,
                    textAlign = TextAlign.Center,

                )
                Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
                {
                    ExplicitButtonExample()
                    Text(
                        text = "     ",
                        lineHeight = 116.sp,
                        textAlign = TextAlign.Center,

                    )
                    ImplicitButtonExample()

                }
                Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
                {
                    CameraButton()
                }



            }
        }
    }
}




@Composable
fun ImplicitButtonExample(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick =  {val intent = Intent("com.example.ACTION_OPEN_SECOND_ACTIVITY")
            context.startActivity(intent)}) {
            Text("Implicit Button")

        }
    }
}

@Composable
fun ExplicitButtonExample(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick =  {
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)

        }) {
            Text("Explicit Button")

        }
    }
}


@Composable
fun CameraButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick =  {
            val intent = Intent(context, CameraActivity::class.java)
            context.startActivity(intent)

        }) {
            Text("Camera Button")

        }
    }
}


