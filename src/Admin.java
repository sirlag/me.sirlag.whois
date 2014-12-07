/**
 * Created by Matthew on 12/2/2014.
 */

import org.apache.commons.net.whois.WhoisClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin {

    private String adminName;
    private String adminEmail;
    private String adminOrganisation;
    private String adminStreet;
    private String adminCity;
    private String adminState;
    private String adminPostalCode;
    private String adminCountry;
    private String adminPhone;
    private String adminPhoneExt;
    private String adminFax;
    private String adminFaxExt;
    private String whoIs;

    public Admin(String domain, String server) {

        whoIs = Whois.getWhoisRequest(domain, server);
        System.out.println(whoIs);

        Matcher matcher;

        matcher = Pattern.compile("Admin Name:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminName = matcher.group(1);

        matcher = Pattern.compile("Admin Organization:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminOrganisation = matcher.group(1);

        matcher = Pattern.compile("Admin Street:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminStreet = matcher.group(1);

        matcher = Pattern.compile("Admin City:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminCity = matcher.group(1);

        matcher = Pattern.compile("Admin State/Province:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminState = matcher.group(1);

        matcher = Pattern.compile("Admin Postal Code:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminPostalCode = matcher.group(1);

        matcher = Pattern.compile("Admin Country:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminCountry = matcher.group(1);

        matcher = Pattern.compile("Admin Phone:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminPhone = matcher.group(1);

        matcher = Pattern.compile("Admin Phone Ext:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminPhoneExt = matcher.group(1);

        matcher = Pattern.compile("Admin Fax:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminFax = matcher.group(1);

        matcher = Pattern.compile("Admin Fax Ext:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminFaxExt = matcher.group(1);

        matcher = Pattern.compile("Admin Email:\\s(.*)").matcher(whoIs);
        if (matcher.find())
            adminEmail = matcher.group(1);

    }

    public static void main(String[] args) {
        System.out.println(Whois.getWhoisRequest("google.com", WhoisClient.DEFAULT_HOST));
        System.out.println("Done");
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminOrganisation() {
        return adminOrganisation;
    }

    public String getAdminStreet() {
        return adminStreet;
    }

    public String getAdminCity() {
        return adminCity;
    }

    public String getAdminState() {
        return adminState;
    }

    public String getAdminPostalCode() {
        return adminPostalCode;
    }

    public String getAdminCountry() {
        return adminCountry;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public String getAdminPhoneExt() {
        return adminPhoneExt;
    }

    public String getAdminFax() {
        return adminFax;
    }

    public String getAdminFaxExt() {
        return adminFaxExt;
    }

    public String getWhoIs() {
        return whoIs;
    }

    /*
        Sample Lookup
        --------------------------------------
        Admin Name: Domain Admin
        Admin Organization: CBS Interactive Inc.
        Admin Street: 235 Second Street,
        Admin City: San Francisco
        Admin State/Province: CA
        Admin Postal Code: 94105
        Admin Country: US
        Admin Phone: +1.4153442000
        Admin Phone Ext:
        Admin Fax: +1.4153442000
        Admin Fax Ext:
        Admin Email: hostmaster@cnet.com */

}
