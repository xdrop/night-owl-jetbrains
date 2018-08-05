package me.xdrop.nightowl.settings

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import me.xdrop.nightowl.highlight.NightOwlJSAnnotator
import java.awt.Component
import java.awt.Graphics
import javax.swing.Icon

class NightOwlColorSettingsPage : ColorSettingsPage {

    class EmptyIcon : Icon {
        override fun getIconHeight(): Int {
            return 32
        }

        override fun paintIcon(c: Component?, g: Graphics?, x: Int, y: Int) {
        }

        override fun getIconWidth(): Int {
            return 32
        }

    }

    override fun getHighlighter(): SyntaxHighlighter {
        return PlainSyntaxHighlighter()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> {
        return HashMap()
    }

    override fun getIcon(): Icon? {
        return EmptyIcon()
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return emptyArray();
    }

    override fun getDisplayName(): String = "Night Owl"
    override fun getDemoText(): String = " "

    companion object {
        private var DESCRIPTORS = arrayOf(
                AttributesDescriptor("JSlike - this, super", NightOwlJSAnnotator.JS_THIS_SUPER),
                AttributesDescriptor("JSlike - export, default, module", NightOwlJSAnnotator.JS_MODULE_KEYWORD),
                AttributesDescriptor("JSlike - debugger", NightOwlJSAnnotator.JS_DEBUGGER)
        )
    }
}