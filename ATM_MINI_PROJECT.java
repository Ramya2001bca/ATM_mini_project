package ATMPROJECT;
package ATMPROJECT;
import java.util.Scanner;

import java.sql.*;

public class ATM_MINI_PROJECT {
	
	
		public static void main(String[] args) throws SQLException {
			try {
					//Class.forName("com.mysql.jdbc.Drive");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3303/atmproject","root","");
					 //  create statement is a function which is used to execute your code and creating this statement
					 Statement stm=con.createStatement();
					
					Scanner scanner=new Scanner(System.in);
					System.out.println("WELCOME TO ALL IN ONE ATM");
					System.out.println("Enter your pin number");
					int password=scanner.nextInt();
					ResultSet rs=stm.executeQuery("select*from list where ac_no="+password);
		            int pin=0;
					
					int addAmount=0;
					int takeAmount=0;
					String name=null;
					
					int balance=0;
					int count=0;
					while(rs.next()){
						name=rs.getString(3);
						balance=rs.getInt(4);
						count++;
						

					}
				
					if(count>0) {
						System.out.println("Enter your name");
						name=scanner.next();
						System.out.println("Welcome "+name);
						while(true) {
							System.out.println("Press 1 to check your balance");
							System.out.println("Press 2 to addAmount");
							System.out.println("Press 3 to takeAmount");
							System.out.println("Press 4 to take resipt");
							System.out.println("Press 5 to exit /Quit");
							System.out.println();
							System.out.println("Enter the Option : ");
							int option=scanner.nextInt();
							switch(option) {
							case 1:
								System.out.println("your current balance is="+balance);
								break;
							case 2:
								System.out.println("How much amount did you want to add to your amount");
								addAmount=scanner.nextInt();
								balance=addAmount+balance;
								int bal=stm.executeUpdate("update list set balance ="+balance+"WHERE ac_no ="+pin);
								System.out.println("successfully credited"+balance);
								
								break;
							case 3:
								System.out.println("How much amount did you want to take");
								takeAmount=scanner.nextInt();
								if(takeAmount>balance) {
									System.out.println("your balance is insuffient"+balance);
									System.out.println("try less than your available balance");
								}else {
									balance=balance-takeAmount;
									int sub=stm.executeUpdate("update list set balance ="+balance+"where ac_no ="+pin);
									System.out.println("successfull taken"+balance);
								}
								break;
							case 4:
								System.out.println("welcome to all in one mini ATM");
								System.out.println("Available balance is="+balance);
								System.out.println("Amount desposited="+addAmount);
								System.out.println("Amount taken="+takeAmount);
								break;
							default:
								System.out.println("press the number below 5");
								break;
							}
							if(option==5) {
								System.out.println("thank you");
								break;
							}
						}
					}else {
						System.out.println("wrong pin pin number");
					}

				}catch(Exception e){
					System.out.println(e);
				  }
				}
			}
	


