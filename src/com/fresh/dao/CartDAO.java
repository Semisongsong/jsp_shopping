package com.fresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fresh.dto.CartDTO;
import com.fresh.dto.CartVDTO;
import com.fresh.dto.GoodsDTO;

import util.DBManager;

public class CartDAO {
	private CartDAO() {
	}

	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	public int insertcart(CartDTO dto) {
		String sql = "insert into cart(" + "no,id ,num ,name, amount, price) "
				+ "values(cart_no.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getNum());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAmount());
			pstmt.setInt(5, dto.getPrice());
			// pstmt.setString(6, dto.getImage());
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

	public CartDTO searchdup(String id, int num) {
		String sql = "select * from cart where id=? and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setAmount(rs.getInt("amount"));
				System.out.println("이미 있는 항목임");
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

	public int updatedup(CartDTO dto) {
		String sql = "update cart set name=?, amount=?, price=? where num=? and id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAmount());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getNum());
			pstmt.setString(5, dto.getId());
			int r = pstmt.executeUpdate();

			if (r > 0) {
				System.out.println("성공");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("왜 업데이트가 실행이 안되냐규ㅠㅠㅠ");
		return 0;
	}

	public int delOne(String id, int num) {
		String sql = "delete from cart where id=? and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
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

	public ArrayList<CartVDTO> selectview(String id) {
		String sql = "select * from cartview where id=?";
		ArrayList<CartVDTO> cartview = new ArrayList<CartVDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartVDTO dto = new CartVDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setAmount(rs.getInt("amount"));
				dto.setPrice(rs.getInt("price"));
				dto.setImage(rs.getString("image"));
				cartview.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cartview;
	}

	public ArrayList<CartDTO> selectcart(ArrayList<String> list) {
		String sql = "select * from cart where id=? and num=?";
		ArrayList<CartDTO> cart = new ArrayList<CartDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i < list.size(); i++) {
				pstmt.setString(1, list.get(0));
				pstmt.setInt(2, Integer.parseInt(list.get(i)));
				rs = pstmt.executeQuery();
				while (rs.next()) {
					CartDTO dto = new CartDTO();
					dto.setNo(rs.getInt("no"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setNum(rs.getInt("num"));
					dto.setAmount(rs.getInt("amount"));
					dto.setPrice(rs.getInt("price"));
					cart.add(dto);
				}
			}
			return cart;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cart;
	}

	public int delcart(ArrayList<String> list) {
		String sql = "delete from cart where id=? and num=?";
		ArrayList<CartDTO> cart = new ArrayList<CartDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i < list.size(); i++) {
				pstmt.setString(1, list.get(0));
				pstmt.setInt(2, Integer.parseInt(list.get(i)));
				int r = pstmt.executeUpdate();

				if (r > 0) {
					System.out.println("성공");

				}
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 2;
	}

	public int countcart(String id) {
		String sql = "select count(*) from cart where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int r = pstmt.executeUpdate();

			if (r > 0) {
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;
	}

}
