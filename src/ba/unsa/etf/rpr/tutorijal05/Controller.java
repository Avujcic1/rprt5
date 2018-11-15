package ba.unsa.etf.rpr.tutorijal05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Model m = new Model();

    @FXML
    public void actionNumber(ActionEvent actionEvent) {
        if(start) {
            output.setText("");
            start = false;
        }

        String value = ((Button) actionEvent.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    public void actionOperator(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();

        if(!"=".equals(value)) {
            if(!operator.isEmpty()) return;
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if(operator.isEmpty()) return;
            output.setText(String.valueOf(m.calculate(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
