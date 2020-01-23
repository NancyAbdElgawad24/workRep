package ae.etisalat.spring.boot.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.etisalat.core.utils.GeneralException;
import com.etisalat.core.utils.HibernateUtil;
import com.etisalat.core.utils.LogUtil;

@SpringBootApplication(scanBasePackages = { "ae.etisalat.assignment" })
public class SpringBootAssignmentApplication {

	public static void main(String[] args) {
		try {
			LogUtil.initialize();

			HibernateUtil.initialize();
		} catch (GeneralException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Seeeeesaaaaaaaaa");
		SpringApplication.run(SpringBootAssignmentApplication.class, args);
	}

}
