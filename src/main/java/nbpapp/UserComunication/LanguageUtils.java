package nbpapp.UserComunication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LanguageUtils {
	
	public Properties loadLanguageProperties() {
		Properties prop = new Properties();
		InputStream config = LanguageUtils.class.getResourceAsStream("/language.prop");
		try {
			prop.load(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
