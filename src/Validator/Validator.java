package Validator;

import java.util.Scanner;

public class Validator {
    protected Scanner sc;
    int sum2 = 0;//intialization of variable
    int sum = 0;

    public boolean checkPassword(String password){//checking password
        boolean lengthCheck = false;//properties for logical operations
        boolean upperCaseCheck = false;//properties for logical operations
        boolean lowerCaseCheck = false;//properties for logical operations
        boolean digitCheck = false;//properties for logical operations
        boolean specialSymbol = false;//properties for logical operations
        boolean check = false;//properties for logical operations

        for(int i = 0 ; i < password.length(); i++) {//for loop for checking
            if(password.isEmpty()){
                System.out.println("Invalid password!"+"\n"+" Password must to contain at least 1 uppercase letter, 1 lowercase letter, 1 digit,"+"\n"+" 1 special symbol(@,$,!,^) and length more or equal to 8.\n"+"Try again : ");
                password = "";
            }
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {//logical statements for checking password
                upperCaseCheck = true;
            }
            if (Character.isLowerCase(ch)) {//logical statements for checking password
                lowerCaseCheck = true;
            }
            if (Character.isDigit(ch)) {//logical statements for checking password
                digitCheck = true;
            }
            if (ch == 94 || ch == 64 || ch == 36 || ch == 33) {//logical statements for checking password
                specialSymbol = true;
            }
            if (password.length() >= 8) {//logical statements for checking password
                lengthCheck = true;
            }
        }
        if(upperCaseCheck == true && lowerCaseCheck == true && digitCheck == true && lengthCheck == true && specialSymbol == true) {//logical statements for checking password
            return true;
        }

        else {//logical statements for checking password
            System.out.println("Invalid password! \nTry again : ");
            password = "";
            return false;
        }
    }
    public  boolean checkPasswordLogIn(String password,String realPassword){
        boolean status;
        if (realPassword.equals(password)){
            return true;
        }else{
            return false;
        }


    }
}
