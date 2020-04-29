package com.project.dto.GUI;

import com.project.dto.config.PROP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;


import static javax.swing.GroupLayout.Alignment.CENTER;

/**
 *  A short description about the software
 * @author Mihai
 */

class AboutDialog extends JDialog {

    JLabel jLabelHeader = new JLabel(PROP.getProperty("app.artifactId") + " - " + PROP.getProperty("app.version"));
    private JTextPane tPane;
    public AboutDialog(Frame parent) {
        super(parent);

        initUI();
    }

    private void initUI() {

        Font font = new Font("my font", Font.BOLD,  14);
        Font font1 = new Font("my font", Font.BOLD,  16);

        EmptyBorder eb = new EmptyBorder(new Insets(10, 10, 10, 10));

        tPane = new JTextPane();
        tPane.setBorder(eb);
        tPane.setMargin(new Insets(5, 5, 5, 5));

        ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("images/logo.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));

        var imgLabel = new JLabel(icon);

        var okBtn = new JButton("OK");

        okBtn.setBounds(175, 5, 60, 40);
        okBtn.addActionListener(event -> dispose());

        tPane.setText(" This is the first version of our \n Remote Container Management" +
                " System. \n Its purpose is to provide the client a platform" +
                "\n for shipping goods overseas using containers.\n Many thanks to: Group I " +
                "\n 2020 (c) www.dtu.dk ");
        tPane.setEditable(false);
        tPane.setEnabled(true);
        tPane.setForeground(Color.RED);
        tPane.setFont(font);
        StyledDocument doc = tPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        jLabelHeader.setForeground(Color.RED);
        jLabelHeader.setFont(font1);

        createLayout(jLabelHeader, imgLabel, tPane, okBtn);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setSize(375, 450);
        setResizable(false);
        setTitle("About Software");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);
        pane.add(jLabelHeader);
        pane.add(tPane);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addGap(300)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(10)
                .addComponent(arg[0])
                .addGap(20)
                .addComponent(arg[1])
                .addGap(20)
                .addComponent(arg[2])
                .addGap(20)
                .addComponent(arg[3])
                .addGap(20)
        );

        pack();
    }
}