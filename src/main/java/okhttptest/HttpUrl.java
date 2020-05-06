package okhttptest;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class HttpUrl {

	public void sendTeammate(String send_text) throws IOException {

//      ----------------------------------------------------------------------------------
		System.out.println("--------------try HttpURLConnection post--------------");
//		建置與對方服務的連線。
//		URL url = new URL("http://10.14.88.149/API/IMservice.ashx?ask=sendChatMessage");
		URL url = new URL("https://reqres.in/api/users");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

//		setRequestMethod("POST"): 設置傳送方式為 POST 或 GET
//		con.setRequestMethod("GET");
		con.setRequestMethod("POST");

		con.setDoInput(true);
		con.setDoOutput(true);
//		setRequestProperty: 設置傳送時封包 Header 所帶的參數，這邊是指取得的物件是 JSON
		con.setRequestProperty("Content-Type", "application/json");
//		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//
//		String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";
//
//		api function parameters
//		String urlParameters  = "param1=a&param2=b&param3=c";
		String POST_PARAMS = "account=mary5566&" + "api_key=qwertyuiop&" + "chat_sn=517&" + "content_type=1&"
				+ "msg_content=" + send_text;

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes("UTF-8"));
		os.flush();
		os.close();
		// For POST only - END
		System.out.println("sending ReadPush.sendTeammate");

//				String query = "question";
////		      下面四行 則是設置傳送的資料格式為 UTF-8		
//				DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
//				outputStream.write(query.toString().getBytes("UTF-8"));
//				outputStream.flush();
//				outputStream.close();

////		      下面是取得對方服務的回傳結果。
//		        InputStreamReader isr = new InputStreamReader(con.getInputStream()); 
//		        BufferedReader br = new BufferedReader(isr);
//		        String line = "";
//		        while( (line = br.readLine()) != null ) {
////		        	response.append(Line.trim());
//		            System.out.println(line.toString());
//		        }

	}

	public static void main(String[] args) throws IOException {

		// read text file to string
		System.out.println("-----------read text file to string-----------");
		String fileString = new String(Files.readAllBytes(Paths.get("pom.xml")));
		System.out.println(fileString);

		System.out.println("--------------json like string--------------");
		// json like string
		String json1 = "{\"api_key\": akjdfkljasdhfklsaf}";

		System.out.println(json1);

		System.out.println("---------------json object-------------");
		// json object
		JSONObject jo = new JSONObject();
		jo.put("name", "jon doe");
		jo.put("age", "22");
		jo.put("city", "chicago");
		System.out.println(jo);

		System.out.println("--------------put text file string into json--------------");
		// put text file string into json
		JSONObject param = new JSONObject();
		param.put("account", "marry5566");
		param.put("api_key", "qwertyuiop");
		param.put("content_type", "1");
		// put here
		param.put("msg_content", fileString);

		System.out.println(param);

		String send_text="abc";
//		call自己class的methed
		HttpUrl s = new HttpUrl(); 
		s.sendTeammate(send_text);
		
	}

}