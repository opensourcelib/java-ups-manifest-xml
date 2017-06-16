# java-ups-manifest-xml

Java Library to download UPS Quantum View data like package manifest containing tracking information, etc. 
## Installation

* git pull https://github.com/jelqui/java-ups-manifest-xml.git
* cd java-ups-manifest-xml
* add libraries dependencies under src/com/partshighway/ups/xml/libs/*

## Dependencies
* [jcabi-xml](http://www.jcabi.com/jcabi-xml) - Best XML Library for parsing documents
* [jcabi-http](http://www.jcabi.com/jcabi-http)
* [jcabi-matchers](http://matchers.jcabi.com)
* [jcabi-immutable](http://immutable.jcabi.com/)
* [jcabi-log](http://log.jcabi.com/)
* [slf4j-api-1.7.25](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/1.7.25)
* [slf4j-simple](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple/1.7.25)
* [javax.json](https://mvnrepository.com/artifact/org.glassfish/javax.json/1.1)
* [javax.json-api](https://mvnrepository.com/artifact/javax.json/javax.json-api/1.1)
* [hamcrest-core](https://github.com/hamcrest/JavaHamcrest/hamcrest-core)
* [hamcrest-library](https://github.com/hamcrest/JavaHamcrest/hamcrest-library)


## Usage
```java
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
```

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D


## Credits
* [jcabi](http://www.jcabi.com/) - Small Useful Java Components
* [PartsHighway](https://store.partshighway.com) - Online Auto Parts Store

## License
[GNU GENERAL PUBLIC LICENSE](https://github.com/jelqui/java-ups-manifest-xml/blob/master/LICENSE)