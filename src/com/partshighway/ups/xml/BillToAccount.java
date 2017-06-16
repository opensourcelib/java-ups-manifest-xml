package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class BillToAccount
{
    @XmlElement
    private String Option;

    @XmlElement
    private String Number;

    public String getOption ()
    {
        return Option;
    }

    public void setOption (String Option)
    {
        this.Option = Option;
    }

    public String getNumber ()
    {
        return Number;
    }

    public void setNumber (String Number)
    {
        this.Number = Number;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Option = "+Option+", Number = "+Number+"]";
    }
}
