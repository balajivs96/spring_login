package com.example.security.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.example.security.api.RelationshipConstants;

@Entity
@Table(name = "cities")
public class City implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="code")
	private String code;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name = RelationshipConstants.STATE_ID)
	private State state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", name=" + name + ", state=" + state + "]";
	}

}
