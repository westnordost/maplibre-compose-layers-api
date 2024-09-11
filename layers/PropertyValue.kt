package de.westnordost.maplibre_compose_api.layers

import androidx.compose.runtime.Immutable

/** A layer property value can either be a constant or an expression */
sealed interface PropertyValue<T>

@JvmInline @Immutable
value class Const<T>(val value: T) : PropertyValue<T>

@JvmInline @Immutable
value class Expr<T>(val value: Expression<T>) : PropertyValue<T>
