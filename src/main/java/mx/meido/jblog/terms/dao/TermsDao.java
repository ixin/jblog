package mx.meido.jblog.terms.dao;

import java.util.List;

import mx.meido.jblog.terms.model.Terms;

public interface TermsDao {
	public int saveTerms(Terms terms);
	public List getTerms(int fromResultCount, int resultCountPerPage, String type);
	public int getTermsCount(String type);

}
  