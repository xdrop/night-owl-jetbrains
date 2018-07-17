package me.xdrop.nightowl;

import com.intellij.openapi.components.ApplicationComponent;
import me.xdrop.nightowl.settings.NightOwlSettings;

public class NightOwlComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        NightOwlSettings settings = NightOwlSettings.getInstance();
        if (settings.isSetup() || !settings.isAppearanceSettingsEnabled()) {
            settings.setSetup(false);
            NightOwlAppearance.applyIdeSettings();
        }
        NightOwlRainbowColorSettings.applyRainbowColorSettings();
    }

    @Override
    public void disposeComponent() {

    }
}
