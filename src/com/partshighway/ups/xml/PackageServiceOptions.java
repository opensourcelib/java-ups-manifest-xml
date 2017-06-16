package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PackageServiceOptions
{
    @XmlElement(name="COD")
    private String COD;

    public String getCOD ()
    {
        return COD;
    }

    public void setCOD (String COD)
    {
        this.COD = COD;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [COD = "+COD+"]";
    }
}
