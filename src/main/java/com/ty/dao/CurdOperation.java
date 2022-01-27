package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.Invoice;
import com.ty.onetoone.Item;

public class CurdOperation {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	public EntityManager getEntityManager() {

		entityManagerFactory = Persistence.createEntityManagerFactory("project");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;

	}

	public void saveData(Invoice invoice, Item item) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(invoice);
		entityManager.persist(item);

		entityTransaction.commit();
	}

	public void remove(int id) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Invoice invoice = entityManager.find(Invoice.class, id);

		if (invoice != null) {
			entityManager.remove(invoice);

			Item item = invoice.getItem();
			if (item != null) {

				entityManager.remove(item);
			}

		}
		entityTransaction.commit();

	}

	public void getInvoice(int id) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Invoice invoice = entityManager.find(Invoice.class, id);

		if (invoice != null) {

			System.out.println("name is " + invoice.getName());
			System.out.println("address is " + invoice.getBillingAdress());
			System.out.println("gst number is " + invoice.getGstno());
			System.out.println("tax is " + invoice.getTax());
			System.out.println("Invoice id is " + invoice.getId());

			Item item = invoice.getItem();
			System.out.println(item.getId());
			System.out.println(item.getName());
			System.out.println(item.getCost());
			System.out.println(item.getQuantity());

		}
		entityTransaction.commit();

	}

	public void update(Item item) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.merge(item);

		entityTransaction.commit();

	}

}
