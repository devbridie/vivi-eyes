package eyes.models

sealed class Input {
    class ButtonInput(val button: NunchukButton) : Input()
    class DirectionInput(val direction: Direction) : Input()
}

class MappingsBuilder {
    private val building = mutableMapOf<InputCombination, String>()
    val C = Input.ButtonInput(NunchukButton.C);
    val Z = Input.ButtonInput(NunchukButton.Z)
    val UP = Input.DirectionInput(Direction.UP);
    val DOWN = Input.DirectionInput(Direction.DOWN);
    val LEFT = Input.DirectionInput(Direction.LEFT)
    val RIGHT = Input.DirectionInput(Direction.RIGHT)

    fun mapping(name: String, vararg inputs: Input) {
        val inputCombination = InputCombination(inputs.filterIsInstance<Input.DirectionInput>().map { it.direction },
            inputs.filterIsInstance<Input.ButtonInput>().map { it.button })
        building[inputCombination] = name
    }

    fun build() = building
}

fun mappings(fn: MappingsBuilder.() -> Unit): Map<InputCombination, String> {
    return MappingsBuilder().apply { fn() }.build()
}