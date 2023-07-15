package id.android.basics.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.SelfImprovement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import id.android.basics.compose.theme.ComposerTheme

/**
 * Contains individual Wear OS demo composables for the code lab
 * Function only used as a demo for when you start the code lab (removed as step 1)
 */
@Composable
fun StartOnlyTextComposables() {
  Text(
    modifier = Modifier.fillMaxSize(),
    textAlign = TextAlign.Center,
    color = MaterialTheme.colors.primary,
    text = stringResource(R.string.hello_world_starter)
  )
}

@Composable
fun ButtonExample(
  modifier: Modifier = Modifier,
  iconModifier: Modifier = Modifier) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center) {
    Button(
      modifier = Modifier.size(ButtonDefaults.LargeButtonSize),
      onClick = { /* no content */ }) {
      Icon(
        imageVector = Icons.Rounded.Phone,
        contentDescription = "Triggers phone action",
        modifier = iconModifier
      )
    }
  }
}

@Composable
fun TextExample(modifier: Modifier = Modifier) {
  Text(
    modifier = modifier,
    textAlign = TextAlign.Center,
    color = MaterialTheme.colors.primary,
    text = stringResource(id = R.string.device_shape)
  )
}

@Composable
fun CardExample(
  modifier: Modifier = Modifier,
  iconModifier: Modifier = Modifier) {
  AppCard(
    modifier = modifier,
    appImage = {
      Icon(
        imageVector = Icons.Rounded.Message,
        contentDescription = "Triggers open message action",
        modifier = iconModifier
      )
    },
    appName = { Text(text = "Messages") },
    time = { Text(text = "12m") },
    title = { Text(text = "Kim Green") },
    onClick = { /* no content */ }) {
    Text(text = "On my way!")
  }
}

@Composable
fun ChipExample(
  modifier: Modifier = Modifier,
  iconModifier: Modifier = Modifier) {
  Chip(
    modifier = modifier,
    onClick = { /* no content */ },
    label = {
      Text(
        text = "5 minute Meditation",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    },
    icon = {
      Icon(
        imageVector = Icons.Rounded.SelfImprovement,
        contentDescription = "Triggers meditation action",
        modifier = iconModifier
      )
    }
  )
}

@Composable
fun ToggleChipExample(modifier: Modifier = Modifier) {
  var checked by remember { mutableStateOf(true) }
  ToggleChip(
    modifier = modifier,
    checked = checked,
    toggleControl = {
      Switch(
        checked = checked,
        modifier = Modifier.semantics {
          this.contentDescription = if (checked) "On" else "Off"
        }
      )
    },
    onCheckedChange = { checked = it },
    label = {
      Text(
        text = "Sound",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  )
}

/**
 * Previews of Composables
 * Hello, world starter text preview
 */
@Preview(
  group = "Starter",
  widthDp = WEAR_PREVIEW_ELEMENT_WIDTH_DP,
  heightDp = WEAR_PREVIEW_ELEMENT_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun StartOnlyTextComposablesPreview() {
  ComposerTheme {
    StartOnlyTextComposables()
  }
}

/**
 * Button Preview
 */
@Preview(
  group = "Button",
  widthDp = WEAR_PREVIEW_ELEMENT_WIDTH_DP,
  heightDp = WEAR_PREVIEW_ELEMENT_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun ButtonExamplePreview() {
  ComposerTheme {
    ButtonExample(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
      iconModifier = Modifier
        .size(24.dp)
        .wrapContentSize(align = Alignment.Center)
    )
  }
}

/**
 * Text Preview
 */
@Preview(
  group = "Text",
  widthDp = WEAR_PREVIEW_ROW_WIDTH_DP,
  heightDp = WEAR_PREVIEW_ROW_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun TextExamplePreview() {
  ComposerTheme {
    TextExample(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
  }
}

/**
 * Card Preview
 */
@Preview(
  group = "Card",
  widthDp = WEAR_PREVIEW_ROW_WIDTH_DP,
  heightDp = WEAR_PREVIEW_ROW_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun CardExamplePreview() {
  ComposerTheme {
    CardExample(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
      iconModifier = Modifier
        .size(24.dp)
        .wrapContentSize(align = Alignment.Center)
    )
  }
}

/**
 * Chip Preview
 */
@Preview(
  group = "Chip",
  widthDp = WEAR_PREVIEW_ROW_WIDTH_DP,
  heightDp = WEAR_PREVIEW_ROW_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun ChipExamplePreview() {
  ComposerTheme {
    ChipExample(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
      iconModifier = Modifier
        .size(24.dp)
        .wrapContentSize(align = Alignment.Center)
    )
  }
}

/**
 * Toggle Chip Preview
 */
@Preview(
  group = "Toggle Chip",
  widthDp = WEAR_PREVIEW_ROW_WIDTH_DP,
  heightDp = WEAR_PREVIEW_ROW_HEIGHT_DP,
  apiLevel = WEAR_PREVIEW_API_LEVEL,
  uiMode = WEAR_PREVIEW_UI_MODE,
  backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
  showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun ToggleChipExamplePreview() {
  ComposerTheme {
    ToggleChipExample(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
  }
}