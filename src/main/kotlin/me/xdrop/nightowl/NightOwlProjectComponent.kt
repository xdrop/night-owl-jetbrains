package me.xdrop.nightowl

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import me.xdrop.nightowl.dialog.SetSettingsDialog
import me.xdrop.nightowl.settings.NightOwlSettings
import me.xdrop.nightowl.utils.compareVersion
import me.xdrop.nightowl.utils.notify

class NightOwlProjectComponent(project: Project) : AbstractProjectComponent(project) {

    private val applicationComponent = NightOwlComponent.instance

    override fun projectOpened() {
        val settings = NightOwlSettings.instance

        if (settings.isSetup) {
            showAppearanceSettingsDialog()
            settings.isSetup = false
        }
        
        checkAndNotifyIfUpdated()
    }

    private fun showAppearanceSettingsDialog() {
        SetSettingsDialog(myProject).show()
    }

    private fun checkAndNotifyIfUpdated() {
        if (applicationComponent.hasUpdated) {
            notifyUpdate(myProject)
            applicationComponent.hasUpdated = false
        }
    }

    companion object {
        private val version = NightOwlSettings.instance.version
        private const val channel = "me.xdrop.night-owl"

        private const val UPDATE_MSG = """
        <b>Night Owl</b> successfully updated!<br/>
        <br/>
        <b>In this release</b>: <ul>
        <li>Add custom highlight for some Javascript keywords. (Edit under Color Scheme > Night Owl)</li>
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
    }
}