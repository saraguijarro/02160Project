package com.project.dto.GUI;

import com.project.dto.config.PROP;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Frame about class
 * @author Mihai Nipomici
 */

public class FrameAbout extends JInternalFrame {

    final static Logger log = Logger.getLogger(FrameAbout.class);

    JLabel jLabelLogo;
    JLabel jLabelHeader = new JLabel("<html><h3>" + PROP.getProperty("app.artifactId") + "-" + PROP.getProperty("app.version") + "</h3></html>");
    JTextArea jTextArea1 = new JTextArea(11, 21);
    JButton jButtonOk = new JButton("frameAbout.jButtonOk");

    /**
     * Constructor.
     */
    public FrameAbout()
    {
        log.debug("START constructor...");

        setTitle("frameAbout.title");
        setLocation(new Random().nextInt(140) + 50, new Random().nextInt(150) + 50);
        setSize(320, 400);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(false);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        // data :
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        //ImageIcon resizedIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("images/logo.png")).getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
        jLabelLogo = new JLabel(icon);

        jTextArea1.setText("frameAbout.jTextArea1");
        jTextArea1.setEditable(false);
        jTextArea1.setEnabled(false);

        //add component to the frame :
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(jLabelHeader);
        getContentPane().add(jLabelLogo);
        getContentPane().add(new JScrollPane(jTextArea1));
        getContentPane().add(jButtonOk);

        // actions / events :
        jButtonOk.addActionListener((ActionEvent ev) ->
        {
            log.debug("ActionEvent on " + ev.getActionCommand());

            setVisible(false);
        });

        setVisible(false);

        log.debug("End of constructor.");
    }
}