/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four;

public class ObserverTest {
    public static void main(String[] args) {
        //ONE
        Newspaper newpaperObservable = new Newspaper();
        //ONE TO MANY
        Observer personObserver = new Person(newpaperObservable);
        Observer companyObserver= new Company(newpaperObservable);
        
        newpaperObservable.notifyObserver();
        newpaperObservable.removeObserver(personObserver);
        newpaperObservable.notifyObserver();
    }
}
