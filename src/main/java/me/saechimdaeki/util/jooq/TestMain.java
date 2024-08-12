package me.saechimdaeki.util.jooq;


sealed class TestSeal permits TestA, TestB {
    public TestSeal() {
        System.out.println("TestSeal" + getClass().getSimpleName());
    }
}

final class TestA extends TestSeal {

}

final class TestB extends TestSeal {

}

public class TestMain {
    public static void main(String[] args) {
        TestSeal testSeal = new TestA();
        TestSeal testSeal2 = new TestB();
    }
}
