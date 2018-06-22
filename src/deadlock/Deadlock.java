/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

/**
 *
 * @author Olayinka Akeju
 */
public class Deadlock {
    
    String program1 = "Bagpack";
    String program2 = "Laptops";
    
    Thread trd1 = new Thread("Thread One"){
        public void run(){
            while(true) synchronized (program1) {
                synchronized (program2) {
                    System.out.println(program1 + " " + program2);
                }
            }
        }
    };

    Thread trd2 = new Thread("Thread Two"){
        public void run(){
            while(true) synchronized (program2) {
                synchronized (program1) {
                    System.out.println(program2 + " " + program1);
                }
            }
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Deadlock obj = new Deadlock();
        obj.trd1.start();
        obj.trd2.start();
    }
    
}
