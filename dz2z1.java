/*  Задание № 1.
    В файле содержится строка с исходными данными в такой форме:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
    SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
    Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
    Значения null не включаются в запрос.
 */

 import java.io.FileReader;
 import java.io.IOException;
 import java.io.BufferedReader;
 
 
 public class dz2z1 {
     public static void main(String[] args)  {
 
         String str = fileRead("data_dz2z1.txt");                
         String[] sqlVal = stringPars(str);                                
         System.out.println(stringSQL(sqlVal[0],sqlVal[1],sqlVal[2]));   
 
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
 
 

     static String stringSQL(String name, String country, String city){
         StringBuilder strSQL = new StringBuilder();
 
         strSQL.append("SELECT * FROM students WHERE name = \"");
         strSQL.append(name);
 
         strSQL.append("\" AND country = \"");
         strSQL.append(country);
 
         strSQL.append("\" AND city = \"");
         strSQL.append(city);
         strSQL.append("\";");
 
         return strSQL.toString();
     }
 
 }