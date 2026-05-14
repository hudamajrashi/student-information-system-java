package FinalProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Person {    //information for patiant
    private String Fullname;
    private String sex;
    private int age;

    public Person(String Fullname,String sex, int age) {
        if (age <= 0) {
            
            
    throw new IllegalArgumentException("The age should be positive number");
        }
        this.Fullname = Fullname;
        this.sex=sex;
        this.age = age;
    }

    public String getName() {
        return Fullname;
    }
    
    
public String getSex() {
        return sex;
    }


       public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "FullName: " + Fullname + ", Sex: " + sex +", Age: " + age;
    }
}


