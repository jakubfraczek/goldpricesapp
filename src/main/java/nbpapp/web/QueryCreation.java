package nbpapp.web;

import java.util.List;

import nbpapp.json.NBPGson;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class QueryCreation {

	public Observable<List<NBPGson>> urlCreation(String baseURL, int daysRange) {
		Retrofit retrofit = retrofitBuilder(baseURL);
		NBPService service = retrofit.create(NBPService.class);

		return service.listRepos(daysRange);
	}

	private Retrofit retrofitBuilder(final String BASE_URL) {
		return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
	}

}
