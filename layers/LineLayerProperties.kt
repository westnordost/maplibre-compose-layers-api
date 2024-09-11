package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/** A stroked line. */
@Immutable
data class LineLayerProperties(
    val color: PropertyValue<Color> = Const(Color.Black),
    val width: PropertyValue<Dp> = Const(1.dp),
    val cap: StrokeCap = StrokeCap.Butt,
    val join: StrokeJoin = StrokeJoin.Default,
    val opacity: PropertyValue<Float> = Const(1f),
    val gapWidth: PropertyValue<Dp> = Const(0.dp),
    val offset: PropertyValue<Dp> = Const(0.dp),
    val blur: PropertyValue<Dp> = Const(0.dp),
    val translate: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val translateAnchor: TranslateAnchor = TranslateAnchor.Map,
    val sortKey: Float? = null,
    val visibility: Visibility = Visibility.Visible,
    // TODO dasharray + pattern + gradient
) : LayerProperties

/** Display of lines when joining */
sealed interface StrokeJoin {
    /** A join with a squared-off end which is drawn beyond the endpoint of the line at a distance
     *  of one-half of the line's width. */
    @Immutable
    data object Bevel : StrokeJoin

    /** A join with a rounded end which is drawn beyond the endpoint of the line at a radius of
     *  one-half of the line's width and centered on the endpoint of the line.
     *  Limit is used to automatically convert to miter join for shallow angles. */
    @Immutable
    data class Round(val limit: PropertyValue<Float> = Const(1.05f)) : StrokeJoin

    /** A join with a sharp, angled corner which is drawn with the outer sides beyond the endpoint
     *  of the path until they meet.
     *  Limit is used to automatically convert to bevel join for sharp angles.*/
    @Immutable
    data class Miter(val limit: PropertyValue<Float> = Const(2.0f)) : StrokeJoin

    companion object {
        val Default = Miter()
    }
}

/** Display of line endings */
@Immutable
enum class StrokeCap {
    /** A cap with a squared-off end which is drawn to the exact endpoint of the line. */
    Butt,

    /** A cap with a rounded end which is drawn beyond the endpoint of the line at a radius of
     * one-half of the line's width and centered on the endpoint of the line. */
    Round,

    /** A cap with a squared-off end which is drawn beyond the endpoint of the line at a distance of
     * one-half of the line's width. */
    Square
}

