package printMac;

public class Cartridgefill implements Runnable{
    Printer printer;

    public Cartridgefill(Printer printer) {
        this.printer = printer;
    }



    @Override
    public void run() {
       while (true){
           if (printer.inkcount==500){
               }
           System.out.println("sedcrfvtgbynuimo,");
          printer.fillcartridge();
        }

    }
}
