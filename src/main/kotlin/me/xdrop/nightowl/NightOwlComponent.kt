package me.xdrop.nightowl

import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.diagnostic.logger
import me.xdrop.nightowl.settings.NightOwlSettings
import java.io.IOException

class NightOwlComponent : ApplicationComponent {

    override fun initComponent() {
        try {
            initialize()
        } catch (e: IOException) {
            logger<NightOwlComponent>().error("IOException: ${e.message}")
        }
    }

    private fun initialize() {
        val settings = NightOwlSettings.instance
        if (settings.isSetup || settings.isAppearanceSettingsEnabled) {
            settings.isSetup = false
            applyIdeSettings()
        }
        if (settings.isOverrideRainbowBrackets) {
            applyRainbowBracketsSettings()
        }
    }

    override fun disposeComponent() {}

}