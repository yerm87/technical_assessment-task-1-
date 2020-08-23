package palyndromicStrings.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="palyndromics")
public class StringEntity {

    @Id
    @GeneratedValue
    private Integer Id;
    private String palyndromicString;

    public String getPalyndromicString(){
        return palyndromicString;
    }

    public void setPalyndromicString(String palyndromicString){
        this.palyndromicString = palyndromicString;
    }
}
