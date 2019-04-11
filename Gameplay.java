//ASKHSH 3
//Tsotras Stefanos icsd13189
package vrestislekseis;

import java.util.*;

/**
 *
 * @author Stefanos
 */
public class Gameplay {
    
    //DHLWSH METAVLHTWN
    private String name;
    private ArrayList<Word> wordlist;
    private List<String> shuffledword;
    private int end;
    private int tries;
    private int round;
    private int win;
    private int difficulty;
    private int wordchoice;
    private String wordguess;
    private List<String> word1;
    private List<String> word2;
    private List<String> word3;
    private Scanner sc1;
    
    //CONSTRUCTOR
    public Gameplay(){
        
        wordlist = new ArrayList<Word>();
        sc1 =new Scanner(System.in);
        
        //KALESMA MET
        CreateWords();
        
        //ARXIKOPOIHSH METAVLHTWN
        end=1;
        round=0;
        difficulty=0;
        
        //EISAGWGH ONOMATOS
        System.out.print("Insert your name : ");
        name = sc1.nextLine();
        System.out.println();
            
        //EPILOGH DUSKOLIAS
        while(difficulty != 1 && difficulty != 2){
            System.out.print("Choose level of difficulty (1 - Easy, 2 - Hard) : ");
            difficulty = sc1.nextInt();
            System.out.println();
        }
        
        
        
        while(end == 1){
            
            //ARXIKOPOIHSH METAVLHTWN
            tries=0;
            win=0;
            round++;
            //EMFANISH GYROU
            System.out.println(round +"os GYROS PAIXNIDIOU");
            
            //ANAKATEMA THS LISTAS GIA NA TUXAIA EPILOGH LEKSEWN
            Collections.shuffle(wordlist);
            
            //KALWNTAS THN SHUFFLEWORDS OI TREIS PRWTES LEKSEIS GINONTAI MIA ANAKATEMENH SE MORFH LISTAS
            shuffledword = ShuffleWords(wordlist.get(0).getWord()+wordlist.get(1).getWord()+wordlist.get(2).getWord());
            
            //KALWNTAS THN CREATELIST EISAGW SE TREIS LISTES TIS TREIS LEKSEIS
            //KANWNTAS ETSI EUKOLH THN EPEKSERGASIA TOUS LEKSH LEKSH
            word1 = CreateList(wordlist.get(0).getWord());
            word2 = CreateList(wordlist.get(1).getWord());
            word3 = CreateList(wordlist.get(2).getWord());
            
            //EMFANISH PERIGRAFHS PRWTHS LEKSHS
            System.out.print(wordlist.get(0).getDesc()+".            ");
                
            //EMFANISH VOITHEIAS ANALOGA ME THN DUSKOLIA
            //AN EINAI EUKOLH
            if(difficulty == 1){
                //EMFANIZEI TO PRWTO GRAMMA
                System.out.print(word1.get(0)+" ");
                //PAULES GIA TIS UPOLOIPES EKTOS THS TELEUTAIAS
                for(int i=1; i<word1.size()-1;i++){
                    System.out.print("_ ");
                }
                //KAI THN TELEUTAIA
                System.out.print(word1.get(word1.size()-1)+"\n");
                    
            }//AN EINAI DUSKOLH
            else{
                //EMFANIZEI MONO PAULES
                for(int i=0; i<word1.size();i++){
                    System.out.print("_ ");
                }
                System.out.println();
            }
            
            //EMFANISH PERIGRAFHS DEUTERHS LEKSHS
            System.out.print(wordlist.get(1).getDesc()+".            ");
            
            //EMFANISH VOITHEIAS ANALOGA ME THN DUSKOLIA
            //AN EINAI EUKOLH
            if(difficulty == 1){
                //EMFANIZEI TO PRWTO GRAMMA
                System.out.print(word2.get(0)+" ");
                //PAULES GIA TIS UPOLOIPES EKTOS THS TELEUTAIAS
                for(int i=1; i<word2.size()-1;i++){
                    System.out.print("_ ");
                }
                //KAI THN TELEUTAIA
                System.out.print(word2.get(word2.size()-1)+"\n");
                    
            }//AN EINAI DUSKOLH
            else{
                //EMFANIZEI MONO PAULES
                for(int i=0; i<word2.size();i++){
                    System.out.print("_ ");
                }
                System.out.println();
            }
            
            //EMFANISH PERIGRAFHS TRITHS LEKSHS
            System.out.print(wordlist.get(2).getDesc()+".            ");    
            
            //EMFANISH VOITHEIAS ANALOGA ME THN DUSKOLIA
            //AN EINAI EUKOLH
            if(difficulty == 1){
                //EMFANIZEI TO PRWTO GRAMMA
                System.out.print(word3.get(0)+" ");
                //PAULES GIA TIS UPOLOIPES EKTOS THS TELEUTAIAS
                for(int i=1; i<word3.size()-1;i++){
                    System.out.print("_ ");
                }
                //KAI THN TELEUTAIA
                System.out.println(word3.get(word3.size()-1)+"\n");
                    
            }//AN EINAI DUSKOLH
            else{
                //EMFANIZEI MONO PAULES
                for(int i=0; i<word3.size();i++){
                    System.out.print("_ ");
                }
                System.out.println();
            }
            
            while( win != 3 && tries < 5){
                
                //EMFANISH DIATHESIMWN LEKSEWN
                for(int i=0; i < shuffledword.size(); i++){
                    System.out.print(shuffledword.get(i)+" ");
                }
                System.out.println("\n");
                
                //EISAGWGH LEKSHS POU TA MANTEUTEI
                System.out.print("Choose which word you want to guess : ");
                wordchoice = sc1.nextInt();
                
                //EISAGWGH LEKSHS
                System.out.print("Insert the word : ");
                wordguess = sc1.nextLine();  //BUFFER FLUSH
                wordguess = sc1.nextLine();
                
                //KALWNTAS THN COMPAREWORDS GINETE H SUGKRISH
                if(CompareWords(wordguess,wordchoice)){
                    //AN MANTEPSE SWSTA TOTE AYKSANETE TO WIN KAI
                    System.out.println("Bravo! You guessed correctly\n");
                    win++;
                    //DIAGRAFETE H LEKSH POU MANTEPSE APO TIS TREIS ANAKATEMENES 
                    if(wordchoice == 1){
                        RemoveWord(word1);
                    }
                    else if(wordchoice == 2){
                        RemoveWord(word2);
                    }
                    else{
                        RemoveWord(word3);
                    }
                    
                }
                else{
                    //AN MANTEPSE LATHOS AYKSANONTAI TA TRIES
                    tries++;
                    System.out.println("Wrong. You still have "+(5-tries)+"tries\n");
                }
                

            }
            
            //DIAGRAFH TWN XRHSIMOPOIHMENWN LEKSEWN
            wordlist.remove(0);
            wordlist.remove(0);
            wordlist.remove(0);
            
            //AN H LISTA PERIEXEI LIGOTERO APO TREIS LEKSEIS TERMATIZEI
            if(wordlist.size()<3){
                System.out.println("Wooops, there are not enough words left to play you won!!!");
                break;
            }
            
            if(win == 3){
                System.out.println("CONGRATULATION "+name+"!!! You guessed all 3 words correctly");
            }
            else{
                System.out.println("GAME OVER");
                break;
            }
            
            //ERWTHMA GIA SUNEXISH PAIXNIDIOU H TERMATISMOS
            System.out.println("If you want to continue press 1");
            end = sc1.nextInt();
        }
        
    }
    
