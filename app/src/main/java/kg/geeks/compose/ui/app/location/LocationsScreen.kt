package kg.geeks.compose.ui.app.location

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kg.geeks.compose.ui.data.dto.LocationsResponse
import org.koin.core.component.getScopeId

@Composable
fun LocationsScreen(navController: NavController) {
    val locations = listOf<LocationsResponse>(

    )

    LazyColumn {
        items(locations) { location ->
            Text(
                text = location.name,
                modifier = Modifier.clickable {
                    navController.navigate("location_detail/${location.getScopeId()}")
                }
            )
        }
    }
}