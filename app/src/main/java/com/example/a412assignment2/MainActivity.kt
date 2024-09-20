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
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _412Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Colin Campbell",
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            // Handle the button click action here
                        }
                    )

                }
            }
        }
    }
}

@Composable
fun ButtonForApp(onClick: () -> Unit){

}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(modifier = modifier.padding(8.dp), verticalArrangement = Arrangement.Center) {

        Text(
            text = "$name \nStudent ID: 1402334",
            fontSize = 50.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
        {
            ExplicitButtonExample()
            Text(
                text = "     ",
                lineHeight = 116.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            ImplicitButtonExample()
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


