package TextJustification;

public class Phrases {
    int start;
    int end;
    int numSpace;

    int sumLetter(String[] list){
        int numWord=0;
        for(int i=start;i<end;i++) numWord+=list[i].length();
        return numWord;
    }
    int sumSpace(int numWord, int maxWidth){
        int numSpace=0;
        numSpace=(maxWidth-numWord)/(end-start);
        return numSpace;

    }

}
