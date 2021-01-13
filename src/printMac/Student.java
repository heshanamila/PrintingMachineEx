package printMac;

public class Student implements Runnable {
    Printer printer;

    public Student(Printer printer){
        this.printer=printer;

    }
    @Override
    public void run() {
//        while (printer.isalive){
//            }
//        printer.isalive = false;
        printer.print();
    }
}
