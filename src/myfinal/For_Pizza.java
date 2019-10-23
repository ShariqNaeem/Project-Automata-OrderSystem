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
public class For_Pizza {
    private int remainingAmount;
    private int totalAmount;
    private static int quantityOfPIZZA=0;
    Scanner scan=new Scanner(System.in);
    int amountOfPIZZA = 500;
	
    int TT[][];
    int IS;
    int  FS;
    int [] possibleAmount;
    
    
    public For_Pizza(int[][] TT,int IS,int FS,int[] possibleAmount){
        this.TT=TT;
        this.IS=IS;
        this.FS=FS;
        this.possibleAmount=possibleAmount;
    }
    
    public int getRemainingAmount(){
        return remainingAmount;
    }
    
    public int getQuantityOfPIZZA(){
        return quantityOfPIZZA;
    }
    
    public boolean transaction(int credit,int st){
        st=transition(st,credit);
        remainingAmount=credit;
        if(st==FS){
            remainingAmount=credit-amountOfPIZZA;
            
            if(remainingAmount>=amountOfPIZZA){
                
                while(credit-amountOfPIZZA>=500){
                    System.out.println("Your transaction successful");
                    System.out.println("Do you want to purchase more ?");
                    System.out.println("Press 1 for Yes");
                    System.out.println("Press 2 for No");
                    
                    boolean flag=false;
                    int choice;
                    do{
                        while(!scan.hasNextInt())scan.next();
                        choice=scan.nextInt();
                        if(choice==1 || choice==2){
                            flag=true;
                        }
                    }while(!flag);
                    
                    
                    switch(choice){
                        case 1:
                            boolean check = transaction(remainingAmount, st);
                            if (check)
                                quantityOfPIZZA++;
                            return true;
                            
                        case 2:
                            quantityOfPIZZA++;
                            return true;
                    }
                }
            }
            quantityOfPIZZA++;
            return true;
        }else{
            if(st!=FS){
                while(st!=FS){
                    System.out.println("Not enough amount to purchase PIZZA");
                    System.out.println("Press 1 for input more amount");
                    System.out.println("Press 2 for exit");
				
                    boolean flag=false;
                    int choice;
                    do{
                        while(!scan.hasNextInt())scan.next();
                        choice=scan.nextInt();
                        if(choice==1 || choice==2){
                            flag=true;
                        }
                    }while(!flag);
                    
                    switch(choice){
                        case 1:
                            totalAmount=addAmount(credit);
                            boolean check = transaction(totalAmount, st);
                            if (check)
                                return true;
                            
                        case 2:
                            return false;
                    }
                }
            }
        }
        return false;
    }
    
    public int transition(int st,int credit){
        
        if((credit>=100 && credit<500) || credit==100){
            return TT[st][0];
        }
        
        if((credit>=500 && credit<1000) || credit==500){
            return TT[st][1];
        }
        
        if((credit>=1000 && credit<5000) || credit==1000){
            return TT[st][2];
        }
        
        if(credit>=5000){
            return TT[st][3];
        }
        return -1;
    }
    
    public int addAmount(int credit){
        System.out.println("Enter acceptable amount:");
        int totAmount;
	int newAmount;
        boolean flag=false;
        
        do{
            while(!scan.hasNextInt())scan.next();
            newAmount=scan.nextInt();
            
            for (int i = 0; i < possibleAmount.length; i++) {
                if(newAmount==possibleAmount[i]){
                    totAmount = newAmount+credit;
                    return totAmount;
                }  
            }
        }while(!flag);
        return -1;
    }
}
