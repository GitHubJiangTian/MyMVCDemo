package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.dao.util.OracleSessionFactory;

public class DaoEmpImpl implements IEmpDao {

	@Override
	public void save(Emp t) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.setString(2, t.getEname());
		ps.setString(3, t.getJob());
		ps.setInt(4, t.getMgr());
		ps.setString(5, t.getHiredate());
		ps.setDouble(6, t.getSal());
		ps.setDouble(7, t.getComm());
		ps.setInt(8, t.getDeptno());
		ps.executeUpdate();
		OracleSessionFactory.close(null, ps, con);
	}

	@Override
	public void update(Emp t) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "UPDATE emp SET ename=?,job=?,mgr=NVL(?,0),hiredate=to_date(?,'yyyy-MM-dd'),sal=NVL(?,0),comm=NVL(?,0),deptno=NVL(?,0) WHERE empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getEname());
		ps.setString(2, t.getJob());
		ps.setInt(3, t.getMgr());
		ps.setString(4, t.getHiredate());
		ps.setDouble(5, t.getSal());
		ps.setDouble(6, t.getComm());
		ps.setInt(7, t.getDeptno());
		ps.setInt(8, t.getEmpno());
		ps.executeUpdate();
		OracleSessionFactory.close(null, ps, con);
	}

	@Override
	public void delete(Emp t) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "DELETE FROM emp WHERE empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.executeUpdate();
		OracleSessionFactory.close(null, ps, con);
	}

	@Override
	public List<Emp> findAll() throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "SELECT empno,ename,job,NVL(mgr,0),to_char(hiredate,'yyyy-MM-dd'),NVL(sal,0),NVL(comm,0),NVL(deptno,0) FROM emp";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Emp> EmpList = new ArrayList<Emp>();
		while (rs.next()) {
			Emp Emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
			EmpList.add(Emp);
		}
		return EmpList;
	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "SELECT empno,ename,job,NVL(mgr,0),to_char(hiredate,'yyyy-MM-dd'),NVL(sal,0),NVL(comm,0),NVL(deptno,0) FROM emp WHERE empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Emp e = null;
		while (rs.next()) {
			e = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),
					rs.getDouble(7), rs.getInt(8));
		}
		System.out.println(e);
		return e;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "SELECT empno,ename,job,NVL(mgr,0),to_char(hiredate,'yyyy-MM-dd'),NVL(sal,0),NVL(comm,0),NVL(deptno,0) FROM emp WHERE ename LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + ename + "%");
		ResultSet rs = ps.executeQuery();
		List<Emp> EmpList = new ArrayList<Emp>();
		while (rs.next()) {
			Emp Emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
			EmpList.add(Emp);
		}
		return EmpList;
	}

	@Override
	public List<Emp> findByPage(int page, int size) throws Exception {

		return null;
	}

}
