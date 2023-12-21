package com.practicum.newsappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.practicum.newsappcompose.domain.usecase.AppEntryUseCases
import com.practicum.newsappcompose.presentation.onboarding.OnBoardingScreen
import com.practicum.newsappcompose.presentation.onboarding.OnBoardingViewModel
import com.practicum.newsappcompose.ui.theme.NewsAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject

    lateinit var useCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )
        installSplashScreen()

        lifecycleScope.launch {
            useCases.readAppEntry().collect {
                Log.d("TAG", it.toString())
            }
        }

        setContent {
            NewsAppComposeTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = {
                            viewModel.onEvent(it)
                        }
                    )
                }
            }
        }
    }
}
