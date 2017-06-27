package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by elmer on 6/13/17.
 */
public class ReferenceNumber
{
    @XmlElement
    private String Value;

    @XmlElement
    private String Number;

    @XmlElement
    private String Code;

    private String prefix=null;
    private Integer poLenght=null;

    public String getValue ()
    {
        return Value;
    }

    public void setValue (String Value)
    {
        this.Value = Value;
    }

    public String getNumber ()
    {
        return Number;
    }

    public void setNumber (String Number)
    {
        this.Number = Number;
    }

    public String getCode ()
    {
        return Code;
    }

    public void setCode (String Code)
    {
        this.Code = Code;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getPoLenght() {
        return poLenght;
    }

    public void setPoLenght(Integer poLenght) {
        this.poLenght = poLenght;
    }

    public String getPO(){
        String po=null;
        po=getValue();
        return po;
    }

    public String getPO(String prefix,Integer poLenght){
        String po=null;
        if(poLenght !=null && prefix !=null){
            String regex=prefix+"\\d{"+(poLenght-prefix.length())+"}";
            po=getValue();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(po);
            if (matcher.find())
            {
                return matcher.group(0);
            }
            else {
                return null;
            }
        }

        return po;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Value = "+Value+", Number = "+Number+", Code = "+Code+"]";
    }
}
