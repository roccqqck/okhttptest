package okhttptest;

public class Main {

	public static void main(String[] args) {
		System.out.println("main");
		
		ReqRes r = new ReqRes();
		r.sendJson();
		r.sendUrlencoded();
	}

}
