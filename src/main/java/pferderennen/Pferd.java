package pferderennen;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.Random;

public class Pferd extends Thread {
    String name;
     static final int minStrecke=100;
     static final int maxStrecke=1000;
    int zurueckgelegteDistanz;
    public Pferd(String name){
        this.name=name;
        this.zurueckgelegteDistanz=0;
    }


    @Override
    public void run() {
        Random random=new Random();
        while (zurueckgelegteDistanz<maxStrecke){
            int distanz=random.nextInt(10);
            zurueckgelegteDistanz+=distanz;
            System.out.println(name+" hat "+zurueckgelegteDistanz+ " Meter zurückgelegt.");

            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if (zurueckgelegteDistanz>maxStrecke){
                System.out.println(name+" ist im Ziel.");
            }
        }
    }
    public int getGelaufeneDistanz(){
        return zurueckgelegteDistanz;
    }


    public static void main(String[]args){
        Pferd pferd1= new Pferd("Peter");
        Pferd pferd2= new Pferd("Lolek");

        pferd1.start();
        pferd2.start();

    }
}
