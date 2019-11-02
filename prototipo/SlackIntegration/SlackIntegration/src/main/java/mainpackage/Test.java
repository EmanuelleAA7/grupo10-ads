package mainpackage;

import integration.Slack;
import org.json.JSONObject;

/**
 *
 * @author Diego.Brito
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Slack slack = new Slack();

        JSONObject message = new JSONObject();
        message.put("text", "Teste");
        slack.insertMessage(message);

    }
}
