package me.xdrop.nightowl.settings.form

import me.xdrop.nightowl.Appearance
import me.xdrop.nightowl.settings.NightOwlSettings
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JPanel

class NightOwlSettingsForm {
    private var rootPanel: JPanel? = null
    private var isAppearanceSettingsEnabledCheckBox: JCheckBox? = null
    private var isOverrideRainbowBracketsCheckBox: JCheckBox? = null
    private var setNow: JButton? = null

    private val settings: NightOwlSettings = NightOwlSettings.instance

    init {
        setNow?.addActionListener { Appearance.applyIdeSettings() }
        reset()
    }

    fun component(): JComponent? = rootPanel

    fun reset() {
        isAppearanceSettingsEnabledCheckBox?.isSelected = settings.isAppearanceSettingsEnabled
        isOverrideRainbowBracketsCheckBox?.isSelected = settings.isOverrideRainbowBrackets
    }

    val isAppearanceSettingsEnabled
            get() = isAppearanceSettingsEnabledCheckBox?.isSelected

    val isOverrideRainbowBrackets
        get() = isOverrideRainbowBracketsCheckBox?.isSelected

    val isModified: Boolean
        get() = isAppearanceSettingsEnabled != settings.isAppearanceSettingsEnabled
                || isOverrideRainbowBrackets != settings.isOverrideRainbowBrackets
}
