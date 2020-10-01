package dk.springboot.restful.flag;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlagService {

    private String flagEndpointUrl = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    /**
     * This Method takes a country tag
     * sends a soap request to an endpoint
     * and returns a jpg url of the country's flag
     *
     * @param countryTag The countryTag we want the flag image of
     * @return returns a jpg url
     */
    public String getImageSouce(String countryTag) throws IOException {

        String xml = "" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soap:Body>" +
                "<CountryFlag xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">" +
                "<sCountryISOCode>" +
                countryTag +
                "</sCountryISOCode>" +
                "</CountryFlag>" +
                "</soap:Body>" +
                "</soap:Envelope>";

        try {
        URL urlObject = new URL(flagEndpointUrl);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        DataOutputStream writeRequest = new DataOutputStream(connection.getOutputStream());
        writeRequest.writeBytes(xml);
        writeRequest.flush();
        writeRequest.close();
        String responseStatus = connection.getResponseMessage();
        System.out.println(responseStatus);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()
        ));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("response" + response.toString());
        return response.toString();
    }catch (Exception e ){
            System.out.println(e);
            return null;
        }
    }

}
