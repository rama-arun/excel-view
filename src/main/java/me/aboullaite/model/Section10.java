package me.aboullaite.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "section10")
public class Section10 {

	private String user;
	private String pname;
	private String bpname;
	private String coverage;
	private String death;
	private String issuedate;
	private String client;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getBpname() {
		return bpname;
	}

	public void setBpname(String bpname) {
		this.bpname = bpname;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getDeath() {
		return death;
	}

	public void setDeath(String death) {
		this.death = death;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

}
