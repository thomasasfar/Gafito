@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.gafito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gafito.ui.theme.GafitoTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GafitoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Register()
                }
            }
        }
    }
}

@Composable
fun Register() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("")}
    var conf_pass by remember { mutableStateOf("")}
    var nim by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 48.dp, end = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo_only),
            contentDescription = null,
            modifier = Modifier
                .size(width = 160.dp, height = 160.dp)
        )
        Text(
            text = stringResource(R.string.login),
            modifier = Modifier,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(top = 48.dp)
        ) {
            FormRegister(
                label = R.string.fullname,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = fullname,
                onValueChange = { fullname = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
            FormRegister(
                label = R.string.nim,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = nim,
                onValueChange = { nim = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
            FormRegister(
                label = R.string.username,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
            FormRegister(
                label = R.string.password,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
            FormRegister(
                label = R.string.conf_pass,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = conf_pass,
                onValueChange = { conf_pass = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        ButtonLogin(
            onClick = { /*TODO*/ },
            text = "Login"
        )
        Text(
            text = stringResource(R.string.or),
            modifier = Modifier.padding(4.dp)
        )
        ClickableText(
            text = AnnotatedString(stringResource(R.string.login_here)),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Color.Blue
            )
        )
    }
}

@Composable
private fun FormRegister(
    @StringRes label: Int,
//    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(bottom = 16.dp),
) {
    TextField(
        value = value,
//        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = stringResource(label))},
        modifier = Modifier,
        keyboardOptions = keyboardOptions,
    )
}

@Composable
private fun ButtonLogin(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier.padding(top = 32.dp)
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(200.dp),
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegister() {
    GafitoTheme {
        Register()
    }
}