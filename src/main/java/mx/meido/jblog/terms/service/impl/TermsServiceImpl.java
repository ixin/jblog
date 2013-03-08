package mx.meido.jblog.terms.service.impl;

import java.util.List;

import mx.meido.jblog.terms.dao.TermsDao;
import mx.meido.jblog.terms.model.Terms;
import mx.meido.jblog.terms.service.TermsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("termsService")
public class TermsServiceImpl implements TermsService {

	@Autowired
	private TermsDao termsDao;
	public int saveTerms(Terms terms) {
		return termsDao.saveTerms(terms);
	}
	public List getCategoryTerms(int fromResultCount, int resultCountPerPage) {
		return termsDao.getTerms(fromResultCount, resultCountPerPage, "category");
	}
	public int getCategoryTermsCount() {
		return termsDao.getTermsCount("category");
	}
	public List getTagTerms(int fromResultCount, int resultCountPerPage) {
		return termsDao.getTerms(fromResultCount, resultCountPerPage, "tag");
	}
	public int getTagTermsCount() {
		return termsDao.getTermsCount("tag");
	}
	public int saveCategoryTerms(Terms terms) {
		terms.setTermsType("category");
		return saveTerms(terms);
	}
	public int saveTagTerms(Terms terms) {
		terms.setTermsType("tag");
		return saveTerms(terms);
	}
	public List getAllCategoryTerms() {
		return getCategoryTerms(0, 0);
	}
	public List getAllTagTerms() {
		return getTagTerms(0, 0);
	}

}
