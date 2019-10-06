package proj5sp18;
import java.io.File;
import java.util.Scanner;

/**
 * <p>Title: The Project 5 Application Class</p>
 *
 * <p>Description: This application class reads from a text file containing commands to
 * be performed; create a new facebook member, make two members friends, unfriend two
 * members, get the friend list of a member, or check to see if two members are friends. 
 * All the commands are processed through the SFacebook object created to act as the
 * actual functions of Facebook. </p>
 * 
 * @author Alen Holsey
 */
public class Proj5App
{
	public static void main (String[] args) throws Exception
	{
		/*//TESTING
		SFacebook myBook = new SFacebook();

		myBook.addToFacebook("Sue", 1);
		myBook.addToFacebook("John", 0);
		myBook.addToFacebook("Ellen", 0);
		myBook.addToFacebook("Mike", 0);

		System.out.println(myBook);

		//calling getFriends on a members of facebook
		System.out.println("The friend list of Sue:\n" + myBook.getFriends("Sue") + "\n");
		System.out.println("The friend list of John:\n" + myBook.getFriends("John") + "\n");
		System.out.println("The friend list of Ellen:\n" + myBook.getFriends("Ellen") + "\n");
		System.out.println("The friend list of Mike:\n" + myBook.getFriends("Mike") + "\n");

		//calling getFriends on a nonmemeber of facebook
		try
		{
			System.out.println(myBook.getFriends("Mary"));
		}
		catch (FriendNotFoundException ex)
		{
			System.out.println("The friend list of Mary:\n" + ex.getMessage());
		}

		//making Sue and John friends
		myBook.makeFriends("Sue", "John");
		System.out.println("\n" + myBook.getFriends("Sue") + "\n");
		System.out.println(myBook.getFriends("John") + "\n");

		//making Ellen and Mike friends
		myBook.makeFriends("Ellen", "Mike");
		System.out.println(myBook.getFriends("Ellen") + "\n");
		System.out.println(myBook.getFriends("Mike") + "\n");

		//making Ellen and Sue friends
		myBook.makeFriends("Sue", "Ellen");
		System.out.println(myBook.getFriends("Sue") + "\n");
		System.out.println(myBook.getFriends("Ellen") + "\n");

		//making Sue friends with a nonmember of facebook
		try
		{
			myBook.makeFriends("Sue", "Jake");
		}

		catch (FriendNotFoundException ex)
		{
			System.out.println("Attempting to make Sue and Jake friends:\n" + ex.getMessage());
		}

		//unfriending Sue and Ellen
		myBook.breakFriendship("Sue", "Ellen");
		System.out.println("\n" + myBook.getFriends("Sue") + "\n");
		System.out.println(myBook.getFriends("Ellen") + "\n");

		//unfriending John and a nonmember of facebook
		try
		{
			myBook.breakFriendship("John", "Lynn");
		}

		catch (FriendNotFoundException ex)
		{
			System.out.println("Attemtping to unfriend John and Lynn:\n" + ex.getMessage() + "\n");
		}

		//checking if Sue and John are friends
		System.out.println("Sue and John are friends:\n" + myBook.getFriendStatus("Sue", "John"));

		//checking if Ellen and Mike are friends
		System.out.println("\nEllen and Mike are friends:\n" + myBook.getFriendStatus("Ellen", "Mike"));

		//checking if Sue and Ellen are friends
		System.out.println("\nSue and Ellen are friends:\n" + myBook.getFriendStatus("Sue", "Ellen"));

		//checking if Mike is friends with a nonmember of facebook
		try
		{
			myBook.getFriendStatus("Mike", "Pat");
		}

		catch (FriendNotFoundException ex)
		{
			System.out.println("\nAttempting to see if Mike and Pat are friends:\n" + ex.getMessage());
		}

		System.out.println("\n" + myBook.getFriendsByLevel("Sue"));
		System.out.println(myBook.getFriendsByLevel("Ellen"));
		 */
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//PROJECT 5 APPLICATION CODE
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//instance variables
		String name;
		String otherName;
		int sLevel;
		String commandToDo[];
		String readLine;
		SFacebook myBook = new SFacebook();

		//declaring/instantiating Scanner object
		Scanner fileScan = new Scanner(new File("fbTextFileProj5.txt"));

		//fileScan.nextLine();

		while (fileScan.hasNextLine())
		{
			//reading each line and splitting the information
			readLine = fileScan.nextLine();
			commandToDo = readLine.split(" ");

			//creating a new member
			if (commandToDo[0].equals("P"))
			{
				name = commandToDo[1];
				sLevel = Integer.parseInt(commandToDo[2]);
				myBook.addToFacebook(name, sLevel);
				System.out.println("Command P: " + name + " " + sLevel + "\n");
			}

			else
				//making two specified members friends
				if (commandToDo[0].equals("F"))
				{
					name = commandToDo[1];
					otherName = commandToDo[2];

					try
					{
						myBook.makeFriends(name, otherName);
						System.out.println("Command F: Making " + name + " and " + otherName + " friends\n");
					}

					catch (FriendNotFoundException ex)
					{
						System.out.println("Command F: " + ex.getMessage() + "\n");
					}
				}

				else
					//unfriending two specified members
					if (commandToDo[0].equals("U"))
					{
						name = commandToDo[1];
						otherName = commandToDo[2];

						try
						{
							myBook.breakFriendship(name, otherName);
							System.out.println("Command U: Unfriending " + name + " and " + otherName + "\n");
						}

						catch (FriendNotFoundException ex)
						{
							System.out.println("Command U: " + ex.getMessage() + "\n");
						}
					}

					else
						//listing the friends of a specified member
						if (commandToDo[0].equals("L"))
						{
							try
							{
								name = commandToDo[1];
								System.out.println("Command L: " + myBook.getFriends(name) + "\n");
							}

							catch (FriendNotFoundException ex)
							{
								System.out.println("Command L: " + ex.getMessage() + "\n");
							}
						}

						else
							//checking if two members are friends
							if (commandToDo[0].equals("Q"))
							{
								name = commandToDo[1];
								otherName = commandToDo[2];
								try
								{
									if (myBook.getFriendStatus(name, otherName) == true)
									{
										System.out.println("Command Q: " + name + " and " + otherName + " are friends!\n");
									}

									else
									{
										System.out.println("Command Q: " + name + " and " + otherName + " are not friends :-(\n");
									}
								}

								catch (FriendNotFoundException ex)
								{
									System.out.println("Command Q: " + ex.getMessage() + "\n");
								}
							}

							else
								//listing the friends of a specified member and perhaps their friends too
								if (commandToDo[0].equals("V"))
								{
									try
									{
										name = commandToDo[1];
										System.out.println("Command V:\n" + myBook.getFriendsByLevel(name) + "\n");
									}

									catch (FriendNotFoundException ex)
									{
										System.out.println("Command V: " + ex.getMessage() + "\n");
									}
								}

								else
									//terminating the program
									if (commandToDo[0].equals("X"))
									{
										System.out.println("Thank you for visiting our Facebook Page! Come back soon :-)");
									}
		}

		//CLosing file
		fileScan.close();

		//displaying final state of facebook
		System.out.println("\n\n\nFinal Facebook Output:\n\n" + myBook.toString());
	}
}
