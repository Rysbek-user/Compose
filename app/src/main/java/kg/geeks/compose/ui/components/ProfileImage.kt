package kg.geeks.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ProfileImage(image: Painter) {
    Column {
        Spacer(modifier = Modifier.size(40.dp))
        Image(
            painter = image,
            contentDescription = "Фото профиля",
            modifier = Modifier
                .size(120.dp)
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )
    }
}