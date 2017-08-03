package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.dao.idao.ILoginRegistryDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.dao.util.HibernateMySQLSessionFactory;
import com.company.dao.util.MySQLSessionFactory;

import oracle.net.aso.l;

public class DaoLoginRegistryImpl implements ILoginRegistryDao {

	@Override
	public void registry(Login login, Detail detail) throws Exception {
		/*
		 * Connection con = MySQLSessionFactory.getInstance().getSession(); String sql1
		 * = "INSERT INTO t_login (username,userpwd) VALUES (?,?)"; String sql2 =
		 * "INSERT INTO t_detail (realname,balance) VALUES (?,?)";
		 * con.setAutoCommit(false); PreparedStatement ps1 = null; PreparedStatement ps2
		 * = null; try { ps1 = con.prepareStatement(sql1); ps1.setString(1,
		 * login.getUsername()); ps1.setString(2, login.getUserpwd()); ps2 =
		 * con.prepareStatement(sql2); ps2.setString(1, detail.getRealname());
		 * ps2.setDouble(2, detail.getBalance()); ps1.executeUpdate();
		 * ps2.executeUpdate(); con.commit(); } catch (Exception e) { con.rollback();
		 * throw e; } finally { MySQLSessionFactory.close(null, ps2, null);
		 * MySQLSessionFactory.close(null, ps1, con); }
		 */
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.save(login);
		session.save(detail);
		trans.commit();
		HibernateMySQLSessionFactory.close();
	}

	@Override
	public Login login(Login login) throws Exception {
		/*
		 * Connection con = MySQLSessionFactory.getInstance().getSession(); String sql =
		 * "SELECT userid,username,userpwd FROM t_login WHERE username=? AND userpwd=?";
		 * PreparedStatement ps = con.prepareStatement(sql); ps.setString(1,
		 * login.getUsername()); ps.setString(2, login.getUserpwd()); ResultSet rs =
		 * ps.executeQuery(); Login result = null; while(rs.next()) { result = new
		 * Login(rs.getString(2),rs.getString(3)); result.setUserid(rs.getInt(1)); }
		 * return result;
		 */
		Session session = HibernateMySQLSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Login result = null;
		result = (Login) session.createQuery("from Login where username=:username and userpwd=:userpwd")
				.setParameter("username", login.getUsername()).setParameter("userpwd", login.getUserpwd())
				.uniqueResult();
		trans.commit();
		HibernateMySQLSessionFactory.close();
		return result;
	}

}
