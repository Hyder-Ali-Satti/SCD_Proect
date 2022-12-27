/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author haide
 */
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.lang.model.util.ElementScanner6;

public class NewClass123 {
    public static void main(String[] args)
     {
linkedlist l1=new linkedlist();

l1.main();

     }
}

class linkedlist {
    Scanner input = new Scanner(System.in);
    node head;
    node tail;

    public linkedlist() {
        tail = null;
        head = null;

    }

    public void main() {

        System.out.println("ENTER THE FOLLOWING DIGIT TO CONTINUE");
        System.out.println("1 : ADD A RECORD FOR NEW EMPLOYEE");
        System.out.println("2 : UPDATE A RECORD OF AN EMPLOYEE");
        System.out.println("3 : DELETE A RECORD OF AN EMPLOYYE");
        System.out.println("4 : DISPLAY THE DETAIL OF AN EMPLOYEE");
        System.out.println("5 : SEARCH THE RECORD OF AN EMPLOYEE");
        System.out.println("0 : EXIT");
        int f = input.nextInt();
        if (f == 0)
         {
            return;
        }
         else if (f == 1) {
            System.out.println("DO YOU WANT TO INSERT THE RECORD AT THE START OR AT THE LAST OF THE LIST");
            System.out.println("1 : FOR FIRST");
            System.out.println("2 : FOR LAST");
            int g1 = input.nextInt();
            if (g1 == 1) {
                int id;
                String name;
                String emailAddress;
                int yearOfBirth;
                String qualification;
                int salary;
                String job_title;
                String date;  
                System.out.println("NAME : ");
                name = input.next();
                System.out.println("ID :");
                id = input.nextInt();
                System.out.println("EMAIL ADDRESS :");
                emailAddress = input.next();
                System.out.println("YEAR OF BIRTH :");
                yearOfBirth = input.nextInt();
                System.out.println("QUALIFICATION :");
                qualification = input.next();
                System.out.println("SALARY : ");
                salary = input.nextInt();
                System.out.println("JOB TITLE :");
                job_title = input.next();
                System.out.println("DATE : ");
                date = input.next();

                insert_at_first(id, name, emailAddress, yearOfBirth, qualification, salary, job_title, date);
                System.out.println("THE EMPLOYEE HAS BEEN ADDED IN THE SYSTEM");
                main();
            } else if (g1 == 2) {
                int id;
                String name;
                String emailAddress;
                int yearOfBirth;
                String qualification;
                int salary;
                String job_title;
                String date; 
                System.out.println("ID :");
                id = input.nextInt();
                System.out.println("NAME : ");
                name = input.next();
                System.out.println("EMAIL ADDRESS :");
                emailAddress = input.next();
                System.out.println("YEAR OF BIRTH :");
                yearOfBirth = input.nextInt();
                System.out.println("QUALIFICATION :");
                qualification = input.next();
                System.out.println("SALARY : ");
                salary = input.nextInt();
                System.out.println("JOB TITLE :");
                job_title = input.next();
                System.out.println("DATE : ");
                date = input.next();
                insert_at_last(id, name, emailAddress, yearOfBirth, qualification, salary, job_title, date);
                System.out.println("THE EMPLOYEE HAS BEEN ADDED IN THE SYSTEM");
                main();
            } else {
                System.out.println("YOU HAVE ENTER THE WRONG OPTION");
                System.out.println("     TRY AGAIN       ");
                System.out.println("   ");
                main();
            }
        } else if (f == 2) {
            update();
            System.out.println("UPDATED");
            main();
        } else if (f == 3) {
            delete();
            System.out.println("DELETED");
            main();
        } else if (f == 4) {
            display_all_employee();
            main();
        } else if (f == 5) {
            search();
            main();
        } else {
            System.out.println("YOU HAVE ENTERED THE WRONG INDEX NUMBER");
            System.out.println("TRY AGAIN");
            main();
        }
    }

    public void insert_at_first(int id, String name, String emailAddress, int yearOfBirth, String qualification,
            int salary, String job_title, String date) {
        node new_node = new node(id, name, emailAddress, yearOfBirth, qualification, salary, job_title, date);
        if (tail == null) {
            tail = new_node;
            head = new_node;

        } else {
            head.pre = new_node;
            new_node.next = head;
            head = new_node;
        }
    }

