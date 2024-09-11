package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable

/** Raster map textures such as satellite imagery. */
@Immutable
data class RasterLayerProperties(
    val opacity: PropertyValue<Float> = Const(1f),
    val hueRotate: PropertyValue<Float> = Const(0f),
    val brightnessMin: PropertyValue<Float> = Const(0f),
    val brightnessMax: PropertyValue<Float> = Const(1f),
    val saturation: PropertyValue<Float> = Const(0f),
    val contrast: PropertyValue<Float> = Const(0f),
    val resampling: RasterResampling = RasterResampling.Linear,
    val fadeDuration: PropertyValue<Int> = Const(300),
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties

/** The resampling/interpolation method to use for overscaling, also known as texture magnification
 *  filter */
@Immutable
enum class RasterResampling {
    /** (Bi)linear filtering interpolates pixel values using the weighted average of the four
     *  closest original source pixels creating a smooth but blurry look when overscaled */
    Linear,

    /** Nearest neighbor filtering interpolates pixel values using the nearest original source pixel
     *  creating a sharp but pixelated look when overscaled */
    Nearest,
}
