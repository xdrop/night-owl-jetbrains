package me.xdrop.nightowl;

import com.intellij.openapi.components.ApplicationComponent;
import me.xdrop.nightowl.settings.NightOwlSettings;

public class NightOwlComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        if (NightOwlSettings.getInstance().isEnabled()){
            if (NightOwlSettings.getInstance().isSetup()){
                NightOwlSettings.getInstance().setSetup(false);
                NightOwlAppearance.applyIdeSettings();
            }
            if (!NightOwlSettings.getInstance().isOverrideAppearance()) {
                NightOwlAppearance.applyIdeSettings();
            }
            NightOwlRainbowColorSettings.applyRainbowColorSettings();
        }
    }

    @Override
    public void disposeComponent() {

    }
}
