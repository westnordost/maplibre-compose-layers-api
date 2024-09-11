package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset

/** A filled polygon with an optional stroked border. */
@Immutable
data class FillLayerProperties(
    // TODO pattern
    val color: PropertyValue<Color> = Const(Color.Black),
    val opacity: PropertyValue<Float> = Const(1f),
    val outlineColor: PropertyValue<Color> = color,
    val antialias: Boolean = true,
    val translate: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val translateAnchor: TranslateAnchor = TranslateAnchor.Map,
    val sortKey: Float? = null,
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties
