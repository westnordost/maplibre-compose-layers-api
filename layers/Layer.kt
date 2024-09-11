package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable

@Immutable
data class Layer(
    val id: String,
    val metadata: Any? = null,
    val source: String? = null,
    val sourceLayer: String? = null,
    val minZoom: Float? = null,
    val maxZoom: Float? = null,
    val filter: Expression<Boolean>? = null,
    val properties: LayerProperties,
)

sealed interface LayerProperties

@Immutable
enum class Visibility {
    Visible,
    None,
}

/** Frame of reference for translating */
@Immutable
enum class TranslateAnchor {
    /** It is translated relative to the map */
    Map,

    /** It is translated relative to the viewport */
    Viewport
}

interface Expression<T> // TODO :->
