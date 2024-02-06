package e05_sealed_types.user;

import e05_sealed_types.library.MySubTypeA;
import e05_sealed_types.library.MySubTypeB;

import java.util.List;

public class Main {

    public static void main(String[] args){

        MySubTypeA a = new MySubTypeA();
        MySubTypeB b = new MySubTypeB();
        var myTypes = List.of(a, b);

        /*for(MyBaseType type : myTypes){
            System.out.println(type);
        }*/

    }
}
