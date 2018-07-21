package me.xdrop.nightowl;

import com.intellij.ide.ui.UISettings;
import com.intellij.openapi.editor.ex.EditorSettingsExternalizable;

public class NightOwlAppearance {
    public static void applyIdeSettings() {
        UISettings.getInstance().setShowMainToolbar(false);
        UISettings.getInstance().setShowStatusBar(false);
        UISettings.getInstance().setShowNavigationBar(false);
        EditorSettingsExternalizable.getInstance().setBreadcrumbsShown(false);
        EditorSettingsExternalizable.getInstance().setIndentGuidesShown(false);
        EditorSettingsExternalizable.getInstance().setFoldingOutlineShown(false);
    }
}
