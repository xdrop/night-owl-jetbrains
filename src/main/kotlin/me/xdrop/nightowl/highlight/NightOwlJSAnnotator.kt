package me.xdrop.nightowl.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.lang.javascript.highlighting.JSHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class NightOwlJSAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement) {
            val kind = when (element.text) {
                "this" -> JS_THIS_SUPER
                "super" -> JS_THIS_SUPER
                "export" -> JS_MODULE_KEYWORD
                "default" -> JS_MODULE_KEYWORD
                "module" -> JS_MODULE_KEYWORD
                "debugger" -> JS_DEBUGGER
                else -> {
                    return
                }
            }
            val range = TextRange(element.textRange.startOffset, element.textRange.endOffset)
            val annotation = holder.createAnnotation(HighlightSeverity.INFORMATION, range, null)
            annotation.textAttributes = kind
        }
    }

    companion object {
        val JS_THIS_SUPER = TextAttributesKey.createTextAttributesKey("JS.THIS_SUPER", JSHighlighter.JS_KEYWORD)
        val JS_MODULE_KEYWORD = TextAttributesKey.createTextAttributesKey("JS.MODULE_KEYWORD", JSHighlighter.JS_KEYWORD)
        val JS_DEBUGGER = TextAttributesKey.createTextAttributesKey("JS.DEBUGGER_STMT", JSHighlighter.JS_KEYWORD)
    }
}