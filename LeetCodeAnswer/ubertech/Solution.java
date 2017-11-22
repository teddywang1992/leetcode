package ubertech;

//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.

//store the login and logout infos in memory
//class implements two methods
//First one: login or logout
//Second one: query whether user login or logout in a timestamp

//login 1pm logout 2pm 
import java.util.HashMap;
import java.util.ArrayList;

class User {
 ArrayList<Integer> login;
 ArrayList<Integer> logout;
 
 public User() {
     this.login = new ArrayList<Integer>();
     this.logout = new ArrayList<Integer>();
 }
}
public class Solution {
 
 
 HashMap<String, User> map = new HashMap<String, User>();
 // insert(user1, 1, login)
 public void insert(String userId, int timestamp, String type) {
     if (map.containsKey(userId)) {
         User user = map.get(userId);
         if (type.equals("login")) {
             user.login.add(timestamp);
         } else if (type.equals("logout")) {
             user.logout.add(timestamp);
         }
     } else {
         User user = new User();
         if (type.equals("login")) {
             user.login.add(timestamp);
         } else if (type.equals("logout")) {
             user.logout.add(timestamp);
         } 
         map.put(userId, user);
     }
 }
  
 public String query(String userId, int timestamp) {
     if (!map.containsKey(userId)) return "User not exist!";
     User user = map.get(userId);
     ArrayList<Integer> loginList = user.login;
     ArrayList<Integer> logoutList = user.logout;
     if (loginList.size() == 0) return "logout";
     if (logoutList.get(logoutList.size() - 1) < timestamp) return "logout";
     if (loginList.get(0) > timestamp) return "logout";
     int login = 0, logout = 0;
     for (int i = 0; i < loginList.size(); i++) {
         if (loginList.get(i) < timestamp) login = timestamp;
     }
     for (int i = 0; i < logoutList.size(); i++) {
         if (logoutList.get(i) > timestamp) {
             logout = timestamp;
             break;
         }
     }
     if (login < logout) return "login";
     return "logout";
 }
 // insert(user1, 0, login)
 // insert(user1, 1, logout)
 
 public static void main(String[] args) {

	 String test = "123123";
	 System.out.println(test.split(",").length);
 }
}