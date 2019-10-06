package proj5sp18;

/**
 * <p>Title: FriendList Class</p>
 *
 * <p>Description: This class utilizes a linked list to store references to friend 
 * objects to create a friend list. There are methods to add to the front of the
 * friend list, remove from the friend list, search the friend list, check if it is
 * empty, to get the size of the friend list, and lastly to display the state of the
 * friend list. </p>
 * 
 * @author Alen Holsey
 */
public class FriendList
{
	//instance variables
	private Node<Friend> currentPos;
	private Node<Friend> first;
	private int count;

	/**
	 * default constructor
	 * --
	 * Initializes the linked list to an initial
	 * node of null and count to zero(0)
	 */
	public FriendList()
	{
		first = new Node<Friend>();
		count = 0;
	}

	/**
	 * size method
	 * --
	 * Returns the size of the linked list
	 * @return instance variable count
	 */
	public int size()
	{
		return count;
	}

	/**
	 * isEmpty method
	 * --
	 * If count equals zero(0), returns true, otherwise
	 * return false
	 * @return true or false if count equals zero(0)
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}

	/**
	 * addToFront method
	 * --
	 * Adds a specified friend to the beginning
	 * of a friend's friend list
	 * @param chosen for the friend to be added to the list
	 */
	public void addToFront(Friend chosen)
	{	
		Node<Friend> add = new Node<Friend>(chosen);

		if (count == 0)
		{
			first.setNext(add);
			count++;
		}

		else
		{
			Node<Friend> temp = first.getNext();
			add.setNext(temp);
			first.setNext(add);
			count++;
		}
	}

	/**
	 * remove method
	 * --
	 * Removes the specified friend sent through as an argument
	 * from a friend's friend list
	 * @param target for the friend to be removed
	 * @return the friend that was removed
	 * @throws FriendNotFoundException if friend is not found
	 */
	public Friend remove(Friend target) throws FriendNotFoundException
	{
		Node<Friend> current = first.getNext();
		Node<Friend> prev = first;

		while (current != null)
		{
			if (target.equals((Friend)current.getItem()))
			{
				prev.setNext(current.getNext());
				count--;
				return current.getItem();
			}

			else
			{
				prev = current;
				current = current.getNext();
			}
		}

		throw new FriendNotFoundException("friend: " + target.getName());
	}

	/**
	 * resetList method
	 * --
	 * Resets the instance variable currentPos to refer
	 * to the beginning of the friendList array
	 */
	public void resetList()
	{
		currentPos = first;
	}

	/**
	 * getNextFriend method
	 * --
	 * Retrieves the next friend in the friendList array
	 * @return the friend that is being retrieved
	 */
	public Friend getNextFriend()
	{
		currentPos = currentPos.getNext();
		return currentPos.getItem();
	}

	/**
	 * search method
	 * --
	 * Searches through the friend list to find the specified
	 * friend pass through as an argument
	 * @param target for the friend to searched
	 * @return true if the friend was found, otherwise false
	 */
	public boolean search(Friend target)
	{
		Node<Friend> current = first.getNext();
		//boolean found = false;

		while (current != null)
		{
			if (target.equals((Friend)current.getItem()))
			{
				return true;
			}

			else
			{
				current = current.getNext();
			}
		}

		return false;
	}

	/**
	 * listOfFriends method
	 * --
	 * Displays the state of a friend's friend list
	 * @return the state of the friend list
	 */
	public String listOfFriends()
	{	
		String str = new String();

		Node<Friend> current = first.getNext(); 

		while (current != null)
		{
			str += current.getItem().getName() + " ";
			current = current.getNext();
		}

		return str;
	}
}
