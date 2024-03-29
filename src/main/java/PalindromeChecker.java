import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  if(noPunctuation(onlyLetter(noSpaces(word.toLowerCase()))).equals(noSpaces(reverse(noPunctuation(onlyLetter(word.toLowerCase()))))) == true)
    return true;
  return false;
}
public String reverse(String str)
{
    String sNew = new String();
    for(int x = str.length()-1; x > -1; x--)
    sNew += str.substring(x,x+1);
    return sNew;
}
public String noSpaces (String str){
    String s = "";
  for(int x = 0; x < str.length();x++)
  if(str.substring(x,x+1).equals(" ") != true)
  s += str.substring(x,x+1);
  
  return s;
}
  public String noPunctuation(String c) {
  String s = new String();
  for(int x = 0; x < c.length(); x++)
  if(c.substring(x,x+1).equals(".") == false && c.substring(x,x+1).equals(",") == false)
  s += c.substring(x,x+1);
  
  return s;
}
public String onlyLetter(String f){
 String cheese = "";
   for(int x = 0; x < f.length(); x++)
  if(Character.isLetter(f.charAt(x))==true)
   cheese = cheese + f.substring(x,x+1);
 
 return cheese;
}

  
}

