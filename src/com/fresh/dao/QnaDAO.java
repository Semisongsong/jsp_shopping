package com.fresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fresh.dto.QnaDTO;

import util.DBManager;

public class QnaDAO {

	private QnaDAO() {
	}

	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	public int insertqna(QnaDTO dto) {
		String sql = "insert into qna(" + "num,title, id, contents, views, grp) "
				+ "values(qna_num.nextval, ?, ?, ?, 0,qna_num.nextval)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getContents());

			int r = pstmt.executeUpdate();
			if (r > 0) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;
	}
	
	public ArrayList<QnaDTO> AllList() {
		String sql = "select * from qna order by grp desc, lvl desc, qdate";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				QnaDTO dto = new QnaDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setContents(rs.getString("contents"));
				dto.setViews(rs.getInt("views"));
				dto.setQdate(rs.getTimestamp("qdate"));
				dto.setGrp(rs.getInt("grp"));
				dto.setLvl(rs.getInt("lvl"));
				dto.setSeq(rs.getInt("seq"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public void updateReadCount(String num) {
		String sql = "update qna set views=views+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public QnaDTO selectOneqnaByNum(String num) {
		String sql = "select * from qna where num = ?";
		QnaDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new QnaDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getNString("title"));
				dto.setId(rs.getString("id"));
				dto.setContents(rs.getString("contents"));
				dto.setViews(rs.getInt("views"));
				dto.setGrp(rs.getInt("grp"));
				dto.setLvl(rs.getInt("lvl"));
				dto.setSeq(rs.getInt("seq"));
				dto.setQdate(rs.getTimestamp("qdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	
	public ArrayList<QnaDTO> selectByGrp(String num) {
		String sql = "select * from qna where grp=? order by qdate";
		ArrayList<QnaDTO> list = new ArrayList<>();
		QnaDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new QnaDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getNString("title"));
				dto.setId(rs.getString("id"));
				dto.setContents(rs.getString("contents"));
				dto.setViews(rs.getInt("views"));
				dto.setGrp(rs.getInt("grp"));
				dto.setLvl(rs.getInt("lvl"));
				dto.setSeq(rs.getInt("seq"));
				dto.setQdate(rs.getTimestamp("qdate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int chkgrp(String num) {
		String sql = "select * from qna where grp = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			int r = pstmt.executeUpdate();
			if(r > 1) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;
	}

	public int makefloor(int num, QnaDTO dto) {
		String sql = "select grp,lvl,seq from qna where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int grp_n = 0;
		int lvl_n = 0;
		int seq_n = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				grp_n = rs.getInt("grp");
				lvl_n = rs.getInt("lvl");
				seq_n = rs.getInt("seq");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		try {
			String levelsql = "update board set lvl=lvl+1 where grp=? and lvl > ?";
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(levelsql);

			pstmt.setInt(1, grp_n);
			pstmt.setInt(2, lvl_n);

			pstmt.executeUpdate();

			String sql_n ="insert into qna(" + "num,title, id, contents, views, grp, lvl, seq) "
					+ "values(qna_num.nextval, ?, ?, ?, ?, ?, ?, ?)";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_n);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getContents());
			pstmt.setInt(4, dto.getViews());
			pstmt.setInt(5, grp_n); // 부모의 ref값을 넣어줌
			pstmt.setInt(6, lvl_n + 1); // 답글이기 때문에 부모글 re_step에 1을 더해준다.
			pstmt.setInt(7, seq_n + 1); // 답글이기 때문에 부모글 re_level에 1을 더해준다.

			int r =pstmt.executeUpdate();
			if(r>0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return 0;
		

	}
	
	public int chkorigin(String num) {
		String sql = "select * from qna where num=? and grp=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, num);
			int r = pstmt.executeUpdate();
			if(r > 0) { // 원글
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;
	}
	

}
