package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by elmer on 6/13/17.
 */
public class Package
{
    @XmlElement
    private Activity Activity;

    @XmlElement
    private ReferenceNumber[] ReferenceNumber;

    @XmlElement
    private Dimensions Dimensions;

    @XmlElement
    private String TrackingNumber;

    @XmlElement
    private DimensionalWeight DimensionalWeight;

    @XmlElement
    private PackageWeight PackageWeight;

    @XmlElement
    private PackageServiceOptions PackageServiceOptions;

    private String delimiter =",";


    public Activity getActivity ()
    {
        return Activity;
    }

    public void setActivity (Activity Activity)
    {
        this.Activity = Activity;
    }

    public ReferenceNumber[] getReferenceNumber ()
    {
        return ReferenceNumber;
    }

    public void setReferenceNumber (ReferenceNumber[] ReferenceNumber)
    {
        this.ReferenceNumber = ReferenceNumber;
    }

    public Dimensions getDimensions ()
    {
        return Dimensions;
    }

    public void setDimensions (Dimensions Dimensions)
    {
        this.Dimensions = Dimensions;
    }

    public String getTrackingNumber ()
    {
        return TrackingNumber;
    }

    public void setTrackingNumber (String TrackingNumber)
    {
        this.TrackingNumber = TrackingNumber;
    }

    public DimensionalWeight getDimensionalWeight ()
    {
        return DimensionalWeight;
    }

    public void setDimensionalWeight (DimensionalWeight DimensionalWeight)
    {
        this.DimensionalWeight = DimensionalWeight;
    }

    public PackageWeight getPackageWeight ()
    {
        return PackageWeight;
    }

    public void setPackageWeight (PackageWeight PackageWeight)
    {
        this.PackageWeight = PackageWeight;
    }

    public PackageServiceOptions getPackageServiceOptions ()
    {
        return PackageServiceOptions;
    }

    public void setPackageServiceOptions (PackageServiceOptions PackageServiceOptions)
    {
        this.PackageServiceOptions = PackageServiceOptions;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }


    public String getPO(){
        String po=null;
        if(getReferenceNumber() != null){
            for(ReferenceNumber ref:getReferenceNumber())

               if(ref.getValue() != null){
                if(po == null)
                    po=ref.getPO();
                else
                    po=po+getDelimiter()+ref.getValue();
               }
        }
        return po;
    }

    public String getPO(String prefix,Integer poLenght){
        String po=null;
        if(getReferenceNumber() != null){
            for(ReferenceNumber ref:getReferenceNumber())

                if(ref.getPO(prefix,poLenght) != null){
                    po=ref.getPO(prefix,poLenght);
                }
        }
        return po;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Activity = "+Activity+", ReferenceNumber = "+ReferenceNumber+", Dimensions = "+Dimensions+", TrackingNumber = "+TrackingNumber+", DimensionalWeight = "+DimensionalWeight+", PackageWeight = "+PackageWeight+", PackageServiceOptions = "+PackageServiceOptions+"]";
    }
}