    public void insert_at_last(int id, String name, String emailAddress, int yearOfBirth, String qualification,
            int salary, String job_title, String date) {
        node new_node = new node(id, name, emailAddress, yearOfBirth, qualification, salary, job_title, date);
        if (head == null) {
            tail = new_node;
            head = new_node;

        } else {
            tail.next = new_node;
            new_node.pre = tail;
            tail = new_node;
        }

    }
public boolean compareTwoStrings (String a, String b, boolean isIgnoreCase){ 
  if (isIgnoreCase) 
    return (a.toLowerCase()).equals(b.toLowerCase());        
  else 
   return a.equals(b);      
}
    public void delete() {
        System.out.println("DO YOU WANT TO DELETE THE RECORD OF THE EMPLOYEE BY HIS/HER ID OR NAME");
        System.out.println("1 for ID");
        System.out.println("2 for NAME");
        int e = input.nextInt();
        if (e == 1) {
            System.out.println("ENTER THE ID NUMBER");
            int f = input.nextInt();

            if (f == head.id) {
                node temp = head;
                head.next.pre = null;
                head = head.next;
                temp.next = null;
                System.out.println("THE EMPLOYEE HAS BEEN DELETE FROM THE MANAGEMENT SYSTEM");
            } else if (f == tail.id) {
                node temp = tail;
                tail.pre.next = null;
                tail = tail.pre;
                temp.pre = null;
                System.out.println("THE EMPLOYEE HAS BEEN DELETE FROM THE MANAGEMENT SYSTEM");
            } else {
                node temp = head.next;
                node previous = temp.pre;
                node Next = temp.next;
                while (temp != null) {
                    if (f == temp.id) {
                        System.out.println("THE EMPLOYEE HAS BEEN DELETE FROM THE MANAGEMENT SYSTEM");
                        previous.next = Next;
                        Next.pre = previous;
                        temp.pre = null;
                        temp.next = null;
                    }
                    temp = temp.next;
                    previous = previous.next;
                    Next = Next.next;
                }
            }
        } else if (e == 2) {
//myStr1.compareToIgnoreCase(myStr2)
            System.out.println("ENTER THE NAME");
            String g = input.next();
            if (g.equalsIgnoreCase(head.name));
                    {
                node temp = head;
                head.next.pre = null;
                head = head.next;
                temp.next = null;
                    }
                //System.out.println(myStr1.equals//IgnoreCase(myStr2)); // true

                if (g.equalsIgnoreCase(tail.name))
                       {
                node temp = tail;
                tail.pre.next = null;
                tail = tail.pre;
                temp.pre = null;
                System.out.println("THE EMPLOYEE HAS BEEN DELETE FROM THE MANAGEMENT SYSTEM");
            } else {
                node temp = head.next;
                node previous = temp.pre;
                node Next = temp.next;
                while (temp != null&&Next!=null) {
                    if (g.equalsIgnoreCase(temp.name)) {
                        System.out.println("THE EMPLOYEE HAS BEEN DELETE FROM THE MANAGEMENT SYSTEM");
                        previous.next = Next;
                        Next.pre = previous;
                        temp.pre = null;
                        temp.next = null;
                    }
                    Next = Next.next;
                    
                    temp = temp.next;
                    previous = previous.next;
                    //Next = Next.next;
                }
            }   
        } else {
            System.out.println("YOU HAVE ENTERED THE WRONG OPTION");
        }
    }

    public void display_detail_of_a_employ(node a) {
        System.out.println("ID :" + a.id);
        System.out.println("NAME :" + a.name);
        System.out.println("EMAIL ADDRESS :" + a.emailAddress);
        System.out.println("YEAR OF BIRTH :" + a.yearOfBirth);
        System.out.println("QUALIFICATION :" + a.qualification);
        System.out.println("SALARY :" + a.salary);
        System.out.println("JOB TITLE :" + a.job_title);
        System.out.println("DATE OF JOINING :" + a.date);

    }

    public void display_all_employee() {
        node temp = head;
        int i = 0;
        System.out.println("SR-NO        ID        NAME");

        while (temp != null) {
            System.out.println(++i + "             " + temp.id + "      " + temp.name);
            temp = temp.next;
        }
        System.out.println("DO YOU WANT TO THE COMPLETE DETAIL OF THE EMPLOYEE");
        System.out.println("1 FOR YES");
        System.out.println(" 2 FOR N0");
        int a = input.nextInt();
        if (a == 1) {
            node temp1 = head;
            System.out.println("ENTER THE ID ");
            int b = input.nextInt();
            while (temp1 != null) {
                if (b == temp1.id) {
                    display_detail_of_a_employ(temp1);
                }
                temp1 = temp1.next;
            }
        } else {
            System.out.println("EXIT");
        }

    }

    public void search() {
        System.out.println("ENTER THE EMPLOYEE'S NAME OR ID TO SEARCH ");
        System.out.println("1 : NAME");
        System.out.println("2 : ID");
        System.out.println("0 : EXIT");
        int k = input.nextInt();
        if (k == 0) {
            return;
        } else if (k == 1) {
            node temp = head;
            System.out.println("ENTER THE NAME ");
            String a = input.next();
            while (temp != null) {
                if (a.equalsIgnoreCase(temp.name)) {
                    display_detail_of_a_employ(temp);
                    return;
                }
                temp=temp.next;
            }
            System.out.println("NOT FOUND");
            System.out.println("TRY AGAIN");
            search();
            return;
        }

        else if (k == 2) {
            node temp = head;
            System.out.println("ENTER THE ID ");
            int h = input.nextInt();
            while (temp != null) {
                if (h == temp.id) {
                    display_detail_of_a_employ(temp);
                    return;
                }
                temp=temp.next;
            }
            System.out.println("NOT FOUND");
            System.out.println("TRY AGAIN");
            search();
            return;
        } else {
            System.out.println("YOU HAVE ENTERED THE WRONG OPTION");
            System.out.println("TRY AGAIN");
            search();
        }
    }

