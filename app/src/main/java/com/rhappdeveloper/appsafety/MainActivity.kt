package com.rhappdeveloper.appsafety

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.rhappdeveloper.appsafety.ui.screen.ThreatListScreen
import com.rhappdeveloper.appsafety.ui.screen.ThreatListViewModel
import com.rhappdeveloper.appsafety.ui.theme.AppSafetyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppSafetyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Log.d("TAG", "ThreatScreen ${it}")
                    val viewModel = hiltViewModel<ThreatListViewModel>()
                    ThreatListScreen(viewModel)
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
    AppSafetyTheme {
        Greeting("Android")
    }
}