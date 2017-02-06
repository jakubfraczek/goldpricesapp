package nbpapp.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import nbpapp.json.NBPGson;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

public interface NBPService {
	public static final int LONGEST_PERIOT_IN_DAYS = 367;
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_DATE;
	@GET("cenyzlota/last/{topCount}")
	@Headers("Accept: application/json")
	Observable<List<NBPGson>> listRepos(@Path("topCount") int topCount);
	
	@GET("cenyzlota/last/{startDate}/{endDate}")
	@Headers("Accept: application/json")
	Observable<List<NBPGson>> listRepos(@Path("startDate") LocalDate startDate, @Path("endDate") LocalDate endDate);
	
}
