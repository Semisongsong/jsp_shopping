package com.fresh.controller;

import com.fresh.controller.Qaction.MWriteAction;
import com.fresh.controller.Qaction.MakefloorAction;
import com.fresh.controller.Qaction.OnlyForManager;
import com.fresh.controller.Qaction.QAction;
import com.fresh.controller.Qaction.QListAction;
import com.fresh.controller.Qaction.ViewOriginAction;

public class ActionFactoryQna {
	private static ActionFactoryQna instance = new ActionFactoryQna();

	private ActionFactoryQna() {
		super();
	}

	public static ActionFactoryQna getInstance() {
		return instance;
	}

	public QAction getAction(String command) {
		QAction action = null;
		System.out.println("ActionFactoryQnA :" + command);
		if (command.equals("write")) {
			action = new MWriteAction();
		}else if(command.equals("list")) {
			action = new QListAction();
		}else if(command.equals("vieworigin")) {
			action = new ViewOriginAction();
		}else if(command.equals("onlyforManager")) {
			action = new OnlyForManager();
		}else if(command.equals("writerep")) {
			action = new MakefloorAction();
		}
		return action;
	}

	


}
