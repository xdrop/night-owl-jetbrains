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
        if (compareVersion(materialThemeUI?.version ?: "0.0.0", "2.6.0") > 0) {
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

        private val incompatibleMsg = """
 <br/>
<b>WARNING:</b> Night owl requires Material Theme UI version <b>2.6.0 or higher</b></br>
Please <b>update Material Theme UI</b>, otherwise this theme won't load.
"""

        private fun notifyUpdate(project: Project) {
            Notify.show(
                    project = project,
                    title = "Night Owl",
                    content = "",
                    displayId = channel
            )
        }

        private fun notifyIncompatible(project: Project) {
            Notify.show(
                    project = project,
                    title = "Night Owl",
                    content = "",
                    displayId = channel
            )
        }
    }
}