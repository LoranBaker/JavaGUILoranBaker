
package supermario;

import java.util.Scanner;

public class SuperMarioExectuor {
    public static void main(String[] args) {
        
        SuperMarioImplementation smi = new SuperMarioImplementation(0, State.SMALL_MARIO);
        Scanner sc = new Scanner(System.in);
        String line = "";
        System.out.println("Super mario");
        System.out.println();
        System.out.println("Printing possible commands: ");
        System.out.println("");
        System.out.println(" GET_COINS, GET_STATE, FIRE, SHROOM, COIN, FLOWER, HIT ");
        System.out.println("");
        smi.getCointCount();
        smi.getCurrentState();
        
        while(true){
            if(smi.checkCurrentState() == State.DEAD){
                System.out.println("Mario is dead! GAME OVER!");
                break;
            }
            System.out.println("Enter a command or enter 'END' to exit: ");
            line = sc.nextLine();
            if(line.contentEquals("END")){
                System.out.println("Exiting..");
                System.out.println("Sucessufully exited");
                break;
            }
            else if(line.contentEquals("GET_COINS")){
                smi.getCointCount();
            }
            else if(line.contentEquals("GET_STATE")){
                smi.getCurrentState();
            }
            else if(line.contentEquals("FIRE")){
                smi.fire();
            }
            else if(line.contentEquals("SHROOM")){
                smi.pick(Item.MUSHROOM);
            }
            else if(line.contentEquals("COIN")){
                smi.pick(Item.COIN);
            }
            else if(line.contentEquals("FLOWER")){
                smi.pick(Item.FLOWER);
            }
            else if(line.contentEquals("HIT")){
                smi.reciveHit();
            }
            
        }
    }
}
