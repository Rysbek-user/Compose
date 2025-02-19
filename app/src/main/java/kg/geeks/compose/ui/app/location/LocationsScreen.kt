package kg.geeks.compose.ui.app.location

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kg.geeks.compose.ui.viewModule.LocationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LocationsScreen(navController: NavController) {
    val viewModel: LocationViewModel = koinViewModel()
    val locations = viewModel.locations.collectAsState().value

    LazyColumn {
        if (locations.isEmpty()) {
            item { Text(text = "Загрузка...") }
        } else {
            items(locations) { location ->
                Text(
                    text = location.name,
                    modifier = Modifier.clickable {
                        navController.navigate("location_detail/${location.id}")
                    }
                )
            }
        }
    }
}