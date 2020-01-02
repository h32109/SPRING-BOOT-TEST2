package com.test2.web.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.test2.web.board.Board;
import com.test2.web.proxy.Proxy;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component // 어노테이션 순서가 중요하다.
@Entity
@Table(name = "PERSON")
@Getter
@Setter(AccessLevel.PROTECTED) // 안전하게 만들기 위해 프로텍티드
@NoArgsConstructor(access = AccessLevel.PUBLIC) // 퍼블릭으로 디폴트 생성자 생성
@ToString // 투스트링



public class Person extends Proxy implements Serializable{

	private static final long serialVersionUID = 1L; // DTO로 날리기 위해 직렬화 하기
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull @Column(name = "PERSONID") private Long personid;
	@NotNull @Column(name = "USERID", length = 62) private String userid;
	@NotNull @Column(name = "PASSWD", length = 62) private String passwd;
	@NotNull @Column(name = "NAME", length = 62) private String name;
	@NotNull @Column(name = "BIRTHDAY",length = 50) private String birthday;
	@NotNull @Column(name = "MALE") private boolean male;
	@NotNull @Column(name = "ROLE", length = 10) private String role;
	@Column(name = "HAK") private int ban;
	@Column(name = "BAN") private int hak;
	@Column(name = "SCORE") private int score;
	public enum Level{
		HIGH, MID, LOW;
	}
	
	@OneToMany(mappedBy = "personid",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Board> images = new ArrayList<>();
	
	@Builder
	private Person( String userid,  String passwd,  String name,  String birthday,
			 boolean male,  String role, int ban, int hak, int score) {
		Assert.hasText(userid, "userid must not be empty");
	    Assert.hasText(passwd, "passwd must not be empty");
	    Assert.hasText(name, "name must not be empty");
	    Assert.hasText(birthday, "birthday must not be empty");
	    Assert.hasText(String.valueOf(male), "male must not be empty");
	    Assert.hasText(role, "role must not be empty");
	    Assert.hasText(string(ban), "ban must not be empty");
	    Assert.hasText(String.valueOf(hak), "ban must not be empty");
	    Assert.hasText(String.valueOf(score), "ban must not be empty");
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.birthday = birthday;
		this.male = male;
		this.role = role;
		this.ban = ban;
		this.hak = hak;
		this.score = score;
	}
}
