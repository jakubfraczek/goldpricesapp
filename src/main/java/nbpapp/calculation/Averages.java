package nbpapp.calculation;

import java.util.List;

import nbpapp.json.NBPGson;

public class Averages {
	
	public double average(List<NBPGson> listNBP) {
		return listNBP.stream().mapToDouble(NBPGson::getCena).average().getAsDouble();
		
	}
	
	public double averageLast3Days(List<NBPGson> listNBP) {
		int count = 0;
		double sum = 0;
		if (listNBP.size() < 3) {
			return 0;
		} else {
			for (int i = listNBP.size() - 3; i < listNBP.size(); i++) {
				sum += listNBP.get(i).getCena();
				count++;
			}
		}
		double avarageLast3Days = sum / count;
		return avarageLast3Days;
	}
}
