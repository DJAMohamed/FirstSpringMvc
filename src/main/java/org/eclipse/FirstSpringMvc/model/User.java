package org.eclipse.FirstSpringMvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String userName;
	private String password;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long num, String userName, String password, List<Role> roles) {
		super();
		this.num = num;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
// + getters & setters + addRole & removeRole
}