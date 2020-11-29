public class Call{
   public static void main(String args[]){
	  boolean softwareNotNeeded = false;
	  int[] emails= new int[100];
	  String[] projectName = {"Web App", "Custom Database", "Business Intelligence Reports", "Dashboards"};
	  String[] R_dates = {"11/23/2017", "05/23/2018","03/25/2019","02/20/2021"};
	  String[] C_dates = {"03/23/2018", "01/23/2019","05/15/2019","09/20/2021"};
	  for(int contactNow=0; contactNow<=10; contactNow++){
	     if(softwareNotNeeded){
			break;
		 }else{
			emails[contactNow]= contactNow;
			System.out.println("Customer email "+ (contactNow+1));
		 }
		 if(contactNow ==5){
		 	softwareNotNeeded = true;
			System.out.println("\nProject History");
			System.out.println("=============");
			for(int k = 0; k<contactNow; k++){
				try{
					System.out.println("Customer #: "+ emails[k]);
					System.out.println("Project name: "+ projectName[k]);
					System.out.println("Date received: "+ R_dates[k]);
					System.out.println("Date completed: "+ C_dates[k]);
					System.out.println("--------");
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("More projects coming soon!!");
				}
			}
			System.out.println("\n(Last 5 items selected)");
		}
	  }
   }
}


/*
//Sample output:

λ javac CallNow.java

C:\Users\sub\Desktop
λ java CallNow
Customer email 1
Customer email 2
Customer email 3
Customer email 4
Customer email 5
Customer email 6

Project History
=============
Customer #: 0
Project name: Web App
Date received: 11/23/2017
Date completed: 03/23/2018
--------
Customer #: 1
Project name: Custom Database
Date received: 05/23/2018
Date completed: 01/23/2019
--------
Customer #: 2
Project name: Business Intelligence Reports
Date received: 03/25/2019
Date completed: 05/15/2019
--------
Customer #: 3
Project name: Dashboards
Date received: 02/20/2021
Date completed: 09/20/2021
--------
Customer #: 4
More projects coming soon!!

(Last 5 items selected)
*/