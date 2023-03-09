package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.core.EntityManager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VueSelecteurDeRepertoire extends JFrame {

    private JButton button;
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public VueSelecteurDeRepertoire(EntityManager mEntityManager) {
        super("Sélecteur de fichier");

        button = new JButton("Ouvrir");
        textArea = new JTextArea(20, 40);
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(VueSelecteurDeRepertoire.this);
                   if (returnVal == JFileChooser.APPROVE_OPTION) {
                        textArea.setText(fileChooser.getSelectedFile().getAbsolutePath());
                        mEntityManager.setExchangeDirectory(fileChooser.getSelectedFile().getAbsolutePath());
                    }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}