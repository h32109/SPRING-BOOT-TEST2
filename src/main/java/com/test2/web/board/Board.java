package com.test2.web.board;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.test2.web.person.Person;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
@Table(name = "BOARD")
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@NotNull @Column(name = "BRDNUM", length = 6) private String brdnum;
		@NotNull @Column(name = "BRDDATE", length = 8) private String brddate;
		@NotNull @Column(name = "TITLE", length = 100) private String title;
		@NotNull @Column(name = "CNUM", length = 4) private String cnum;
		@NotNull @Column(name = "PNUM", length = 6) private String pnum;
		@NotNull @Column(name = "CONTENT", length = 3000) private String content;
		@Column(name = "URL1", length = 200, nullable = true) private String url1;
		@Column(name = "URL2", length = 200, nullable = true) private String url2;
		@Column(name = "URL3", length = 200, nullable = true) private String url3;
		@Column(name = "URL4", length = 200, nullable = true) private String url4;
		@Column(name = "URL5", length = 200, nullable = true) private String url5;
		@Temporal(TemporalType.DATE)
		@Column(name = "REGDATE", nullable=false) private Date regdate;
		
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "userid")
	    private Person personid;
		
		@Builder
		private Board( String brddate,  String title,  String cnum,  String pnum,
				 String content, String url1, String url2, String url3, String url4, String url5,
				Date regdate) {
			Assert.hasText(brddate, "brddate must not be empty");
		    Assert.hasText(title, "title must not be empty");
		    Assert.hasText(cnum, "cnum must not be empty");
		    Assert.hasText(pnum, "pnum must not be empty");
		    Assert.hasText(content, "content must not be empty");
			this.brddate = brddate;
			this.title = title;
			this.cnum = cnum;
			this.pnum = pnum;
			this.content = content;
			this.url1 = url1;
			this.url2 = url2;
			this.url3 = url3;
			this.url4 = url4;
			this.url5 = url5;
			this.regdate = regdate;
		}

}
