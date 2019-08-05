package eyes.parser

import eyes.models.FaceFile
import java.io.File

fun findFaceFiles(): List<FaceFile> {
    val classloader = object {}::class.java.classLoader
    val files = classloader.getResourceAsStream("faces").bufferedReader().readLines()
    return files.map { filename ->
        val lines = classloader.getResourceAsStream("faces/$filename").bufferedReader().readLines()
        val withoutExtension = File(filename).nameWithoutExtension
        parseFaceFile(withoutExtension, lines)
    }
}