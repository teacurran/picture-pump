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
 * PreviewPanel.java
 *
 * Created on Apr 5, 2009, 8:35:07 PM
 */
package com.approachingpi.picturepump;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author tea
 */
public class PreviewPanel extends javax.swing.JPanel {

    private BufferedImage image;

    /** Creates new form PreviewPanel */
    public PreviewPanel() {
	initComponents();
    }

    public void setImage(String imageName) {
	try {
	    image = ImageIO.read(new File(imageName));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void paintComponent(Graphics g) {



	g.clearRect(0, 0, super.getWidth(), super.getHeight());
	g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
