package com.test2.web.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	public Person findByUseridAndPasswd(String userid, String passwd);
	public Person findByUserid(String userid);
	@Query(value = "select *\r\n" + 
			"from person as p1, \r\n" + 
			"(select hak, max(score) as max_score from person group by hak) as p2 \r\n" + 
			"where p1.score = p2.max_score and p1.id = p1.id AND role = 'STUDENT'\r\n" + 
			"GROUP BY p1.hak", nativeQuery = true)
	public Iterable<Person> findGroubByHak();
	public List<Person> findByRole(String role);
}
