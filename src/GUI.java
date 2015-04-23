import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by porrith on 4/20/15.
 * GridBagConstraints, look up location of grid
 */
public class GUI extends JFrame{

    final int row = 7;
    final int column = 5;

    private String textField;

    public GUI(Calculation calculator)
    {
        bootGUI();
    }

    private void noPad(final JTextField input, final String numRep)
    {
        JButton b = new JButton(numRep);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
        input.setEditable(true);
        panel.add(input, constraints);

        constraints.ipady = 20;

        //Memory label
        final JLabel memory = new JLabel("Memory: "); //remember to add
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = column;
        panel.add(memory, constraints);

        constraints.gridwidth = 1;

        //Memory Buttons
        JButton clearMem = new JButton("MC"); //clears the memory and textfield
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(clearMem, constraints);

        JButton addMem = new JButton("M+"); //takes the textfield and adds it to memory
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(addMem, constraints);

        JButton subMem = new JButton("M-"); //subtracts from memory using the textfield
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(subMem, constraints);

        JButton recallMem = new JButton("MR"); //recalls the memory and puts it in the textfield
        constraints.gridx = 3;
        constraints.gridy = 3;
        panel.add(recallMem, constraints);

        JButton clear = new JButton("C"); //clears the textfield only
        constraints.gridx = 4;
        constraints.gridy = 3;
        panel.add(clear, constraints);

        JButton one = new JButton("1");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(one, constraints);

        JButton two = new JButton("2");
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(two, constraints);

        JButton three = new JButton("3");
        constraints.gridx = 2;
        constraints.gridy = 5;
        panel.add(three, constraints);

        JButton four = new JButton("4");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(four, constraints);

        JButton five = new JButton("5");
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(five, constraints);

        JButton six = new JButton("6");
        constraints.gridx = 2;
        constraints.gridy = 6;
        panel.add(six, constraints);

        JButton seven = new JButton("7");
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(seven, constraints);

        JButton eight = new JButton("8");
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(eight, constraints);

        JButton nine = new JButton("9");
        constraints.gridx = 2;
        constraints.gridy = 7;
        panel.add(nine, constraints);

        JButton zero = new JButton("0");
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridy = 8;
        panel.add(zero, constraints);

        setVisible(true);
    }
}
