package bitjava.year2016.day02;

class App {
	public void logo() {
		app_run();
		System.out.println("logo()");
	}

	public void app_run() {
		app_exit();
		System.out.println("app_run()");
	}

	public void app_exit() {
		System.out.println("app_exit()");
	}
}

public class function {

	public static void main(String[] args) {
		App a = new App();
		a.logo();

	}

}
