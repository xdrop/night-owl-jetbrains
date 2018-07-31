package me.xdrop.nightowl

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import me.xdrop.nightowl.settings.NightOwlSettings
import me.xdrop.nightowl.utils.compareVersion
import me.xdrop.nightowl.utils.notify

class NightOwlNotifyComponent(project: Project) : AbstractProjectComponent(project) {

    private val applicationComponent = NightOwlComponent.instance

    override fun projectOpened() {
        if (!checkAndNotifyMaterialUIVersion()) {
            checkAndNotifyIfUpdated()
        }
    }

    private fun checkAndNotifyMaterialUIVersion() : Boolean {
        val materialThemeUI = PluginManager.getPlugin(PluginId.getId("com.chrisrm.idea.MaterialThemeUI"))
        if (compareVersion(materialThemeUI?.version ?: "0.0.0", "2.6.0") < 0) {
            notifyIncompatible(myProject)
            return true
        }
        return false
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
        <br/>
        <b>In this release</b>: <ul>
        <li>New <i>Night Owl Carbon</i> theme!</li>
        <li>New <i>accent color</i> for theme</li>
        <li>Reduce line spacing</li>
        <li>Minor color updates</li>
        </ul>
        </br>
        Visit our <a href="https://github.com/xdrop/night-owl-jetbrains/issues">Github page</a> for any issues you have
        """

        private fun notifyUpdate(project: Project) {
            notify(
                    project = project,
                    title = "Night Owl: Updated to $version",
                    content = UPDATE_MSG,
                    displayId = channel
            )
        }

        private fun notifyIncompatible(project: Project) {
            notify(
                    project = project,
                    title = "ERROR: Night Owl Incompatibility",
                    content = INCOMPATIBLE_MSG,
                    displayId = channel
            )
        }
    }
}