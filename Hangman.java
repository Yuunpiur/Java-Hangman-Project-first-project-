package Java_FinishedProj;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// ? THINGS TO IMPROVE
// ! USE MORE FUNCTIONS
// ! TRY TO USE OBJECTS?
// ! NAME VARIABLES CORRECTLY ----
// ! IMPROVE THE FLOW OF THE PROGRAM?

public class Hangman
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        // store for the words that the user will guess
        String wordToGuess = "Scanner";
               wordToGuess = wordToGuess.toUpperCase();
   
        
        ArrayList<String> eachLetterInAword = new ArrayList<>();
        eachLetterInAword = stripWordsIntoLetters(wordToGuess);
        

      

        
        String[][][] eigthHangmanPics = 
        {{{"|---"},
        {"|   "},
        {"|   "},
        {"|     "},
        {"|     "}},


   
        {{"|---"},
        {"|  |"},
        {"|   "},
        {"|     "},
        {"|     "}},



        {{"|---"},
        {"|  |"},
        {"|  0"},
        {"|     "},
        {"|     "}},



        {{"|---"},
        {"|  |"},
        {"|  0"},
        {"|  |  "},
        {"|    "}},



        {{"|---"},
        {"|  |"},
        {"|  0"},
        {"| /|  "},
        {"|     "}},



        {{"|---"},
        {"|  |"},
        {"|  0"},
        {"| /|\\"},
        {"|     "}},


   
        {{"|---"},
        {"|  |"},
        {"|  0"},
        {"| /|\\"},
        {"| /  "}},

   
        {{"|---"},
        {"|  |"},
        {"|  0"},
        {"| /|\\"},
        {"| / \\"}}};

        // LOOP THIS UNTIL TRIES IS ZERO  
        // lives the user has
        int livesOfUser = 7;
        int lengthOfSubArrayHangmanPics = 5;
        int numOfSpacesInAWord = spacesCounter(eachLetterInAword);

        String guessedLetterOfUser = "";
        ArrayList<String> guessedLettersOfUser = new ArrayList<>();

        while(true)  
        {
            System.out.println("You have " + livesOfUser + " left");
       
            displayHangman(eigthHangmanPics, lengthOfSubArrayHangmanPics, livesOfUser);

            if(livesOfUser <= 0)
             {
                System.out.println("You lose!");
                break;
             }

            boolean checkerForEveryIte = false;
            
         
           // ask the user each single letter 
           System.out.print("Guess a letter: ");
           guessedLetterOfUser = sc.nextLine();


           if(guessedLetterOfUser.equals(" "))
           {
            System.out.println("Spaces are not allowed!");
            continue;
           }

           System.out.print("Word: ");

           // keeps track of the quantity of letters in the line
           int numOfDisplayedLetters = 0;
           


           // display the guessed letters
           for(int i = 0; i < wordToGuess.length(); i++)
           {
               // ! THE GUESSED LETTERS EQUALS THE SAME INDEX?         THE LETTER IS NEW?
               if(guessedLetterOfUser.equals(eachLetterInAword.get(i)) && !(guessedLettersOfUser.contains(guessedLetterOfUser)))
               {

                  System.out.print(guessedLetterOfUser);
                  guessedLettersOfUser.add(guessedLetterOfUser);

                  // keep track if the user got the correct ans
                  checkerForEveryIte = true;
                  numOfDisplayedLetters++;
           
               }

               // ! DISPLAY ALL THE GUESSED LETTERS
               else if(guessedLettersChecker(eachLetterInAword.get(i), guessedLettersOfUser))
               {

                System.out.print(eachLetterInAword.get(i));
                numOfDisplayedLetters++;
               
               }

               else 
               {
                  spaceOrLetter(eachLetterInAword, i);
               
               
                }

           }

          System.out.println();
           // subtract the users livesOfUser based on the following condition
           if(checkerForEveryIte)
           {
             
             // the user won!
             if(wordToGuess.length() - numOfSpacesInAWord == numOfDisplayedLetters)
             {
                 System.out.println("You won!");
                 break;

             }
           }
           else 
           {

             livesOfUser--;

           }

           // display the hangman here
                  
    }
  }




    public static void spaceOrLetter(ArrayList<String> eachLetterInAword, int i)
    {
      // skip spaces
      if(eachLetterInAword.get(i).equals(" "))
      {
        System.out.print(" ");

      }
      else
      {
        System.out.print("_");
      }

    }

    public static ArrayList<String> stripWordsIntoLetters(String givenWord)
    {
      String charToAddToList = "";
      ArrayList<String> arrOfLetters = new ArrayList<>(); 
      
      for(int a = 0; a < givenWord.length(); a++)
        {

          
            charToAddToList = String.valueOf(givenWord.charAt(a));
            arrOfLetters.add(charToAddToList);
            
        }
        return arrOfLetters;

    }
    public static void displayHangman(String[][][] eigthHangmanPicsPiece, int lengthOfSubArrayHangmanPics, int livesOfUser)
    {
      for(int i = 0; i < lengthOfSubArrayHangmanPics; i++)
            {

              System.out.println(eigthHangmanPicsPiece[7 - livesOfUser][i][0]);
    
            }

    }
    public static Integer spacesCounter(ArrayList<String> eachLetterInAword)
    {

      int numOfSpacesInAWord = 0;
      for(int i = 0; i < eachLetterInAword.size(); i++)
      {
        if(eachLetterInAword.get(i).equals(" "))
        {
          numOfSpacesInAWord++;
        }

      }

      return numOfSpacesInAWord;

    }  
    
    public static Boolean guessedLettersChecker(String currLetterInword, ArrayList<String> guessedLettersOfUser)
    {
      for(String letter: guessedLettersOfUser)
      {
        if(currLetterInword.equals(letter))
        {
          return true;
        }
      }

      return false;

    }
}