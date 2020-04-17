
package supermario;

interface SuperMario {
    
    void pick (Item item);//pick up items
    
    public void reciveHit();//he recieves a hit and changes the state
    
    public boolean fire();//shoots fire
    
    public int getCointCount();//coin counter
    
    public State getCurrentState();// returns current health
}

enum Item{
    COIN, MUSHROOM, FLOWER;
}
enum State{
    DEAD, SMALL_MARIO, BIG_MARIO, FIRE_MARIO;
}
