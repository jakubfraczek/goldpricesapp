package nbpapp.calculation;

import java.util.List;

import nbpapp.UserComunication.Messages;
import nbpapp.json.NBPGson;

public class Recommendation {
	
	public String recommendation(List<NBPGson> listNBP) {
		
		Averages tempAvarage = new Averages();
		double avarage = tempAvarage.average(listNBP);
		double avarageLast3Days = tempAvarage.averageLast3Days(listNBP);
		
		if (avarageLast3Days == 0) {
			return Messages.NOT_ENOUGH_DATA;
		} else if (avarageLast3Days / avarage < 1.01 && avarageLast3Days / avarage > 0.99) {
			return Messages.KEEP;
		} else if (avarage < avarageLast3Days) {
			return Messages.SELL;
		} else {
			return Messages.BUY;
		}
	}
}
