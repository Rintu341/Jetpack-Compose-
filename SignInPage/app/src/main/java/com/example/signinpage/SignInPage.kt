package com.example.signinpage

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.IconButton as IconButton1
import androidx.compose.material3.IconButton as IconButton2
import androidx.compose.material3.Text as Text1
import androidx.compose.material3.Text as Text2

@Composable
fun SignInPage() {
    var text by remember {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        //UnderlinedText("This text is underlined")
        Text1(
            text = "Sign In",
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(16.dp)
                .weight(0.5f),
        )
        Column(
            modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UsernameEmailInputField(text = text, onTextChange = { text = it })

            Spacer(modifier = Modifier.height(50.dp))

            PasswordInputField(password = password, onPasswordChange = { password = it })
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text1("SignUp", fontSize = MaterialTheme.typography.titleLarge.fontSize)
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text1("SignIn", fontSize = MaterialTheme.typography.titleLarge.fontSize)
                }
            }

        }
    }

}

@Composable
fun UsernameEmailInputField(text: String, onTextChange: (String) -> Unit) {
    TextField(value = text, onValueChange = onTextChange, label = {
        Text2("Username/Email")
    }, leadingIcon = {
        IconButton2(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Person, contentDescription = "username/email")
        }
    }, singleLine = true, keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
    ), keyboardActions = KeyboardActions(onNext = {
        Log.d("Next", "Clicked")
    }), shape = RoundedCornerShape(12.dp)
    )
}

/*
To add visibility to a password input field in Jetpack Compose,
you can use the TextField composable. You can use the visualTransformation
 parameter to toggle between the password being visible or hidden
 */
@Composable
fun PasswordInputField(password: String, onPasswordChange: (String) -> Unit) {
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        label = {
            Text1("Password")
        },
        leadingIcon = {
            IconButton1(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "lock")
            }
        },
        trailingIcon = {
            IconButton1(onClick = { /*TODO*/ }) {
                val image =
                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton1(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Password visibility toggle")
                }
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            Log.d("Done", "CLicked")
        }),
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Preview(showBackground = true)
@Composable
fun SignInPagePreview() {
    SignInPage()
}