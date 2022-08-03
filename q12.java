import java.util.*;


class student {
    private int stuid, contno;
    private String sname;

    student(int stuid, String sname, int contno) {
        this.stuid = stuid;
        this.sname = sname;
        this.contno = contno;
    }

    public int getstuid() {
        return stuid;
    }

    public String getsname() {
        return sname;
    }

    public int getcontno() {
        return contno;
    }

    public String toString() {
        return stuid + " " + sname + "" + contno;
    }

}

class q12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        List<student> c = new ArrayList<student>();
        int ch;
        do {
          
            System.out.println("enter 1 for insert  :");
            System.out.println("enter 2 for display :");
            System.out.println("enter 3 for search  :");
            System.out.println("enter 4 for delete  :");
            System.out.println("enter 5 for update  :");
            System.out.println("enter the choice:");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("enter the student id         :");
                    int sid = s.nextInt();
                    System.out.print("enter the student name       :");
                    String sname = s1.nextLine();
                    System.out.print("enter the student contact no :");
                    int contno = s.nextInt();
                    c.add(new student(sid,sname,contno));
                    break;
                case 2:
                    System.out.println("----------------------------------------");
                    Iterator<student> i = c.iterator();
                    while (i.hasNext()) {
                        student e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("----------------------------------------");
                    break;

                case 3:
                    Boolean found = false;
                    System.out.println("enter student id to search :");
                    int stuid = s.nextInt();
                    System.out.println("----------------------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        student e = i.next();
                        if (e.getstuid() == stuid) {
                            System.out.println(e);
                            found = true;
                        }

                    }

                    if (!found) {
                        System.out.println("Record not found");
                    }
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    found = false;
                    System.out.println("enter student id to delete :");
                    stuid = s.nextInt();
                    System.out.println("----------------------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        student e = i.next();
                        if (e.getstuid() == stuid) {
                            i.remove();
                            found = true;
                        }

                    }

                    if (!found) {
                        System.out.println("Record not found");
                    } else {
                        System.out.println("record is successfully deleted");
                    }
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    found = false;
                    System.out.println("enter student id to update :");
                    stuid = s.nextInt();
                   
                    ListIterator<student>li=c.listIterator();
                    while (li.hasNext()) {
                        student e = li.next();
                        if (e.getstuid() == stuid) {
                            System.out.print("enter new name:");
                             sname = s1.nextLine();
                            System.out.print("enter new contact number :");
                             contno = s.nextInt(); 
                             li.set(new student(stuid,sname,contno));                           
                            found = true;
                        }

                    }

                    if (!found) {
                        System.out.println("Record not found");
                    } else {
                        System.out.println("record is successfully updated");
                    }
                   
                    break;
                    default:
                    System.out.println("enter valid number"); 
             }
        } while (ch != 0);
    }
}
