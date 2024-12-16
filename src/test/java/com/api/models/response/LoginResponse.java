package com.api.models.response;

import java.util.List;

public class LoginResponse {
	private String token;
	private String type;
	private String username;
	private Integer id;
	private String email;
	private List<String> roles;
	
	

	
	
	public LoginResponse() {
		
	}

	public LoginResponse(String token, String type, Integer id, String email, List<String> roles) {
		super();
		this.token = token;
		this.type = type;
		this.id = id;
		this.username=username;
		this.email = email;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", type=" + type + ", id=" + id + ",username="+username+", email=" + email + ", roles=" + roles
				+ "]";
	}


}
