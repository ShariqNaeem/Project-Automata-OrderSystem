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
public class For_Pepsi {
    private int remainingAmount;
    private int totalAmount;
    private static int quantityOfPEPSI=0;
    Scanner scan=new Scanner(System.in);
    int amountOfPepsi = 50;
	
    int TT[][];
    int IS;
    int  FS;
    int [] possibleAmount;
    
    
    public For_Pepsi(int[][] TT,int IS,int FS,int[] possibleAmount){
        this.TT=TT;
        this.IS=IS;
        this.FS=FS;
        this.possibleAmount=possibleAmount;
    }
    
    public int getRemainingAmount(){
        return remainingAmount;
    }
    
    public int getQuantityOfPEPSI(){
        return quantityOfPEPSI;
    }
    
    public boolean transaction(int credit,int st){
        st=transition(st,credit);
        remainingAmount=credit;
        if(st==FS){
            remainingAmount=credit-amountOfPepsi;
            
            if(remainingAmount>=amountOfPepsi){
                
                while(credit-amountOfPepsi>=50){
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
                                quantityOfPEPSI++;
                            return true;
                            
                        case 2:
                            quantityOfPEPSI++;
                            return true;
                    }
                }
            }
            quantityOfPEPSI++;
            return true;
        }else{
            if(st!=FS){
                while(st!=FS){
                    System.out.println("Not enough amount to purchase PEPSI");
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
        if((credit>=10 && credit<20) || credit==10){
            return TT[st][0];
        }
        
        if((credit>=20 && credit<50) || credit==20){
            return TT[st][1];
        }
        
        if((credit>=50 && credit<100) || credit==50){
            return TT[st][2];
        }
        
        if((credit>=100 && credit<500) || credit==100){
            return TT[st][3];
        }
        
        if((credit>=500 && credit<1000) || credit==500){
            return TT[st][4];
        }
        
        if(credit>=1000){
            return TT[st][5];
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
