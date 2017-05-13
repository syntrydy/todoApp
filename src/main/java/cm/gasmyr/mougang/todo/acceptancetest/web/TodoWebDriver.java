package cm.gasmyr.mougang.todo.acceptancetest.web;

public class TodoWebDriver {
	private static TodoWebDriver instance = new TodoWebDriver();

	private TodoWebDriver() {

	}

	public static TodoWebDriver getInstance() {
		return instance;
	}

//	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
//		@Override
//		protected WebDriver initialValue() {
//			return new ChromeDriver();
//		}
//	};
//
//	public WebDriver getDriver() {
//		return driver.get();
//	}
//
//	public void removeDriver() {
//		driver.get().quit();
//		driver.remove();
//	}

}
