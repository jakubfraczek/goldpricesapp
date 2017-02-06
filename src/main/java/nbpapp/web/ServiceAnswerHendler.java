package nbpapp.web;

import java.util.List;

import nbpapp.UserComunication.ConsoleComunication;
import nbpapp.UserComunication.FinalFileCreation;
import nbpapp.UserComunication.Messages;
import nbpapp.calculation.Recommendation;
import nbpapp.json.NBPGson;
import rx.Observer;

public class ServiceAnswerHendler implements Observer<List<NBPGson>>{

	@Override
	public void onCompleted() {
		ConsoleComunication.warning();
		System.out.println(Messages.USING_THANKS);
	}

	@Override
	public void onError(Throwable arg0) {
		System.err.println(Messages.SERVER_ERROR);
	}

	@Override
	public void onNext(List<NBPGson> listNBP) {
		Recommendation test = new Recommendation();
		String recommendation = test.recommendation(listNBP);
		ConsoleComunication.recomendationPrintln(recommendation);
		
		FinalFileCreation.fileCreation(listNBP, recommendation);
	}

}
