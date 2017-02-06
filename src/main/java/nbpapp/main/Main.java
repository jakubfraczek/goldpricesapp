package nbpapp.main;

import java.io.IOException;
import java.util.List;

import nbpapp.UserComunication.ConsoleComunication;
import nbpapp.json.NBPGson;
import nbpapp.web.ServiceAnswerHendler;
import nbpapp.web.QueryCreation;
import rx.Observable;

public class Main {

	public static void main(String[] args) throws IOException {
		final String BASE_URL = "http://api.nbp.pl/api/";
		int daysRange = ConsoleComunication.getDaysRange();
		
		QueryCreation urlCreation = new QueryCreation();
		
		Observable<List<NBPGson>> callToServer = urlCreation.urlCreation(BASE_URL, daysRange);
		callToServer.toBlocking().subscribe(new ServiceAnswerHendler());


	}

	

}
