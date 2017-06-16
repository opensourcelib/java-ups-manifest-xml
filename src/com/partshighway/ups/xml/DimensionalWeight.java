package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class DimensionalWeight
{
    @XmlElement
    private UnitOfMeasurement UnitOfMeasurement;

    @XmlElement
    private String Weight;

    public UnitOfMeasurement getUnitOfMeasurement ()
    {
        return UnitOfMeasurement;
    }

    public void setUnitOfMeasurement (UnitOfMeasurement UnitOfMeasurement)
    {
        this.UnitOfMeasurement = UnitOfMeasurement;
    }

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
        return "ClassPojo [UnitOfMeasurement = "+UnitOfMeasurement+", Weight = "+Weight+"]";
    }
}
