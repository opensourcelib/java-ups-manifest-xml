package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class ShipTo
{
    @XmlElement
    private String AttentionName;

    @XmlElement
    private Address Address;

    @XmlElement
    private String PhoneNumber;


    public String getAttentionName ()
    {
        return AttentionName;
    }

    public void setAttentionName (String AttentionName)
    {
        this.AttentionName = AttentionName;
    }

    public Address getAddress ()
    {
        return Address;
    }

    public void setAddress (Address Address)
    {
        this.Address = Address;
    }

    public String getPhoneNumber ()
    {
        return PhoneNumber;
    }

    public void setPhoneNumber (String PhoneNumber)
    {
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [AttentionName = "+AttentionName+", Address = "+Address+", PhoneNumber = "+PhoneNumber+"]";
    }
}
