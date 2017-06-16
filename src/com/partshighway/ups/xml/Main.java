package com.partshighway.ups.xml;



public class Main {

    public static void main(String[] args) {
        UPSRequest upsRequest=new UPSRequest();
        upsRequest.setAccessLicenseNumber("LICENSENUMBER");
        upsRequest.setUserId("UPSUSER");
        upsRequest.setPassword("UPSPASSWORD");
        upsRequest.setBeginDateTime("20170613000000");//starting date
        upsRequest.setEndDateTime("20170614235959");//ending date
        upsRequest.setUrl("https://onlinetools.ups.com/ups.app/xml/QVEvents");//ups access point
        upsRequest.setMaxUPSResponse(100);
        upsRequest.run();
        int counter=1;
        for (Manifest man:upsRequest.getManifestList()) {
            Package pkg=man.getPackage();
            System.out.println(counter+"\tPickUp Date="+man.getPickupDate()+"\tPO="+pkg.getPO("9",5)+"\tTrackingNumber="+man.getPackage().getTrackingNumber()+"\t"+man.getShipTo().getAddress().getPostalCode());
            System.out.println("******************************");
            counter++;

        }
        upsRequest.printResponseFiles();
        upsRequest.printRequestFiles();

    }

}
