import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FrameBuilder {

    public JFrame buildEmptyFrame (String title) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setResizable(true);
        jFrame.setSize(285, 130);
        jFrame.setTitle(title);

        // Define o layout da janela como BorderLayout
        jFrame.setLayout(new BorderLayout());

        // Centraliza a janela na tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = jFrame.getWidth();
        int frameHeight = jFrame.getHeight();
        jFrame.setLocation((screenWidth - frameWidth) / 2, ((screenHeight - frameHeight) / 2)-20);

        return jFrame;
    }

    public JPanel textPanel(String text) {
        // Cria um painel para adicionar o texto e o botão
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Altera o layout do JPanel para BoxLayout
        panel.add(Box.createVerticalStrut(20));

        JLabel label = new JLabel(text);
        label.setAlignmentX(0.51f);
        panel.add(label);

        panel.add(Box.createVerticalStrut(10));

        return panel;
    }

    public JPanel questionTextPanel(String text) {
        // Cria um painel para adicionar o texto e o botão
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Altera o layout do JPanel para BoxLayout
        panel.add(Box.createVerticalStrut(10));

        JLabel label = new JLabel("    " + text, UIManager.getIcon("OptionPane.questionIcon"), JLabel.RIGHT);
        label.setAlignmentX(0.23f);
        panel.add(label);

        panel.add(Box.createVerticalStrut(5));

        return panel;
    }

    public JPanel infoTextPanel(String text) {
        // Cria um painel para adicionar o texto e o botão
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Altera o layout do JPanel para BoxLayout
        panel.add(Box.createVerticalStrut(10));

        JLabel label = new JLabel("    " + text,  UIManager.getIcon("OptionPane.informationIcon"), JLabel.RIGHT);
        label.setAlignmentX(0.1f);
        panel.add(label);

        panel.add(Box.createVerticalStrut(5));

        return panel;
    }

    public JButton createCentralizedButton(ActionListener actionListener, String buttonText){
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(80, 30)); // Define a largura preferencial do botão
        button.setAlignmentX(0.51f);
        button.addActionListener(actionListener);
        return button;
    }

    public JButton createCentralizedInfoScreenButton(ActionListener actionListener, String buttonText){
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(80, 30)); // Define a largura preferencial do botão
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

    public JPanel createYesNoButton(JFrame yesActionListener, JFrame noActionListener) {
        ActionListenerBuilder actionListenerBuilder = new ActionListenerBuilder();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Define o layout do painel como FlowLayout
        buttonPanel.add(createYesButton(actionListenerBuilder.actionListener(yesActionListener)));
        buttonPanel.add(createNoButton(actionListenerBuilder.actionListener(noActionListener)));
        return buttonPanel;
    }
}
