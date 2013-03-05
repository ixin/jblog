package mx.meido.jblog.terms.service;

import java.util.List;

import mx.meido.jblog.terms.model.Terms;

public interface TermsService {
	public int saveTerms(Terms terms);
	/**
	 * 获取 分类文章
	 * @param fromResultCount
	 * @param resultCountPerPage
	 * @return
	 */
	public List getCategoryTerms(int fromResultCount, int resultCountPerPage);
	public int getCategoryTermsCount();
	/**
	 * 获取 标签
	 * @param fromResultCount
	 * @param resultCountPerPage
	 * @return
	 */
	public List getTagTerms(int fromResultCount, int resultCountPerPage);
	public int getTagTermsCount();
	
	public int saveCategoryTerms(Terms terms);
	
	public int saveTagTerms(Terms terms);
	
	public List getAllCategoryTerms();
	
	public List getAllTagTerms();
}
