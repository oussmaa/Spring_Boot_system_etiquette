package com.example.demo.payload.response;

import java.util.List;

import javax.validation.constraints.Size;

public class JwtResponse {

	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	 private String token;
	  private String type = "Bearer";
	  private Long id;
	  private String username;
	  private String firstName;
	    @Size(max = 20)
	    private String lastName;
	    private String poste;
	    private String equipe;
	  private String email;
	  private String roles;

	private Boolean valid;

	public Boolean isValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	  public JwtResponse(String accessToken, Long id, String username, String firstName, String lastName, String poste,
				String equipe, String email, String roles,String imageUrl,Boolean valid) {
	    this.token = accessToken;
	    this.id = id;
	    this.username = username;
	    this.firstName = firstName;
		this.lastName = lastName;
		this.poste = poste;
		this.equipe = equipe;
	    this.email = email;
	    this.roles = roles;
		this.imageUrl=imageUrl;
		this.valid=valid;
	  }

	  public String getAccessToken() {
	    return token;
	  }

	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }

	  public String getTokenType() {
	    return type;
	  }

	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public  String  getRoles() {
	    return roles;
	  }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	  
}
