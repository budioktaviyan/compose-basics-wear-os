package id.android.basics.compose.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme

@Composable
fun ComposerTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colors = ComposerColorPalette,
    typography = ComposerTypography,
    content = content
  )
}