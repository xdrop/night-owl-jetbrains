package me.xdrop.nightowl

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.stateStore
import me.xdrop.nightowl.utils.replaceFile
import java.io.IOException
import java.nio.file.Paths

@Throws(IOException::class)
fun applyRainbowBracketsSettings() {
    val application = ApplicationManager.getApplication()
    val storageManager = application.stateStore.storageManager
    val configPath = storageManager.expandMacros("\$APP_CONFIG\$") + "/rainbow_brackets.xml"
    val path = Paths.get(configPath)

    val classLoader = NightOwlComponent::class.java.classLoader
    val rainbowSettings = classLoader.getResourceAsStream("colors/rainbow_brackets.xml")

    val outputStream = path.toFile().outputStream()

    replaceFile(rainbowSettings, outputStream)
}
