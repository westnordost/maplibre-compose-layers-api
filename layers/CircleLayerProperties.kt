package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/** A filled circle. */
@Immutable
data class CircleLayerProperties(
    val color: PropertyValue<Color> = Const(Color.Black),
    val radius: PropertyValue<Dp> = Const(5.dp),
    val opacity: PropertyValue<Float> = Const(1f),
    val strokeWidth: PropertyValue<Dp> = Const(0.dp),
    val strokeColor: PropertyValue<Color> = Const(Color.Black),
    val strokeOpacity: PropertyValue<Float> = Const(1f),
    val blur: PropertyValue<Dp> = Const(0.dp),
    val pitchScale: CirclePitchScale = CirclePitchScale.Map,
    val pitchAlignment: CirclePitchAlignment = CirclePitchAlignment.Viewport,
    val translate: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val translateAnchor: TranslateAnchor = TranslateAnchor.Map,
    val sortKey: Float? = null,
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties

/** Scaling behavior of circles when the map is pitched. */
@Immutable
enum class CirclePitchScale {
    /** Circles are scaled according to their apparent distance to the camera, i.e. as if they are
     *  on the map. */
    Map,

    /** Circles are not scaled, i.e. as if glued to the viewport. */
    Viewport
}

/** Orientation of circles when the map is pitched. */
@Immutable
enum class CirclePitchAlignment {
    /** Circles are aligned to the plane of the map, i.e. flat on top of the map. */
    Map,

    /** Circles are aligned to the plane of the viewport, i.e. facing the camera. */
    Viewport
}
