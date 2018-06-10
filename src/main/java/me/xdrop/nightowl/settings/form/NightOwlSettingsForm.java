package me.xdrop.nightowl.settings.form;

import javax.swing.*;

public class NightOwlSettingsForm {
    private JPanel rootPanel;
    private JCheckBox isEnabled;
    private JLabel toggleTheThemeOnLabel;

    public NightOwlSettingsForm() {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isNightOwlEnabled() {
        return isEnabled.isSelected();
    }

}
