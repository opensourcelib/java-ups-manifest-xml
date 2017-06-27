package com.partshighway.ups.xml;

import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.XmlResponse;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elmer on 6/14/17.
 */
public class UPSRequest {
    private String UserId="";
    private String Password="";
    private String AccessLicenseNumber="";
    private String RequestAction="QVEvents";
    private String BeginDateTime=null;
    private String EndDateTime=null;
    private String Name="DropShip";
    private String Bookmark=null;
    private String bookmarkDir="//QuantumViewResponse//Bookmark/text()";
    private String url="https://onlinetools.ups.com/ups.app/xml/QVEvents";
    private List<Manifest> manifestList;
    private List<String> upsRequests;
    private String manifestNodeDir="//QuantumViewResponse//QuantumViewEvents//SubscriptionEvents//SubscriptionFile//Manifest";
    private String exceptionLog=null;
    private int counter=1;
    private int upsResponseCounter=0;
    private List<String> upsResponses;
    protected int maxUPSResponse=2000;
    private String upsError=null;
    private String upsLog="";
    private static String upsLogPattern="yyyyMMdd HH:mm:ss";

    public UPSRequest() {
        this.upsRequests=new ArrayList<>();
        this.manifestList=new ArrayList<Manifest>();
        this.upsResponses=new ArrayList<>();
    }

