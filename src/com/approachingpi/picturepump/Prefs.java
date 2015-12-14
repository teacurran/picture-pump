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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import java.util.Set;
import javax.jnlp.BasicService;
import javax.jnlp.FileContents;
import javax.jnlp.PersistenceService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;

public class Prefs extends Properties {

    public static final int DEFAULT_MAX_THREADS = 50;
    public static final int DEFAULT_MAX_RESULTS = 2000;
    public static final String DEFAULT_SELECTED_SIZE = "any";
    public static final String DEFAULT_AGENT_SPOOF = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.1.4322)";
    public static final String DEFAULT_SELECTED_TYPE = "any";
    public static final String DEFAULT_SELECTED_LICENSE = "any";
    public static final String DEFAULT_SELECTED_SAFE = "off";
    private static final long MUFFIN_SIZE = 2048;
    PersistenceService ps = null;
    BasicService bs = null;
    URL prefsUrl = null;

    public Prefs() {
	try {
	    ps = (PersistenceService) ServiceManager.lookup("javax.jnlp.PersistenceService");
	    bs = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
	} catch (UnavailableServiceException e) {
	    e.printStackTrace();
	}
	try {
	    prefsUrl = new URL(bs.getCodeBase(), "prefs");
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	}
    }

    public void load() {
	try {
	    FileContents contents = getOrCreateStorage(ps, prefsUrl);
	    if (contents == null) {
		return;
	    }

	    InputStream in = contents.getInputStream();
	    this.load(in);
	    in.close();
	} catch (IOException iox) {
	    // do nothing
	}

    }

    private FileContents getOrCreateStorage(final PersistenceService ps, final URL address) throws IOException {
	FileContents toRet = null;
	try {
	    toRet = ps.get(address);

	    InputStream in = toRet.getInputStream();
	    in.close();
	} catch (FileNotFoundException fnf) {
	    long size = ps.create(address, MUFFIN_SIZE);
	    toRet = ps.get(address);
	}

	return toRet;
    }

    public void save() {
	try {
	    FileContents contents = getOrCreateStorage(ps, prefsUrl);
	    if (contents == null) {
		return;
	    }

	    PrintStream out = new PrintStream(contents.getOutputStream(true));
	    Set<Object> keys = this.keySet();
	    for (Object key : keys) {
		String keyString = (String) key;
		out.println(keyString + "=" + getProperty(keyString));
	    }
	    out.close();
	} catch (IOException iox) {
	    iox.printStackTrace();
	}

    }

    public void setPropertyInt(String key, String value, int defaultValue) {
	try {
	    Integer.parseInt(value);
	} catch (Exception e) {
	    value = new Integer(defaultValue).toString();
	}
	setProperty(key, value);
    }

    public String getProperty(String property) {
	if (!containsKey(property)) {
	    return "";
	}
	return super.getProperty(property);
    }

    public String getPropertyWithDefaultBlank(String property, String defaultValue) {
	if (!containsKey(property)) {
	    return defaultValue;
	}
	if (super.getProperty(property).equals("")) {
	    return defaultValue;
	}
	return super.getProperty(property);
    }

    public int getPropertyInt(String property) {
	return getPropertyInt(property, 0);
    }

    public int getPropertyInt(String property, int defaultValue) {
	int retval = defaultValue;
	try {
	    retval = Integer.parseInt(super.getProperty(property));
	} catch (Exception e) {
	    retval = defaultValue;
	}
	return retval;
    }
}
