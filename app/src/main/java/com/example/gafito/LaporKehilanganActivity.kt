@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.gafito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gafito.ui.theme.GafitoTheme

class LaporKehilanganActivity : ComponentActivity() {
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
fun ReportView() {
    var KPInput by remember { mutableStateOf("") }
    var nopolInput by remember { mutableStateOf("") }
    var KDInput by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(40.dp)
    ) {
        Text(
            text = "Nomor Polisi",
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            FormNomPol(
                label = R.string.nopol1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = KPInput,
                onValueChange = { KPInput = it },
                modifier = Modifier
                    .padding(2.dp)
                    .width(80.dp)
                //                .fillMaxWidth()
            )
            FormNomPol(
                label = R.string.nopol2,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = nopolInput,
                onValueChange = { nopolInput = it },
                modifier = Modifier
                    .padding(4.dp)
                    .width(160.dp)
                //                .fillMaxWidth()
            )
            FormNomPol(
                label = R.string.nopol3,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = KDInput,
                onValueChange = { KDInput = it },
                modifier = Modifier
                    .padding(2.dp)
                    .width(80.dp)
                //                .fillMaxWidth()
            )
        }
        Text(
            text = "Informasi Kendaraan",
            modifier = Modifier
                .padding(top = 32.dp, bottom = 8.dp)
        )
        FormNomPol(
            label = R.string.merek_kendaraan,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = "Vario 1000cc",
            onValueChange = {"no"},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        FormNomPol(
            label = R.string.warna_kendaraan,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = "Maroon Metalic",
            onValueChange = {"no"},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        FormNomPol(
            label = R.string.tanggal_report,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = "26/10/2023, 01.10 AM",
            onValueChange = {"no"},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}


@Composable
fun FormNomPol(
    @StringRes label: Int,
//    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
//        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = stringResource(label))},
        modifier = modifier,
        keyboardOptions = keyboardOptions
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    GafitoTheme {
        ReportView()
    }
}