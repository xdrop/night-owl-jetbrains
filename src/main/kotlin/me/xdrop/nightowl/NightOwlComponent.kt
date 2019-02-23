package me.xdrop.nightowl

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.BaseComponent
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.extensions.PluginId
import me.xdrop.nightowl.settings.NightOwlSettings
import java.io.IOException

class NightOwlComponent : BaseComponent {

    var hasUpdated: Boolean = false

    override fun initComponent() {
        try {
            initialize()
        } catch (e: IOException) {
            LOG.error("IOException: ${e.message}")
        }
    }

    private fun initialize() {
        val settings = NightOwlSettings.instance

        if (hasUpdated(settings)) {
            hasUpdated = true
        }

        updateVersion(settings)

        if (settings.isOverrideRainbowBrackets) {
            NightOwlAppearance.applyRainbowBracketsSettings()
        }
    }

    private fun hasUpdated(settings: NightOwlSettings): Boolean {
        return getPlugin()!!.version != settings.version
    }

    private fun updateVersion(settings: NightOwlSettings) {
        val current = getPlugin()!!.version

        if (settings.version != current) {
            settings.version = current
        }
    }

    companion object {
        val instance: NightOwlComponent
            get() = ApplicationManager.getApplication().getComponent(NightOwlComponent::class.java)

        val LOG = logger<NightOwlComponent>();

        private fun getPlugin() = PluginManager.getPlugin(
                PluginId.getId("me.xdrop.night-owl")
        )
    }

}