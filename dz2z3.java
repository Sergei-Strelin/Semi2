/*  Семинар №2. Задание №3.
    В файле содержится строка с данными:
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
**/


import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class dz2z3 {
    public static void main(String[] args){

        String stroka = fileRead("data_dz2z3.txt");                     
        String[] result = resultStr(parsRawString(stroka)).split(",");    
        printStr(result);

    }



    static String fileRead(String fileName){
        String strInFile = "";
        try {
            BufferedReader str = new BufferedReader(new FileReader(fileName));
            strInFile = str.readLine();
            str.close();
        } catch (IOException ex){
            System.out.println("Не удалось прочитать файл " + fileName + " !");
        }
        return strInFile;
    }



    static String parsRawString(String str){
        StringBuilder rezult = new StringBuilder();
        str = str.substring(1, str.length()-1);     
        String[] strArr = str.split(", ");               
        for (String el : strArr){
            rezult.append(String.join(",", stringPars(el)));
            rezult.append(",");
        }
        return rezult.toString();                                   
    }



    static String resultStr(String str){ 
        StringBuilder rezult = new StringBuilder();
        String[] arr = str.split(",");
        for (int i = 0; i <arr.length ; i+=3) {
            if (arr[i].endsWith("а")) {
                rezult.append("Студентка ");
                rezult.append(arr[i]);
                rezult.append(" получила ");
            } 
            else {
                rezult.append("Студент ");
                rezult.append(arr[i]);                
                rezult.append(" получил ");
            }
            rezult.append(arr[i+1]);
            rezult.append(" по предмету ");
            rezult.append(arr[i+2]);
            rezult.append(".\n");
        }
        return rezult.toString();
    }




    static String[] stringPars(String str){
        int index = 0;
        str = str.substring(1, str.length()-1);       
        String[] strArr = str.split(",");                   
        int len = strArr.length;
        String[] strSQL = new String[len];
        for (String elem : strArr){
            int ind = elem.indexOf(':');                          
            strSQL[index] = elem.substring(ind+2, elem.length()-1);    
            index++;
        }
        return strSQL;
    }

    
    
     static String printStr(String[] text){
        for (String el : text){          
            System.out.println(el);
        }
        return null;
    }   
}