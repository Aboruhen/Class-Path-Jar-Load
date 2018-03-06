package uberfat;

import com.google.common.base.Stopwatch;

import java.time.Duration;

public class UberMain {

    public long stopWatch() {
        System.out.println("Start stopwatch with guava 23.0");
        Stopwatch unstarted = Stopwatch.createUnstarted();
        Stopwatch start = unstarted.start();
        Duration elapsed = start.elapsed();
        System.out.println("Finish stopwatch with guava 23.0");
        return elapsed.getNano();
    }
}
