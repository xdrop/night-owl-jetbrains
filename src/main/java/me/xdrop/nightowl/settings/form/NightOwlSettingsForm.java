package me.xdrop.nightowl.settings.form;

import me.xdrop.nightowl.settings.NightOwlSettings;

import javax.swing.*;

public class NightOwlSettingsForm {
    private JPanel rootPanel;
    private JCheckBox isEnabled;
    private JLabel toggleTheThemeOnLabel;
    private JCheckBox isAppearanceOverriden;
    private JLabel appearanceOverrideLabel;
    private NightOwlSettings settings = NightOwlSettings.getInstance();

    public NightOwlSettingsForm() {
        settings = NightOwlSettings.getInstance();
        reset();
    }

    public boolean isModified() {
        return isNightOwlEnabled() != settings.isEnabled()
                || isAppearanceOverriden() != settings.isOverrideAppearance();
    }

    public void reset() {
        isEnabled.setSelected(settings.isEnabled());
        isAppearanceOverriden.setSelected(settings.isOverrideAppearance());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isNightOwlEnabled() {
        return isEnabled.isSelected();
    }

    public boolean isAppearanceOverriden() {
        return isAppearanceOverriden.isSelected();
    }

}
