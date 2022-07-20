package com.example.demo.Security.Services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	private String username;
	 private String firstName;
	 private String lastName;
	 private String poste;
	private String equipe;
	private String email;
	private String roles;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	public UserDetailsImpl(Long id, String username, String firstName, String lastName, String poste,
			String equipe, String email, String password,
			String roles,String imageUrl) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.poste = poste;
		this.equipe = equipe;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.imageUrl=imageUrl;
	}
	public static UserDetailsImpl build(User user) {

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getFirstName(),
				user.getLastName(),
				user.getEquipe(),
				user.getPoste(),
				user.getEmail(),
				user.getPassword(), 
				user.getRoles(),user.getImageUrl());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getPoste() {
		return poste;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getEquipe() {
		return equipe;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}
