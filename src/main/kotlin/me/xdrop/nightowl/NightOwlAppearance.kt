package me.xdrop.nightowl

import com.intellij.ide.ui.UISettings
import com.intellij.openapi.editor.ex.EditorSettingsExternalizable

object Appearance {
    fun applyIdeSettings() {
        UISettings.instance.showMainToolbar = false
        UISettings.instance.showStatusBar = false
        UISettings.instance.showNavigationBar = false
        EditorSettingsExternalizable.getInstance().isBreadcrumbsShown = false
        EditorSettingsExternalizable.getInstance().isIndentGuidesShown = false
        EditorSettingsExternalizable.getInstance().isFoldingOutlineShown = false
    }
}
