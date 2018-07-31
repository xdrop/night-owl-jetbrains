package me.xdrop.nightowl

import com.intellij.ide.ui.UISettings
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.stateStore
import com.intellij.openapi.editor.ex.EditorSettingsExternalizable
import me.xdrop.nightowl.utils.rewriteStreamTo
import java.io.IOException
import java.nio.file.Paths

object Appearance {
    private val uiSettings = UISettings.instance
    private val editorSettings = EditorSettingsExternalizable.getInstance()

    fun applyIdeSettings() {
        applyEditorSettings()
        applyUISettings()
    }

    fun applyEditorSettings() {
        editorSettings.isBreadcrumbsShown = false
        editorSettings.isIndentGuidesShown = false
        editorSettings.isFoldingOutlineShown = false
    }

    fun applyUISettings() {
        uiSettings.showMainToolbar = false
        uiSettings.showStatusBar = false
        uiSettings.showNavigationBar = false
    }

    @Throws(IOException::class)
    fun applyRainbowBracketsSettings() {
        val application = ApplicationManager.getApplication()
        val storageManager = application.stateStore.storageManager
        val configPath = storageManager.expandMacros("\$APP_CONFIG\$") + "/rainbow_brackets.xml"
        val path = Paths.get(configPath)

        val classLoader = NightOwlComponent::class.java.classLoader
        val rainbowSettings = classLoader.getResourceAsStream("colors/rainbow_brackets.xml")
        val outputFile = path.toFile()

        if (outputFile.exists()) {
            outputFile.delete()
        }

        rewriteStreamTo(rainbowSettings, outputFile.outputStream())
    }
}
