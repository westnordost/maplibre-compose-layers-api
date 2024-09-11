# Kotlin MapLibre Compose API suggestion

Example:
```kotlin
val roadSource = Source("jawg-streets", "road")

val roadWidth = interpolate(
  interpolator = Interpolator.Exponential(2f),
  value = get("zoom"),
  stops = listOf(9.0 to 1.dp, 16.0 to 6.dp, 24.0 to 1536.dp)
)

val roadStyle = lineProperties(
  color = 0xff9999,
  cap = StrokeCap.Round,
  join = StrokeJoin.Round(limit = 2.5f),
  widthExpr = roadWidth
)

val defaultTextStyle = Text(
  color = 0x112244,
  font = "Roboto Regular",
  sizeExpr = 16.sp,
  haloColor = 0xffffff,
  haloWidth = 2.5.dp,
  padding = 12.dp,
)

val layers = listOf(
  Layer(
    id = "roads",
    source = roadSource,
    properties = roadStyle
  ),
  Layer(
    id = "road-bridges",
    source = roadSource,
    filter = equals(get("structure"), "bridge"),
    properties = roadStyle.copy(opacity = 0.75f)
  ),
  Layer(
    id = "road-bridges-casing",
    source = roadSource,
    filter = equals(get("structure"), "bridge"),
    properties = lineProperties(
      color = Color.Black,
      cap = StrokeCap.Butt,
      gapWidthExpr = roadWidth,
      width = 4.dp
    )
  ),
  Layer(
    id = "road-labels",
    source = roadSource,
    filter = equals(geometryType(), "LineString"),
    properties = symbolProperties(
      text = defaultTextStyle.copy(fieldExpr = get("name")),
      placement = SymbolPlacement.LineCenter,
      sortKeyExpr = get("scalerank")
    )
  )
)
```

So, these are the layers to display roads with labels and bridges are drawn on top of normal roads
with some transparency and a black casing.

`lineProperties` is just a factory function that creates a `LineLayerProperties` data class, the
same with `symbolProperties`.

Regarding the code in the layers folder, I had to stop myself working further on this lest I end up
with some complet-ish implementation rather than a mockup.

## Compared with Java API

### Pros

- Easier to work with in an IDE because the factory function signature discloses which are the 
  possible properties (not possible to add properties for another layer or add them twice) and
  which are the defaults

- less verbose (no `fillExtrusionColor`, just `color`)

- Kotlin-idiomatic (see e.g. how parameters are passed to composables in Jetpack Compose)

### Cons

- Awkward handling of Expressions. As most style properties in MapLibre could either be a 
  value or an expression and Kotlin has no union types, all constant style properties would have to be 
  specified by wrapping them in a  e.g. `color = Constant(Color.Red)`.
  A solution explored in the example above is to use factory functions that have for each property
  actually two parameters: One that accepts a constant (e.g. `width`), the other e.g. `widthExpr`), an expression. But hm.

## Compared with MapLibreSwiftUI

### Pros

- **Can share text styles, line styles etc. between layers and copy & modify them for different layers**

- Easier to work with in an IDE because the factory function signature discloses which are the 
  defaults for properties not specified and also it is not possible to add them twice.

- less verbose (no `fillExtrusionColor`, just `color`)

- Kotlin-idiomatic (see e.g. how parameters are passed to composables in Jetpack Compose)

### Cons

- Same cons as compared to the Java API
