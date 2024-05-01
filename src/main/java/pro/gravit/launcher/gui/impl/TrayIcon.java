package pro.gravit.launcher.gui.impl;

import java.awt.AWTException;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;

import javax.imageio.ImageIO;

import pro.gravit.launcher.gui.JavaFXApplication;

public class TrayIcon {
	java.awt.TrayIcon trayIcon;
    public final JavaFXApplication application;

	public TrayIcon(JavaFXApplication application) {
        this.application = application;
		try {
			java.awt.Toolkit.getDefaultToolkit();
			java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
			java.awt.Image image = ImageIO.read(JavaFXApplication.getResourceURL("trayicon.png"));
			trayIcon = new java.awt.TrayIcon(image);
			trayIcon.setToolTip("MyLittleWorld");
			tray.add(trayIcon);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void notify(String title, String details) {
		if(trayIcon == null || (title == null && details == null)) return;
		trayIcon.displayMessage(title, details, MessageType.NONE);
	}

	public void notify(String details) {
		if(trayIcon == null || details == null) return;
		trayIcon.displayMessage(null, details, MessageType.NONE);
	}

	public void notify(MessageType type, String details) {
		if(trayIcon == null || details == null) return;
		String title = "";
		switch(type) {
			case INFO: title = "🟢 " + application.getTranslation("misc.info"); break;
			case WARNING: title = "🟡 " + application.getTranslation("misc.warn"); break;
			case ERROR: title = "🔴 " + application.getTranslation("misc.error"); break;
			default: break;
		}
		trayIcon.displayMessage(title, details, MessageType.NONE);
	}
}
