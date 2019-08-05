package eyes

import eyes.models.Color
import eyes.models.Eye
import eyes.models.FaceFile
import eyes.models.Position

val rightEyeMapping = listOf(
    7, 15, 23, 31, 39,
    6, 14, 22, 30, 38,
    5, 13, 21, 29, 37,
    4, 12, 20, 28, 36,
    3, 11, 19, 27, 35,
    2, 10, 18, 26, 34,
    1,  9, 17, 25, 33,
    0,  8, 16, 24, 32
)

val leftEyeMapping = rightEyeMapping.reversed().map { it + 40 }

// Draw pixels from an (x,y) position to a led index.
fun Eye.remapToLeds(remap: List<Int>): List<Pair<Int, Color>> {
    return map.entries.sortByPosition().map { it.value }.withIndex().map { (newIndex, color) -> remap[newIndex] to color }
}

private fun Set<Map.Entry<Position, Color>>.sortByPosition() = sortedWith(compareBy<Map.Entry<Position, Color>> { it.component1().y }.thenBy { it.component1().x })

fun FaceFile.remapToLeds(): List<Pair<Int, Color>> {
    return (this.left.remapToLeds(leftEyeMapping) + this.right.remapToLeds(rightEyeMapping)).sortedBy { it.first }
}