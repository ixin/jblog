package mx.meido.jblog.terms.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Terms implements Serializable {
	private BigInteger termsId;
	private String termsName;
	private String termsSummary;
	private BigInteger termsPid;
	private String termsType;
  
	public BigInteger getTermsId() {
		return termsId;
	}

	public void setTermsId(BigInteger termsId) {
		this.termsId = termsId;
	}

	public String getTermsName() {
		return termsName;
	}

	public void setTermsName(String termsName) {
		this.termsName = termsName;
	}

	public String getTermsSummary() {
		return termsSummary;
	}

	public void setTermsSummary(String termsSummary) {
		this.termsSummary = termsSummary;
	}

	public BigInteger getTermsPid() {
		return termsPid;
	}

	public void setTermsPid(BigInteger termsPid) {
		this.termsPid = termsPid;
	}

	public String getTermsType() {
		return termsType;
	}

	public void setTermsType(String termsType) {
		this.termsType = termsType;
	}

	public Terms(BigInteger termsId, String termsName, String termsSummary,
			BigInteger termsPid, String termsType) {
		super();
		this.termsId = termsId;
		this.termsName = termsName;
		this.termsSummary = termsSummary;
		this.termsPid = termsPid;
		this.termsType = termsType;
	}

	public Terms() {
		super();
	}

}
