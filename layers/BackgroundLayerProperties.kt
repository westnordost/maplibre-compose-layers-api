package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/** The background color or pattern of the map. */
@Immutable
data class BackgroundLayerProperties(
    // TODO pattern
    val color: PropertyValue<Color> = Const(Color.Black),
    val opacity: PropertyValue<Float> = Const(1f),
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties
