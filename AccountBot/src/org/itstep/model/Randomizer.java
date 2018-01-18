package org.itstep.model;

public class Randomizer {

 public static String getEmail(String firstName, String secondName) {
  String email = "";
  int rndInt = 100000 + ((int) (Math.random() * (1000000 - 100000)));
  email = firstName + "." + secondName + "." + rndInt + "@" + getDomain();
  return email;
 }

 public static String getPassword(String secondName) {
  return secondName + String.valueOf(10000 + ((int) (Math.random() * (100000 - 10000))));
 }

 private static String getDomain() {
  int rndInt = (int) (Math.random() * 5);
  switch (rndInt) {
  case 0:
   return "gmail.com";
  case 1:
   return "inbox.com";
  case 2:
   return "mail.com";
  case 3:
   return "bigmir.net";
  case 4:
   return "rk.com";
  default:
   return "hotmail.com";
  }
 }
}