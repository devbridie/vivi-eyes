package eyes.models

enum class NunchukButton { C, Z }
enum class Direction {
    RIGHT,
    UP,
    LEFT,
    DOWN
}

data class InputCombination(val directions: List<Direction>, val buttons: List<NunchukButton>) {
    val notDirections = Direction.values().toList() - directions
    val notButtons = NunchukButton.values().toList() - buttons
    val condition = (directions + notDirections.map { "!$it" } + buttons.map { "$it" } + notButtons.map { "!$it" }).joinToString(" && ")
}
