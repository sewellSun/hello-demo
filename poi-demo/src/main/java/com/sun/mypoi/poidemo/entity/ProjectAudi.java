package com.sun.mypoi.poidemo.entity;

import java.util.Date;

/**
 *@author sunq
 *@date2019/7/29 17:32
 *@Description
 */
public class ProjectAudi {

	public ProjectAudi(String bigArea, String campus, String major, String faceToFaceTeacher, String onlineTeacher,
			String gradeClass, String projectTerm, Integer worksNumber, Date projectCommitTime, Integer projectScore,
			String projectLevel, String reason, String comment, String eclosure) {
		this.bigArea = bigArea;
		this.campus = campus;
		this.major = major;
		this.faceToFaceTeacher = faceToFaceTeacher;
		this.onlineTeacher = onlineTeacher;
		this.gradeClass = gradeClass;
		this.projectTerm = projectTerm;
		this.worksNumber = worksNumber;
		this.projectCommitTime = projectCommitTime;
		this.projectScore = projectScore;
		this.projectLevel = projectLevel;
		this.reason = reason;
		this.comment = comment;
		this.eclosure = eclosure;
	}

	private String bigArea;

	private String campus;

	private String major;

	private String faceToFaceTeacher;

	private String onlineTeacher;

	private String gradeClass;

	private String projectTerm;

	private Integer worksNumber;

	private Date projectCommitTime;

	private Integer projectScore;

	private String projectLevel;

	private String reason;

	private String comment;

	private String eclosure;

	public String getBigArea() {
		return bigArea;
	}

	public void setBigArea(String bigArea) {
		this.bigArea = bigArea;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getFaceToFaceTeacher() {
		return faceToFaceTeacher;
	}

	public void setFaceToFaceTeacher(String faceToFaceTeacher) {
		this.faceToFaceTeacher = faceToFaceTeacher;
	}

	public String getOnlineTeacher() {
		return onlineTeacher;
	}

	public void setOnlineTeacher(String onlineTeacher) {
		this.onlineTeacher = onlineTeacher;
	}

	public String getGradeClass() {
		return gradeClass;
	}

	public void setGradeClass(String gradeClass) {
		this.gradeClass = gradeClass;
	}

	public String getProjectTerm() {
		return projectTerm;
	}

	public void setProjectTerm(String projectTerm) {
		this.projectTerm = projectTerm;
	}

	public Integer getWorksNumber() {
		return worksNumber;
	}

	public void setWorksNumber(Integer worksNumber) {
		this.worksNumber = worksNumber;
	}

	public Date getProjectCommitTime() {
		return projectCommitTime;
	}

	public void setProjectCommitTime(Date projectCommitTime) {
		this.projectCommitTime = projectCommitTime;
	}

	public Integer getProjectScore() {
		return projectScore;
	}

	public void setProjectScore(Integer projectScore) {
		this.projectScore = projectScore;
	}

	public String getProjectLevel() {
		return projectLevel;
	}

	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEclosure() {
		return eclosure;
	}

	public void setEclosure(String eclosure) {
		this.eclosure = eclosure;
	}
}
