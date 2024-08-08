package Level1.Stacks;

public class OOPS {
    public static class Person{
        int age;
        String name;

        void sayHello(){
            System.out.println("Hello" + " " +  name +" "+ age);
        }
    }
    public static void main(String[] args) {
        Person p1= new Person();
        p1.name="imran";
        p1.age=10;
//        p1.sayHello();

        Person p2 = new Person();
        p2.name="Bhat";
        p2.age=12;
//        p2.sayHello();

        p1=p2;
        Person p3=p1;
        p3.age=0;
        p3.name="kuni";
        p1.sayHello();

//        swapFnc();
//        p1.sayHello();
//        p1.sayHello();
    }
}
