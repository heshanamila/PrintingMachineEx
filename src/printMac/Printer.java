package printMac;

public class Printer implements Runnable {

    int paperbundle = 250;
    int inktray = 500;
    int papercount = 0;
    int inkcount = 0;
    public boolean isalive = false;
    Printer printer;



    public Printer() {

    }


    @Override
    public void run() {
    }

    public void print() {
        synchronized (this){
            for (int i = 1; i <= 250; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                papercount++;
                paperbundle--;
                inkcount++;
                inktray--;
                System.out.println(Thread.currentThread().getName() + " is printing " + i);
                System.out.println(paperbundle);
                System.out.println(inktray);


                if (this.paperbundle == 0) {

                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (inktray == 0) {

                        try {
                            printer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
//        System.out.println("count  "+count);


            }
        }
    }
    public synchronized void fillcartridge(){
        if (inktray==0){
            System.out.println("Cartridge Refilling");
            this.inktray=500;
        }
        notify();
    }

    public synchronized void fillpapers() {
        if (paperbundle==0){
            System.out.println("paper Filling");
            this.paperbundle=250;
        }
        notify();
    }
}