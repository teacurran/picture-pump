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
 * Approaching Pi, Inc.
 * User: Tea Curran
 * Date: Mar 25, 2004
 * Time: 12:35:33 PM
 */
package com.approachingpi.picturepump;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

public class ImageGrabber extends Thread {

    App app = null;
    String imageName = "";
    String saveToPath = "";
    HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
    GetMethod get;
    boolean aborted = false;
    File fileToWrite = null;

    private void getImage(String imageName) {
	if (app.getImagesDownloaded() >= app.getMaxResults()) {
	    return;
	}
	try {
	    if (aborted) {
		return;
	    }

	    httpClient.getParams().setConnectionManagerTimeout(10000);
	    get = new GetMethod(imageName);

	    // set a faux User-agent
	    get.setRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.1.4322)");

	    int responseCode = httpClient.executeMethod(get);

	    if (responseCode == 200) {
		String fileName = saveToPath + File.separator + app.getNamePrefix() + "_" + app.getPaddedImageNumber() + imageName.substring(imageName.length() - 4).toLowerCase();
		String fileNamePart = saveToPath + File.separator + "_part_" + app.getNamePrefix() + "_" + app.getPaddedImageNumber() + imageName.substring(imageName.length() - 4).toLowerCase();
		fileToWrite = new File(fileNamePart);
		FileOutputStream fileWriteStream = new FileOutputStream(fileToWrite);

		fileWriteStream.write(get.getResponseBody());

		/*
		InputStream responseStream = get.getResponseBodyAsStream();

		DataInputStream dis = new DataInputStream(responseStream);

		//app.copyStream(responseStream, fileWriteStream);

		int len = 0;
		byte[] readBuffer = new byte[1024];

		synchronized (dis) {
		synchronized (fileWriteStream) {
		while ((len = responseStream.read(readBuffer)) >= 0) {
		fileWriteStream.write(readBuffer, 0, len);
		fileWriteStream.flush();
		//app.writeStream(fileWriteStream, readBuffer, len);
		}
		}
		}
		 */

		fileWriteStream.close();
		get.releaseConnection();
		fileToWrite.renameTo(new File(fileName));
		app.previewImage(fileName);

		app.incrementImagesDownloaded();

	    }



	    /* Removing 4.0 because it isn't thread safe
	    DefaultHttpClient httpClient = new DefaultHttpClient();

	    HttpGet get = new HttpGet(imageName);

	    get.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.1.4322)");

	    get.getParams().setLongParameter(ConnManagerPNames.TIMEOUT, 60000);

	    HttpResponse response = httpClient.execute(get);

	    int responseCode = response.getStatusLine().getStatusCode();

	    if (responseCode == 200) {
	    File fileToWrite = new File(saveToPath + File.separator + app.getNamePrefix() + "_" + app.getPaddedImageNumber() + imageName.substring(imageName.length() - 4).toLowerCase());

	    FileOutputStream fileWriteStream = new FileOutputStream(fileToWrite);
	    HttpEntity entity = response.getEntity();
	    //InputStream responseStream = entity.getContent();
	    entity.writeTo(fileWriteStream);

	    entity.consumeContent();

	    //responseStream.close();
	    fileWriteStream.close();
	    }
	     */

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    app.incrementImagesChecked();
	    // on abort, temp file will still be there, delete it
	    if (fileToWrite != null) {
		if (fileToWrite.exists()) {
		    fileToWrite.delete();
		}
	    }
	}
    }

    public String getImageName() {
	return this.imageName;
    }

    public void run() {
	app.incrementThreadCount();
	app.updateUI();
	getImage(getImageName());
	app.decrementThreadCount();
	//app.runner.imageGrabbers.delete(this);
	app.updateUI();
	//app.runner.startGrabbers();
    }

    public void abort() {
	aborted = true;
	if (get != null) {
	    get.abort();
	}
	if (fileToWrite != null && fileToWrite.exists()) {
	    fileToWrite.delete();
	}
    }

    public void setApplication(App in) {
	this.app = in;
    }

    public void setImageName(String in) {
	this.imageName = in;
    }

    public void setSaveToPath(String in) {
	this.saveToPath = in;
    }
}
