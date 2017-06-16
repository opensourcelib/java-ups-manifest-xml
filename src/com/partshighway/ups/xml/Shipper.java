package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class Shipper
{
    @XmlElement
    private String Name;

    @XmlElement
    private Address Address;

    @XmlElement
    private String ShipperNumber;

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public Address getAddress ()
    {
        return Address;
    }

    public void setAddress (Address Address)
    {
        this.Address = Address;
    }

    public String getShipperNumber ()
    {
        return ShipperNumber;
    }

    public void setShipperNumber (String ShipperNumber)
    {
        this.ShipperNumber = ShipperNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Name = "+Name+", Address = "+Address+", ShipperNumber = "+ShipperNumber+"]";
    }
}
