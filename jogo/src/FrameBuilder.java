import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameBuilder {

    public JFrame buildEmptyFrame (String title) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setResizable(true);
        jFrame.setSize(285, 130);
        jFrame.setTitle(title);

        jFrame.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = jFrame.getWidth();
        int frameHeight = jFrame.getHeight();
        jFrame.setLocation((screenWidth - frameWidth) / 2, ((screenHeight - frameHeight) / 2)-20);

        return jFrame;
    }

    public JPanel textPanel(String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(20));

        JLabel label = new JLabel(text);
        label.setAlignmentX(0.51f);
        panel.add(label);

        panel.add(Box.createVerticalStrut(10));

        return panel;
    }

    public JPanel questionTextPanel(String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));

        JLabel label = new JLabel("    " + text, UIManager.getIcon("OptionPane.questionIcon"), JLabel.RIGHT);
        label.setAlignmentX(0.23f);
        panel.add(label);

        panel.add(Box.createVerticalStrut(5));

        return panel;
    }

    public JPanel infoTextPanel(String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));

        JLabel label = new JLabel("    " + text,  UIManager.getIcon("OptionPane.informationIcon"), JLabel.RIGHT);
        label.setAlignmentX(0.1f);
        panel.add(label);

        panel.add(Box.createVerticalStrut(5));

        return panel;
    }

    public JButton createCentralizedButton(ActionListener actionListener, String buttonText){
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(80, 30));
        button.setAlignmentX(0.51f);
        button.addActionListener(actionListener);
        return button;
    }

    public JButton createYesButton(ActionListener actionListener){
        JButton button = new JButton("<html><u>S</u>im</html>");
        button.setAlignmentX(1f);
        button.addActionListener(actionListener);
        return button;
    }

    public JButton createNoButton(ActionListener actionListener){
        JButton button = new JButton("<html><u>N</u>ão</html>");
        button.setAlignmentX(0.009f);
        button.addActionListener(actionListener);
        return button;
    }

    public JButton createCancelButton(ActionListener actionListener){
        JButton button = new JButton("<html><u>C</u>ancelar</html>");
        button.setAlignmentX(0.009f);
        button.addActionListener(actionListener);
        return button;
    }

    public JButton createOKButton(ActionListener actionListener){
        JButton button = new JButton("<html><u>O</u>k</html>");
        button.setAlignmentX(0.009f);
        button.addActionListener(actionListener);
        return button;
    }

    public JPanel createYesNoButton(ArrayList<JFrame> frames, JFrame yesActionListener, JFrame noActionListener) {
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(createYesButton(actionListenerBuilder.actionListener(frames, yesActionListener)));
        buttonPanel.add(createNoButton(actionListenerBuilder.actionListener(frames, noActionListener)));
        return buttonPanel;
    }

    public JPanel createOkCancelButton(ArrayList<JFrame> frames, ActionListener okActionListener) {
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(createOKButton(okActionListener));
        buttonPanel.add(createCancelButton(actionListenerBuilder.closeAllScreens(frames)));
        return buttonPanel;
    }
}