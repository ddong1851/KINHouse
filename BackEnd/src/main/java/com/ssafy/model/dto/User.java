package com.ssafy.model.dto;

public class User {
	String id, password, email, name, phone, login_log, register_log;

	public User() {
	};

	public User(String id, String password, String email, String name, String phone, String login_log,
			String register_log) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.login_log = login_log;
		this.register_log = register_log;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public String getLogin_log() {
		return login_log;
	}

	public void setLogin_log(String login_log) {
		this.login_log = login_log;
	}

	public String getRegister_log() {
		return register_log;
	}

	public void setRegister_log(String register_log) {
		this.register_log = register_log;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pass
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", login_log=" + login_log + ", register_log=" + register_log + "]";
	}
	
}
