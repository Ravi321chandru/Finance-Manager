import javax.swing.JApplet;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceManagerApplet extends JApplet implements ActionListener {
    private List expenseList;
    private TextField descriptionField;
    private TextField amountField;
    private Button addButton;
    private Label balanceLabel;
    private double balance = 100.0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Finance Manager Applet");
        FinanceManagerApplet applet = new FinanceManagerApplet();
        frame.add(applet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        applet.init();
    }

    public void init() {
        setLayout(new FlowLayout());

        expenseList = new List(10);
        descriptionField = new TextField(20);
        amountField = new TextField(10);
        addButton = new Button("Add Expense");
        balanceLabel = new Label("Balance: $" + balance);

        addButton.addActionListener(this);

        add(new Label("Personal Finance Manager"));
        add(new Label("Description:"));
        add(descriptionField);
        add(new Label("Amount: $"));
        add(amountField);
        add(addButton);
        add(expenseList);
        add(balanceLabel);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addButton) {
            String description = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());

            if (balance >= amount) {
                expenseList.add(description + " - $" + amount);
                balance -= amount;
                balanceLabel.setText("Balance: $" + balance);

                descriptionField.setText("");
                amountField.setText("");
            } else {
                balanceLabel.setText("Insufficient funds!");
            }
        }
    }
}
