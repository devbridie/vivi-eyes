package eyes.data

import eyes.models.mappings

val mappings = mappings {
    mapping("open")

    // up: blink
    mapping("halfblink", UP)
    mapping("caret", UP, C)
    mapping("blink1", UP, Z)

    // UP RIGHT: sad/cry
    mapping("sad", UP, RIGHT, C)
    mapping("cry", UP, RIGHT, C, Z)

    // UP LEFT: mad/angry
    mapping("mad", UP, LEFT, C)
    mapping("angry", UP, LEFT, C, Z)

    // LEFT: suspicious / ???
    mapping("suspicious", LEFT)
    mapping("blink2", LEFT, C)
    mapping("really", LEFT, Z)
    mapping("question", LEFT, Z)

    // RIGHT: happy
    mapping("happy", RIGHT)
    mapping("caret", RIGHT, C)
    mapping("wink", RIGHT, Z)
    mapping("heart", RIGHT, C, Z)

    // DOWN: weird
    mapping("surprise", DOWN)
    mapping("frustrated", DOWN, C)
    mapping("dead", DOWN, Z)
    mapping("question", DOWN, C, Z)
}