    //METHODOS DHMIOURGIAS LEKSEWN KAI EISAGWGH STH LISTA
    public void CreateWords(){
        
        wordlist.add(new Word("BANANA","Tropical fruit,very beneficial, many vitamins"));
        wordlist.add(new Word("GUITAR","Instrument with strings"));
        wordlist.add(new Word("WOLF","Wild animal, usually resides in the woods"));
        wordlist.add(new Word("JAVA","The best programming language"));
        wordlist.add(new Word("YOUTUBE","Popular website with videos and music"));
        wordlist.add(new Word("SLIDESHOW","Powerpoint helps you do it very easy"));
        wordlist.add(new Word("SYRIA","Country at war, many refugees"));
        wordlist.add(new Word("SAMOS","Really beautifull island, close to Turkey"));
        
        
        
        
    }
    
    //METHODOS DHMIOURGIAS LISTAS APO STRING
    public List<String> CreateList(String str){
        
        //XWRIZEI TO STRING SE XARAKTHRES KAI TOUS EISAGEI SE LISTA
        List<String> letters = Arrays.asList(str.split(""));
        return letters;
    }
    
    //METHODOS DHMIOURGIAS LISTAS APO STRING KAI ANAKATEMATOS THS
    public List<String> ShuffleWords(String shuff){
        
        //XWRIZEI TO STRING SE XARAKTHRES KAI TOUS EISAGEI SE LISTA
        //WS ARRAYLIST GIA NA MPORW META NA KANW ALLAGES OPWS NA XRHSIMOPOIHSW
        //THN REMOVE()
        List<String> letters = new ArrayList<String>(Arrays.asList(shuff.split("")));
        //ANAKATEUEI TH LISTA
        Collections.shuffle(letters);
        
        return letters;
    }
    
    //METHODOS SYGKRISHS LEKSEWN
    public boolean CompareWords(String wordinput,int whichword){
        
        //AN H LEKSH EINAI IDIA ME TO INPUT TOU XRHSTH 
        if(wordlist.get(whichword-1).getWord().equalsIgnoreCase(wordinput)){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    //METHODOS AFAIRESHS GRAMMATWN APO LISTA
    public void RemoveWord(List<String> word){
        
        //GIA OSA EINAI TA GRAMMATA THS LEKSHS
        for(int i=0;i<word.size();i++){
            //PSAKSE STIS ANAKATEMENES TREIS LEKSEIS
            for(int j=0;j<shuffledword.size();j++){
                //AN VREI IDIO GRAMMA
                if(word.get(i).equalsIgnoreCase(shuffledword.get(j))){
                    //TO DIAGRAFEI APTHN LISTA KAI PROXWRAEI STO EPOMMENO GRAMMA
                    shuffledword.remove(j);
                    break;
                }

             } 
        }
        
    }
}
