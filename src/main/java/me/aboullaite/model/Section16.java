package me.aboullaite.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "section16")
public class Section16 {

	private String user;
	private String accttype;
	private String acctname;
	private String total;
	private String ipy;
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

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getIpy() {
		return ipy;
	}

	public void setIpy(String ipy) {
		this.ipy = ipy;
	}

}
