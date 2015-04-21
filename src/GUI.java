import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by porrith on 4/20/15.
 */
public class GUI extends JFrame{

    final int row = 7;
    final int column = 4;

    private double memoryVal;

    public GUI()
    {
        bootGUI();
    }

    private void bootGUI() {
        Container contentPanel = getContentPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize((row * 100), (column * 100));

        JPanel panel = new JPanel(new GridBagLayout());
        contentPanel.add(panel, BorderLayout.NORTH);
        GridBagConstraints constraints = new GridBagConstraints();

        //Memory label
        final JLabel memory = new JLabel("Memory: ");
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = column;
        panel.add(memory, constraints);

        //Output field
        final JTextField output = new JTextField();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = column;
        constraints.ipady = 20;
        constraints.fill = GridBagConstraints.BOTH;
        output.setEditable(false);
        panel.add(output, constraints);

        //Input field
        JTextField input = new JTextField();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = column;
        constraints.weightx = 1;
        constraints.ipady = 20;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(input, constraints);

        constraints.ipady = 0;

        //Memory Buttons
        JButton clearMem = new JButton("MC");
        clearMem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memory.setText("Memory: ");
                output.setText("");
            }
        });
        contentPanel.add(clearMem);

        JButton resetMem = new JButton("MR");
        resetMem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memory.setText("Memory : ");
                output.setText("");
            }
        });


        setVisible(true);


    }
}
