/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfinal;
import java.util.*;
/**
 *
 * @author ShariQ
 */
public class MyFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scr=new Scanner(System.in);
        int [] possibleAmount = {10,20,50,100,500,1000};
        int [] possibleAmount2 = {100,500,1000,5000};
        System.out.println("What you want ?");
		
        System.out.println("Press 1 for Pepsi = RS.50"+"\n"+
                           "Press 2 for pizza = RS.500"+"\n"+
                           "Press 3 for Ice-Cream= RS.50"+"\n"+
                           "Press 4 for Burger= RS.100"+"\n"+
                           "Press 5 for EXIT");
        
        
        boolean flag=false;
        int choice;
        do{
            while(!scr.hasNextInt())scr.next();
            choice=scr.nextInt();
            if(choice==1 || choice==2 || choice==3 || choice==4 || choice==5){
                flag=true;
            }
        }while(!flag);
        
        switch(choice){
            case 1:
                int [][] TT1 = {{1,2,5,5,5,5},
		                {2,3,5,5,5,5},
		                {3,4,5,5,5,5},
                                {4,5,5,5,5,5},
			        {5,5,5,5,5,5},
			        {5,5,5,5,5,5}};
	
                int IS = 0;
                int FS = 5;
                For_Pepsi fp1=new For_Pepsi(TT1,IS,FS,possibleAmount);
                int credit=fp1.addAmount(0);
                
                
                boolean check=fp1.transaction(credit, IS);
                
                if(check){
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("FAILED");
                }
                
                System.out.println("Quantity of pepsi  is: "+fp1.getQuantityOfPEPSI());
                System.out.println("your remaining amount is:"+fp1.getRemainingAmount());
                break;
                
                
                
                case 2:
                int [][] TT2 = {{1,5,5,5},
		                {2,5,5,5},
		                {3,5,5,5},
                                {4,5,5,5},
			        {5,5,5,5},
			        {5,5,5,5}};
	
                int IS2 = 0;
                int FS2 = 5;
                For_Pizza fp2=new For_Pizza(TT2,IS2,FS2,possibleAmount2);
                int credit2=fp2.addAmount(0);
                
                
                boolean check2=fp2.transaction(credit2, IS2);
                
                if(check2){
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("FAILED");
                }
                
                System.out.println("Quantity of PIZZA  is: "+fp2.getQuantityOfPIZZA());
                System.out.println("your remaining amount is:"+fp2.getRemainingAmount());
                break;
                
                
                case 3:
                int [][] TT3 = {{1,2,5,5,5,5},
		                {2,3,5,5,5,5},
		                {3,4,5,5,5,5},
                                {4,5,5,5,5,5},
			        {5,5,5,5,5,5},
			        {5,5,5,5,5,5}};
	
                int IS3 = 0;
                int FS3 = 5;
                For_IceCream fp3=new For_IceCream(TT3,IS3,FS3,possibleAmount);
                int credit3=fp3.addAmount(0);
                
                
                boolean check3=fp3.transaction(credit3, IS3);
                
                if(check3){
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("FAILED");
                }
                
                System.out.println("Quantity of pepsi  is: "+fp3.getQuantityOfIC());
                System.out.println("your remaining amount is:"+fp3.getRemainingAmount());
                break;
                
                case 4:
                    int [][] TT4 = {{1,2,5,10,10,10},
                                    {2,3,6,10,10,10},
                                    {3,4,7,10,10,10},
                                    {4,5,8,10,10,10},
                                    {5,6,9,10,10,10},
                                    {6,7,10,10,10,10},
                                    {7,8,10,10,10,10},
                                    {8,9,10,10,10,10},
                                    {9,10,10,10,10,10},
                                    {10,10,10,10,10,10},
                                    {10,10,10,10,10,10}};
	
                int IS4 = 0;
                int FS4 = 10;
                For_Burger fp4=new For_Burger(TT4,IS4,FS4,possibleAmount);
                int credit4=fp4.addAmount(0);
                
                
                boolean check4=fp4.transaction(credit4, IS4);
                
                if(check4){
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("FAILED");
                }
                
                System.out.println("Quantity of burger  is: "+fp4.getQuantityOfBURGER());
                System.out.println("your remaining amount is:"+fp4.getRemainingAmount());
                break;
                
                case 5:
                    break;
        }
    }
    
    
}
