package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class Address
{
    @XmlElement
    private String StateProvinceCode;

    @XmlElement
    private String PostalCode;

    @XmlElement
    private String CountryCode;

    @XmlElement
    private String AddressLine1;

    @XmlElement
    private String City;

    public String getStateProvinceCode ()
    {
        return StateProvinceCode;
    }

    public void setStateProvinceCode (String StateProvinceCode)
    {
        this.StateProvinceCode = StateProvinceCode;
    }

    public String getPostalCode ()
    {
        return PostalCode;
    }

    public void setPostalCode (String PostalCode)
    {
        this.PostalCode = PostalCode;
    }

    public String getCountryCode ()
    {
        return CountryCode;
    }

    public void setCountryCode (String CountryCode)
    {
        this.CountryCode = CountryCode;
    }

    public String getAddressLine1 ()
    {
        return AddressLine1;
    }

    public void setAddressLine1 (String AddressLine1)
    {
        this.AddressLine1 = AddressLine1;
    }

    public String getCity ()
    {
        return City;
    }

    public void setCity (String City)
    {
        this.City = City;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [StateProvinceCode = "+StateProvinceCode+", PostalCode = "+PostalCode+", CountryCode = "+CountryCode+", AddressLine1 = "+AddressLine1+", City = "+City+"]";
    }
}
