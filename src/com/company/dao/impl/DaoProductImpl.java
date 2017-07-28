package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;
import com.company.dao.util.SessionFactory;

public class DaoProductImpl implements IProductDao {

	@Override
	public void save(Product t) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "INSERT INTO t_product (pname,ean,price) VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,t.getPname());
		ps.setString(2,t.getEan());
		ps.setDouble(3, t.getPrice());
		ps.executeUpdate();
		SessionFactory.close(null, ps, con);
	}

	@Override
	public void update(Product t) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "UPDATE t_product SET pname = ?,ean = ?,price = ? WHERE pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,t.getPname());
		ps.setString(2,t.getEan());
		ps.setDouble(3, t.getPrice());
		ps.setInt(4, t.getPid());
		ps.executeUpdate();
		SessionFactory.close(null, ps, con);
	}

	@Override
	public void delete(Product t) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "DELETE FROM t_product WHERE empno = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getPid());
		ps.executeUpdate();
		SessionFactory.close(null, ps, con);
	}

	@Override
	public List<Product> findAll() throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "SELECT pid,pname,ean,price FROM t_product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while(rs.next()){
			Product product = new Product(rs.getString(2),rs.getString(3),rs.getDouble(4));
			product.setPid(rs.getInt(1));
			productList.add(product);
		}
		return productList;
	}

	@Override
	public Product findById(Integer k) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "SELECT pid,pname,ean,price FROM t_product WHERE pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Product product = null;
		while(rs.next()){
			product = new Product(rs.getString(2),rs.getString(3),rs.getDouble(4));
			product.setPid(rs.getInt(1));
		}
		return product;
	}

	@Override
	public List<Product> findByName(String pname) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
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
		return productList;
	}

	@Override
	public List<Product> findByPage(int page, int size) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
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
		return productList;
	}

}
