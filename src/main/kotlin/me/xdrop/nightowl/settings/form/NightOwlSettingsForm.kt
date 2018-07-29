package me.xdrop.nightowl.settings.form

import me.xdrop.nightowl.NightOwlAppearance
import me.xdrop.nightowl.settings.NightOwlSettings

import javax.swing.*

class NightOwlSettingsForm {
    private val rootPanel: JPanel? = null
    private val isAppearanceSettingsEnabledCheckBox: JCheckBox? = null
    private val isOverrideRainbowBracketsCheckBox: JCheckBox? = null
    private val setNow: JButton? = null

    private val settings: NightOwlSettings = NightOwlSettings.instance

    init {
        setNow?.addActionListener { NightOwlAppearance.applyIdeSettings() }
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
