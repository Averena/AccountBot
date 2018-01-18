package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDAOTest {

 private String firstName;
 private String secondName;

 @Before
 public void setDataBeforeTest() {
  firstName = "Alex";
  secondName = "Dzuba";
  AccountDAO accDao = new AccountDAO();
  Account account = new Account(firstName, secondName);
  accDao.save(account);
 }

 @After
 public void deleteDataAfterTest() {
  AccountDAO accDao = new AccountDAO();
  accDao.delete(firstName, secondName);
 }

 @Test
 public void testUpdate() {

  AccountDAO accDao = new AccountDAO();
System.out.println(firstName + secondName);

 assertNotNull(accDao.get(firstName, secondName).getEmail());

  Account updatedAccount = new Account();
  updatedAccount.setFirstName("Poiuytr");
  updatedAccount.setSecondName("Zxcvbnm");
  updatedAccount.setEmail("Poiuytr@ukr.net");
  updatedAccount.setPassword("123456789");

  accDao.update(firstName, secondName, updatedAccount);

  assertNull(accDao.get(firstName, secondName).getEmail());
  
  firstName = updatedAccount.getFirstName();
  secondName = updatedAccount.getSecondName();
  System.out.println(firstName + secondName);
  System.out.println(accDao.get(firstName, secondName).getEmail());
  assertEquals(accDao.get(firstName, secondName).getEmail(), "Poiuytr@ukr.net");

 }


@Test
public void testSave() {

 AccountDAO accDao = new AccountDAO();

 Account savedAccount = new Account();
 savedAccount.setFirstName("Alex");
 savedAccount.setSecondName("Dzuob");
 savedAccount.setEmail("alex_dzuob@ukr.net");
 savedAccount.setPassword("7894561230");

 accDao.save(savedAccount);

 assertNotNull(accDao.get(firstName, secondName).getEmail());
 
 firstName = savedAccount.getFirstName();
 secondName = savedAccount.getSecondName();

 assertEquals(accDao.get(firstName, secondName).getEmail(), "alex_dzuob@ukr.net");
}
}