package eyes.models

class FaceFile(val name: String, val left: Eye, val right: Eye)
class Eye(val map: Map<Position, Color>)
data class Position(val x: Int, val y: Int)