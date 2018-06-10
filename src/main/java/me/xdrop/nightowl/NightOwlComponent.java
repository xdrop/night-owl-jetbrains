package me.xdrop.nightowl;

import com.intellij.ide.ui.UISettings;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.editor.ex.EditorSettingsExternalizable;

public class NightOwlComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        UISettings.getInstance().setEditorTabLimit(1);
        UISettings.getInstance().setShowMainToolbar(false);
        UISettings.getInstance().setShowStatusBar(false);
        UISettings.getInstance().setShowNavigationBar(false);
        EditorSettingsExternalizable.getInstance().setBreadcrumbsShown(false);
        EditorSettingsExternalizable.getInstance().setIndentGuidesShown(false);
        EditorSettingsExternalizable.getInstance().setFoldingOutlineShown(false);
    }

    @Override
    public void disposeComponent() {

    }
}
