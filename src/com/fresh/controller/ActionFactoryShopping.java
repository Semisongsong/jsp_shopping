package com.fresh.controller;

import com.fresh.controller.Saction.GoCartAction;
import com.fresh.controller.Saction.MainAction;
import com.fresh.controller.Saction.MycartAction;
import com.fresh.controller.Saction.OrderAction;
import com.fresh.controller.Saction.SAction;
import com.fresh.controller.Saction.ShopAction;
import com.fresh.controller.Saction.ShopDAction;
import com.fresh.controller.Saction.UpdateCartAction;
import com.fresh.controller.Saction.delCartAction;

public class ActionFactoryShopping {
	private static ActionFactoryShopping instance = new ActionFactoryShopping();

	private ActionFactoryShopping() {
		super();
	}

	public static ActionFactoryShopping getInstance() {
		return instance;
	}

	public SAction getAction(String command) {
		SAction action = null;
		System.out.println("ActionFactoryShopping :" + command);
		if (command.equals("Main")) {
			action = new MainAction();
		}else if(command.equals("shop")) {
			action = new ShopAction();
		}else if(command.equals("shopD")) {
			action = new ShopDAction();
		}else if(command.equals("gocart")) {
			action = new GoCartAction();
		}else if(command.equals("mycart")) {
			action = new MycartAction();
		}else if(command.equals("delcart")) {
			action = new delCartAction();
		}else if(command.equals("updatecart")) {
			action = new UpdateCartAction();
		}else if(command.equals("order")) {
			action = new OrderAction();
		}
		return action;
	}

	
}
