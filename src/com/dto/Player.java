package com.dto;

public class Player {

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", team=" + team + ", age=" + age + "]";
	}

	// creating properties of a player
	private Integer id;
	private String name;
	private String team;
	private Integer age;

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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
