package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCount = new AList<>();
        final int Op = 10000;
        int n;
        for (n = 1000; n <= 128000; n = n * 2) {
            SLList<Integer> l = new SLList<>();
            for (int i = 0; i < n; i++) {
                l.addLast(i);
            }
            Stopwatch sw = new Stopwatch();
            for (int i = 0 ; i < Op; i++) {
                l.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            ns.addLast(n);
            times.addLast(timeInSeconds);
            opCount.addLast(Op);
        }
        printTimingTable(ns, times, opCount);
    }

}
