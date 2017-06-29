package com.partshighway.ups.lasso;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.partshighway.ups.xml.*;
import com.partshighway.ups.xml.Package;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elmer on 6/28/17.
 */
public class WebQuantumView {

    private String Username=null;
    private String password=null;
    private String beginningDate=null;
    private String endDate=null;
    private List<Manifest> manifestList=null;
    private String ignoreIfContain="Tracking";
    private String csvContent=null;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(String beginningDate) {
        this.beginningDate = beginningDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIgnoreIfContain() {
        return ignoreIfContain;
    }

    public void setIgnoreIfContain(String ignoreIfContain) {
        this.ignoreIfContain = ignoreIfContain;
    }

    public String getCsvContent() {
        return csvContent;
    }

    public void setCsvContent(String csvContent) {
        this.csvContent = csvContent;
    }

    public static void main(String[] arg){


    }

    /*
    The Description of the method to explain what the method does
    @param String Username, String password,String beginningDate=2017-06-26 and String endDate=2017-06-28

    */
    public WebQuantumView(String username, String password, String beginningDate, String endDate) {
        Username = username;
        this.password = password;
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.manifestList=new ArrayList<>();
    }

    /*
    The Description of the method to explain what the method does
    @param beginningDate=2017-06-26 and endDate=2017-06-28
    @return null or a CSV formatted String
    */
    public String getQVData() {
        try {
            final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
            webClient.setCache(new Cache());
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            // Get the first page
            final HtmlPage page1 = webClient.getPage("https://www.ups.com/lasso/login?loc=en_US");
            //System.out.println(page1.asXml());
            // Get the form that we are dealing with and within that form,
            // find the submit button and the field that we want to change.
            final HtmlForm form = page1.getFormByName("LoginTest");


            HtmlTextInput textField   =  form.getInputByName("userID");
            HtmlInput textField2  =  form.getInputsByName("password").get(0);
            final HtmlButton button = form.getButtonByName("getTokenWithPassword");
            // Change the value of the text field
            textField.setValueAttribute(getUsername());
            textField2.setValueAttribute(getPassword());

            // Now submit the form by clicking the button and get back the second page.
            final HtmlPage page2 = button.click();
            //System.out.println(page2.asXml());

            HtmlPage page3 = webClient.getPage("https://www.ups.com/webqvm?loc=en_US");

            //System.out.println(page3.asXml());
            String requestBody="start_row_0=1&noofrows_0=811&viewName_0=S_ALTERNAT&view_by=INBOUND_RA&dataType=3&loc=en_US&detail_sort_order=&detail_sort_by=&filter_name_0=start_date&filter_value_0="+getBeginningDate()+"&search_type_0=&filter_name_1=end_date&filter_value_1="+getEndDate()+"&search_type_1=&filter_name_2=date_type&filter_value_2=PUD&search_type_2=&selected_columns=TKU%2CREF%2CSTA%2CPUD%2CSFRGRP%2CSTOGRP%2CCZC%2CSVC%2CSDD%2CDIS";
            //System.out.println(requestBody);
            WebRequest webRequest=new WebRequest(new URL("https://filexfer.ups.com/qvmxfer/download"));
            webRequest.setHttpMethod(HttpMethod.POST);
            webRequest.setRequestBody(requestBody);
            if(webClient.getPage(webRequest).isHtmlPage())
                return null;
            else{
                String csvResult=webClient.getPage(webRequest).getWebResponse().getContentAsString();
                setCsvContent(csvResult);
                return  csvResult;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    private void parseCSVToManifest(String csv){
        String[] csvByLine=csv.split("\n");
        int csvLenght=csvByLine.length;
        if(csvLenght >14){
            for (int i=0;i<csvLenght;i++){
                if(!csvByLine[i].toLowerCase().contains(getIgnoreIfContain().toLowerCase()) && csvByLine[i].contains("Manifest")){
                    String[] line=csvByLine[i].split(",");
                    if(line.length >0){
                        Manifest manifest = new Manifest();
                        Package upsPackage=new Package();


                        String[] refNumbers=line[1].split("\\|");
                        ReferenceNumber[] referenceNumbers=new ReferenceNumber[refNumbers.length];
                        for (int j=0;j<refNumbers.length;j++){
                            ReferenceNumber referenceNumber = new ReferenceNumber();
                            referenceNumber.setNumber(String.valueOf(j+1));
                            referenceNumber.setValue(refNumbers[j]);
                            referenceNumbers[j]=referenceNumber;
                        }
                        manifest.setReferenceNumber(referenceNumbers);

                        upsPackage.setReferenceNumber(referenceNumbers);
                        upsPackage.setTrackingNumber(line[0]);
                        manifest.setPackage(upsPackage);
                        manifest.setPickupDate(line[3]);
                        manifest.setScheduledDeliveryDate(line[14]);
                        Shipper shipper=new Shipper();
                        shipper.setName(line[4]);
                        Address shipperAddress = new Address();
                        shipperAddress.setCity(line[5]);
                        shipperAddress.setStateProvinceCode(line[6]);
                        shipperAddress.setCountryCode(line[7]);
                        shipper.setAddress(shipperAddress);
                        manifest.setShipper(shipper);
                        ShipTo shipTo=new ShipTo();
                        shipTo.setAttentionName(line[8]);
                        Address shiptoAddress =new Address();
                        shiptoAddress.setCity(line[9]);
                        shiptoAddress.setStateProvinceCode(line[10]);
                        shiptoAddress.setCountryCode(line[11]);
                        shiptoAddress.setPostalCode(line[12]);
                        shipTo.setAddress(shiptoAddress);
                        manifest.setShipTo(shipTo);
                        setManifestList(manifest);
                    }
                }

            }
        }
    }

    public void setManifestList(Manifest manifest){
        this.manifestList.add(manifest);
    }

    public List<Manifest> getManifest(){
        parseCSVToManifest(getCsvContent());
        return this.manifestList;
    }
}
