package me.xdrop.nightowl;

import com.github.izhangzhihao.rainbow.brackets.settings.RainbowSettings;

public class NightOwlRainbowColorSettings {
    public static void applyRainbowColorSettings() {
        RainbowSettings settings = RainbowSettings.Companion.getInstance();
        settings.setEnableRainbowRoundBrackets(true);
        settings.setEnableRainbowAngleBrackets(false);
        settings.setEnableRainbowSquareBrackets(true);
        settings.setEnableRainbowSquigglyBrackets(true);
        settings.setRainbowifyHTMLInsideJS(true);
        settings.setRainbowifyKotlinFunctionLiteralBracesAndArrow(true);
        settings.setDarkRoundBracketsColors(new String[]{"0xffd700","0xda70d6","0x87cefa"});
        settings.setDarkSquareBracketsColors(new String[]{"0xffd700","0xda70d6","0x87cefa"});
        settings.setDarkSquigglyBracketsColors(new String[]{"0xffd700","0xda70d6","0x87cefa"});
    }
}
