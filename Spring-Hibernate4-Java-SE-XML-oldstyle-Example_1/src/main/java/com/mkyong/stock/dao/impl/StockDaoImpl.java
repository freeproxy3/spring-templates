package com.mkyong.stock.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.stock.dao.StockDao;
import com.mkyong.stock.model.Stock;

@Transactional
public class StockDaoImpl extends HibernateDaoSupport implements StockDao{
	
	
	public void save(Stock stock){
		System.out.println("Richard is debuging Java SE with Hibernate:=========" + getHibernateTemplate().getSessionFactory());
		// getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(stock);
	}
	
	public void update(Stock stock){
		getHibernateTemplate().update(stock);
	}
	
	public void delete(Stock stock){
		getHibernateTemplate().delete(stock);
	}
	
	public Stock findByStockCode(String stockCode){
		List list = getHibernateTemplate().find("from Stock where stockCode=?",stockCode);
		return (Stock)list.get(0);
	}

}
