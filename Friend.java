package proj5sp18;

/**
 * <p>Title: Friend Class</p>
 *
 * <p>Description: This class utilizes a name, a security level, and a friend list
 * to create a facebook friend. There are accessor methods to get the name of a friend,
 * get the friend list of a friend, and to get the friend list of a friend 
 * according to their security level. There is a method to see if two members are
 * eqal to each other by comparing names. There is a method to add a friend to
 * a friend's friend list, a method to unfriend a friend from a friend's friend
 * list, and a method to check if two friends and friends with each other. </p>
 * 
 * @author Alen Holsey
 */
public class Friend 
{
	//instance variables
	private String name;
	private int securityLevel;
	private FriendList friends;
	
	/**
	 * parameterized constructor
	 * --
	 * Creates a new friend object with the arguments passed
	 * through the method
	 * @param nm for the name of the friend to be created
	 * @param sLev for the security level of the friend
	 */
	public Friend(String nm, int sLev)
	{
		name = nm;
		securityLevel = sLev;
		friends = new FriendList();
	}
	
	/**
	 * getName method
	 * --
	 * Accessor method to retrieve the name of the friend
	 * @return the name of the friend
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * addFriend method
	 * --
	 * Adds a specified friend to another friend's friend list
	 * @param chosen for the friend to be added to the friend list
	 */
	public void addFriend(Friend chosen)
	{
		friends.addToFront(chosen);
	}
	
	/**
	 * unfriend method
	 * --
	 * Unfriends a specified friend from a friend's friend list
	 * @param target for the friend to be removed
	 * @throws FriendNotFfoundException if friend is not found
	 */
	public void unfriend(Friend target) throws FriendNotFoundException
	{
		friends.remove(target);
	}
	
	/**
	 * friendsWith method 
	 * --
	 * Checks if a specified friend is in the friend's list of 
	 * the friend he method was called on
	 * @param target for the friend to be searched for
	 * @return true if the friend was found, otherwise false
	 */
	public boolean friendsWith(Friend target)
	{
		return friends.search(target);
	}
	
	/**
	 * getFriends method
	 * --
	 * Returns the friend list of the friend the method was
	 * called on
	 * @return the friend list of a friend
	 */
	public String getFriends()
	{
		if (friends.isEmpty())
		{
			return null;
		}
		
		return getName() + " is friends with: " + friends.listOfFriends();
	}
	
	/**
	 * getFriendsByLevel method
	 * --
	 * Retrieves the friends inside a friend's friend list and
	 * depending on their security level, the friend list of their
	 * friends as well
	 * @return the friend's friend list
	 */
	public String getFriendsByLevel()
	{
		String str = new String();
		
		if (securityLevel == 1)
		{
			str = getName() + " is friends with: " + friends.listOfFriends() + "\n";
			
			friends.resetList();
			 
			for (int i = 0; i < friends.size(); i++)
			{
				str += friends.getNextFriend().getFriends() + "\n";
			}
			
			return str;
		}
		
		else
		{
			return getName() + " is friends with: " + friends.listOfFriends();
		}
	}
	
	/**
	 * equals method 
	 * --
	 * Determines if two friends are equal by names
	 * @param otherFriend for the friend to be compared
	 * @return true if the same, otherwise false
	 */
	public boolean equals(Friend otherFriend)
	{
		return (name.equals(otherFriend.getName()));
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		return name + " is friends with: " + friends.listOfFriends();
	}

}
