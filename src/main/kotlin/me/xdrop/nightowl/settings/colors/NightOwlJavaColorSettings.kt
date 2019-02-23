package me.xdrop.nightowl.settings.colors

import com.intellij.openapi.options.colors.AttributesDescriptor
import me.xdrop.nightowl.highlight.NightOwlJavaAndKotlinAnnotator
import me.xdrop.nightowl.settings.NightOwlColorSettingsPage

class NightOwlJavaColorSettings : NightOwlColorSettingsPage() {
    override fun getDisplayName(): String = "Java/Kotlin - Extended"

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    companion object {
        private var DESCRIPTORS = arrayOf(
                AttributesDescriptor("Keyword: this, super", NightOwlJavaAndKotlinAnnotator.JAVA_THIS_SUPER),
                AttributesDescriptor("Keyword: null", NightOwlJavaAndKotlinAnnotator.JAVA_NULL)
        )
    }
}