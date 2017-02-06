package nbpapp.UserComunication;

import java.util.Properties;

public enum LanguageSettings {
	CONFIG;

	private final Properties prop;

	private LanguageSettings() {
		prop = new LanguageUtils().loadLanguageProperties();
	}

	public String getString(String name) {
		return prop.getProperty(name);
	}

}
