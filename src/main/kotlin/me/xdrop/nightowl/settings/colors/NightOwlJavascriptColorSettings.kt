package me.xdrop.nightowl.settings.colors

import com.intellij.openapi.options.colors.AttributesDescriptor
import me.xdrop.nightowl.highlight.NightOwlJSAnnotator
import me.xdrop.nightowl.settings.NightOwlColorSettingsPage

class NightOwlJavascriptColorSettings : NightOwlColorSettingsPage() {
    override fun getDisplayName(): String = "Javascript/Typescript - Extended"

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    companion object {
        private var DESCRIPTORS = arrayOf(
                AttributesDescriptor("Keyword: this, super", NightOwlJSAnnotator.JS_THIS_SUPER),
                AttributesDescriptor("Keyword: export, default, module", NightOwlJSAnnotator.JS_MODULE_KEYWORD),
                AttributesDescriptor("Keyword: debugger", NightOwlJSAnnotator.JS_DEBUGGER)
        )
    }
}