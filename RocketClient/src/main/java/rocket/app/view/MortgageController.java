package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	private ComboBox<String> cmbTerm;
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtDownPayment;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private TextField txtRate;
	@FXML
	private TextField txtMonthlyPayment;
	@FXML
	private TextField txterrorMessage;
	@FXML
	private TextField txtnumberofpaymnet;
	@FXML
	private TextField txtMortgagePayment;
	@FXML
	private Label lblMortgagePayment;
	@FXML
	private Label lblnumberofpayment;
	@FXML
	private Label error;
	@FXML
	private Button CalculatePayment;
	@FXML
	private Label lblincome;
	@FXML
	private Label lblexpenses;
	@FXML
	private Label lblCreditScore;
	@FXML
	private Label lbldownpayment;
	@FXML
	private Label lblHouseCost;
	@FXML
	private Label lblRate;
	@FXML
	private Label lblMonthlyPayment;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setIncome(Double.parseDouble((txtIncome.getText())));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiTerm(Integer.parseInt(cmbTerm.getStyle()));
		lq.setdRate(Double.parseDouble(txtHouseCost.getText())-Double.parseDouble(txtDownPayment.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		
		a.setLoanRequest(lq);
		
		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		LoanRequest lq = new LoanRequest();
		RateBLL _RateBLL = new RateBLL();
		String pmt = String.format("%1$,.2f", Math.abs(lRequest.getdPayment()));
		lblMortgagePayment.setText(pmt);
		
		String rate = String.format("%1$,.2f", Math.abs(lRequest.getdRate()));
		lblMortgagePayment.setText(rate);
		
		double PMT = Math.abs(lq.getdPayment());
		double RATE = Math.abs(lq.getdRate());
	
		if (RATE == 0) {
			txtRate.setText("nothing");
			txtMonthlyPayment.setText("nothing");
		} else {
			txtRate.setText(rate);
			if (_RateBLL.incomecheck(lq.getIncome())){
				txtMonthlyPayment.setText(pmt);
			} else {
				txtMonthlyPayment.setText("House Cost too high");
			}
		}

	}
}