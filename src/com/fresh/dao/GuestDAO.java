package com.fresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fresh.dto.GuestDTO;

import util.DBManager;

public class GuestDAO {
	private GuestDAO() {
	}

	private static GuestDAO instance = new GuestDAO();

	public static GuestDAO getInstance() {
		return instance;
	}

	public int loginchk(String id, String pwd) {
		int result = 0;
		String sql = "select who from guest where id=? and pw=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int lv= Integer.parseInt(rs.getString("who"));
				if(lv==1) {
					System.out.println("회원 로그인가능");
					return 1;
				}else {
					System.out.println("관리자 로그인가능");
					return 5;
				}
			} else {
				System.out.println("로그인불가능");
				return -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;

	}

	public int chkid(String id) {
		int result = 0;
		String sql = "select * from guest where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int r = pstmt.executeUpdate();

			if (r > 0) {
				System.out.println("중복있음");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;
	}

	public int insertGuest(GuestDTO bVo) {
		int result = 0;
		String sql = "insert into guest(" + "id, pw, name, phon, address, email,who) " + "values(?, ?, ?, ?, ?, ?,1)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getId());
			pstmt.setString(2, bVo.getPw());
			pstmt.setString(3, bVo.getName());
			pstmt.setString(4, bVo.getPhon());
			pstmt.setString(5, bVo.getAddress());
			pstmt.setString(6, bVo.getEmail());
			int r = pstmt.executeUpdate();

			if (r > 0) {
				System.out.println("성공");
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
