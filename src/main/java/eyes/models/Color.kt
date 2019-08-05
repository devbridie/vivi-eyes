package eyes.models

data class Color(val name: Char, val r: Int, val g: Int, val b: Int) {
    val definedName = "color_${name.toLowerCase()}"
}