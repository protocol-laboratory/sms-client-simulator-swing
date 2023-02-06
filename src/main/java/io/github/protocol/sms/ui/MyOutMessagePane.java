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


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Dimension;

public class MyOutMessagePane extends JPanel {
    private int width;
    private int height;
    private String label;
    private JTextPane myTextPane;
    private JLabel myLabel;
    private JScrollPane scrollPane;

    public MyOutMessagePane() {
    }

    public MyOutMessagePane(String label, JTextPane myTextPane, int width, int height) {
        this.label = label;
        this.myTextPane = myTextPane != null ? myTextPane : new MyTextPane();
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        this.init();
    }

    private void init() {
        int inboxWidth = (int) ((double) this.width * 0.95);
        int inboxHeight = (int) ((double) this.height * 0.8);
        Dimension inboxSize = new Dimension(inboxWidth, inboxHeight);
        this.myLabel = new JLabel(this.label, 2);
        this.myLabel.setPreferredSize(new Dimension(inboxWidth, 24));
        this.myTextPane.setPreferredSize(inboxSize);
        this.scrollPane = new JScrollPane(this.myTextPane, 22, 31);
        this.scrollPane.setPreferredSize(inboxSize);
        this.add(this.myLabel);
        this.add(this.scrollPane);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public JTextPane getMyTextPane() {
        return this.myTextPane;
    }

    public void setMyTextPane(JTextPane myTextPane) {
        this.myTextPane = myTextPane;
    }
}
