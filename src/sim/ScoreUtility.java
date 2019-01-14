/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

/**
 *
 * @author SAM
 */
public class ScoreUtility {
    
    int e=65;
    int w=25;
    int t;
    int f=150;
    public  void cal(){
        int sum=Integer.sum(e, w);
    double weight=(double)sum/f*100;
    
    System.out.println(weight);
    
    
    }
    public static void main(String[] args) {
     ScoreUtility sc = new ScoreUtility();  
       sc. cal();
        
    }
    
}
