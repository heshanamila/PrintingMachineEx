package printMac;

public class Paperfill implements Runnable{
    Printer printer;

    public Paperfill(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized (this){
            printer.fillpapers();

        }



    }

}
