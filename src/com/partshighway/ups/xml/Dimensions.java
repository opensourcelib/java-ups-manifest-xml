package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class Dimensions
{
    @XmlElement
    private String Length;

    @XmlElement
    private String Height;

    @XmlElement
    private String Width;

    public String getLength ()
    {
        return Length;
    }

    public void setLength (String Length)
    {
        this.Length = Length;
    }

    public String getHeight ()
    {
        return Height;
    }

    public void setHeight (String Height)
    {
        this.Height = Height;
    }

    public String getWidth ()
    {
        return Width;
    }

    public void setWidth (String Width)
    {
        this.Width = Width;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Length = "+Length+", Height = "+Height+", Width = "+Width+"]";
    }
}

