package com.hai.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user ;
	public MyUserDetails(Users user) {
		this.user = user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<UserRole> userRoles = user.getRoles();
		List<Role> roles = new ArrayList<>();
		for (UserRole userRole : userRoles) {
			roles.add(userRole.getRole());
		}
		return roles;
	}

	@Override
	public String getPassword() {
		
		return user.getPasswords();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(user.getLoginStatus().equals("BAN"))
				return false;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(user.getLoginStatus().equals("ACTIVE"))
			return true;
		return false;
	}

}
