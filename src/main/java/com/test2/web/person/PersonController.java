package com.test2.web.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test2.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PersonService personService;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+" "));
		return sb.toString();
	}
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody Person person) {
		HashMap<String, Object> map = new HashMap<>();
		person = personRepository.findByUseridAndPasswd(
				person.getUserid(), 
				person.getPasswd());
		if(person != null) {
			map.put("person", person);
			map.put("result", "True");
		}else {
			map.put("person", person);
			map.put("result", "False");
		}
		System.out.println(map);
		return map;
	}
	
	@PostMapping("/join")
	public HashMap<String, Object> join(@RequestBody Person person){
		HashMap<String, Object> map = new HashMap<>();
		Person param = personRepository.findByUserid(person.getUserid());
		if(param != null) {
			map.put("result", "FAIL");
		}else {
			personRepository.save(person);
			map.put("result", "SUCCESS");
			map.put("person", person);
		}
		return map;
	}
	
	@DeleteMapping("/withdrawal/{userid}")
	public String withdrawal(@PathVariable String userid) {
		personRepository.delete(personRepository.findByUserid(userid));
		return "SUCCESS";
	}
	
	
	@PatchMapping("/reregist")
	public HashMap<String, Object> reregist(@RequestBody Person person) {
		HashMap<String, Object> map = new HashMap<>();
		Person target = personRepository.findByUserid(person.getUserid());
		if(person.getScore()!=0) {
			target.setScore(person.getScore());
		}
		if(person.getPasswd()!=null) {
			target.setPasswd(person.getPasswd());
		}
		personRepository.save(target);
		map.put("person", target);
		return map;
	}
	
	@GetMapping("/students")
	public Stream<Person> list(){
		Iterable<Person> entites = personRepository.findAll();
		List<Person> list = new ArrayList<>();
		for(Person entity : entites) {
			Person dto = modelMapper.map(entity, Person.class);
			list.add(dto);
		}
		return list.stream().filter(d->d.getRole().equals("STUDENT"));
	}
	@GetMapping("/students/search/{searchWord}")
	public Stream<Person> findSome(@PathVariable String searchWord){
		printer.accept("넘어온 검색어: "+searchWord);
		List<Person> personDTOs = new ArrayList<>();
		List<Person> persons = new ArrayList<>();;
		String switchKey = "";
		switch(searchWord) {
			case "namesOfStudents" :break;
			case "streamToArray" :break;
			case "streamToMap" :break;
			case "theNumberOfStudents" :break;
			case "totalScore" :break;
			case "topStudent" :break;
			case "getStat" :break;
			case "nameList" :break;
			case "남학생목록":  case "여학생목록":
				switchKey = (searchWord=="남") ? "partioningByMale" : "partioningByFemale";
				break;
			case "partioningCountPerGender" :break;
			case "partioningTopPerGender" :break;
			case "partioningRejectPerGender" :break;
			case "groupingByBan" :break;
			case "groupingByGrade" :break;
			case "groupingByCountByLevel" :break;
			case "3학년목록" :
				switchKey = "groupingByHak";
				break;
			case "groupingByHakAndBan" :break;
			case "groupingTopByHakAndBan" :break;
			case "groupingByStat" :break;
		}
		switch(switchKey) {
			case "namesOfStudents" :break;
			case "streamToArray" :break;
			case "streamToMap" :break;
			case "theNumberOfStudents" :break;
			case "totalScore" :break;
			case "topStudent" :break;
			case "getStat" :break;
			case "nameList" :break;
			case "partioningByMale" :
				persons = personService.partioningByGender(true);
				break;
			case "partioningCountPerGender" :break;
			case "partioningTopPerGender" :break;
			case "partioningRejectPerGender" :break;
			case "groupingByBan" :break;
			case "groupingByGrade" :break;
			case "groupingByCountByLevel" :break;
			case "groupingByHakAndBan" :break;
			case "groupingTopByHakAndBan" :break;
			case "groupingByStat" :break;
			case "groupingByHak" :
				Iterable<Person> entites =  personRepository.findGroubByHak();
				personDTOs = new ArrayList<>();
				for(Person p: entites) {
					Person dto = modelMapper.map(p, Person.class);
					personDTOs.add(dto);
				}
				
				
		}
		return personDTOs.stream()
				.filter(role-> role.getRole().equals("student"));
		
	}

}
