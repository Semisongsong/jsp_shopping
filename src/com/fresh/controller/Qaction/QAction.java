package com.fresh.controller.Qaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface QAction {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}