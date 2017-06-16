package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class PackageWeight
{
    @XmlElement
    private String Weight;

    public String getWeight ()
    {
        return Weight;
    }

    public void setWeight (String Weight)
    {
        this.Weight = Weight;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Weight = "+Weight+"]";
    }
}
