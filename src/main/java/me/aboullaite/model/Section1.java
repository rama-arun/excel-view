package me.aboullaite.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "section1")
public class Section1 {

	public Section1() {
	}

	public Section1(String user, String client, String key, String value) {
		super();
		this.user = user;
		this.client = client;
		this.key = key;
		this.value = value;
	}

	private String user;
	private String key;
	private String value;
	private String client;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClient() {
		return client;
	}

	public void setclient(String client) {
		this.client = client;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }
}
