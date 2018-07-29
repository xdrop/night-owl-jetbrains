package me.xdrop.nightowl

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import me.xdrop.nightowl.settings.NightOwlSettings
import me.xdrop.nightowl.utils.Notify
import me.xdrop.nightowl.utils.compareVersion

class NightOwlNotifyComponent(project: Project) : AbstractProjectComponent(project) {

    private val applicationComponent = NightOwlComponent.instance

    override fun projectOpened() {
        checkAndNotifyMaterialUIVersion()
        checkAndNotifyIfUpdated()
    }

    private fun checkAndNotifyMaterialUIVersion() {
        val materialThemeUI = PluginManager.getPlugin(PluginId.getId("com.chrisrm.idea.MaterialThemeUI"))
        if (compareVersion(materialThemeUI?.version ?: "0.0.0", "2.6.0") < 0) {
            notifyIncompatible(myProject)
        }
    }

    private fun checkAndNotifyIfUpdated() {
        if (applicationComponent.hasUpdated) {
            notifyUpdate(myProject)
            applicationComponent.hasUpdated = false
        }
    }

    companion object {
        private val version = NightOwlSettings.instance.version
        private const val channel = "me.xdrop.nightowl"

        private const val INCOMPATIBLE_MSG = """
        <b>WARNING:</b> Night Owl requires Material Theme UI version <b>2.6.0 or higher.</b><br>
        Please <b>update Material Theme UI</b>, otherwise this theme won't load.
        """
        private const val UPDATE_MSG = """
        <b>Night Owl</b> successfully updated!<br/>
        <b>In this release</b>: <ul>
        <li>New <i>accent color</i> for theme</li>
        </ul>
        </br>
        Visit <a href="https://github.com/xdrop/night-owl-jetbrains/issues">Github</a> for any issues you have
        """

        private fun notifyUpdate(project: Project) {
            Notify.show(
                    project = project,
                    title = "Night Owl",
                    content = UPDATE_MSG,
                    displayId = channel
            )
        }

        private fun notifyIncompatible(project: Project) {
            Notify.show(
                    project = project,
                    title = "Night Owl",
                    content = INCOMPATIBLE_MSG,
                    displayId = channel
            )
        }
    }
}