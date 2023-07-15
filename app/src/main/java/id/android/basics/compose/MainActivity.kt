package id.android.basics.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import id.android.basics.compose.theme.ComposerTheme

/**
 * This code lab is meant to help existing Compose developers get up to speed quickly on Compose for Wear OS
 * The code lab walks through a majority of the simple composables for Wear OS (both similar to existing mobile composables and new composables)
 * It also covers more advanced composables like [ScalingLazyColumn] (Wear OS's version of [LazyColumn]) and the Wear OS version of [Scaffold]
 */
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      ComposerApp()
    }
  }
}

@Composable
fun ComposerApp() {
  ComposerTheme {
    // TODO: Swap to ScalingLazyListState
    val listState = rememberLazyListState()

    // TODO (Start): Create a Scaffold (Wear Version)
    /**
     * Modifiers used by our Wear composables
     */
    val contentModifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
    val iconModifier = Modifier.size(24.dp).wrapContentSize(align = Alignment.Center)

    // TODO: Create a ScalingLazyColumn (Wear's version of LazyColumn)
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(
        top = 32.dp,
        start = 8.dp,
        end = 8.dp,
        bottom = 32.dp
      ),
      verticalArrangement = Arrangement.Center,
      state = listState) {

      item { ButtonExample(contentModifier, iconModifier) }
      item { TextExample(contentModifier) }
      item { CardExample(contentModifier, iconModifier) }

      item { ChipExample(contentModifier, iconModifier) }
      item { ToggleChipExample(contentModifier) }
    }

    // TODO (End): Create a Scaffold (Wear Version)
  }
}

@Preview(
  widthDp = WEAR_PREVIEW_DEVICE_WIDTH_DP,
  heightDp = WEAR_PREVIEW_DEVICE_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun ComposerAppPreview() {
  ComposerApp()
}