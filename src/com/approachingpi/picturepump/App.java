/*
Copyright 2009 Terrence Curran - Approaching Pi

Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

/*
 * App.java
 *
 * Created on Apr 3, 2009, 2:28:01 PM
 */
package com.approachingpi.picturepump;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author tea
 */
public class App extends javax.swing.JFrame {

    Runner runner;
    String namePrefix = "";
    int imagesAdded = 0;
    int imagesChecked = 0;
    int imageNameCounter = 0;
    int imagesDownloaded = 0;
    boolean running = false;
    String selectedSize = "";
    String selectedType = "";
    String selectedLicense = "";
    String selectedSafe = "";
    int imagesToCheck = 0;
    int threadCount = 0;
    Prefs prefs;
    final JFileChooser fileChooser = new JFileChooser();

    /** Creates new form App */
    public App() {
	initComponents();

	prefs = new Prefs();
	prefs.load();

	this.loadSettings();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSize = new javax.swing.ButtonGroup();
        buttonGroupType = new javax.swing.ButtonGroup();
        buttonGroupSafe = new javax.swing.ButtonGroup();
        mainTabPane = new javax.swing.JTabbedPane();
        searchPanel = new javax.swing.JPanel();
        labelSearchString = new javax.swing.JLabel();
        textSearchString = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        labelActive = new javax.swing.JLabel();
        labelProgress = new javax.swing.JLabel();
        labelChecked = new javax.swing.JLabel();
        labelDownloaded = new javax.swing.JLabel();
        labelCheckedValue = new javax.swing.JLabel();
        labelDownloadedValue = new javax.swing.JLabel();
        labelPending = new javax.swing.JLabel();
        labelPendingValue = new javax.swing.JLabel();
        previewPanel = new com.approachingpi.picturepump.PreviewPanel();
        progressBar = new javax.swing.JProgressBar();
        labelActiveValue = new javax.swing.JLabel();
        optionsPanel = new javax.swing.JPanel();
        labelSaveToPath = new javax.swing.JLabel();
        textSaveToPath = new javax.swing.JTextField();
        buttonSaveToPath = new javax.swing.JButton();
        labelMaxResults = new javax.swing.JLabel();
        textMaxResults = new javax.swing.JTextField();
        labelMaxThreads = new javax.swing.JLabel();
        textMaxThreads = new javax.swing.JTextField();
        labelSize = new javax.swing.JLabel();
        radioSizeSmall = new javax.swing.JRadioButton();
        radioSizeMedium = new javax.swing.JRadioButton();
        radioSizeLarge = new javax.swing.JRadioButton();
        radioSizeAny = new javax.swing.JRadioButton();
        labelAgentSpoof = new javax.swing.JLabel();
        textAgentSpoof = new javax.swing.JTextField();
        labelType = new javax.swing.JLabel();
        radioTypeAny = new javax.swing.JRadioButton();
        radioTypeNews = new javax.swing.JRadioButton();
        radioTypeFaces = new javax.swing.JRadioButton();
        radioTypePhotos = new javax.swing.JRadioButton();
        radioTypeClip = new javax.swing.JRadioButton();
        radioTypeLine = new javax.swing.JRadioButton();
        labelLicense = new javax.swing.JLabel();
        comboLicense = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        radioSafeOff = new javax.swing.JRadioButton();
        radioSafeModerate = new javax.swing.JRadioButton();
        radioSafeStrict = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelSearchString.setText("Search String");

        textSearchString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchStringActionPerformed(evt);
            }
        });

        buttonSearch.setText("search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        labelActive.setText("active");

        labelProgress.setText("progress");

        labelChecked.setText("checked");

        labelDownloaded.setText("downloaded");

        labelCheckedValue.setText("0");

        labelDownloadedValue.setText("0");

        labelPending.setText("pending");

        labelPendingValue.setText("0");

        org.jdesktop.layout.GroupLayout previewPanelLayout = new org.jdesktop.layout.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 327, Short.MAX_VALUE)
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 286, Short.MAX_VALUE)
        );

        labelActiveValue.setText("0");

        org.jdesktop.layout.GroupLayout searchPanelLayout = new org.jdesktop.layout.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(labelActive)
                    .add(labelSearchString)
                    .add(labelProgress)
                    .add(labelPending)
                    .add(labelChecked)
                    .add(labelDownloaded))
                .add(18, 18, 18)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelActiveValue)
                    .add(labelDownloadedValue)
                    .add(labelCheckedValue)
                    .add(labelPendingValue)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, searchPanelLayout.createSequentialGroup()
                        .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, previewPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, progressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textSearchString, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelSearchString)
                    .add(textSearchString, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonSearch))
                .add(7, 7, 7)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelProgress)
                    .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelActive)
                    .add(labelActiveValue))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelPending)
                    .add(labelPendingValue))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelChecked)
                    .add(labelCheckedValue))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelDownloaded)
                    .add(labelDownloadedValue))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(previewPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("search", searchPanel);

        labelSaveToPath.setText("save to path");

        buttonSaveToPath.setText("browse");
        buttonSaveToPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveToPathActionPerformed(evt);
            }
        });

        labelMaxResults.setText("max results");

        labelMaxThreads.setText("max threads");

        labelSize.setText("size");

        buttonGroupSize.add(radioSizeSmall);
        radioSizeSmall.setText("small");
        radioSizeSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSizeSmallActionPerformed(evt);
            }
        });

        buttonGroupSize.add(radioSizeMedium);
        radioSizeMedium.setText("medium");

        buttonGroupSize.add(radioSizeLarge);
        radioSizeLarge.setText("large");

        buttonGroupSize.add(radioSizeAny);
        radioSizeAny.setText("any");
        radioSizeAny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSizeAnyActionPerformed(evt);
            }
        });

        labelAgentSpoof.setText("agent spoof");

        labelType.setText("type");

        buttonGroupType.add(radioTypeAny);
        radioTypeAny.setText("any");
        radioTypeAny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTypeAnyActionPerformed(evt);
            }
        });

        buttonGroupType.add(radioTypeNews);
        radioTypeNews.setText("news");

        buttonGroupType.add(radioTypeFaces);
        radioTypeFaces.setText("faces");

        buttonGroupType.add(radioTypePhotos);
        radioTypePhotos.setText("photos");
        radioTypePhotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTypePhotosActionPerformed(evt);
            }
        });

        buttonGroupType.add(radioTypeClip);
        radioTypeClip.setText("clip art");

        buttonGroupType.add(radioTypeLine);
        radioTypeLine.setText("line art");

        labelLicense.setText("license");

        comboLicense.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Labeled for reuse", "Labeled for commercial reuse", "Labeled for reuse with modification", "Labeled for commercial reuse with modification" }));

        jLabel1.setText("safe search");

        buttonGroupSafe.add(radioSafeOff);
        radioSafeOff.setText("off");

        buttonGroupSafe.add(radioSafeModerate);
        radioSafeModerate.setText("moderate");

        buttonGroupSafe.add(radioSafeStrict);
        radioSafeStrict.setText("strict");

        org.jdesktop.layout.GroupLayout optionsPanelLayout = new org.jdesktop.layout.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(optionsPanelLayout.createSequentialGroup()
                        .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(labelLicense)
                            .add(labelType)
                            .add(labelSize)
                            .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(labelMaxResults)
                                    .add(labelSaveToPath))
                                .add(labelMaxThreads)))
                        .add(6, 6, 6))
                    .add(optionsPanelLayout.createSequentialGroup()
                        .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel1)
                            .add(labelAgentSpoof, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, textMaxThreads)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, textMaxResults, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, optionsPanelLayout.createSequentialGroup()
                        .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, optionsPanelLayout.createSequentialGroup()
                                .add(textSaveToPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                .add(118, 118, 118))
                            .add(optionsPanelLayout.createSequentialGroup()
                                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(radioSizeAny)
                                    .add(radioTypeAny))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(radioSizeSmall)
                                    .add(radioTypeNews))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(optionsPanelLayout.createSequentialGroup()
                                        .add(6, 6, 6)
                                        .add(radioSizeMedium)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(radioSizeLarge))
                                    .add(optionsPanelLayout.createSequentialGroup()
                                        .add(4, 4, 4)
                                        .add(radioTypeFaces)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(radioTypePhotos)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(radioTypeLine)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(radioTypeClip))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, buttonSaveToPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, comboLicense, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, optionsPanelLayout.createSequentialGroup()
                                .add(radioSafeOff)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(radioSafeModerate)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(radioSafeStrict))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textAgentSpoof, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                        .add(190, 190, 190)))
                .addContainerGap())
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textSaveToPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelSaveToPath)
                    .add(buttonSaveToPath))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textMaxResults, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelMaxResults))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelMaxThreads)
                    .add(textMaxThreads, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelSize)
                    .add(radioSizeAny)
                    .add(radioSizeSmall)
                    .add(radioSizeMedium)
                    .add(radioSizeLarge))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelType)
                    .add(radioTypeAny)
                    .add(radioTypeNews)
                    .add(radioTypeFaces)
                    .add(radioTypePhotos)
                    .add(radioTypeLine)
                    .add(radioTypeClip))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelLicense)
                    .add(comboLicense, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(radioSafeOff)
                    .add(radioSafeModerate)
                    .add(radioSafeStrict)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(optionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelAgentSpoof)
                    .add(textAgentSpoof, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(185, 185, 185))
        );

        mainTabPane.addTab("options", optionsPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainTabPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainTabPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void textSearchStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchStringActionPerformed
	    // TODO add your handling code here:
}//GEN-LAST:event_textSearchStringActionPerformed

	private void radioSizeSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSizeSmallActionPerformed
	    // TODO add your handling code here:
}//GEN-LAST:event_radioSizeSmallActionPerformed

	private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
	    if (!running) {
		startRunning();
	    } else {
		this.stopRunning();
	    }
	}//GEN-LAST:event_buttonSearchActionPerformed

	private void buttonSaveToPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveToPathActionPerformed
	    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    fileChooser.setAcceptAllFileFilterUsed(false);

	    int returnVal = fileChooser.showDialog(this, "Select");

	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = fileChooser.getSelectedFile();
		// JFileChooser often adds the folder name when the user double clicks
		// on the folder rather than using the choose button
		if (!file.exists()) {
		    file = fileChooser.getCurrentDirectory();
		}
		this.textSaveToPath.setText(file.getPath());
	    }
	}//GEN-LAST:event_buttonSaveToPathActionPerformed

	private void radioTypeAnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTypeAnyActionPerformed
	    // TODO add your handling code here:
	}//GEN-LAST:event_radioTypeAnyActionPerformed

	private void radioSizeAnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSizeAnyActionPerformed
	    // TODO add your handling code here:
	}//GEN-LAST:event_radioSizeAnyActionPerformed

	private void radioTypePhotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTypePhotosActionPerformed
	    // TODO add your handling code here:
	}//GEN-LAST:event_radioTypePhotosActionPerformed

    public void startRunning() {
	saveSettings();

	prefs.setPropertyInt("maxThreads", this.textMaxThreads.getText(), Prefs.DEFAULT_MAX_THREADS);
	prefs.setPropertyInt("maxResults", this.textMaxResults.getText(), Prefs.DEFAULT_MAX_RESULTS);
	imagesToCheck = prefs.getPropertyInt("maxResults");
	namePrefix = textSearchString.getText().replaceAll("\\W", "_");

	boolean abortRunning = false;
	if (prefs.getProperty("saveToPath").equals("")) {
	    abortRunning = true;
	    JOptionPane.showMessageDialog(this, "Please choose a path to save the files to", "Error", JOptionPane.ERROR_MESSAGE);
	}
	if (!abortRunning && (textSearchString.getText() == null || textSearchString.getText().equals(""))) {
	    abortRunning = true;
	    JOptionPane.showMessageDialog(this, "Please enter a search term", "Error", JOptionPane.ERROR_MESSAGE);
	}

	if (!abortRunning) {
	    imagesAdded = 0;
	    imagesChecked = 0;
	    imagesDownloaded = 0;
	    threadCount = 0;

	    textSaveToPath.setEnabled(false);
	    textSearchString.setEnabled(false);
	    textMaxResults.setEnabled(false);
	    textMaxThreads.setEnabled(false);
	    progressBar.setValue(0);

	    this.buttonSearch.setText("Stop");

	    runner = new Runner(this, textSearchString.getText(), 0);
	    running = true;
	    runner.start();
	}
    }

    public void stopRunning() {
	runner.finishRunning();
	buttonSearch.setText("Stopping");
    }

    public void loadSettings() {
	try {
	    this.textMaxThreads.setText(new Integer(prefs.getPropertyInt("maxThreads", Prefs.DEFAULT_MAX_THREADS)).toString());
	    this.textMaxResults.setText(new Integer(prefs.getPropertyInt("maxResults", Prefs.DEFAULT_MAX_RESULTS)).toString());
	    this.textSaveToPath.setText(prefs.getProperty("saveToPath"));
	    this.textAgentSpoof.setText(prefs.getPropertyWithDefaultBlank("agentSpoof", Prefs.DEFAULT_AGENT_SPOOF));
	    selectedSize = prefs.getPropertyWithDefaultBlank("selectedSize", Prefs.DEFAULT_SELECTED_SIZE);
	    selectedType = prefs.getPropertyWithDefaultBlank("selectedType", Prefs.DEFAULT_SELECTED_TYPE);
	    selectedLicense = prefs.getPropertyWithDefaultBlank("selectedLicense", Prefs.DEFAULT_SELECTED_LICENSE);
	    selectedSafe = prefs.getPropertyWithDefaultBlank("selectedSafe", Prefs.DEFAULT_SELECTED_SAFE);

	    this.setSelectedSize();
	    this.setSelectedType();
	    this.setSelectedSafe();
	    for (int i = 0; i < this.comboLicense.getItemCount(); i++) {
		String thisOption = (String) comboLicense.getItemAt(i);
		if (thisOption.equalsIgnoreCase(selectedLicense)) {
		    this.comboLicense.setSelectedItem(thisOption);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public String getNamePrefix() {
	return this.namePrefix;
    }

    public int getMaxResults() {
	return prefs.getPropertyInt("maxResults");
    }

    public int getMaxThreads() {
	return prefs.getPropertyInt("maxThreads");
    }

    public int getMaxImageChecks() {
	return this.getMaxResults();
    }

    public synchronized void decrementThreadCount() {
	this.threadCount--;
    }

    public synchronized String getPaddedImageNumber() {
	imageNameCounter++;
	int maxPadSize = (new Integer(this.getMaxResults()).toString()).length();
	int padSize = maxPadSize - (new Integer(imageNameCounter).toString()).length();
	StringBuffer paddedImageNumber = new StringBuffer(maxPadSize);
	for (int i = 0; i < padSize; i++) {
	    paddedImageNumber.append("0");
	}
	paddedImageNumber.append(new Integer(imageNameCounter).toString());
	return paddedImageNumber.toString();
    }

    public String getSaveToPath() {
	return (this.textSaveToPath.getText() == null) ? "" : this.textSaveToPath.getText();
    }

    public String getSelectedSize() {
	if (selectedSize == null) {
	    selectedSize = "";
	}
	return selectedSize;
    }

    public String getSelectedSizeGoogle() {
	if (getSelectedSize().equalsIgnoreCase("any")) {
	    return "";
	} else if (getSelectedSize().equalsIgnoreCase("small")) {
	    return "i";
	} else if (getSelectedSize().equalsIgnoreCase("medium")) {
	    return "m";
	} else if (getSelectedSize().equalsIgnoreCase("large")) {
	    return "l";
	}
	return getSelectedSize();
    }

    public String getSelectedType() {
	if (selectedType == null) {
	    selectedType = "";
	}
	return selectedType;
    }

    public String getSelectedTypeGoogle() {
	if (getSelectedType().equalsIgnoreCase("any")) {
	    return "";
	} else if (getSelectedType().equalsIgnoreCase("news")) {
	    return "news";
	} else if (getSelectedType().equalsIgnoreCase("faces")) {
	    return "face";
	} else if (getSelectedType().equalsIgnoreCase("photos")) {
	    return "photo";
	} else if (getSelectedType().equalsIgnoreCase("line art")) {
	    return "lineart";
	} else if (getSelectedType().equalsIgnoreCase("clip art")) {
	    return "clipart";
	}
	return getSelectedType();
    }

    public String getSelectedLicense() {
	if (selectedLicense == null) {
	    selectedLicense = "";
	}
	return selectedLicense;
    }

    public String getSelectedLicenseGoogle() {
	if (getSelectedLicense().equalsIgnoreCase("any")) {
	    return "";
	} else if (getSelectedLicense().equalsIgnoreCase("labeled for reuse")) {
	    return "(cc_publicdomain|cc_attribute|cc_sharealike|cc_noncommercial|cc_nonderived)";
	} else if (getSelectedLicense().equalsIgnoreCase("labeled for commercial reuse")) {
	    return "(cc_publicdomain|cc_attribute|cc_sharealike|cc_nonderived).-(cc_noncommercial)";
	} else if (getSelectedLicense().equalsIgnoreCase("labeled for reuse with modification")) {
	    return "(cc_publicdomain|cc_attribute|cc_sharealike|cc_noncommercial).-(cc_nonderived)";
	} else if (getSelectedLicense().equalsIgnoreCase("labeled for commercial reuse with modification")) {
	    return "(cc_publicdomain|cc_attribute|cc_sharealike).-(cc_noncommercial|cc_nonderived)";
	}
	return getSelectedLicense();
    }

    public String getSelectedSafe() {
	if (selectedSafe == null) {
	    selectedSafe = "";
	}
	return selectedSafe;
    }

    public String getSelectedSafeGoogle() {
	if (getSelectedSafe().equalsIgnoreCase("off")) {
	    return "off";
	} else if (getSelectedSafe().equalsIgnoreCase("moderate")) {
	    return "images";
	} else if (getSelectedLicense().equalsIgnoreCase("strict")) {
	    return "active";
	}
	return getSelectedSafe();
    }

    public int setThreadCount() {
	return this.threadCount;
    }

    public synchronized void incrementImagesChecked() {
	imagesChecked++;
    }

    public synchronized void incrementImagesAdded() {
	imagesAdded++;
    }

    public synchronized void incrementImagesDownloaded() {
	imagesDownloaded++;
    }

    public synchronized void incrementThreadCount() {
	threadCount++;
    }
    String previewImage = null;
    boolean previewImagePending = false;

    public synchronized void previewImage(String fileName) {
	if (!previewImagePending) {
	    previewImage = fileName;
	    previewImagePending = true;
	    SwingUtilities.invokeLater(new Runnable() {

		public void run() {
		    previewPanel.setImage(previewImage);
		    previewPanel.repaint();
		    previewImagePending = false;
		}
	    });
	}
    }

    public int getActiveThreads() {
	return this.threadCount;
    }

    public int getImagesAdded() {
	return this.imagesAdded;
    }

    public int getImagesChecked() {
	return this.imagesChecked;
    }

    public int getImagesDownloaded() {
	return imagesDownloaded;
    }

    public void saveSettings() {
	prefs.setProperty("maxThreads", textMaxThreads.getText());
	prefs.setProperty("maxResults", textMaxResults.getText());
	prefs.setProperty("saveToPath", textSaveToPath.getText());
	prefs.setProperty("agentSpoof", textAgentSpoof.getText());

	// SIZE
	if (this.radioSizeAny.isSelected()) {
	    this.selectedSize = radioSizeAny.getText();
	}
	if (this.radioSizeSmall.isSelected()) {
	    this.selectedSize = radioSizeSmall.getText();
	}
	if (this.radioSizeMedium.isSelected()) {
	    this.selectedSize = radioSizeMedium.getText();
	}
	if (this.radioSizeLarge.isSelected()) {
	    this.selectedSize = radioSizeLarge.getText();
	}

	// TYPE
	if (this.radioTypeAny.isSelected()) {
	    this.selectedType = radioTypeAny.getText();
	}
	if (this.radioTypeClip.isSelected()) {
	    this.selectedType = radioTypeClip.getText();
	}
	if (this.radioTypeFaces.isSelected()) {
	    this.selectedType = radioTypeFaces.getText();
	}
	if (this.radioTypeLine.isSelected()) {
	    this.selectedType = radioTypeLine.getText();
	}
	if (this.radioTypeNews.isSelected()) {
	    this.selectedType = radioTypeNews.getText();
	}
	if (this.radioTypePhotos.isSelected()) {
	    this.selectedType = radioTypePhotos.getText();
	}

	// SAFE MODE
	if (this.radioSafeModerate.isSelected()) {
	    this.selectedSafe = radioSafeModerate.getText();
	}
	if (this.radioSafeOff.isSelected()) {
	    this.selectedSafe = radioSafeOff.getText();
	}
	if (this.radioSafeStrict.isSelected()) {
	    this.selectedSafe = radioSafeStrict.getText();
	}

	// LICENSE
	this.selectedLicense = (String) this.comboLicense.getSelectedItem();

	prefs.setProperty("selectedSize", selectedSize);
	prefs.setProperty("selectedType", selectedType);
	prefs.setProperty("selectedLicense", selectedLicense);
	prefs.setProperty("selectedSafe", selectedSafe);

	prefs.save();
    }

    public void setSelectedSize() {
	if (selectedSize == null) {
	    selectedSize = "";
	}
	if (selectedSize.equalsIgnoreCase("any")) {
	    radioSizeAny.setSelected(true);
	} else if (selectedSize.equalsIgnoreCase("small")) {
	    radioSizeSmall.setSelected(true);
	} else if (selectedSize.equalsIgnoreCase("medium")) {
	    radioSizeMedium.setSelected(true);
	} else if (selectedSize.equalsIgnoreCase("large")) {
	    radioSizeLarge.setSelected(true);
	}
    }

    public void setSelectedType() {
	if (radioTypeAny.getText().equalsIgnoreCase(getSelectedType())) {
	    radioTypeAny.setSelected(true);
	}
	if (radioTypeNews.getText().equalsIgnoreCase(getSelectedType())) {
	    radioTypeNews.setSelected(true);
	}
	if (radioTypeFaces.getText().equalsIgnoreCase(getSelectedType())) {
	    radioTypeFaces.setSelected(true);
	}
	if (radioTypePhotos.getText().equalsIgnoreCase(getSelectedType())) {
	    radioTypePhotos.setSelected(true);
	}
	if (radioTypeLine.getText().equalsIgnoreCase(getSelectedType())) {
	    radioTypeLine.setSelected(true);
	}
	if (radioTypeClip.getText().equalsIgnoreCase(getSelectedType())) {
	    radioTypeClip.setSelected(true);
	}
    }

    public void setSelectedSafe() {
	if (this.radioSafeOff.getText().equalsIgnoreCase(getSelectedSafe())) {
	    radioSafeOff.setSelected(true);
	}
	if (radioSafeModerate.getText().equalsIgnoreCase(getSelectedSafe())) {
	    radioSafeModerate.setSelected(true);
	}
	if (radioSafeStrict.getText().equalsIgnoreCase(getSelectedSafe())) {
	    radioSafeStrict.setSelected(true);
	}
    }

    public void updateUI() {
	SwingUtilities.invokeLater(new Runnable() {

	    public void run() {
		if (progressBar != null) {
		    progressBar.setMaximum(imagesToCheck);
		    progressBar.setValue(getImagesDownloaded());
		}
		labelActiveValue.setText(new Integer(getActiveThreads()).toString());
		labelPendingValue.setText(new Integer(getImagesAdded() - getImagesChecked()).toString());
		labelCheckedValue.setText(new Integer(getImagesChecked()).toString());
		labelDownloadedValue.setText(new Integer(getImagesDownloaded()).toString());

		if (getActiveThreads() <= 0) {
		    textSaveToPath.setEnabled(true);
		    textSearchString.setEnabled(true);
		    textMaxResults.setEnabled(true);
		    textMaxThreads.setEnabled(true);
		    progressBar.setMaximum(0);
		    progressBar.setValue(0);
		    buttonSearch.setText("Run");
		    imagesAdded = 0;
		    imagesChecked = 0;
		    imageNameCounter = 0;
		    imagesDownloaded = 0;
		    imagesToCheck = 0;
		    running = false;
		}
	    }
	});
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {

	    public void run() {
		new App().setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSafe;
    private javax.swing.ButtonGroup buttonGroupSize;
    private javax.swing.ButtonGroup buttonGroupType;
    private javax.swing.JButton buttonSaveToPath;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox comboLicense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelActive;
    private javax.swing.JLabel labelActiveValue;
    private javax.swing.JLabel labelAgentSpoof;
    private javax.swing.JLabel labelChecked;
    private javax.swing.JLabel labelCheckedValue;
    private javax.swing.JLabel labelDownloaded;
    private javax.swing.JLabel labelDownloadedValue;
    private javax.swing.JLabel labelLicense;
    private javax.swing.JLabel labelMaxResults;
    private javax.swing.JLabel labelMaxThreads;
    private javax.swing.JLabel labelPending;
    private javax.swing.JLabel labelPendingValue;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JLabel labelSaveToPath;
    private javax.swing.JLabel labelSearchString;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelType;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JPanel optionsPanel;
    private com.approachingpi.picturepump.PreviewPanel previewPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JRadioButton radioSafeModerate;
    private javax.swing.JRadioButton radioSafeOff;
    private javax.swing.JRadioButton radioSafeStrict;
    private javax.swing.JRadioButton radioSizeAny;
    private javax.swing.JRadioButton radioSizeLarge;
    private javax.swing.JRadioButton radioSizeMedium;
    private javax.swing.JRadioButton radioSizeSmall;
    private javax.swing.JRadioButton radioTypeAny;
    private javax.swing.JRadioButton radioTypeClip;
    private javax.swing.JRadioButton radioTypeFaces;
    private javax.swing.JRadioButton radioTypeLine;
    private javax.swing.JRadioButton radioTypeNews;
    private javax.swing.JRadioButton radioTypePhotos;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField textAgentSpoof;
    private javax.swing.JTextField textMaxResults;
    private javax.swing.JTextField textMaxThreads;
    private javax.swing.JTextField textSaveToPath;
    private javax.swing.JTextField textSearchString;
    // End of variables declaration//GEN-END:variables
}