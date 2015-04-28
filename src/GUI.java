import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by porrith on 4/20/15.
 */
public class GUI extends JFrame{

    final int row = 7;
    final int column = 5;
    private boolean isParenthesis;

    Calculation calcRef;

    private String currentInput;

    private void setReference(Calculation calculator) { calcRef = calculator; } //sets the reference to the calculation object

    public GUI(Calculation calculator)
    {
        bootGUI();
        setReference(calculator);
    }

    private JButton noPad(final JTextField input, final String numRep)
    {
        JButton b = new JButton(numRep);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isParenthesis == true)
                        input.setText("");
                    isParenthesis = false;
                    currentInput = input.getText();
                    currentInput += numRep;
                    input.setText(currentInput);
                    Double.parseDouble(currentInput);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "This is not a valid number!");
                }
            }
        });
        return b;
    }

    private JButton operator(final JTextField input,final String operatorRep)
    {
        JButton b = new JButton(operatorRep);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operatorRep != "=")
                {
                    currentInput = input.getText();
                    calcRef.addInfix(currentInput);
                    input.setText("");
                    calcRef.addInfix(operatorRep);
                }
                else
                {
                    currentInput = input.getText();
                    calcRef.addInfix(currentInput);
                    calcRef.convertForm();
                    calcRef.calculate();
                    input.setText(Double.toString(calcRef.returnAnswer()));
                }
            }
        });
        return b;
    }

    private JButton memoryButtons(final JLabel memory, final JTextField input, final String memoryRep)
    {
        JButton b = new JButton(memoryRep);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (memoryRep == "MC")
                {
                    calcRef.resetMem();
                    memory.setText(Double.toString(calcRef.getMemory()));
                }
                else if (memoryRep == "M+")
                    try
                    {
                        calcRef.addMemory(input.getText());
                        memory.setText("Memory: " + calcRef.getMemory());
                    }
                    catch (Exception except)
                    {
                        JOptionPane.showMessageDialog(null, "Cannot add to memory.");
                    }
                else if (memoryRep == "M-")
                    try
                    {
                        calcRef.subMemory(input.getText());
                        memory.setText("Memory: " + calcRef.getMemory());
                    }
                    catch (Exception except)
                    {
                        JOptionPane.showMessageDialog(null, "Cannot subract from memory.");
                    }
                else if (memoryRep == "MR")
                    input.setText(Double.toString(calcRef.getMemory()));
                else if (memoryRep == "C")
                    input.setText("");
            }
        });
        return b;
    }

    private JButton extraButtons(final JTextField input, final String rep)
    {
        JButton b = new JButton(rep);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rep == "(") {
                    input.setText(rep);
                    calcRef.addInfix(rep);
                    isParenthesis = true;
                }
                else if (rep == ")")
                {
                    currentInput = input.getText();
                    calcRef.addInfix(currentInput);
                    input.setText(rep);
                    calcRef.addInfix(rep);
                    isParenthesis = true;
                }
                else if (rep == "+/-")
                {
                    String currentIn;
                    StringBuilder buildString;
                    if (input.getText().contains("-"))
                    {
                        currentIn = input.getText();
                        buildString = new StringBuilder(currentIn);
                        buildString.deleteCharAt(0);
                        currentIn = buildString.toString();
                        input.setText(currentIn);
                    }
                    else
                    {
                        currentIn = input.getText();
                        input.setText("-" + currentIn);
                    }
                }
            }
        });
        return b;
    }

    private void bootGUI() {
        //JFrame frame = new JFrame();
        Container contentPane = getContentPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize((column * 75), (row * 50));

        JPanel panel = new JPanel(new GridBagLayout());
        contentPane.add(panel, BorderLayout.NORTH);
        GridBagConstraints constraints = new GridBagConstraints();

        //Input field
        final JTextField input = new JTextField();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = column;
        constraints.weightx = 1;
        constraints.ipady = 20;
        constraints.fill = GridBagConstraints.BOTH;
        input.setEditable(false);
        panel.add(input, constraints);

        constraints.ipady = 20;

        //Memory label
        JLabel memoryLabel = new JLabel("Memory: " + 0.0); //remember to add
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = column;
        panel.add(memoryLabel, constraints);

        constraints.gridwidth = 1;

        //Memory Buttons
        JButton clearMem = memoryButtons(memoryLabel, input, "MC"); //clears the memory and textfield
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(clearMem, constraints);

        JButton addMem = memoryButtons(memoryLabel, input, "M+"); //takes the textfield and adds it to memory
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(addMem, constraints);

        JButton subMem = memoryButtons(memoryLabel, input, "M-"); //subtracts from memory using the textfield
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(subMem, constraints);

        JButton recallMem = memoryButtons(memoryLabel, input, "MR"); //recalls the memory and puts it in the textfield
        constraints.gridx = 3;
        constraints.gridy = 3;
        panel.add(recallMem, constraints);

        JButton clear = memoryButtons(memoryLabel, input, "C"); //clears the textfield only
        constraints.gridx = 4;
        constraints.gridy = 3;
        panel.add(clear, constraints);

        //Numberpad
        JButton one = noPad(input, "1");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(one, constraints);

        JButton two = noPad(input, "2");
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(two, constraints);

        JButton three = noPad(input, "3");
        constraints.gridx = 2;
        constraints.gridy = 5;
        panel.add(three, constraints);

        JButton four = noPad(input, "4");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(four, constraints);

        JButton five = noPad(input, "5");
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(five, constraints);

        JButton six = noPad(input, "6");
        constraints.gridx = 2;
        constraints.gridy = 6;
        panel.add(six, constraints);

        JButton seven = noPad(input, "7");
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(seven, constraints);

        JButton eight = noPad(input, "8");
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(eight, constraints);

        JButton nine = noPad(input, "9");
        constraints.gridx = 2;
        constraints.gridy = 7;
        panel.add(nine, constraints);

        JButton zero = noPad(input, "0");
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridy = 8;
        panel.add(zero, constraints);

        JButton dot = noPad(input, ".");
        constraints.gridx = 2;
        constraints.gridy= 8;
        constraints.gridwidth = 1;
        panel.add(dot, constraints);

        JButton add = operator(input, "+");
        constraints.gridx = 3;
        constraints.gridy = 5;
        panel.add(add, constraints);

        JButton subtract = operator(input, "-");
        constraints.gridx = 3;
        constraints.gridy = 6;
        panel.add(subtract, constraints);

        JButton multiply = operator(input, "*");
        constraints.gridx = 3;
        constraints.gridy = 7;
        panel.add(multiply, constraints);

        JButton divide = operator(input ,"/");
        constraints.gridx = 3;
        constraints.gridy = 8;
        panel.add(divide, constraints);

        JButton equal = operator(input, "=");
        constraints.gridx = 4;
        constraints.gridy = 8;
        panel.add(equal, constraints);

        JButton parenthesisL = extraButtons(input, "(");
        constraints.gridx = 4;
        constraints.gridy = 5;
        panel.add(parenthesisL, constraints);

        JButton parenthesisR = extraButtons(input, ")");
        constraints.gridx = 4;
        constraints.gridy = 6;
        panel.add(parenthesisR, constraints);

        JButton posNeg = extraButtons(input, "+/-");
        constraints.gridx = 4;
        constraints.gridy = 7;
        panel.add(posNeg, constraints);

        setVisible(true);
    }
}
