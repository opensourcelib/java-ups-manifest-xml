package com.partshighway.ups.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by elmer on 6/13/17.
 */
@XmlRootElement(name="Manifest")
public class Manifest
{
    @XmlElement
    private Service Service;

    @XmlElement
    private String ShipmentChargeType;

    @XmlElement
    private BillToAccount BillToAccount;

    @XmlElement
    private ReferenceNumber[] ReferenceNumber;

    @XmlElement
    private Shipper Shipper;

    @XmlElement
    private String DocumentsOnly;

    @XmlElement
    private String ScheduledDeliveryDate;

    @XmlElement
    private Package Package;

    @XmlElement
    private ShipTo ShipTo;

    @XmlElement
    private String PickupDate;

    @XmlElement
    private String ScheduledDeliveryTime;

    public Service getService ()
    {
        return Service;
    }

    public void setService (Service Service)
    {
        this.Service = Service;
    }

    public String getShipmentChargeType ()
    {
        return ShipmentChargeType;
    }

    public void setShipmentChargeType (String ShipmentChargeType)
    {
        this.ShipmentChargeType = ShipmentChargeType;
    }

    public BillToAccount getBillToAccount ()
    {
        return BillToAccount;
    }

    public void setBillToAccount (BillToAccount BillToAccount)
    {
        this.BillToAccount = BillToAccount;
    }

    public ReferenceNumber[] getReferenceNumber ()
    {
        return ReferenceNumber;
    }

    public void setReferenceNumber (ReferenceNumber[] ReferenceNumber)
    {
        this.ReferenceNumber = ReferenceNumber;
    }

    public Shipper getShipper ()
    {
        return Shipper;
    }

    public void setShipper (Shipper Shipper)
    {
        this.Shipper = Shipper;
    }

    public String getDocumentsOnly ()
    {
        return DocumentsOnly;
    }

    public void setDocumentsOnly (String DocumentsOnly)
    {
        this.DocumentsOnly = DocumentsOnly;
    }

    public String getScheduledDeliveryDate ()
    {
        return ScheduledDeliveryDate;
    }

    public void setScheduledDeliveryDate (String ScheduledDeliveryDate)
    {
        this.ScheduledDeliveryDate = ScheduledDeliveryDate;
    }

    public Package getPackage ()
    {
        return Package;
    }

    public void setPackage (Package Package)
    {
        this.Package = Package;
    }

    public ShipTo getShipTo ()
    {
        return ShipTo;
    }

    public void setShipTo (ShipTo ShipTo)
    {
        this.ShipTo = ShipTo;
    }

    public String getPickupDate ()
    {
        return PickupDate;
    }

    public void setPickupDate (String PickupDate)
    {
        this.PickupDate = PickupDate;
    }

    public String getScheduledDeliveryTime ()
    {
        return ScheduledDeliveryTime;
    }

    public void setScheduledDeliveryTime (String ScheduledDeliveryTime)
    {
        this.ScheduledDeliveryTime = ScheduledDeliveryTime;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Service = "+Service+", ShipmentChargeType = "+ShipmentChargeType+", BillToAccount = "+BillToAccount+", ReferenceNumber = "+ReferenceNumber+", Shipper = "+Shipper+", DocumentsOnly = "+DocumentsOnly+", ScheduledDeliveryDate = "+ScheduledDeliveryDate+", Package = "+Package+", ShipTo = "+ShipTo+", PickupDate = "+PickupDate+", ScheduledDeliveryTime = "+ScheduledDeliveryTime+"]";
    }
}