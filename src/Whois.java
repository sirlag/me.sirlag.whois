/**
 * Created by Matthew on 12/2/2014.
 */

import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Whois {

    private static final String SERVER_MATCH = "Whois Server:\\s(.*)";
    static {
        pattern = Pattern.compile(SERVER_MATCH);
    }
    private static Pattern pattern;

    public static String getWhoisRequest(String query) {
        WhoisClient whoisClient = new WhoisClient();
        String output;

        try {
            whoisClient.connect(WhoisClient.DEFAULT_HOST);
            output = whoisClient.query("=" + query.toUpperCase());
            whoisClient.disconnect();

            String returnServer = getWhoisServer(output);

            if (!returnServer.equals("")) {
                whoisClient.connect(returnServer);
                output = whoisClient.query("=" + query.toUpperCase());
                whoisClient.disconnect();
            }

        } catch (IOException e) {
            System.err.println("Error I/O exception: " + e.getMessage());
            return "Error in lookup";
        }

        return output;

    }

    public static String getWhoisServer(String whoisOutput) {
        String server = "";

        Matcher matcher = pattern.matcher(whoisOutput);

        while (matcher.find())
            server = matcher.group(1);


        return server;
    }

}
