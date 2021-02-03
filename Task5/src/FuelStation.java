import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FuelStation {
    private float GasCapacity = 500F;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Semaphore semaphore = new Semaphore(3);

    public float refuel(float request){
        try {
            semaphore.acquire();
            if (request > GasCapacity) {
                System.out.println("Not enough gas! refueling...");
            GasCapacity = 500F;
            }
            lock.writeLock().lock();
            GasCapacity -= request;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
            semaphore.release();
        }
        report();
        return request;
    }

    private void report(){
        try{
            lock.readLock().lock();
            System.out.println(this);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public String toString() {
        return String.format("GasCapacity = " + GasCapacity + "\n" + Thread.currentThread().getName().toString()
        );
    }
}
