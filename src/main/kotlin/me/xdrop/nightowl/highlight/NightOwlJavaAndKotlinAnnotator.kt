package me.xdrop.nightowl.highlight

import com.intellij.ide.highlighter.JavaFileHighlighter
import com.intellij.ide.highlighter.JavaHighlightingColors
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.lang.java.JavaSyntaxHighlighterFactory
import com.intellij.lang.javascript.highlighting.JSHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class NightOwlJavaAndKotlinAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement) {
            val kind = when (element.text) {
                "this" -> JAVA_THIS_SUPER
                "super" -> JAVA_THIS_SUPER
                "null" -> JAVA_NULL
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
        val JAVA_THIS_SUPER = TextAttributesKey.createTextAttributesKey("JAVA_KOTLIN_THIS_SUPER_KEYWORD", JavaHighlightingColors.KEYWORD)
        val JAVA_NULL = TextAttributesKey.createTextAttributesKey("JAVA_KOTLIN_NULL_KEYWORD", JavaHighlightingColors.KEYWORD)
    }
}