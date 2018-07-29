package me.xdrop.nightowl.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager.getService
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.State;
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "NightOwlThemeConfig", storages=[Storage("night-owl-theme.xml")])
class NightOwlSettings : PersistentStateComponent<NightOwlSettings> {

    var isAppearanceSettingsEnabled = false
    var isOverrideRainbowBrackets = true
    var isSetup = false
    var version = "unset"

    override fun getState() = this

    override fun loadState(state: NightOwlSettings) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        val instance: NightOwlSettings
            get() = getService(NightOwlSettings::class.java)
    }
}
