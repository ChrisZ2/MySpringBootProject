package com.chrisspringboot.demo.Domin.Model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@CompoundIndex(def = "{'isAdmin':1, 'timeCreated':1}")
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
    private boolean isAdmin;
    @NotNull
    private Date timeCreated;
    public User(String userName, String firstName, String lastName,
			String userEmail, String userPassWord, boolean isAdmin,
			Date timeCreated) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userPassWord = userPassWord;
		this.isAdmin = isAdmin;
		this.timeCreated = timeCreated;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User() {

    }

    @Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userEmail=" + userEmail
				+ ", userPassWord=" + userPassWord + ", isAdmin=" + isAdmin
				+ ", timeCreated=" + timeCreated + "]";
	}

    public String getUserEmail() {
        return userEmail;
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
