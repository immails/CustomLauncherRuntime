package pro.gravit.launcher.gui.utils;

import pro.gravit.launcher.gui.config.RuntimeSettings;

public class SystemTheme {
    // Available only in JavaFX 22+
    public static RuntimeSettings.LAUNCHER_THEME getSystemTheme() {
        return RuntimeSettings.LAUNCHER_THEME.DARK;
    }
}
