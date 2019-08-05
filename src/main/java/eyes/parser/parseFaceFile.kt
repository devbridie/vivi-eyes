package eyes.parser

import eyes.data.colors
import eyes.models.Color
import eyes.models.Eye
import eyes.models.FaceFile
import eyes.models.Position

fun parseFaceFile(name: String, lines: List<String>): FaceFile {
    val rightMap = hashMapOf<Position, Color>()
    val leftMap = hashMapOf<Position, Color>()

    if (lines.size != 8) { error("Face file \"$name\" should have 8 rows."); }

    lines.take(8).forEachIndexed { y, line ->
        if (lines.size != 8) { error("Face file \"$name\" should have 14 characters on line $y."); }
        line.take(5).forEachIndexed { x, khar ->
            leftMap[Position(x, y)] = colors.find { it.name == khar } ?: error("No color $khar")
        }
        line.drop(5+4).take(5).forEachIndexed { x, khar ->
            rightMap[Position(x, y)] = colors.find { it.name == khar } ?: error("No color $khar")
        }
    }

    return FaceFile(name, Eye(leftMap), Eye(rightMap))
}
