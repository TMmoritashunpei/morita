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
        DogTest dog = new DogTest("しぃ",10);
        System.out.print(DogTest.countDog+"匹目のワンちゃん：名前 "+ dog.name +" 年齢："+ dog.age +"歳");
    }
}

