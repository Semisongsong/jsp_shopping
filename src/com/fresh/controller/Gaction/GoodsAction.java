package com.fresh.controller.Gaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GoodsAction {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
