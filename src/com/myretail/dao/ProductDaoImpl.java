package com.myretail.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myretail.domain.Product;

@SuppressWarnings("unchecked")
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Product> findAllProductsInStock() {

		return getCurrentSession().createQuery(
				"from Product p where p.quantity > 0").list();
	}

	@Override
	@Transactional
	public List<Product> findAllProductsOutOfStock() {

		return getCurrentSession().createQuery(
				"from Product p where p.quantity <= 0").list();
	}

	@Override
	@Transactional
	public List<Product> findAllProducts() {

		return getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional
	public List<Product> searchProductById(String productId) {

		String hql = "from Product p where p.productId=:productId";

		return getCurrentSession().createQuery(hql)
				.setString("productId", productId).list();
	}

	@Override
	@Transactional
	public void add(final Product product) {
		getCurrentSession().saveOrUpdate(product);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
