package com.hai.command;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.hai.model.Product;
import com.hai.validation.Comment;

public class ReviewCommand {

	
	private byte reviewRate;
	@Email
	@NotEmpty(message="{email.notEmpty}")
	private String email;
	@Size(min=3,message="{firstName.size}")
	private String firstName;
	@Size(min=3,message="{lastName.size}")
	private String lastName;
	@Comment(message = "{content.comment}")
	@Size(min=10,message="{content.size}")
	private String content;
	private Product product;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public byte getReviewRate() {
		return reviewRate;
	}

	public void setReviewRate(byte reviewRate) {
		this.reviewRate = reviewRate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ReviewCommand [reviewRate=" + reviewRate + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", content=" + content + "]";
	}
	

}
