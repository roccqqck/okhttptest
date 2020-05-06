package okhttptest;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ReqRes implements ReqResInterface {

	public void sendJson() {
		System.out.println("sendjson");

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		
		MediaType mediaType = MediaType.parse("application/json,application/json"); // json or x-www-form-urlencoded
		
//		parameters
		RequestBody body = RequestBody.create(mediaType, "{\n\t\"name\" : \"morpheu\",\n\t\"job\" : \"leader\" \n}");
		
		Request request = new Request.Builder()
				.url("https://reqres.in/api/users/") // api url
				.method("POST", body)                // POST or GET 
				.addHeader("Content-Type", "application/json") // json or x-www-form-urlencoded
				.addHeader("Content-Type", "application/json")
				.addHeader("Cookie", "__cfduid=d9c539dffed97714f815f403e49dab5681588643565")
				.build();

		try {
			Response response = client.newCall(request).execute();
		} catch (IOException e) {
			System.out.println("catch sendJson ");
			e.printStackTrace();
		}
	}

	public void sendUrlencoded() {
		System.out.println("sendurlencoded");

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded ,application/x-www-form-urlencoded");
		
//		parameters
		RequestBody body = RequestBody.create(mediaType, "name=morpheu&job=leader");
		
		Request request = new Request.Builder()
				.url("https://reqres.in/api/users/")
				.method("POST", body)
				.addHeader("Content-Type", "application/x-www-form-urlencoded ")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("Cookie", "__cfduid=d9c539dffed97714f815f403e49dab5681588643565")
				.build();

		try {
			Response response = client.newCall(request).execute();
		} catch (IOException e) {
			System.out.println("catch sendUrlencoded ");
			e.printStackTrace();
		}

	}

}
