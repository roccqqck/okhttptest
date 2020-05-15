package okhttptest;

public class LoopSleep {

	public static void main(String[] args) {

		while (1 > 0) {
			System.out.println("我的測試：my test");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
				e.printStackTrace();
			}
		}
	}

}