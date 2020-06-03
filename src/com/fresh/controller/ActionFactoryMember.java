package com.fresh.controller;

import com.fresh.controller.ActionFactoryMember;
import com.fresh.controller.Maction.Action;
import com.fresh.controller.Maction.JoinAction;
import com.fresh.controller.Maction.LoginAction;
import com.fresh.controller.Maction.LogoutAction;

public class ActionFactoryMember {
	private static ActionFactoryMember instance = new ActionFactoryMember();

	private ActionFactoryMember() {
		super();
	}

	public static ActionFactoryMember getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactoryMember :" + command);
		if (command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}
		return action;
	}

	


}
