package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** A heatmap. */
@Immutable
data class HeatmapLayerProperties(
    val color: PropertyValue<Color> = Const(Color.Red), // TODO actually defaults to interpolate,linear,heatmap-density,0,rgba(0, 0, 255, 0),0.1,royalblue,0.3,cyan,0.5,lime,0.7,yellow,1,red
    val radius: PropertyValue<Dp> = Const(30.dp),
    val weight: PropertyValue<Float> = Const(1f),
    val intensity: PropertyValue<Float> = Const(1f),
    val opacity: PropertyValue<Float> = Const(1f),
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties
