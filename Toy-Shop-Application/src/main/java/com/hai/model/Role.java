package com.hai.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;


@Entity
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Role_Id")
	private int id;
	private String roleName;
	@OneToMany(mappedBy="user")
	private List<UserRole> users;
	
	//Getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserRole> getUsers() {
		return users;
	}
	public void setUsers(List<UserRole> users) {
		this.users = users;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.roleName;
	}
	
	
	public enum Roles{
		ADMIN,USER,STORE_MANAGER;
	}
	
}
