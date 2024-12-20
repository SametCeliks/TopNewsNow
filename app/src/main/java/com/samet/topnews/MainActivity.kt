package com.samet.topnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.samet.topnews.ui.theme.TopNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        setContent {

            val navController = rememberNavController()


            TopNewsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    ) {
                        Text(text = "TOP NEWS NOW",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            color = Color.Red,
                            fontSize = 26.sp,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif

                        )
                        NavHost(navController= navController, startDestination = HomePageScreen){
                            composable<HomePageScreen> {
                                HomePage(newsViewModel,navController)
                            }
                            composable<NewsArticleScreen> {

                                val args = it.toRoute<NewsArticleScreen>()
                                NewsArticalPage(args.url)

                            }
                        }
                    }




                }
            }
        }
    }
}
