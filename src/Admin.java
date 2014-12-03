/**
 * Created by Matthew on 12/2/2014.
 */

import java.util.regex.*;

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


    private static Pattern emailPattern;
    private static final String EMAIL_MATCH = "Whois Server:\\s(.*)";
    static {
        emailPattern = Pattern.compile(EMAIL_MATCH);
    }

    public static void main(String[] args)
    {
        System.out.println(Whois.getWhoisRequest("google.com"));
        System.out.println("Done");
    }

    public Admin(String whoIs) {

        Matcher matcher;

        matcher = Pattern.compile("Admin Name:\\s").matcher(whoIs);
        matcher.find();
        adminName = matcher.group();

        matcher = Pattern.compile("Admin Organization:\\s").matcher(whoIs);
        matcher.find();
        adminOrganisation = matcher.group();

        matcher = Pattern.compile("Admin Street:\\s").matcher(whoIs);
        matcher.find();
        adminStreet = matcher.group();

        matcher = Pattern.compile("Admin City:\\s").matcher(whoIs);
        matcher.find();
        adminCity = matcher.group();

        matcher = Pattern.compile("Admin State/Province\\s").matcher(whoIs);
        matcher.find();
        adminState = matcher.group();

        matcher = Pattern.compile("Admin Postal Code:\\s").matcher(whoIs);
        matcher.find();
        adminPostalCode = matcher.group();

        matcher = Pattern.compile("Admin Country:\\s").matcher(whoIs);
        matcher.find();
        adminCountry = matcher.group();

        matcher = Pattern.compile("Admin Phone:\\s").matcher(whoIs);
        matcher.find();
        adminPhone = matcher.group();

        matcher = Pattern.compile("Admin Phone Ext:\\s").matcher(whoIs);
        matcher.find();
        adminPhoneExt = matcher.group();

        matcher = Pattern.compile("Admin Fax:\\s").matcher(whoIs);
        matcher.find();
        adminFax = matcher.group();

        matcher = Pattern.compile("Admin Fax Ext:\\s").matcher(whoIs);
        matcher.find();
        adminFaxExt = matcher.group();

        matcher = Pattern.compile("Admin Email:\\s").matcher(whoIs);
        matcher.find();
        adminEmail = matcher.group();


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
