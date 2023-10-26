package com.example.gafito

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gafito.ui.theme.GafitoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    val navigate = Intent(this@MainActivity, DataParkirActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(text = "Data Parkir")
                }
                Button(onClick = {
                    val navigate = Intent(this@MainActivity, LaporKehilanganActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(text = "Report")
                }
                Button(onClick = {
                    val navigate = Intent(this@MainActivity, ShowQRActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(text = "Show QR")
                }
                Button(onClick = {
                    val navigate = Intent(this@MainActivity, ProfilActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(text = "Profil")
                }
                Button(onClick = {
                    val navigate = Intent(this@MainActivity, InfoActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(text = "Info Kehilangan")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GafitoTheme {
        Greeting("Android")
    }
}