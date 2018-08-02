package org.hameister.personmanager;

import java.util.Scanner;

public class newPersonFelix {

Scanner eingabe = new Scanner(System.in);

public String newPersonVorname;

public String newPersonNachname;

public Long newPersonSalary;

public int intYear;

public int intMonth;

public int intDay;


public void setNames(){

          System.out.println("Vorname der Person?");
            newPersonVorname = eingabe.next();

            System.out.println("Nachname der Person?");
            newPersonNachname = eingabe.next();

           
     

}

public void setBirthday(){
    String year;
    String month;
    String day;
    Integer tmp = 0;

            System.out.println("Wann hat die Person Geburtstag");
            System.out.println("YYYY-MM-DD");

            String newPersonBirthday = eingabe.next();

           
            String[] parts = newPersonBirthday.split("-");
            System.out.println(parts.length);
            if(parts.length > 3 || parts.length < 3) {
                year = "2000";
                month = "01";
                day = "01";
                tmp = 1;
            }
            else {   

            year = parts[0]; 
            month = parts[1]; 
            day = parts [2];
            }
            
            if(tmp == 1 ) {
                System.out.println("Die alternativen Daten sind:");
                System.out.println(year + "-" + month + "-" +day);
            }
            




            intYear = Integer.parseInt(year);
            intMonth = Integer.parseInt(month);
            intDay = Integer.parseInt(day);
        }




public void setSalary(){

        System.out.println("Wie viel soll die Person verdienen?");
            newPersonSalary = eingabe.nextLong();

}




    public newPersonFelix(){

        //Felix:
      setNames();
      setBirthday();
      setSalary();


    }


public  String getName(){

     String newPersonName = newPersonVorname + ' ' +  newPersonNachname;
     return newPersonName;
}

public Integer getBirYear(){

    return intYear;

}

public Integer getBirMonth(){

    return intMonth;

}

public Integer getBirDay(){

        return intDay;
    
}

public Long getSalary(){
    
    return newPersonSalary;
}

   
 

}