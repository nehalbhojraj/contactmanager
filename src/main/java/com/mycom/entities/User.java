package com.mycom.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@NotBlank(message = "Please Enter Name!!!")
	@Size(min=2, max=20,message = "min 2 and max 20 character")
	private String name;
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String password;
	@Column(length = 500)
	private String about;
	
	private boolean enabled;
	private String role;
	
	private String imageUrl;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="user",fetch = FetchType.LAZY)
	private List<Contact> contacts =new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImage() {
		return imageUrl;
	}
	public void setImage(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public User(int id, String name, String email, String password, String about, boolean enabled, String role,
			String imageUrl, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.enabled = enabled;
		this.role = role;
		this.imageUrl = imageUrl;
		this.contacts = contacts;
	}
	public User() {
		super();
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ ", enabled=" + enabled + ", role=" + role + ", imageUrl=" + imageUrl + "]";
	}







}
