package com.example.gafito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gafito.ui.theme.GafitoTheme

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GafitoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Info(infoItems = generateInfoItems()) // Ganti ini dengan daftar InfoItem yang sesuai
                }
            }
        }
    }
}

data class InfoItem(val id: Int, val imageResId: Int, val title: String, val description: String, val time: String)

@Composable
fun Info(infoItems: List<InfoItem>) {

    LazyColumn {
        items(infoItems) { item ->
            InfoItemCard(infoItem = item)
        }
    }
}

@Composable
fun InfoItemCard(infoItem: InfoItem) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = infoItem.imageResId),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = infoItem.title)
                Text(text = infoItem.description)
            }
        }
        Text(
            text = infoItem.time,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(Color.White)
                .padding(4.dp)
        )
        ClickableText(
            text = AnnotatedString("View Details"),
            onClick = { offset ->
                // Handle klik di sini
                if (offset == 0) {
                    // Lakukan sesuatu ketika "View Details" diklik
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopEnd)
        )
    }
}

// Fungsi untuk pembuatan daftar InfoItem
fun generateInfoItems(): List<InfoItem> {
    return listOf(
        InfoItem(1, R.drawable.vario, "BA 444 YO", "Vario 1000", "11.20"),
        InfoItem(2, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(3, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(4, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(5, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(6, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(7, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(8, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        InfoItem(9, R.drawable.vario, "BA 123 AB", "Vario 2000", "12.30"),
        // Tambahkan InfoItem lainnya sesuai kebutuhan
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    GafitoTheme {
        Info(infoItems = generateInfoItems()) // Ganti ini dengan daftar InfoItem yang sesuai
    }
}