    public String getXMLSetting(){
        String xmlText="";
        xmlText += "<?xml version=\"1.0\"?>\n";
        xmlText += "<AccessRequest xml:lang=\"en-US\">\n";
        xmlText += "\t<AccessLicenseNumber>" + getAccessLicenseNumber() + "</AccessLicenseNumber>\n";
        xmlText += "\t<UserId>" + getUserId() + "</UserId>\n";
        xmlText += "\t<Password>" + getPassword() + "</Password>\n";
        xmlText += "</AccessRequest>\n";
        xmlText += "<?xml version=\"1.0\"?>\n";                                                             //
        xmlText += "<QuantumViewRequest xml:lang=\"en-US\">\n";                                             //
        xmlText += "\t<Request>\n";                                                                         //
        xmlText += "\t\t<RequestAction>QVEvents</RequestAction>\n";                                         //
        xmlText += "\t</Request>\n";                                                                        //
        xmlText += "\t<SubscriptionRequest>\n";                                                             //
        xmlText += "\t\t<DateTimeRange>\n";                                                                 //
        xmlText += "\t\t\t<BeginDateTime>" +getBeginDateTime()+ "</BeginDateTime>\n";                              //
        xmlText += "\t\t\t<EndDateTime>" + getEndDateTime()+ "</EndDateTime>\n";                                    //
        xmlText += "\t\t</DateTimeRange>\n";                                                                //
        xmlText += "\t\t\t<Name>DropShip</Name>\n";                                                         //
        xmlText += "\t</SubscriptionRequest>\n";                                                            //
        if (getBookmark() != null) {xmlText += "\t<Bookmark>" + getBookmark() +"</Bookmark>\n";}                                    //
        xmlText += "</QuantumViewRequest>\n";

        return xmlText;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAccessLicenseNumber() {
        return AccessLicenseNumber;
    }

    public void setAccessLicenseNumber(String accessLicenseNumber) {
        AccessLicenseNumber = accessLicenseNumber;
    }

    public String getRequestAction() {
        return RequestAction;
    }

    public void setRequestAction(String requestAction) {
        RequestAction = requestAction;
    }

    public String getBeginDateTime() {
        return BeginDateTime;
    }

    public void setBeginDateTime(String beginDateTime) {
        BeginDateTime = beginDateTime;
    }

    public String getEndDateTime() {
        return EndDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        EndDateTime = endDateTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBookmark() {
        return Bookmark;
    }

    public void setBookmark(String bookmark) {
        Bookmark = bookmark;
    }

    public String getBookmarkDir() {
        return bookmarkDir;
    }

    public void setBookmarkDir(String bookmarkDir) {
        this.bookmarkDir = bookmarkDir;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public List<Manifest> getManifestList() {
        return manifestList;
    }

    public void setManifestList(Manifest manifestList) {
        this.manifestList.add(manifestList);
    }

    public List<String> getUpsRequests() {
        return upsRequests;
    }

    public void setUpsRequests(String upsRequests) {
        this.upsRequests.add(upsRequests);
    }

    public String getManifestNodeDir() {
        return manifestNodeDir;
    }

    public void setManifestNodeDir(String manifestNodeDir) {
        this.manifestNodeDir = manifestNodeDir;
    }

    public String getExceptionLog() {
        return exceptionLog;
    }

    public void setExceptionLog(String exceptionLog) {
        this.exceptionLog = exceptionLog;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<String> getUpsResponses() {
        return upsResponses;
    }

    public void setUpsResponses(String upsResponses) {
        this.upsResponses.add(upsResponses);
        this.upsResponseCounter++;
    }

    public int getUpsResponseCounter() {
        return upsResponseCounter;
    }

    public void setUpsResponseCounter(int upsResponseCounter) {
        this.upsResponseCounter = upsResponseCounter;
    }



    public int getMaxUPSResponse() {
        return maxUPSResponse;
    }

    public void setMaxUPSResponse(int maxUPSResponse) {
        this.maxUPSResponse = maxUPSResponse;
    }

    public String getUpsError() {
        return upsError;
    }

    public void setUpsError(String upsError) {
        this.upsError = upsError;
    }

    public String getUpsLog() {
        return upsLog;
    }

    public void setUpsLog(String upsLog) {
        if(this.upsLog.isEmpty())
            this.upsLog =String.format("[%s] ",UPSHelper.todayDate(upsLogPattern))+this.upsLog+ upsLog;
        else
            this.upsLog ="\n"+String.format("[%s] ",UPSHelper.todayDate(upsLogPattern))+this.upsLog+ upsLog;
    }

    private  String getUPSResponse(){

        String response=null;
        try {
            setUpsLog(getXMLSetting().replace("\n","\n["+UPSHelper.todayDate()+"] "));
            byte[] byteArray = new byte[0];
            setUpsRequests(getXMLSetting());
            byteArray = getXMLSetting().getBytes("UTF-8");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
            response = new JdkRequest(getUrl())
                    .header("Content-Type", "application/xml")
                    .method(Request.POST)
                    .fetch(inputStream)
                    .as(XmlResponse.class)
                    //.assertXPath(getManifestNodeDir()) // AssertionError if this XPath is absent
                    .xml() // convert HTTP body to com.jcabi.xml.XML
                    .toString();

            setUpsResponses(response);
            setUpsLog("UPS Response saved");
            setUpsLog(response.replace("\n","\n["+UPSHelper.todayDate()+"] "));
        } catch (IOException e) {
            //e.printStackTrace();
            setUpsLog("UPS Exception "+e.getMessage());
            setExceptionLog(e.getMessage());
            return null;
        }
        return response;
    }

    private  String getUPSResponseWithAssertionError(){

        String response=null;
        try {
            setUpsLog(getXMLSetting().replace("\n","\n["+UPSHelper.todayDate()+"] "));
            byte[] byteArray = new byte[0];
            setUpsRequests(getXMLSetting());
            byteArray = getXMLSetting().getBytes("UTF-8");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
            response = new JdkRequest(getUrl())
                    .header("Content-Type", "application/xml")
                    .method(Request.POST)
                    .fetch(inputStream)
                    .as(XmlResponse.class)
                    .assertXPath(getManifestNodeDir()) // AssertionError if this XPath is absent
                    .xml() // convert HTTP body to com.jcabi.xml.XML
                    .toString();

            //System.out.println(result);
            setUpsResponses(response);
            setUpsLog("UPS Response saved");
            setUpsLog(response.replace("\n","\n["+UPSHelper.todayDate()+"] "));
        } catch (IOException e) {
            //e.printStackTrace();
            setUpsLog("UPS Exception "+e.getMessage());
            setExceptionLog(e.getMessage());
            return null;
        }
        return response;
    }

    public void printResponseFiles(){
        for (String xmlString:getUpsResponses()) {
            System.out.println(xmlString);
        }
    }



    public void printRequestFiles(){
        for (String xmlString:getUpsRequests()) {
            System.out.println(xmlString);
        }
    }


    public void run(){
        try {
            String upsresponse=getUPSResponse();
            XML xmlDoc = new XMLDocument(upsresponse);

            try {
                if(xmlDoc.xpath("//QuantumViewResponse//Response//Error//ErrorDescription/text()").get(0) != null){
                    setUpsError(xmlDoc.xpath("//QuantumViewResponse//Response//Error//ErrorDescription/text()").get(0));
                    System.out.println(getUpsError()+" IF ERROR THERE IS AN ERROR FROM UPS");
                }
                else {
                    System.out.println("There is not error from UPS");
                }
            }
            catch (Exception e){
                setUpsLog("UPS Exception "+e.getMessage());
            }


            for (XML mnf : xmlDoc.nodes(getManifestNodeDir())) {

                byte[] byteArray = new byte[0];
                try {
                    byteArray = mnf.toString().getBytes("UTF-8");
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
                    JAXBContext jaxbContext = JAXBContext.newInstance(Manifest.class);

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    Manifest man= (Manifest) jaxbUnmarshaller.unmarshal(inputStream);
                    setManifestList(man);
                    setUpsLog(counter+") "+man.toString().replace("\n","\n["+UPSHelper.todayDate(upsLogPattern)+"] "));


                } catch (UnsupportedEncodingException e) {
                    setUpsLog(e.getMessage());
                    setExceptionLog(e.getMessage());
                } catch (JAXBException e) {
                    setUpsLog(e.getMessage());
                    setExceptionLog(e.getMessage());
                }
                setCounter(this.counter++);

            }

            if(!xmlDoc.xpath(getBookmarkDir()).isEmpty()){
                String bookmark = xmlDoc.xpath(getBookmarkDir()).get(0);
                setBookmark(bookmark);
                setUpsLog("There is more documents to download "+bookmark);
                run();
            }
            else {
                setUpsLog("There is NOT more documents to download ");
                setBookmark(null);
            }
        }
        catch (Exception e){
            setUpsLog( e.getMessage());
            setExceptionLog(e.getMessage());
        }

    }

    public void runWithAssertion(){
        try {
            String upsresponse=getUPSResponseWithAssertionError();
            XML xmlDoc = new XMLDocument(upsresponse);
            setUpsResponses(upsresponse);
            for (XML mnf : xmlDoc.nodes(getManifestNodeDir())) {

                byte[] byteArray = new byte[0];
                try {
                    byteArray = mnf.toString().getBytes("UTF-8");
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
                    JAXBContext jaxbContext = JAXBContext.newInstance(Manifest.class);

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    Manifest man= (Manifest) jaxbUnmarshaller.unmarshal(inputStream);
                    setManifestList(man);
                    setUpsLog(counter+") "+man.toString().replace("\n","\n["+UPSHelper.todayDate(upsLogPattern)+"] "));

                } catch (UnsupportedEncodingException e) {
                    setUpsLog( e.getMessage());
                    setExceptionLog(e.getMessage());
                } catch (JAXBException e) {
                    setUpsLog( e.getMessage());
                    setExceptionLog(e.getMessage());
                }
                setCounter(this.counter++);

            }

            if(!xmlDoc.xpath(getBookmarkDir()).isEmpty()){
                String bookmark = xmlDoc.xpath(getBookmarkDir()).get(0);
                setUpsLog("There is more documents to download "+bookmark);
                setBookmark(bookmark);
                run();
            }
            else {
                setUpsLog("There is NOT more documents to download ");
                setBookmark(null);
            }
        }
        catch (Exception e){
            setUpsLog(e.getMessage());
            setExceptionLog(e.getMessage());
        }

    }

}
