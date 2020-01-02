package com.test2.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class PersonInit implements ApplicationRunner{
	private PersonRepository personRepository;
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public PersonInit(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepository.count();
		if(count==0) {
		Person person = null;
		String randate = "", realpass = "", role="";
		int password = 0, persons = 0;
		boolean gender = false;
		String[][] mtx = {{"hong"},
				{"kim"},
				{"park"},
				{"you"},
				{"kimjava"},
				{"leejimi"},
				{"cola"},
				{"cider"},
				{"nam"},
				{"python"},
				{"cow"},
				{"dog"},
				{"man"},
				{"woman"},
				{"person"},
				{"league"},
				{"legend"},
				{"car"},
				{"jong"},
				{"won"},
				{"hnas"},
				{"rihanna"},
				{"clock"},
				{"horse"},
				{"ice"},
				{"rapper"},
				{"dancer"},
				{"singer"},
				{"java"},
				{"kwan"}
				};
		for(String[] arr : mtx) {
			randate = String.format("%d-%d-%d", (int)(Math.random()*2000)+1,(int)(Math.random()*12)+1,(int)(Math.random()*30)+1);
			password = (int)(Math.random()*2)+1;
			gender = (password==1)?true:false;
			realpass = String.valueOf(password);
			role = (persons==0) ? "TEACHER" : (persons==1 || persons==2) ? "MANAGER" : "STUDENT";
			person = new Person();
			person.setUserid(arr[0]);
			person.setPasswd(realpass);
			person.setName(arr[0].toUpperCase());
			person.setBirthday(randate);
			person.setMale(gender);
			if(role!="STUDENT") {
				person.setHak(0);
				person.setBan(0);
				person.setScore(0);
			}else {
			person.setHak((int)(Math.random()*5)+1);
			person.setBan((int)(Math.random()*5)+1);
			person.setScore((int)(Math.random()*100)+1);
			}
			person.setRole(role);
			personRepository.save(person);
			persons++;
		}
	  }
	}
}
