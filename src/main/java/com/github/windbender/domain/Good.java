package com.github.windbender.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="image_flagged_good")
public class Good {
	public Good(ImageRecord ir, User user2, int good) {
		user = user2;
		image = ir;
		flagged = (good > 0);
	}
	public Good() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	private int id;
	
	@ManyToOne
    @JoinColumn(name="image_id", nullable=true)
	ImageRecord image;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@Column(name="flagged", nullable=false)
	boolean flagged;

	public int getId() {
		return id;
	}
	public ImageRecord getImage() {
		return image;
	}
	public User getUser() {
		return user;
	}
	public boolean isFlagged() {
		return flagged;
	}
	public void setFlagged(boolean flagged2) {
		this.flagged = flagged2;
		
	}
	
	
}
