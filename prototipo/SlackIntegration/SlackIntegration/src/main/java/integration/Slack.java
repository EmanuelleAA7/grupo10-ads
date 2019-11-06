package integration;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Slack {

    //Nessa variável está a URL do slack ( webhook)
    private String url = "https://hooks.slack.com/services/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";

    public void insertMessage(JSONObject message) throws Exception {

        URL obj = new URL(this.url);

    //Essa função faz a conexão entre o link HTTP do slack ao JAVA
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    //Método de envio das informações 
        con.setRequestMethod("POST");
        con.setDoOutput(true);

    //Enviando as informações via bytes e colocando no na variável url para que o sistema entenda
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(message.toString());

    //limpa as informações que foram inseridas 
        wr.flush();
    //fecha as informações  
        wr.close();

        int responseCode = con.getResponseCode();

    //Enviando solicitação para o slack atráves da URL
        System.out.println("Sending 'POST' request to URL: " + this.url);
        System.out.println("POST parameters: " + message.toString());
        System.out.println("Response Code: " + responseCode);

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            
            response.append(inputLine);
            
        }
        
        reader.close();
        
        System.out.println("Success: " + response);
    }
}
