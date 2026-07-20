import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private final Semaphore fizzSem = new Semaphore(0);
    private final Semaphore buzzSem = new Semaphore(0);
    private final Semaphore fizzbuzzSem = new Semaphore(0);
    private final Semaphore numberSem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizzSem.acquire();
                printFizz.run();
                numberSem.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSem.acquire();
                printBuzz.run();
                numberSem.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzzSem.acquire();
            printFizzBuzz.run();
            numberSem.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberSem.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSem.release();
            } else if (i % 3 == 0) {
                fizzSem.release();
            } else if (i % 5 == 0) {
                buzzSem.release();
            } else {
                printNumber.accept(i);
                numberSem.release();
            }
        }
    }
}