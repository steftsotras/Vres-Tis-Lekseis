//ASKHSH 3
//Tsotras Stefanos icsd13189
package vrestislekseis;

/**
 *
 * @author Stefanos
 */
public class Word {
    
    //DHLWSH METAVLHTWN
    private String word;
    private String desc;
    private boolean used;
    
    //YLOPOIHSH CONSTRUCTOR
    public Word(String word, String desc){
        
        this.word=word;
        this.desc=desc;
        used=false;
    }
    
    //SETS KAI GETS
    public void setUsed(boolean u){
        used = u;
    }
    
    public String getWord(){
        return word;
    }
    public String getDesc(){
        return desc;
    }
    public boolean getUsed(){
        return used;
    }
    
}
