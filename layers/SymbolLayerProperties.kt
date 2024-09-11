package de.westnordost.maplibre_compose_api.layers

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** An icon or a text label. */
@Immutable
data class SymbolLayerProperties(
    val icon: Icon? = null,
    val text: Text? = null,
    val placement: SymbolPlacement = SymbolPlacement.Point,
    val spacing: PropertyValue<Dp> = Const(250.dp),
    val avoidEdges: Boolean = false,
    val sortKey: Float? = null,
    val zOrder: SymbolSortOrder = SymbolSortOrder.Auto,
    val visibility: Visibility = Visibility.Visible,
) : LayerProperties

@Immutable
data class Icon(
    val image: PropertyValue<String>,
    val rotate: PropertyValue<Float> = Const(0f),
    val padding: Dp = 2.dp,
    val keepUpright: Boolean = false,
    val offset: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val anchor: Anchor = Anchor.Center,
    val pitchAlignment: IconPitchAlignment = IconPitchAlignment.Auto,
    val opacity: PropertyValue<Float> = Const(1f),
    val color: PropertyValue<Color> = Const(Color.Black),
    val haloColor: PropertyValue<Color> = Const(Color.Transparent),
    val haloWidth: PropertyValue<Dp> = Const(0.dp),
    val haloBlur: PropertyValue<Dp> = Const(0.dp),
    val translate: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val translateAnchor: TranslateAnchor = TranslateAnchor.Map,
    val rotationAlignment: IconRotationAlignment = IconRotationAlignment.Auto,
    val scale: PropertyValue<Float> = Const(1f),
    val allowOverlap: Boolean = false,
    val ignorePlacement: Boolean = false,
    val optional: Boolean = false,
    val textFit: IconTextFit = IconTextFit.None,
    val textFitPadding: PaddingValues = PaddingValues(0.dp),
)

@Immutable
data class Text(
    val field: PropertyValue<String>,
    val color: PropertyValue<Color> = Const(Color.Black),
    val opacity: PropertyValue<Float> = Const(1f),
    val haloColor: PropertyValue<Color> = Const(Color.Transparent),
    val haloWidth: PropertyValue<Dp> = Const(0.dp),
    val haloBlur: PropertyValue<Dp> = Const(0.dp),
    val font: List<String> = DefaultFonts,
    val size: PropertyValue<TextUnit> = Const(16.sp),
    val transform: TextTransform = TextTransform.None,
    val letterSpacing: PropertyValue<Float> = Const(0f),
    val translate: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val translateAnchor: TranslateAnchor = TranslateAnchor.Map,
    val rotate: PropertyValue<Float> = Const(0f),
    val padding: PropertyValue<Dp> = Const(0.dp),
    val keepUpright: Boolean = true,
    val maxWidth: PropertyValue<Float> = Const(10f),
    val lineHeight: PropertyValue<Float> = Const(1.2f),
    val justify: TextJustify = TextJustify.Auto,
    val offset: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val radialOffset: PropertyValue<Float> = Const(0f),
    val variableAnchor: PropertyValue<DpOffset> = Const(DpOffset.Zero),
    val textAchor: Anchor = Anchor.Center,
    val maxAngle: PropertyValue<Float> = Const(45f),
    val allowOverlap: Boolean = false,
    val ignorePlacement: Boolean = false,
    val optional: Boolean = false,
) {
    companion object {
        val DefaultFonts = listOf("Open Sans Regular", "Arial Unicode MS Regular")
    }
}

/** Symbol placement relative to its geometry. */
@Immutable
enum class SymbolPlacement {
    /** The label is placed at the point where the geometry is located. */
    Point,

    /** The label is placed along the line of the geometry. Can only be used on LineString and
     *  Polygon geometries. */
    Line,

    /** The label is placed at the center of the line of the geometry. Can only be used on
     *  LineString and Polygon geometries. Note that a single feature in a vector tile may contain
     *  multiple line geometries.
     */
    LineCenter,
}

/** Determines whether overlapping symbols in the same layer are rendered in the order that they
 *  appear in the data source or by their y-position relative to the viewport. To control the order
 *  and prioritization of symbols otherwise, use `sortKey`. */
@Immutable
enum class SymbolSortOrder {
    /** Sorts symbols by `sortKey` if set. Otherwise, sorts symbols by their y-position relative to
     *  the viewport if `Icon::allowOverlap` or `Text::allowOverlap` is set to `true` or
     *  `Icon::ignorePlacement` or `Text::ignorePlacement` is `false`. */
    Auto,

    /** Sorts symbols by their y-position relative to the viewport if `Icon::allowOverlap` or
     *  `Text::allowOverlap` is set to `true` or `Icon::ignorePlacement` or `Text::ignorePlacement`
     *  is `false`. */
    ViewportY,

    /** Sorts symbols by `sortKey` if set. Otherwise, no sorting is applied; symbols are rendered in
     *  the same order as the source data. */
    Source,
}

/** In combination with [SymbolPlacement], determines the rotation behavior of icons. */
@Immutable
enum class IconRotationAlignment {
    /** For [SymbolPlacement.Point], aligns icons east-west. Otherwise, aligns icon x-axes with the
     *  line. */
    Map,

    /** Produces icons whose x-axes are aligned with the x-axis of the viewport, regardless of the
     *  [SymbolPlacement]. */
    Viewport,

    /** For [SymbolPlacement.Point], this is equivalent to viewport. Otherwise, this is equivalent
     *  to map. */
    Auto,
}

/** Scales the icon to fit around the associated text. */
@Immutable
enum class IconTextFit {
    /** The icon is displayed at its intrinsic aspect ratio. */
    None,
    /** The icon is scaled in the x-dimension to fit the width of the text. */
    Width,
    /** The icon is scaled in the y-dimension to fit the height of the text. */
    Height,
    /** The icon is scaled in both x- and y-dimensions. */
    Both,
}

/** Orientation of icon when map is pitched. */
@Immutable
enum class IconPitchAlignment {
    /** The icon is aligned to the plane of the map. */
    Map,

    /** The icon is aligned to the plane of the viewport. */
    Viewport,

    /** Automatically matches the value of [IconRotationAlignment] */
    Auto,
}

/** Text justification options. */
@Immutable
enum class TextJustify {
    /** The text is aligned towards the anchor position. */
    Auto,

    /** The text is aligned to the left. */
    Left,

    /** The text is centered. */
    Center,

    /** The text is aligned to the right. */
    Right,
}

/** Specifies how to capitalize text, similar to the CSS text-transform property. */
@Immutable
enum class TextTransform {
    /** The text is not altered. */
    None,

    /** Forces all letters to be displayed in uppercase. */
    Uppercase,

    /** Forces all letters to be displayed in lowercase. */
    Lowercase,
}

/** Part of the icon/text placed closest to the anchor. */
@Immutable
enum class Anchor {
    /** The center of the icon is placed closest to the anchor. */
    Center,

    /** The left side of the icon is placed closest to the anchor. */
    Left,

    /** The right side of the icon is placed closest to the anchor. */
    Right,

    /** The top of the icon is placed closest to the anchor. */
    Top,

    /** The bottom of the icon is placed closest to the anchor. */
    Bottom,

    /** The top left corner of the icon is placed closest to the anchor. */
    TopLeft,

    /** The top right corner of the icon is placed closest to the anchor. */
    TopRight,

    /** The bottom left corner of the icon is placed closest to the anchor. */
    BottomLeft,

    /** The bottom right corner of the icon is placed closest to the anchor. */
    BottomRight,
}
