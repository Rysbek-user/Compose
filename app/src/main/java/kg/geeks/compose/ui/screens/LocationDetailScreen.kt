package kg.geeks.compose.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LocationDetailScreen(locationId: Int) {
    Text(text = "Location Details for Location #$locationId")
}