package me.xdrop.nightowl.settings.form;

import me.xdrop.nightowl.NightOwlAppearance;
import me.xdrop.nightowl.settings.NightOwlSettings;

import javax.swing.*;

public class NightOwlSettingsForm {
    private JPanel rootPanel;
    private JCheckBox isAppearanceSettingsEnabled;
    private JButton setNow;
    private JLabel toggleTheThemeOnLabel;
    private NightOwlSettings settings;

    public NightOwlSettingsForm() {
        settings = NightOwlSettings.getInstance();
        setNow.addActionListener(e -> {
           NightOwlAppearance.applyIdeSettings();
        });
        reset();
    }

    public boolean isModified() {
        return isAppearanceSettingsEnabled() != settings.isAppearanceSettingsEnabled();
    }

    public void reset() {
        isAppearanceSettingsEnabled.setSelected(settings.isAppearanceSettingsEnabled());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isAppearanceSettingsEnabled() {
        return isAppearanceSettingsEnabled.isSelected();
    }

}
