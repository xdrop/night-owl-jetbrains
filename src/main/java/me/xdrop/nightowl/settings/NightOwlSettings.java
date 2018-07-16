package me.xdrop.nightowl.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "NightOwlThemeConfig",
        storages = @Storage("night_owl_theme.xml")
)
public class NightOwlSettings implements PersistentStateComponent<NightOwlSettings> {
    private boolean isEnabled = true;
    private boolean isOverrideAppearance = true;
    private boolean isSetup = true;

    /**
     * Get instance of the settings from the ServiceManager
     *
     * @return the settings instance
     */
    public static NightOwlSettings getInstance() {
        return ServiceManager.getService(NightOwlSettings.class);
    }

    @Nullable
    @Override
    public NightOwlSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull NightOwlSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }


    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isOverrideAppearance() {
        return isOverrideAppearance;
    }

    public void setOverrideAppearance(boolean overrideAppearance) {
        isOverrideAppearance = overrideAppearance;
    }

    public boolean isSetup() {
        return isSetup;
    }

    public void setSetup(boolean setup) {
        isSetup = setup;
    }
}
