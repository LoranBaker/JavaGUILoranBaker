/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four;

/**
 *
 * @author PC
 */
public class Student implements Observer {

    public Student(Observable observable) {
        observable.registerObserver(this);
    }
    
    

    @Override
    public void update() {
        System.out.println("Student gets notification!");
    }
    
}
