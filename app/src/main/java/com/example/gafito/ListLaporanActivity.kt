package com.example.gafito

import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.gafito.ui.theme.GafitoTheme

class ListLaporanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GafitoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReportView()
                }
            }
        }
    }
}

@Composable
fun ReportView(
    modifier: Modifier = Modifier,
    daftar: List<String> = List(15){ "Lorem Ipsum" }
) {
    val mContext = LocalContext.current
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = daftar) { name ->
            ListReport(name = name)

        }
    }


//    Column(
//        modifier
//    ) {
//        Button(
//            onClick = {
//                val pindah = Intent(mContext,LaporKehilanganActivity::class.java)
//                mContext.startActivity(pindah)
//                      },
//            modifier = Modifier.padding(start = 8.dp)
//        ) {
//            Text(text = "Add New Report")
//        }
//        for (data in daftar){
//            ListReport(name = data)
//        }
//
//    }
}

@Composable
fun ListReport(name: String, modifier: Modifier = Modifier) {
    val expanded = rememberSaveable { mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier =  Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(
                    text = "Laporan Kehilangan,",
                    modifier = modifier
                )
                Text(
                    text = "$name",
                    modifier = modifier
                )
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value)  "Show Less" else "Show Details")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview45() {
    GafitoTheme {
        ReportView()
    }
}