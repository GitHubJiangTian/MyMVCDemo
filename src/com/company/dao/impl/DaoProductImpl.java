package com.company.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;
import com.company.dao.util.HibernateMySQLSessionFactory;

import oracle.net.aso.r;

public class DaoProductImpl implements IProductDao {

	@Override
	public void save(Product t) throws Exception {
		/*Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "INSERT INTO t_product (pname,ean,price) VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,t.getPname());
		ps.setString(2,t.getEan());
		ps.setDouble(3, t.getPrice());
		ps.executeUpdate();
		MySQLSessionFactory.close(null, ps, con);*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		HibernateMySQLSessionFactory.close();
	}

	@Override
	public void update(Product t) throws Exception {
	/*	Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "UPDATE t_product SET pname = ?,ean = ?,price = ? WHERE pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,t.getPname());
		ps.setString(2,t.getEan());
		ps.setDouble(3, t.getPrice());
		ps.setInt(4, t.getPid());
		ps.executeUpdate();
		MySQLSessionFactory.close(null, ps, con);*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		HibernateMySQLSessionFactory.close();
	}

	@Override
	public void delete(Product t) throws Exception {
		/*Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "DELETE FROM t_product WHERE pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getPid());
		ps.executeUpdate();
		MySQLSessionFactory.close(null, ps, con);*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		HibernateMySQLSessionFactory.close();
	}

	@Override
	public List<Product> findAll() throws Exception {
	/*	Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "SELECT pid,pname,ean,price FROM t_product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while(rs.next()){
			Product product = new Product(rs.getString(2),rs.getString(3),rs.getDouble(4));
			product.setPid(rs.getInt(1));
			productList.add(product);
		}
		return productList;*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Product> productList = null;
		//因为是正向工程，所以“from Product”中的Product不是数据库中的表名为Product表，而是自己pojo对应的实体累的名字
		productList = session.createQuery("from Product").list();
		trans.commit();
		HibernateMySQLSessionFactory.close();
		return productList;
	}

	@Override
	public Product findById(Integer k) throws Exception {
	/*	Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "SELECT pid,pname,ean,price FROM t_product WHERE pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Product product = null;
		while(rs.next()){
			product = new Product(rs.getString(2),rs.getString(3),rs.getDouble(4));
			product.setPid(rs.getInt(1));
		}
		return product;*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Product p = null;
		p = (Product) session.createQuery("from Product where pid=:pid").setParameter("pid",k).uniqueResult();
		trans.commit();
		HibernateMySQLSessionFactory.close();
		return p;
	}

	@Override
	public List<Product> findByName(String pname) throws Exception {
	/*	Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "SELECT pid,pname,ean,price FROM t_product WHERE pname like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+pname+"%");
		ResultSet rs = ps.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while(rs.next()){
			Product product = new Product(rs.getString(2),rs.getString(3),rs.getDouble(4));
			product.setPid(rs.getInt(1));
			productList.add(product);
		}
		return productList;*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Product> productList = null;
		productList = session.createQuery("from Product where pname like :pname").setParameter("pname", "%"+pname+"%").list();
		trans.commit();
		HibernateMySQLSessionFactory.close();
		return productList;
	}

	@Override
	public List<Product> findByPage(int page, int size) throws Exception {
		/*Connection con = MySQLSessionFactory.getInstance().getSession();
		String sql = "SELECT pid,pname,ean,price FROM t_product LIMIT ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page - 1) * size);
		ps.setInt(2, size);
		ResultSet rs = ps.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while(rs.next()){
			Product product = new Product(rs.getString(2),rs.getString(3),rs.getDouble(4));
			product.setPid(rs.getInt(1));
			productList.add(product);
		}
		return productList;*/
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Product> productList = null;
		productList = session.createQuery("feom Product").setFirstResult((page - 1) * size).setMaxResults(size).list();
		trans.commit();
		HibernateMySQLSessionFactory.close();
		return productList;
	}

}
