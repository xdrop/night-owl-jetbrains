package me.xdrop.nightowl.dialog

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import me.xdrop.nightowl.NightOwlAppearance
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

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
    }
}
