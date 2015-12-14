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

package com.approachingpi.picturepump;

import java.net.URLEncoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Created by IntelliJ IDEA.
 * User: terrence
 * Date: Aug 19, 2004
 * Time: 8:57:52 PM
 * To change this template use Options | File Templates.
 */
public class Runner extends Thread {

    App app;
    CircularList imageGrabbers = new CircularList();
    ArrayList<ImageGrabber> grabbersArray = new ArrayList<ImageGrabber>();
    ArrayList pages = new ArrayList();
    String searchString;
    int start;
    int imagesFound = 0;
    int index = -1;
    int grabberIndex = 0;
    boolean stopRunning = false;
    HttpClient httpClient;

    public Runner(App in, String searchString, int start) {
	app = in;
	SearchPage newPage = new SearchPage();
	newPage.url = searchString;
	newPage.start = start;
	pages.add(newPage);

	httpClient = new HttpClient();



    }

    public void run() {

	while (getNextPage()) {
	}
	//app.imagesToCheck = imagesFound;
	startGrabbers(false);
	//app.stopRunning();
    }

    public void addPage(SearchPage in) {
	pages.add(in);
    }

    // TODO figure out how to make sure this never infinate loops.
    // this thole method if pretty fucked right now
    protected synchronized void startGrabbers(boolean stopWhenFull) {

	while (grabberIndex < grabbersArray.size()) {
	    if (stopRunning) {
		return;
	    }
	    while (app.getMaxThreads() > app.getActiveThreads() && grabberIndex < grabbersArray.size()) {
		if (stopRunning) {
		    return;
		}
		for (int i = grabberIndex; i < grabbersArray.size(); i++) {
		    if (stopRunning) {
			return;
		    }
		    ImageGrabber grabber = (ImageGrabber) grabbersArray.get(i);
		    if (!grabber.isAlive()) {
			try {
			    grabber.start();
			    grabberIndex++;
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }
		}
	    }
	    if (stopWhenFull) {
		return;
	    }
	    try {
		System.out.println("Runner sleeping for 100");
		Thread.sleep(100);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	/*
	ImageGrabber first = null;


	if (grabberIndex==grabbersArray.size()-1) {
	return false;
	}
	if (app.getMaxThreads() > app.getActiveThreads()) {

	while(grabberIndex<grabbersArray.size()) {

	System.out.println("Max/Active:" + app.getMaxThreads() + "/" + app.getActiveThreads());
	//ImageGrabber grabber = (ImageGrabber)imageGrabbers.getNext();
	ImageGrabber grabber = (ImageGrabber)grabbersArray.get(grabberIndex);
	if (grabber==null) {
	return false;
	}
	if (first == null) {
	first = grabber;
	// if we have gone through the list one complete time, exit.
	} else if (first==grabber) {
	return true;
	}
	if (app.getMaxThreads() > app.getActiveThreads()) {
	if (!grabber.isAlive()) {
	app.incrementThreadCount();
	grabber.start();
	}
	} else {
	return true;
	}
	grabberIndex++;
	}
	 */
	//return false;
    }

    public void finishRunning() {
	stopRunning = true;
	for (int i = 0; i < grabberIndex; i++) {
	    ImageGrabber grabber = (ImageGrabber) grabbersArray.get(i);
	    if (grabber.isAlive()) {
		grabber.abort();
	    }
	}
    }

    private synchronized boolean getNextPage() {
	index++;
	System.out.println("ADDING PAGE: " + index);
	if (pages.size() == 0) {
	    return false;
	}

	SearchPage page = (SearchPage) pages.get(0);
	String searchString = page.url;
	int start = page.start;
	pages.remove(page);

	String saveToPath = app.getSaveToPath();

	try {
	    String googleUrl = "http://images.google.com/images?hl=en&btnG=Search+Images&q=" + URLEncoder.encode(searchString, "UTF-8") + "&start=" + start;

	    googleUrl = googleUrl + "&imgsz=" + URLEncoder.encode(app.getSelectedSizeGoogle(), "UTF-8");
	    googleUrl = googleUrl + "&imgtype=" + URLEncoder.encode(app.getSelectedTypeGoogle(), "UTF-8");
	    googleUrl = googleUrl + "&as_rights=" + URLEncoder.encode(app.getSelectedLicenseGoogle(), "UTF-8");
	    googleUrl = googleUrl + "&safe=" + URLEncoder.encode(app.getSelectedSafeGoogle(), "UTF-8");

	    GetMethod get = new GetMethod(googleUrl);

	    get.setRequestHeader("User-Agent", app.prefs.getPropertyWithDefaultBlank("agentSpoof", Prefs.DEFAULT_AGENT_SPOOF));


	    System.out.println("Google URL: " + googleUrl);

	    //get.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2965);
	    //get.getsetCookiePolicy(CookiePolicy.RFC_2109);

	    //CookieSpecRegistry csr = BrowserCompatSpecFactory.newInstance();

	    //httpClient.setCookieSpecs(cookieSpecRegistry);


	    int responseCode = httpClient.executeMethod(get);

	    String resultsPage = get.getResponseBodyAsString();

	    //System.out.println(resultsPage);

	    Pattern pattern = Pattern.compile("imgurl\\\\x3d(.*?)\\\\x26");
	    Matcher matcher = pattern.matcher(resultsPage);
	    int counter = 0;
	    while (matcher.find()) {
		counter++;
		this.imagesFound++;
		app.incrementImagesAdded();

		ImageGrabber ig = new ImageGrabber();
		ig.setApplication(app);
		ig.setSaveToPath(saveToPath);
		ig.setImageName(matcher.group(1));
		//imageGrabbers.insert(ig);
		grabbersArray.add(ig);

		//startGrabbers();
		System.out.println("adding " + matcher.group(1) + " to queue");
		this.startGrabbers(true);
	    }

	    if (app.getImagesChecked() < app.getMaxImageChecks()) {
		if (resultsPage.indexOf("<span>Next</span>") > 0) {
		    SearchPage newPage = new SearchPage();
		    newPage.url = searchString;
		    newPage.start = start + 20;
		    pages.add(newPage);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return true;
    }
}
