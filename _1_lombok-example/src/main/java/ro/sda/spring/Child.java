package ro.sda.spring;

public class Child extends Parent {
    private int b;

    public Child(int a, int b) {
        super(a);
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}

class Example {

    public static void main(String[] args) {

        Parent parent = new Parent(25);
        System.out.println(parent.getA());

        System.out.println("-------------");

        Child child = new Child(67, 34);
        System.out.println(child.getA());
        System.out.println(child.getB());


    }


}
