package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class UnitOfMeasurement
{
    @XmlElement
    private String Code;

    public String getCode ()
    {
        return Code;
    }

    public void setCode (String Code)
    {
        this.Code = Code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Code = "+Code+"]";
    }
}
