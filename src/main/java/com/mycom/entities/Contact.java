package com.mycom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	private String secondName;
	private String nickname;
	private String email;
	private String work;
	private String image;
	private String phone;
	@Column(length = 500)
	private String description;

	
	@ManyToOne()
	private User user;


	public Contact(int cid, String name, String secondName, String nickname, String email, String work, String image,
			String phone, String description, User user) {
		super();
		this.cid = cid;
		this.name = name;
		this.secondName = secondName;
		this.nickname = nickname;
		this.email = email;
		this.work = work;
		this.image = image;
		this.phone = phone;
		this.description = description;
		this.user = user;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public Contact(int cid, String name, String nickname, String email, String work, String image, String phone,
			String description, User user) {
		super();
		this.cid = cid;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.work = work;
		this.image = image;
		this.phone = phone;
		this.description = description;
		this.user = user;
	}


	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", name=" + name + ", nickname=" + nickname + ", email=" + email + ", work="
				+ work + ", image=" + image + ", phone=" + phone + ", description=" + description + ", user=" + user
				+ "]";
	}

	
 	
	
	
	
	
	
	
	
	
}
