package me.xdrop.nightowl.utils

import com.intellij.notification.*
import com.intellij.openapi.project.Project

fun notify(project: Project, title: String, content: String,
           displayId: String, type: NotificationType = NotificationType.INFORMATION,
           listener: NotificationListener = NotificationListener.URL_OPENING_LISTENER) {
    val group = NotificationGroup(
            displayId,
            NotificationDisplayType.STICKY_BALLOON,
            true
    )
    val notification = group.createNotification(title, content, type, listener)
    Notifications.Bus.notify(notification, project)
}
