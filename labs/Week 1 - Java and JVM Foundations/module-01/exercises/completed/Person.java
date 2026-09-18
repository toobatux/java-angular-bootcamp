public class Person {
    // Provided boilerplate fields — focus on constructor + display + new
    String name;
    int age;

    public Person(String name, int age) {
        // TODO: assign this.name / this.age
        this.name = name;
        this.age = age;
    }

    public void display() {
        // TODO: print "<name> is <age> years old"
        System.out.println(name + " is " + age + " years old");
    }

    public static void main(String[] args) {
        // TODO: create Person("Aman", 21) and call display()
        Person p = new Person("Aman", 21);
        p.display();
    }
}
