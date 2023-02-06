/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.github.protocol.sms.ui;

import io.github.protocol.sms.ui.button.ConnectButton;
import io.github.protocol.sms.ui.button.DisconnectButton;
import io.github.protocol.sms.ui.label.IPLabel;
import io.github.protocol.sms.ui.label.LogLabel;
import io.github.protocol.sms.ui.button.MessageButton;
import io.github.protocol.sms.ui.label.PortLabel;
import io.github.protocol.sms.ui.label.ProtocolLabel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;


public class SmsClientSimulatorFrame extends JFrame {

    private GridBagLayout layout = new GridBagLayout();
    private JLabel ipLabel = new IPLabel();
    private JTextField ipTextField = new IPTextField();

    private JLabel portLabel = new PortLabel();

    private JTextField portTextField = new PortTextField();

    private JLabel protocolLabel = new ProtocolLabel();

    private JComboBox protocolComboBox = new ProtocolComboBox();

    private JSeparator separator1 = new JSeparator();

    private JSeparator separator2 = new JSeparator();

    private JSeparator separator3 = new JSeparator();

    private LogLabel logLabel = new LogLabel();

    private LogTextArea logTextArea = new LogTextArea();

    private LogScrollPane logScrollPane;

    private JButton messageButton = new MessageButton();

    private JButton connectButton;

    private JButton disconnectButton;

    private JTabbedPane tabbedPane = new JTabbedPane();

    private JTextPane hexMsgArea = new MyTextPane();

    private JTextPane jsonMsgArea = new MyTextPane();

    public SmsClientSimulatorFrame() throws HeadlessException {
        super("Sms Client Simulator");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(650, 750);
        int width = (int) dimension.getWidth();
        this.setLocation(width - this.getWidth(), 0);
        this.setLocation(width, 0);
        this.setResizable(false);
        this.setLayout(this.layout);
        this.add(this.ipLabel, this.setConstraints(1, 0, 0, 1, 1,
                new Insets(5, 5, 5, 5)));
        this.add(this.ipTextField, this.setConstraints(1, 0, 1, 1, 1, null));
        this.add(this.portLabel, this.setConstraints(1, 0, 2, 1, 1, null));
        this.add(this.portTextField, this.setConstraints(1, 0, 3, 1, 1, null));
        this.add(this.protocolLabel, this.setConstraints(1, 0, 4, 1, 1, null));
        this.add(this.protocolComboBox, this.setConstraints(1, 0, 5, 1, 1, null));
        this.connectButton = new ConnectButton(this);
        this.add(this.connectButton, this.setConstraints(1, 0, 6, 1, 1,
                new Insets(0, 10, 0, 10)));
        this.disconnectButton = new DisconnectButton(this);
        this.add(this.disconnectButton, this.setConstraints(1, 0, 7, 1, 1,
                new Insets(0, 0, 0, 10)));
        this.add(this.separator1, this.setConstraints(1, 1, 0, 8, 1, null));
        this.add(this.logLabel, this.setConstraints(1, 2, 0, 8, 1,
                new Insets(5, 5, 5, 5)));
        this.add(this.logTextArea, this.setConstraints(1, 3, 0, 8, 5,
                new Insets(5, 5, 5, 5)));
        this.logScrollPane = new LogScrollPane(this.logTextArea);
        this.add(this.logScrollPane, this.setConstraints(1, 3, 0, 8, 5, null));
        this.add(this.separator2, this.setConstraints(1, 8, 0, 8, 1, null));
        this.add(this.tabbedPane, this.setConstraints(1, 9, 0, 8, 1, null));
        JPanel hexMsgPanel = new MyOutMessagePane("Hex消息:", this.hexMsgArea, 700, 200);
        this.tabbedPane.add("十六进制码流", hexMsgPanel);
        JPanel jsonMsgPanel = new MyOutMessagePane("JSON消息:", this.jsonMsgArea, 700, 200);
        this.tabbedPane.add("JSON", jsonMsgPanel);
        this.add(this.separator3, this.setConstraints(1, 15, 0, 8, 1, null));
        this.add(this.messageButton, this.setConstraints(1, 17, 0, 8, 1,
                new Insets(5, 5, 5, 6)));

    }

    private GridBagConstraints setConstraints(int fill, int gridy, int gridx, int gridwidth,
                                              int gridheight, Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = fill;
        constraints.gridy = gridy;
        constraints.gridx = gridx;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        if (insets != null) {
            constraints.insets = insets;
        }
        return constraints;
    }

    public JTextField getIpTextField() {
        return this.ipTextField;
    }
}
