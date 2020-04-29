package com.project.dto.GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;


class AboutDialog extends JDialog {

    public AboutDialog(Frame parent) {
        super(parent);

        initUI();
    }

    private void initUI() {
        var icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/logo.png"));
        var imgLabel = new JLabel(icon);

        var textLabel = new JLabel("Place your info here");

        var okBtn = new JButton("OK");
        okBtn.addActionListener(event -> dispose());

        createLayout(imgLabel, textLabel, okBtn);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setSize(300, 300);
        setResizable(false);
        setTitle("About Software");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addGap(300)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addComponent(arg[0])
                .addGap(20)
                .addComponent(arg[1])
                .addGap(20)
                .addComponent(arg[2])
                .addGap(20)
        );

        pack();
    }
}