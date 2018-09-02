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

        if (!checkAndNotifyMaterialUIVersion()) {
            checkAndNotifyIfUpdated()
        }
    }

    private fun showAppearanceSettingsDialog() {
        SetSettingsDialog(myProject).show()
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
        private const val channel = "me.xdrop.night-owl"

        private const val INCOMPATIBLE_MSG = """
        <b>WARNING:</b> Night Owl requires Material Theme UI version <b>2.6.0 or higher.</b><br>
        Please <b>update Material Theme UI</b>, otherwise this theme won't load.
        """
        private const val UPDATE_MSG = """
        <b>Night Owl</b> successfully updated!<br/>
        <br/>
        <b>In this release</b>: <ul>
        <ul>
        <li><i>null</i> and <i>undefined</i> now highlighted differently for <b>Javascript</b> and <b>Typescript</b></li>
        <li><i>null</i> is now highlighted differently for <b>Java</b> and <b>Kotlin</b></li>
        </ul>
        </br>
        Visit our <a href="https://github.com/xdrop/night-owl-jetbrains/issues">Github page</a> for any issues you have.
        Give us a <a href="https://github.com/xdrop/night-owl-jetbrains">star</a> if you enjoy this theme!
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