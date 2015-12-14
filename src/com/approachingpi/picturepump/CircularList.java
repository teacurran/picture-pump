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

/**
 * Created by IntelliJ IDEA.
 * User: terrence
 * Date: Aug 19, 2004
 * Time: 11:55:34 PM
 * To change this template use Options | File Templates.
 */
public class CircularList {

    private CircularListNode current;

    public synchronized void insert(Object o) {
	CircularListNode tn = new CircularListNode();
	tn.o = o;
	if (current == null) {
	    tn.next = tn.previous = tn;
	    current = tn;
	} else {
	    tn.next = current;
	    tn.previous = current.previous;
	    tn.previous.next = tn;
	    current.previous = tn;
	}
    }

    public synchronized void delete(Object o) {
	CircularListNode p = find(o);
	CircularListNode next = p.next;
	CircularListNode previous = p.previous;
	// if we have the last node
	if (p == p.next) {
	    current = null;
	    return;
	}
	previous.next = next;
	next.previous = previous;
	if (current == p) {
	    current = next;
	}
    }

    public CircularListNode find(Object o) {
	CircularListNode p = current;
	if (p == null) {
	    throw new IllegalArgumentException();
	}
	do {
	    if (p.o == o) {
		return p;
	    }
	    p = p.next;
	} while (p != current);

	throw new IllegalArgumentException();
    }

    public synchronized Object locate(Object o) {
	CircularListNode p = current;

	do {
	    if (p.o.equals(o)) {
		return p.o;
	    }
	    p = p.next;
	} while (p != current);
	throw new IllegalArgumentException();
    }

    public synchronized Object getNext() {
	if (current == null) {
	    return null;
	}
	current = current.next;
	return current.o;
    }
}
