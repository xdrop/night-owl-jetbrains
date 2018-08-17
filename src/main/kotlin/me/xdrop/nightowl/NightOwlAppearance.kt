@file:Suppress("MemberVisibilityCanBePrivate")

package me.xdrop.nightowl

import com.intellij.ide.ui.UISettings
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.stateStore
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.ex.EditorSettingsExternalizable
import com.intellij.openapi.vcs.VcsApplicationSettings
import me.xdrop.nightowl.utils.rewriteStreamTo
import java.io.IOException
import java.nio.file.Paths

object NightOwlAppearance {
    private val uiSettings = UISettings.instance
    private val editorSettings = EditorSettingsExternalizable.getInstance()
    private val vcsSettings = VcsApplicationSettings.getInstance()

    fun applyIdeSettings() {
        applyEditorSettings()
        applyUISettings()
        applyVCSSettings()
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

    fun applyVCSSettings() {
        vcsSettings.SHOW_LST_GUTTER_MARKERS = false
    }

    @Throws(IOException::class)
    fun applyRainbowBracketsSettings() {
        val application = ApplicationManager.getApplication()
        val storageManager = application.stateStore.storageManager
        val configPath = storageManager.expandMacros("\$APP_CONFIG\$") + "/rainbow_brackets.xml"
        val path = Paths.get(configPath)

        val classLoader = NightOwlComponent::class.java.classLoader
        val rainbowSettings = classLoader.getResourceAsStream("options/rainbow_brackets.xml")
        val outputFile = path.toFile()

        if (outputFile.exists()) {
            outputFile.delete()
        }

        rewriteStreamTo(rainbowSettings, outputFile.outputStream())
    }
}
