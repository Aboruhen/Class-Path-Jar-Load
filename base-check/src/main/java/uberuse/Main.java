package uberuse;

import com.google.common.base.Stopwatch;
import uberfat.UberClassCheck;

public class Main {

    public static void main(String[] args) {

        System.out.println("Run with guava 10.0");
        Stopwatch stopwatch = new Stopwatch();
        UberClassCheck uberClassCheck = new UberClassCheck();
        uberClassCheck.getFile();
    }

}
