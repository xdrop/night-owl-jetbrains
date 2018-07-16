package me.xdrop.nightowl.settings;

import com.intellij.openapi.options.Configurable;
import me.xdrop.nightowl.settings.form.NightOwlSettingsForm;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NightOwlConfigurable implements Configurable {
    private NightOwlSettingsForm settingsForm;

    @Nls
    @Override
    public String getDisplayName() {
        return "Night Owl";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingsForm = new NightOwlSettingsForm();
        return settingsForm.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return settingsForm != null && settingsForm.isModified();
    }

    @Override
    public void reset() {
        settingsForm.reset();
    }

    @Override
    public void apply() {
        NightOwlSettings instance = NightOwlSettings.getInstance();
        instance.setEnabled(settingsForm != null && settingsForm.isNightOwlEnabled());
        instance.setOverrideAppearance(settingsForm != null && settingsForm.isAppearanceOverriden());
    }
}
