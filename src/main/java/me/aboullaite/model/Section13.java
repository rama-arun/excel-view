package me.aboullaite.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "section13")
public class Section13 {

	private String user;
	private String policy;
	private String cname;
	private String tcoverage;
	private String contactp;
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

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTcoverage() {
		return tcoverage;
	}

	public void setTcoverage(String tcoverage) {
		this.tcoverage = tcoverage;
	}

	public String getContactp() {
		return contactp;
	}

	public void setContactp(String contactp) {
		this.contactp = contactp;
	}

}
