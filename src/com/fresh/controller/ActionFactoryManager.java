package com.fresh.controller;

import com.fresh.controller.Gaction.DelAction;
import com.fresh.controller.Gaction.GoodsAction;
import com.fresh.controller.Gaction.InsertAction;
import com.fresh.controller.Gaction.ListAction;
import com.fresh.controller.Gaction.ModAction;
import com.fresh.controller.Gaction.ModFormAction;

public class ActionFactoryManager {
private static ActionFactoryManager instance = new ActionFactoryManager();

private ActionFactoryManager() {
	super();
}

public static ActionFactoryManager getInstance() {
	return instance;
}

public GoodsAction getAction(String command) {
	GoodsAction action = null;
	System.out.println("ActionFactoryManager :" + command);
	if (command.equals("insert")) {
		action = new InsertAction();
	}else if(command.equals("list")) {
		action = new ListAction();
	}else if(command.equals("del")) {
		action = new DelAction();
	}else if(command.equals("modF")) {
		action = new ModFormAction();
	}else if(command.equals("mod")) {
		action = new ModAction();
	}
	return action;
}
}

