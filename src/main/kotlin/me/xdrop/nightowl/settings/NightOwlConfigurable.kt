package me.xdrop.nightowl.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.ConfigurationException
import me.xdrop.nightowl.settings.form.NightOwlSettingsForm
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class NightOwlConfigurable : Configurable {
    private var settingsForm: NightOwlSettingsForm? = null

    @Nls
    override fun getDisplayName() = "Night Owl"

    override fun createComponent(): JComponent? {
        settingsForm = settingsForm ?: NightOwlSettingsForm()
        return settingsForm?.component()
    }

    override fun isModified(): Boolean {
        return settingsForm?.isModified ?: false
    }

    @Throws(ConfigurationException::class)
    override fun apply() {
        val settings = NightOwlSettings.instance
        settings.isAppearanceSettingsEnabled = settingsForm?.isAppearanceSettingsEnabled ?: false
    }

    override fun reset() {
        settingsForm?.reset()
    }

    override fun disposeUIResources() {
        settingsForm = null
    }
}
