package proj5sp18;
/**
 * <p>Title: FriendNotFoundException Class</p>
 *
 * <p>Description: Exception Class for use by Project 5 Spring 2018</p>
 */

@SuppressWarnings("serial")
public class FriendNotFoundException extends RuntimeException
{
	/**
     * Initializes a FriendNotFoundException storing an appropriate message.
	 */
	public FriendNotFoundException()
	{
		super("The friend is not in the list");
	}

	/**
     * Initializes an EmptyCollectionException storing the type of the
     * collection (as specified by the user) along with an appropriate message.
	 */
	public FriendNotFoundException(String collection)
	{
		super("The friend is not a " + collection);
	}
}
