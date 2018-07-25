package me.xdrop.nightowl;

import com.intellij.configurationStore.StateStorageManager;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceKt;
import com.intellij.openapi.diagnostic.Logger;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NightOwlRainbowColorSettings {
    private static Logger logger = Logger.getInstance(NightOwlRainbowColorSettings.class);

    public static void applyRainbowColorSettings() {
        Application application = ApplicationManager.getApplication();
        StateStorageManager storageManager = ServiceKt.getStateStore(application).getStorageManager();
        String configPath = storageManager.expandMacros("$APP_CONFIG$") + "/rainbow_brackets.xml";
        Path path = Paths.get(configPath);
        File rainbowSettingsOut = path.toFile();
        ClassLoader classLoader = NightOwlRainbowColorSettings.class.getClassLoader();
        InputStream rainbowSettingsIn = classLoader.getResourceAsStream("colors/rainbow_brackets.xml");
        replaceFile(rainbowSettingsIn, rainbowSettingsOut);
    }

    private static void replaceFile(InputStream in, File out) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(out))) {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(in))) {
                String inLine;
                while ((inLine = fileReader.readLine()) != null) {
                    fileWriter.write(inLine);
                    fileWriter.newLine();
                }
            }
        } catch (IOException e) {
           logger.error("Failed to replace rainbow_brackets.xml: " + e.getMessage());
        }
    }
}
