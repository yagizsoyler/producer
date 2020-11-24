package org.interview.kafein.producer.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Embedded.Nullable;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user")
public class User {

	@PrimaryKey
	private Integer id;
	@Column("name")
	private String name;
	@Column("surname")
	private String surname;
	@Column("followerlist")
	private List<Integer> followerList;
	@Nullable
	@Column("createdat")
	private Date createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Integer> getFollowerList() {
		return followerList;
	}	

	public void setFollowerList(List<Integer> followerList) {
		this.followerList = followerList;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
