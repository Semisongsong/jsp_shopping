package com.fresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fresh.dto.GoodsDTO;

import util.DBManager;

public class GoodsDAO {
	private GoodsDAO() {
	}

	private static GoodsDAO instance = new GoodsDAO();

	public static GoodsDAO getInstance() {
		return instance;
	}
	
	public int insertGoods(GoodsDTO dto) {
		String sql = "insert into sale(" + "num,type, name, amount, price, origin,introduce,image) " + "values(sale_num.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getType());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAmount());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getOrigin());
			pstmt.setString(6, dto.getIntroduce());
			pstmt.setString(7, dto.getImage());
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
	
	public ArrayList<GoodsDTO> selectAll() {
		String sql = "select * from sale order by enrolldate desc";
		ArrayList<GoodsDTO> list = new ArrayList<GoodsDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setNum(rs.getInt("num"));
				dto.setType(rs.getString("type"));
				dto.setName(rs.getString("name"));
				dto.setAmount(rs.getInt("amount"));
				dto.setPrice(rs.getInt("price"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setImage(rs.getString("image"));
				//dto.setEnrolldate(rs.getTimestamp("enrolldate"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public GoodsDTO selOne(int num) {
		GoodsDTO dto = null;
		String sql = "select * from sale where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new GoodsDTO();
				dto.setNum(rs.getInt("num"));
				dto.setType(rs.getString("type"));
				dto.setName(rs.getString("name"));
				dto.setAmount(rs.getInt("amount"));
				dto.setPrice(rs.getInt("price"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setImage(rs.getString("image"));
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
		
	}
	
	public int delOne(int num) {
		String sql = "delete from sale where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int r = pstmt.executeUpdate();

			if (r > 0) {
				System.out.println("성공");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return 0;
	}
	
	public int modOne(GoodsDTO dto) {
		String sql = "update sale set name=?, type=?, amount=?, price=?," + "origin=?, introduce=?, image=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getType());
			pstmt.setInt(3, dto.getAmount());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getOrigin());
			pstmt.setString(6, dto.getIntroduce());
			pstmt.setString(7, dto.getImage());
			pstmt.setInt(8, dto.getNum());
			int r = pstmt.executeUpdate();

			if (r > 0) {
				System.out.println("성공");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("왜 업데이트가 실행이 안되냐규ㅠㅠㅠ");
		return 0;
	}	
}
