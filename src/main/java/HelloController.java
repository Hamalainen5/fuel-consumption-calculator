import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private Label lblDistance;

    @FXML
    private Label lblFuel;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtDistance;

    @FXML
    private TextField txtFuel;

    @FXML
    private Button btnCalculate;

    private ResourceBundle bundle;

    @FXML
    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        try {
            bundle = ResourceBundle.getBundle("messages", locale);

            lblDistance.setText(bundle.getString("distance.label"));
            lblFuel.setText(bundle.getString("fuel.label"));
            btnCalculate.setText(bundle.getString("calculate.button"));
            lblResult.setText(bundle.getString("result.default"));

        } catch (MissingResourceException e) {
            lblResult.setText("Language resource file missing.");
        }
    }

    @FXML
    protected void onCalculateClick() {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double fuel = Double.parseDouble(txtFuel.getText());

            if (distance <= 0 || fuel < 0) {
                lblResult.setText(bundle.getString("invalid.input"));
                return;
            }

            double consumption = (fuel / distance) * 100.0;
            String resultPattern = bundle.getString("result.label");
            lblResult.setText(MessageFormat.format(resultPattern, String.format("%.2f", consumption)));

        } catch (NumberFormatException e) {
            lblResult.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    protected void onENClick() {
        setLanguage(new Locale("en", "US"));
    }

    @FXML
    protected void onFRClick() {
        setLanguage(new Locale("fr", "FR"));
    }

    @FXML
    protected void onJPClick() {
        setLanguage(new Locale("ja", "JP"));
    }

    @FXML
    protected void onIRClick() {
        setLanguage(new Locale("fa", "IR"));
    }
}