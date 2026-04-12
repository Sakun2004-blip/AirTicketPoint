package lk.ijse.cmjd112.AirTicketPoint;

import lk.ijse.cmjd112.AirTicketPoint.controller.HealthwithTestAction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirTicketPointApplicationTests {

	@Test
	void contextLoads() {
		new HealthwithTestAction().healthTest();

	}




}
