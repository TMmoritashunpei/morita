package test;

public class DogTest {
	String name;
    int age;
    static int countDog;

    static void count(){
        countDog ++ ;
    }

    public DogTest(String name,int age){
        this.name = name;
        this.age = age;
        count();
    }
}

public class DogTest{

    public static void main(String[] args){
        DogTest dog = new DogTest("����",10);
        System.out.print(DogTest.countDog+"�C�ڂ̃��������F���O "+ dog.name +" �N��F"+ dog.age +"��");
    }
}

