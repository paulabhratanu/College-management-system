package webkiosk;
import java.io.*;
class College
{

    private String placementinfo;
    private String studentwork;
    private String teacherwork;
    private String pass="hello";
    public boolean checklogin(String p)
    {
         if(p.equals(pass))
    {
       System.out.println("\t\t\t\t" + "------WELCOME------");
       System.out.println("\n\n\n");
       return true;
    }
    else
    {

      System.out.println("\t\t\t\t" + "------NOT VALID------");
      return false;
    }
    }
    public void sedit(Student s1)throws IOException
    {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        System.out.print("enter student id again to edit 0/1/2:");
        int r2=Integer.parseInt(br.readLine());
        if(r2==0)
        {
         s1.studentid=300;
         s1.studentbranch="ece";
        }else if(r2==1)
        {
            s1.studentid=400;
            s1.studentbranch="cse";
        }else
        {
            s1.studentid=500;
            s1.studentbranch="ece";
        }

    }
     public void stedit(Staff st1)throws IOException
    {
          InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        System.out.print("enter staff id again to edit 0/1/2:");
        int r2=Integer.parseInt(br.readLine());
        if(r2==0)
        {
         st1.staffsalary=25000;
        }else if(r2==1)
        {
            st1.staffsalary=35000;
        }else
        {
            st1.staffsalary=55000;
        }
    }
    public void ssend(String splace,String swork)
    {
        placementinfo=splace;
        studentwork=swork;

    }
    public void stsend(String stwork)
    {

        teacherwork=stwork;

    }
     public String sreceive()
    {
        return placementinfo;
    }
     public String sreceive1()
    {
        return studentwork;
    }
     public String streceive()
    {
        return teacherwork;
    }

};
class Staff extends College
{
    private int staffid;
    String staffname;
    String staffdept;
    private String staffpass;
    int staffsalary;
    public void stcreate(int stid,String stname,String stdept,String stpass,int stsal)
    {
        staffid=stid;
        staffname=stname;
        staffdept=stdept;
        staffpass=stpass;
        staffsalary=stsal;
    }
    public boolean stchecklogin(String q1)
    {
        if(q1.equals(staffpass))
    {
       System.out.println("\t\t\t\t" + "------WELCOME TEACHER------");
       System.out.println("\n\n\n");
       return true;
    }
    else
    {

      System.out.println("\t\t\t\t" + "------NOT VALID STAFF PASSWORD------");
      return false;
    }
    }
    public void stchange(String q2)
    {
        staffpass=q2;
    }
    public void stdisplay()
    {
        System.out.println("staffid:" + staffid + "\t" + "staffname:" + staffname + "\t" + "staffdept:" + staffdept + "\t"
                            + "staffsalary:" + staffsalary);
    }
    public void stcheck(Student s5)
    {
        System.out.println("studentname:" + s5.studentname + "\t" + "studentbranch:" + s5.studentbranch);
    }
};
final class Student extends Staff
{
    int studentid;
    String studentname;
    String studentbranch;
    private String studentpass;
    public void screate(int sid,String sname,String sbranch,String spass)
    {
     studentid=sid;
     studentname=sname;
     studentbranch=sbranch;
     studentpass=spass;
    }
    public void sdisplay()
    {
        System.out.println("studentid->" + studentid + "\t" + "studentname->" + studentname + "\t" + "studentbranch->"
                        + studentbranch);
    }
     public boolean schecklogin(String p1)
    {
         if(p1.equals(studentpass))
    {
       System.out.println("\t\t\t\t" + "------WELCOME STUDENT------");
       System.out.println("\n\n\n");
       return true;
    }
    else
    {

      System.out.println("\t\t\t\t" + "------NOT VALID STUDENT PASSWORD------");
      return false;
    }
    }
    public void schange(String p2)
    {
        studentpass=p2;
    }
    public void scheck(Staff st1)
    {
        System.out.println("staffname:" + st1.staffname + "\t" + "staffbranch:" + st1.staffdept);
    }



};
public class Collegemanage
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        int ind=0,n1=1,n2=1;
        College c=new College();
        Staff  st[]=new Staff[3];
        Student s[]=new Student[3];
        College c1[]=new College[3];
        for(int i=0;i<3;i++)
        {
            s[i]=new Student();
            st[i]=new Staff();
             c1[i]=new College();

        }
        s[0].screate(100,"amit","cse","amit");
        s[1].screate(101,"rahul","cse","rahul");
        s[2].screate(102,"rohan","ece","rohan");
        st[0].stcreate(200,"pulkit","cse","pulkit",10000);
        st[1].stcreate(201,"anuradha","cse","anuradha",20000);
        st[2].stcreate(202,"rohit","ece","rohit",30000);
        c1[0].ssend("kuliza","ic3 workshop");
      c1[1].ssend("minzar","ic3 workshop");
      c1[2].ssend("amazon","ieee workshop");
        c1[0].stsend("ic3 workshop");
      c1[1].stsend("ic3 workshop");
      c1[2].stsend("ieee workshop");
        Console console=System.console();
        System.out.println("\t\t\t" + "_|-|_|-COLLEGE MANAGEMENT PROJECT-|_|-|_");
        System.out.println("\n\n\n");
        while(n1!=0)
        {

         System.out.print("ENTER SYSTEM PASSWORD->");
        char []cr=console.readPassword();
        String p=new String(cr);
        if(c.checklogin(p))
        {
            ind++;
        }
       if(ind>0)
       {


        System.out.println("\t\t\t" + "******WELCOME TO JIIT,NOIDA******");
        System.out.println("\n\n\n");
        System.out.print("1.college management 2.staff 3.student->");
        int n=Integer.parseInt(br.readLine());
        switch(n)
        {
            case 1:System.out.print("1.edit studentinfo 2.edit staffinfo->");
                   int r=Integer.parseInt(br.readLine());
                   switch(r)
                   {
                   case 1:System.out.print("enter student id to edit 0/1/2:");
                          int r1=Integer.parseInt(br.readLine());
                          c.sedit(s[r1]);
                          break;
                   case 2:System.out.print("enter staff id to edit:");
                           r1=Integer.parseInt(br.readLine());
                          c.stedit(st[r1]);
                          break;


                   }
                   System.out.print("WANT TO CONTINUE??? 1/0->");
                   n1=Integer.parseInt(br.readLine());
                   break;

            case 2:    System.out.print("enter your staff id 0/1/2->");
                   int m3=Integer.parseInt(br.readLine());
                System.out.print("enter your staff password->");
                   char []dh=console.readPassword();
                   String q1=new String(dh);
                   if(st[m3].stchecklogin(q1))
                 {
                   st[m3].stdisplay();
                   System.out.print("want to change your password? 1/0->");
                   int m4=Integer.parseInt(br.readLine());
                   if(m4==1)
                   {
                       System.out.print("enter new password->");
                   char []dg=console.readPassword();
                   String q2=new String(dg);
                       st[m3].stchange(q2);
                   }
                   System.out.print("want to check studentinfo 1/0 ->");
                   int sttemp=Integer.parseInt(br.readLine());
                   if(sttemp==1)
                   {


                   System.out.print("enter the student id to check his info 0/1/2->");
                   int n6=Integer.parseInt(br.readLine());
                   st[m3].stcheck(s[n6]);
                   }
                   System.out.print("want to check workshopinfo 1/0 ->");
                   int temp3=Integer.parseInt(br.readLine());
                   if(temp3==1)
                   {

                   String ans2=c1[m3].streceive();
                   System.out.println("your workshop info:" + ans2);
                   }

                 }
                 System.out.print("WANT TO CONTINUE??? 1/0->");
                 n1=Integer.parseInt(br.readLine());
                 break;

            case 3:System.out.print("enter your student id 0/1/2->");
                   int n3=Integer.parseInt(br.readLine());
                System.out.print("enter your student password->");
                   char []ch=console.readPassword();
                   String p1=new String(ch);
                  if(s[n3].schecklogin(p1))
                 {
                   s[n3].sdisplay();
                   System.out.print("want to change your password? 1/0->");
                   int n4=Integer.parseInt(br.readLine());
                   if(n4==1)
                   {
                       System.out.print("enter new password->");
                   char []cg=console.readPassword();
                   String p2=new String(cg);
                       s[n3].schange(p2);
                   }
                   System.out.print("want to check teacherinfo 1/0 ->");
                   int temp=Integer.parseInt(br.readLine());

                   if(temp==1)
                   {


                   System.out.print("enter the teacher id to check his info 0/1/2->");
                   int n5=Integer.parseInt(br.readLine());
                   s[n3].scheck(st[n5]);
                   }
                    System.out.print("want to check placementinfo 1/0 ->");
                   int temp1=Integer.parseInt(br.readLine());
                   if(temp1==1)
                   {

                   String ans=c1[n3].sreceive();
                   System.out.println("your placement status:" + ans);
                   }
                   System.out.print("want to check workshopinfo 1/0 ->");
                   int temp2=Integer.parseInt(br.readLine());
                   if(temp2==1)
                   {

                   String ans1=c1[n3].sreceive1();
                   System.out.println("your workshop info:" + ans1);
                   }
                 }

                 System.out.print("WANT TO CONTINUE??? 1/0->");
                 n1=Integer.parseInt(br.readLine());
                 break;
        }
       }
       else
       {
         System.out.print("WRONG PASSWORD WANT TO ENTER AGAIN??? 1/0->");
          n1=Integer.parseInt(br.readLine());
          ind=0;
       }
        ind=0;
       if(n1==0)
       {


       System.out.print("WANT TO CONTINUE??? 1/0->");
        n1=Integer.parseInt(br.readLine());
       }


     }
  }
}

