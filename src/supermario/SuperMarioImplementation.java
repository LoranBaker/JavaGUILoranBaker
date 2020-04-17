package supermario;

import javax.sound.midi.Soundbank;
import jdk.nashorn.internal.runtime.ScriptObject;

public class SuperMarioImplementation implements SuperMario {

    private int coinCount;
    private State state;

    //konstruktor za defaultno stanje
    public SuperMarioImplementation(int coinCount, State state) {
        this.coinCount = 0;
        this.state = State.SMALL_MARIO;
    }

    @Override
    public void pick(Item item) {
        //if mario is alive
        if (state != State.DEAD) {
            //if mario pick up coin
            if (item == item.COIN) {
                System.out.println("You picked up a coin!");
                coinCount++;//coin count
                //if mario pick up mushrooms
            } else if (item == item.MUSHROOM) {
                System.out.println("You picked up a shroom!");
                //he changes his state to big 
                if (state == State.SMALL_MARIO) {
                    this.state = State.BIG_MARIO;
                }  
            }
            //if mario pick up flower
            else if (item == item.FLOWER) {
                System.out.println("You picked up a flower!");
                //state changes from small to big
                if (state == State.SMALL_MARIO) {
                    this.state = state.BIG_MARIO;
                } 
                //state changes from big to fire
                else if (state == State.BIG_MARIO) {
                    this.state = State.FIRE_MARIO;
                    System.out.println("from BIG go to FIRE!");
                }
            }
        }
    }

    @Override
    public void reciveHit() {
        //if mario is alive
        if (state != State.DEAD) {
            //if mario gets hits
            if (state == State.BIG_MARIO || state == State.FIRE_MARIO) {
                System.out.println("Mario has recived a hit!");
                this.state = State.SMALL_MARIO;
                System.out.println("His new state is: " + state);
                //if he is small and gets hits
            } else if (state == State.SMALL_MARIO) {
                System.out.println("Mario has recived a hit!");
                this.state = State.DEAD;
                System.out.println("Game over");
            }
        }
    }

    @Override
    public boolean fire() {
        //only if mario gets fire state this will happen
        if (this.state == State.FIRE_MARIO) {
            System.out.println("Mario Fires at the enemies!");
            return true;
        }//else if
        System.out.println("You cant fire yet, Mario");
        return false;
    }

    @Override
    //funkcija koja vraca coin count
    public int getCointCount() {
        System.out.println("Mario has: " + coinCount + " coins");
        if (coinCount > 10) {
            System.out.println("Could you lend me some?");
        }
        return coinCount;
    }

    @Override
    //funkcija koja vraca trenutno stanje
    public State getCurrentState() {
        System.out.println("Mario current state is: " + state);
        return state;
    }
    
    public State checkCurrentState(){
       return state;
    }
}
