package palyndromicStrings.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import palyndromicStrings.entity.StringEntity;
import palyndromicStrings.repo.StringRepository;

@Service
public class MainService {

    @Autowired
    StringRepository repo;

    public String createPalyndromicString(String str){
        String palindromicString = "";
        String tempString = "";

        if(str.length() > 1) {
            String leftLetter;
            String rightLetter;
            for(int i=1; i<str.length(); i++) {
                if(i<str.length()-1) {
                    Character strChar = str.charAt(i);
                    String letter = Character.toString(strChar);

                    int indexLeft = i-1;
                    int indexRight = i+1;
                    leftLetter = Character.toString(str.charAt(indexLeft));
                    rightLetter = Character.toString(str.charAt(indexRight));

                    tempString = letter;
                    while(leftLetter.equals(rightLetter)) {
                        tempString += rightLetter;
                        if(indexLeft != 0 && indexRight != str.length()-1) {
                            indexLeft--;
                            indexRight++;
                            leftLetter = Character.toString(str.charAt(indexLeft));
                            rightLetter = Character.toString(str.charAt(indexRight));
                        } else {
                            break;
                        }
                    }
                    if(tempString.length() == 1){
                        tempString = "";
                    }

                    if(tempString.length() > palindromicString.length()) {
                        palindromicString = tempString;
                    }
                    tempString = "";
                }
            }
        }
        StringEntity se = repo.findById(1).get();
        se.setPalyndromicString(palindromicString);
        repo.save(se);

        return palindromicString;
    }
}
