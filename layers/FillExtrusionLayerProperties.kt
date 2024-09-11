package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset

/** An extruded (3D) polygon. */
@Immutable
data class FillExtrusionLayerProperties(
    // TODO pattern
    val color: PropertyValue<Color> = Const(Color.Black),
    val opacity: PropertyValue<Float> = Const(1f),
    val height: PropertyValue<Float> = Const(0f),
    val base: PropertyValue<Float> = Const(0f),
    val verticalGradient: Boolean = true,
    val translate: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val translateAnchor: TranslateAnchor = TranslateAnchor.Map,
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties
