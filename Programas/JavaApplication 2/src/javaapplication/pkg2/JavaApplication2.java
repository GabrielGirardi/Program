/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.pkg2;

import java.util.Scanner;

/**
 *
 * @author gabriel.girardi
 */
public class JavaApplication2 {

    public static void main(String[] args) {
               float a = 0;
               float c = 0;
               float d = 0;
                 Scanner input = new Scanner(System.in);
                  System.out.println("informe um valor: ");
                     a = input.nextInt();                      
                       
                       System.out.println("Informe a operação (1 +, 2 -, 3 *, 4 /  ");
                       int b = input.nextInt();
                       

                       switch (b)
                       {
                         case 1:
                               System.out.println("Informação inserida é (+), digite o proximo valor: ");
                               c = input.nextInt ();
                               d = a + c;
                               System.out.println(a + " + " + b + " = " + d);
                               break;
                               
                               
                         case 2: 
                               System.out.println("Informação inserida é (-), digite o proximo valor: ");
                               c = input.nextInt ();
                               d = a - c;
                               System.out.println(a + " - " + b + " = " + d);
                               break;
                               
                         case 3:
                               System.out.println("Informação inserida é (*), digite o proximo valor: * ");
                               c = input.nextInt ();
                               d = a * c;
                               System.out.println(a + " * " + b + " = " + d);
                               break;
                               
                         case 4: 
                               System.out.println("Informação inserida é (/),  digite o proximo valor: ");
                               c = input.nextInt ();
                               d = a / c;
                               System.out.println(a + " / " + b + " = " + d);
                               break;
                       
             }
                             
    }
    
}