package proj5sp18;

/**
 * <p>Title: SFacebook Class</p>
 *
 * <p>Description: This class utilizes an array that can contain a friend object
 * as a member of facebook. There are accessor methods to get the friendship status
 * of two members of facebook, to get the friend list of a member of facebook, and
 * to get the friend list of a member of facebook according to their security level.
 * There are methods to add a member to facebook, make two(2) members of facebook 
 * friends, unfriend two members of facebook from each other, to find a member
 * in facebook, and lastly to display the status of facebook itself. </p>
 * 
 * @author Alen Holsey
 */
public class SFacebook //extends Friend
{
	//instance variables
	private Friend[] theMembers;
	private int count;

	/**
	 * default constructor
	 * --
	 * Initializes the array to an initial size of 
	 * ten(10) and count as zero(0)
	 */
	public SFacebook()
	{
		theMembers = new Friend[20];
		count = 0;
	}

	/**
	 * addtoFacebook method
	 * --
	 * Adds a friend that was created to facebook
	 * @param name for the name of the friend
	 * @param sLev for the security level of the friend
	 */
	public void addToFacebook(String name, int sLev)
	{
		if (count < theMembers.length)
		{
			theMembers[count] = new Friend(name, sLev);
			count++;
		}
	}

	/**
	 * makeFriends method
	 * --
	 * Adds two separate members of facebook to each
	 * other's friend list
	 * @param name for the name of a friend
	 * @param otherName for the name of the other friend
	 * @throws FriendNotFoundException if the friend is not found
	 */
	public void makeFriends(String name, String otherName) throws FriendNotFoundException
	{
		if (name.equals(otherName))
		{
			System.out.println("Command F: You cannot add a member to their own friend list\n");
		}

		else
		{
			findFriend(name).addFriend(findFriend(otherName));
			findFriend(otherName).addFriend(findFriend(name));
		}
	}

	/**
	 * breakFriendship method
	 * --
	 * Removes two separate members of facebook from
	 * each other's friend list
	 * @param name for the name of a friend
	 * @param otherName for the name of the other friend
	 * @throws FriendNotFoundException if the friend is not found
	 */
	public void breakFriendship(String name, String otherName) throws FriendNotFoundException
	{
		if (name.equals(otherName))
		{
			System.out.println("Command U: You cannot not unfriend a member from themselves\n");
		}
		
		else
		{
			findFriend(name).unfriend(findFriend(otherName));
			findFriend(otherName).unfriend(findFriend(name));
		}
	}

	/**
	 * getFriends method
	 * --
	 * Retrieves the friend list of a specified friend within
	 * facebook
	 * @param name for the name of the friend
	 * @return the friend list of the friend
	 * @throws FriendNotFoundException if the friend is not found
	 */
	public String getFriends(String name) throws FriendNotFoundException
	{
		if (findFriend(name).getFriends() == null)
		{
			return name + " does not have any friends :-(";
		}
		
		else
		{
			return findFriend(name).getFriends();
		}
	}

	/**
	 * getFriendsByLevel method
	 * --
	 * Retrieves the friends inside a friend's friend list and
	 * depending on their security level, the friend list of their
	 * friends as well
	 * @param name for the name of the friend
	 * @return the friend's friend list
	 * @throws FriendNotFoundException if the friend is not found 
	 */
	public String getFriendsByLevel(String name) throws FriendNotFoundException
	{
		return findFriend(name).getFriendsByLevel();
	}

	/**
	 * getFriendStatus method
	 * --
	 * Checks if two friends are friends with each other
	 * @param name for the name of a friend
	 * @param otherName for the name of the other friend
	 * @return true if the friend is found, otherwise false
	 * @throws FriendNotFoundException if the friend is not found
	 */
	public boolean getFriendStatus(String name, String otherName) throws FriendNotFoundException
	{
		return findFriend(name).friendsWith(findFriend(otherName));
	}

	/**
	 * findFriend method
	 * --
	 * Searches through facebook for the specified friend 
	 * sent through as an argument to the method
	 * @return the friend that was being looked for
	 * @throws FriendNotFoundException if the friend is not found
	 */
	public Friend findFriend(String target) throws FriendNotFoundException
	{
		for (int i = 0; i < count; i++)
		{
			if (target.equals(theMembers[i].getName()))
			{
				return theMembers[i];
			}
		}

		throw new FriendNotFoundException("member: " + target);
	}

	/**
	 * toString method
	 * --
	 * Displays the state of facebook
	 * @returns a reference to a String that displays the 
	 * members in facebook
	 */
	public String toString()
	{
		String str = new String();

		for (int i = 0; i < count; i++)
		{
			str += theMembers[i] + "\n";
		}

		return str;
	}

}