       public void update() {
        System.out.println("DO YOU WANT TO UPDATE THE DETAIL OF AN EMPLOYEE");
        System.out.println("1 FOR YES");
        System.out.println(" 2 FOR N0");
        
        
        int a = input.nextInt();
        if(a==2)
        {
            return;
        }
        else if (a == 1) {
            System.out.println("ENTER THE ID OF THAT EMPLOYEE");
            int f = input.nextInt();
            node temp = head;
            while (temp != null) {
                if (f == temp.id) {
                    System.out.println("WHAT DO WANT TO UPDATE?");
                    System.out.println("ENTER THE INDEX NO ACCORDING TO THE FOLLOWING");
                    System.out.println("1 FOR ID :");
                    System.out.println("2 FOR NAME :");
                    System.out.println("3 FOR EMAIL ADDRESS :");
                    System.out.println("4 FOR YEAR OF BIRTH :");
                    System.out.println("5 FOR QUALIFICATION :");
                    System.out.println("6 FOR SALARY :");
                    System.out.println("7 FOR JOB TITLE :");
                    System.out.println("8 FOR DATE OF JOINING :");
                    System.out.println("ENTER THE DIGIT");
                    System.out.println("0 FOR EXIT");
                    int e = input.nextInt();
                    if (e == 0)
                     {
                        return;
                    } else if (e==1)
                    {  
                         System.out.println("ENTER THE NEW ID");
                                int g = input.nextInt();
                                node temp1 = head;
                                while (temp1 != null) 
                                {
                                    if (g == temp1.id)
                                     {
                                        System.out.println("THIS ID NUMBER IS ALREADY ALLOTTED");
                                        System.out.println("ENTER AN ANOTHER ONE EXCEPT");
                                        node temp2 = head;

                                        while (temp2 != null)
                                         {
                                            System.out.print(temp2.id + ",");
                                            temp2 = temp2.next;
                                        }
                                        System.out.println(" ");
                                        System.out.println("ENTER AGAIN");
                                        int l;
                                        l = input.nextInt();
                                        node temp3 = head;
                                        while (temp3 != null) {
                                            if (l == temp3.id) {
                                                System.out.println("EXIT");
                                                return;
                                            }
                                            temp3 = temp.next;
                                        }
                                    }
                                

                                    temp1 = temp1.next;
                                }
                                                           temp.id = g;
                                                           //System.out.println("UPDATED);

                    }
                                
                    
                                else if(e==2)
                                {
                                System.out.println("ENTER NEW NAME");
                                temp.name = input.next();
                                //System.out.println("UPDATED);

                                }

                        else if(e==3)
                        {
                                System.out.println("ENTER NEW EMAIL");
                                temp.emailAddress = input.next();
//System.out.println("UPDATED);

                        }
                                else if(e==4)
                                {
                                System.out.println("ENTER NEW DATE OF YEAR OF BIRTH");
                                temp.yearOfBirth = input.nextInt();
//System.out.println("UPDATED);

                                }
                               
                                else if(e==5)
                                {
                                System.out.println("UPDATE THE QUALIFICATION");
                                temp.qualification = input.next();
//System.out.println("UPDATED);

                                }
                                
                            else if(e==6)
                            {
                                System.out.println("ENTER NEW AMOUNT OF SALARY");
                                temp.salary = input.nextInt();
//System.out.println("UPDATED);

                            }
                                else if(e==7)
                                {
                                System.out.println("ENTER NEW JOB TITLE");
                                temp.job_title = input.next();
//System.out.println("UPDATED);

                                }
                               
                          else if(e==8)
                          {
                                System.out.println("ENTER NEW DATE");
                                temp.date = input.next();
//System.out.println("UPDATED);

                          }

                        
                     else {
                        System.out.println("YOU HAVE ENTERED THE WRONG INDEX");
                        System.out.println("TRY AGAIN");
                        update();
                    }

                }
                temp = temp.next;
            }
//System.out.println("UPDATED);

update();
}
else
{
    System.out.println("YOU HAVE ENTERED THE WRONG INDEX");
                        System.out.println("TRY AGAIN");
                        update();
  //  main();
    
}}
}

class node {

    node next;
    node pre;
    int id;
    String name;
    String emailAddress;
    int yearOfBirth;
    String qualification;
    int salary;
    String job_title;
    String date;

    public node(int id, String name, String emailAddress, int yearOfBirth, String qualification, int salary,
            String job_title, String date) {
        this.next = null;
        this.pre = null;
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.yearOfBirth = yearOfBirth;
        this.qualification = qualification;
        this.salary = salary;
        this.job_title = job_title;
        this.date = date;

    }

}
