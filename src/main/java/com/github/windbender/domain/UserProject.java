package com.github.windbender.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="user_project")
public class UserProject implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	Long id;
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	User user;
	
	
	transient Integer idForUser;
	transient Integer idForProject;
	
	@JsonProperty
	public Integer getIdForProject() {
		return idForProject;
	}

	@JsonProperty
	public void setIdForProject(Integer idForProject) {
		this.idForProject = idForProject;
	}

	@JsonProperty
	public void setIdForUser(Integer i) {
		this.idForUser = i;
	}
	
	@JsonProperty
	public Integer getIdForUser() {
		return idForUser;
	}

	@JsonProperty
	public Integer getUserId() {
		return user.getId();
	}
	@JsonProperty
	public String getUsername() {
		return user.getUsername();
	}
	@JsonProperty
	public String getUserEmail() {
		return user.getEmail();
	}
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id")
	Project project;

	@Column(name="canReport", nullable=false)
	private Boolean canReport = true;
	
	@Column(name="canCategorize", nullable=false)
	private Boolean canCategorize = true;
	
	@Column(name="canUpload", nullable=false)
	private Boolean canUpload = true;
	
	@Column(name="canAdmin", nullable=false)
	private Boolean canAdmin = false;
	
	public Boolean getCanReport() {
		return canReport;
	}

	public void setCanReport(Boolean canReport) {
		this.canReport = canReport;
	}

	public Boolean getCanCategorize() {
		return canCategorize;
	}

	public void setCanCategorize(Boolean canCategorize) {
		this.canCategorize = canCategorize;
	}

	public Boolean getCanUpload() {
		return canUpload;
	}

	public void setCanUpload(Boolean canUpload) {
		this.canUpload = canUpload;
	}

	public Boolean getCanAdmin() {
		return canAdmin;
	}

	public void setCanAdmin(Boolean canAdmin) {
		this.canAdmin = canAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
