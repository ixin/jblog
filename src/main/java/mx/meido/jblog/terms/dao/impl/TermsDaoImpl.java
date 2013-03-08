package mx.meido.jblog.terms.dao.impl;

import java.util.List;

import mx.meido.jblog.terms.dao.TermsDao;
import mx.meido.jblog.terms.model.Terms;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("termsDao")
public class TermsDaoImpl extends JdbcDaoSupport implements TermsDao {

	public int saveTerms(Terms terms) {
		String sql = "insert into terms(terms_name, terms_summary, terms_parent_id, terms_type) values(?, ?, ?, ?) ";
		Object[] obj = new Object[4];
		obj[0] = terms.getTermsName();
		obj[1] = terms.getTermsSummary();
		obj[2] = terms.getTermsPid();
		obj[3] = terms.getTermsType();
		return this.getJdbcTemplate().update(sql, obj); 
	}

	public List getTerms(int fromResultCount, int resultCountPerPage,
			String type) {
		StringBuffer sb = new StringBuffer("select * from terms where terms_type = ? ");
		int params = 1;
		if(resultCountPerPage  > 0){
			sb.append(" LIMIT ? OFFSET ? ");
			params = params + 2;
		}
		Object[] obj = new Object[params];
		int pp = 0;
		obj[pp++] = type;
		if(resultCountPerPage  > 0){
			obj[pp++] = resultCountPerPage;
			obj[pp++] = fromResultCount;
		}
		return this.getJdbcTemplate().queryForList(sb.toString(), obj);
	}

	public int getTermsCount(String type) {
		String sql = "select count(*) from terms where terms_type = ? ";
		return this.getJdbcTemplate().queryForInt(sql, type);
	}
	

}
