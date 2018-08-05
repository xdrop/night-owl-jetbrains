package me.xdrop.nightowl.dialog

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import me.xdrop.nightowl.NightOwlAppearance
import javax.swing.JComponent
import javax.swing.JPanel

class SetSettingsDialog(project: Project) : DialogWrapper(project)  {
    var panel: JPanel? = null

    override fun createCenterPanel(): JComponent? {
        return panel
    }

    init {
        super.init()
        title = "Night Owl Appearance Settings"
        isModal = true
    }

    override fun doOKAction() {
        NightOwlAppearance.applyIdeSettings()
        super.doOKAction()
    }
}
