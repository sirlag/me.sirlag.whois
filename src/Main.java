/**
 * Created by Matthew on 12/2/2014.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    private TextField nameField, organizationField, streetField, cityField, stateField, postalField, countryField,
            phoneField, phoneExtField, faxField, faxExtField, emailField;

    private Admin currentAdmin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        currentAdmin = null;

        //TextArea for the full whois to display
        TextArea fullWhois = new TextArea();
        fullWhois.setEditable(false);
        fullWhois.setMinHeight(250);

        //Horizontal Box Constructor
        HBox inputPane = new HBox();

        //TextField
        TextField domainField = new TextField();

        //Button
        Button getInfo = new Button("Search");
        getInfo.setOnAction((ActionEvent e) -> {

            updateAdmin(getInfo.getText());

        });

        //Adds a label, the TextField and the Button to the Horizontal Box
        inputPane.getChildren().addAll(new Label("Domain : "), domainField, getInfo);
        inputPane.setSpacing(10);
        inputPane.setAlignment(Pos.CENTER);

        VBox leftPane = new VBox();
        leftPane.getChildren().addAll(fullWhois, inputPane);
        leftPane.setSpacing(10);
        leftPane.setMinWidth(300);
        leftPane.setMaxWidth(300);


        GridPane rightPane = new GridPane();

        rightPane.add(new Label("Name"), 0, 0);
        nameField = new TextField();
        nameField.setEditable(false);
        rightPane.add(nameField, 1, 0);

        rightPane.add(new Label("Organization"), 0, 1);
        organizationField = new TextField();
        organizationField.setEditable(false);
        rightPane.add(organizationField, 1, 1);

        rightPane.add(new Label("Street"), 0, 2);
        streetField = new TextField();
        streetField.setEditable(false);
        rightPane.add(streetField, 1, 2);

        rightPane.add(new Label("City"), 0, 3);
        cityField = new TextField();
        cityField.setEditable(false);
        rightPane.add(cityField, 1, 3);

        rightPane.add(new Label("State"), 0, 4);
        stateField = new TextField();
        stateField.setEditable(false);
        rightPane.add(stateField, 1, 4);

        rightPane.add(new Label("Postal Code"), 0, 5);
        postalField = new TextField();
        postalField.setEditable(false);
        rightPane.add(postalField, 1, 5);

        rightPane.add(new Label("Country"), 0, 6);
        countryField = new TextField();
        countryField.setEditable(false);
        rightPane.add(countryField, 1, 6);

        rightPane.add(new Label("Phone Number"), 0, 7);
        phoneField = new TextField();
        phoneField.setEditable(false);
        rightPane.add(phoneField, 1, 7);

        rightPane.add(new Label("Phone Ext."), 0, 8);
        phoneExtField = new TextField();
        phoneExtField.setEditable(false);
        rightPane.add(phoneExtField, 1, 8);

        rightPane.add(new Label("Fax Number"), 0, 9);
        faxField = new TextField();
        faxField.setEditable(false);
        rightPane.add(faxField, 1, 9);

        rightPane.add(new Label("Fax Ext."), 0, 10);
        faxExtField = new TextField();
        faxExtField.setEditable(false);
        rightPane.add(faxExtField, 1, 10);

        rightPane.add(new Label("Email"), 0, 11);
        emailField = new TextField();
        emailField.setEditable(false);
        rightPane.add(emailField, 1, 11);

        rightPane.setMinWidth(260);
        rightPane.setMaxWidth(260);
        rightPane.setAlignment(Pos.CENTER);

        HBox root = new HBox(leftPane, rightPane);
        root.setSpacing(10);

        Scene scene = new Scene(root, 600, 325);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private void updateAdmin(String domain) {
        currentAdmin = new Admin(domain);

        nameField.setText(currentAdmin.getAdminName());
        organizationField.setText(currentAdmin.getAdminOrganisation());
        streetField.setText(currentAdmin.getAdminStreet());
        cityField.setText(currentAdmin.getAdminCity());
        stateField.setText(currentAdmin.getAdminState());
        postalField.setText(currentAdmin.getAdminPostalCode());
        countryField.setText(currentAdmin.getAdminCountry());

        phoneField.setText(currentAdmin.getAdminPhone());
        phoneExtField.setText(currentAdmin.getAdminPhoneExt());
        faxField.setText(currentAdmin.getAdminFax());
        faxExtField.setText(currentAdmin.getAdminFaxExt());
        emailField.setText(currentAdmin.getAdminEmail());

    }
}
