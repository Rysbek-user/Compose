package kg.geeks.compose.ui.activity

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Main() {
    MaterialTheme {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Main()
}