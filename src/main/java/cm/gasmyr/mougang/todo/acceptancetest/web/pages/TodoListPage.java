package cm.gasmyr.mougang.todo.acceptancetest.web.pages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*@Component
@ConfigurationProperties(prefix = "landingpage")*/
public class TodoListPage extends TodoPage {

	/**
	 * 
	 */

	@Value("${app.baseurl}")
	private String baseurl;
	
	public TodoListPage gotoListPage(){
//		 navigate("http://localhost:8080");
//		 clickId("button");
		 return this;
	}

}
