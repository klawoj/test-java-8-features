package defaultmethods;

public class DefaultMethodsInheritance {

    interface A {
        default void foo() {
            System.out.print("A.foo");
        }
    }

    interface B {
        default void foo() {
            System.out.print("B.foo");
        }
    }

    interface C {
        default void foo() {
            System.out.print("C.foo");
        }
    }

    interface X extends A, B {
        default void foo() {
            B.super.foo();
        }
    }

    interface Y extends A, B {
        void foo();
    }


    static class Dimpl implements X, C {

        @Override
        public void foo() {
            C.super.foo();
        }
    }

}
