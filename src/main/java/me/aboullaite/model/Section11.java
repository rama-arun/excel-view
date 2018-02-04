package me.aboullaite.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "section11")
public class Section11 {

	private String user;
	private String pensionSource;
	private String pensionTerms;
	private String deathTerms;
	private String termsOfPeriod;
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

	public String getPensionSource() {
		return pensionSource;
	}

	public void setPensionSource(String pensionSource) {
		this.pensionSource = pensionSource;
	}

	public String getPensionTerms() {
		return pensionTerms;
	}

	public void setPensionTerms(String pensionTerms) {
		this.pensionTerms = pensionTerms;
	}

	public String getDeathTerms() {
		return deathTerms;
	}

	public void setDeathTerms(String deathTerms) {
		this.deathTerms = deathTerms;
	}

	public String getTermsOfPeriod() {
		return termsOfPeriod;
	}

	public void setTermsOfPeriod(String termsOfPeriod) {
		this.termsOfPeriod = termsOfPeriod;
	}

}
