package com.ty.controller;

import com.ty.dao.CurdOperation;
import com.ty.onetoone.Invoice;
import com.ty.onetoone.Item;

public class Controller {
	
	public static void main(String[] args) {
		
		CurdOperation curdOperation = new CurdOperation();
		
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setBillingAdress("banglore");
		invoice.setGstno("5455-IOP");
		invoice.setName("shankha");
		invoice.setTax(15);
		Item item = new Item();
		item.setId(1);
		item.setName("football");
		item.setQuantity(1);
		item.setCost(500);
		invoice.setItem(item);
		
		curdOperation.saveData(invoice, item);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
