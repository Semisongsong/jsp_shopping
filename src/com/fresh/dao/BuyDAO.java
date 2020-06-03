package com.fresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fresh.dto.BuyDTO;
import com.fresh.dto.CartDTO;
import com.fresh.dto.CartVDTO;
import com.fresh.dto.GoodsDTO;

import util.DBManager;

public class BuyDAO {
	private BuyDAO() {
	}

	private static BuyDAO instance = new BuyDAO();

	public static BuyDAO getInstance() {
		return instance;
	}
	
	public int insertbuy(ArrayList<BuyDTO> blist) {
		String sql = "insert into buy(" + "no,id ,productnum ,name, amount, price) " + "values(buy_no.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<blist.size(); i++) {
			pstmt.setString(1, blist.get(i).getId());
			pstmt.setInt(2, blist.get(i).getProductnum());
			pstmt.setString(3, blist.get(i).getName());
			pstmt.setInt(4,blist.get(i).getAmount());
			pstmt.setInt(5, blist.get(i).getPrice());
			//pstmt.setString(6, dto.getImage());
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
		return 0;
	}
}
