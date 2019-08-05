package eyes

import eyes.data.mappings
import eyes.out.writeCodeFile
import eyes.out.writePpmPreview
import eyes.parser.findFaceFiles
import eyes.parser.parseFaceFile
import java.io.File

fun main() {
    val faceFiles = findFaceFiles()
    println("Processing ${faceFiles.joinToString { it.name }}")

    val out = File("out").also { it.mkdirs() }
    faceFiles.forEach { writePpmPreview(it, File(out, "${it.name}.ppm")) }

    val controls = mappings.mapValues { (_, name) -> faceFiles.single { it.name == name } }
    writeCodeFile(controls, File(out, "arduino.ino"))
}