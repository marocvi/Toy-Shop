package com.hai.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hai.model.Users.LoginStatus;

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
		return null;
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
		if(user.getLoginStatus().equals(LoginStatus.ACTIVE.toString()))
				return true;
		return false;
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
