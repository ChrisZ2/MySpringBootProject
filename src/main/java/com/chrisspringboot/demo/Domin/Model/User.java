package com.chrisspringboot.demo.Domin.Model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    @Id
    private String userName;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Indexed
    private String userEmail;
    @NotNull
    private String userPassWord;


    public User() {

    }

    @Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userEmail=" + userEmail
				+ ", userPassWord=" + userPassWord + "]";
	}

    public String getUserEmail() {
        return userEmail;
    }

    public User(String userName, String firstName, String lastName,
			String userEmail, String userPassWord) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userPassWord = userPassWord;
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

	public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
