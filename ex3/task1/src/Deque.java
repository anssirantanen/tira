/*
Tietorakenteet - kaksiloppuinen jono

Data structures - double ended queue
*/

import java.util.Date;

class Deque
{
	/*
	 boolean IsEmpty ()
	 palauttaa true, jos jono on tyhjä?, muutoin false.

	 returns true, if queue is empty, false otherwise 
	*/
	public boolean IsEmpty ()
	{
		return head == null;
	}

	/*
	void insertFirst (Object o)
	laittaa olion o jonon ensimm?iseksi

	inserts object o to the front of the queue
	*/
	public void insertFirst (Object o)
	{
		DoubleLinkNode n = new DoubleLinkNode (o);
		if (IsEmpty ())
			head = tail = n;
		else
		{
			n.next = head;
			head.prev = n;
			head = n;
		}
	}

	/*
	Object removeFirst ()
	palauttaa jonon ensimm?isen alkion
	palauttaa null, jos jono on tyhj?, parempi olisi k?sitell? virhe
	poikkeuksella, mutta j?tet??n se tekem?tt? yksinkertaisuuden vuoksi

	Removes and returns the first object in the queue, null if queue is empty
	*/
	public Object removeFirst ()
	{
		Object result = null;
		if (! IsEmpty ())
		{
			result = head.data;
			head = head.next;
			if (head != null) 
				// linkki edelliseen irti, ettei j?? muistiin roikkumaan
				head.prev = null; 
			else
				// tail irti, ettei j?? viimeinen alkio roikkumaan
				tail = null;
		}
		return result;
	}

	/* 
	void insertLast (Object o)
	laittaa olion o jonon viimeiseksi

	inserts object o to the back of the queue
	*/

	public void insertLast (Object o)
	{
		var node = new DoubleLinkNode(o);
		if(tail == null){
			tail = head =node;
		}else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}

	/* 
	Object removeLast () poistaa jonon viimeisen alkion.
	Jos jono on tyhj?, palautetaan null.
	
	Removes and returns the last object in the queue, null if queue is empty
	*/

	public Object removeLast ()	{
		if (tail == null){
			return null;
		}
		var data = tail.data;
		tail = tail.prev;
		if(tail == null){
			head = null;
		}else{
			tail.next = null;
		}
		return data;
	}


	/* 
	void Reverse ()
	K??nt?? jonon alkiot p?invastaiseen j?rjestykseen

	reverses the order of the objects in the queue
	*/
	
	public void Reverse () {
		var current = head;
		head = tail;
		tail = current;
		while (current != null){
			var next = current.next;
			current.next = current.prev;
			current.prev = next;
			current = next;
		}


	}

	private DoubleLinkNode head;
	private DoubleLinkNode tail;
}
