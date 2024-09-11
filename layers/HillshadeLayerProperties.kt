package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/** Client-side hillshading visualization based on DEM data. The implementation supports Mapbox
 *  Terrain RGB, Mapzen Terrarium tiles and custom encodings. */
@Immutable
data class HillshadeLayerProperties(
    val illuminationDirection: PropertyValue<Float> = Const(335f),
    val illuminationAnchor: IlluminationAnchor = IlluminationAnchor.Viewport,
    val exaggeration: PropertyValue<Float> = Const(0.5f),
    val shadowColor: PropertyValue<Color> = Const(Color.Black),
    val highlightColor: PropertyValue<Color> = Const(Color.White),
    val accentColor: PropertyValue<Color> = Const(Color.Black),
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties

/** Direction of light source when map is rotated. */
@Immutable
enum class IlluminationAnchor {
    /** The hillshade illumination is relative to the north direction. */
    Map,
    /** The hillshade illumination is relative to the top of the viewport. */
    Viewport,
}
