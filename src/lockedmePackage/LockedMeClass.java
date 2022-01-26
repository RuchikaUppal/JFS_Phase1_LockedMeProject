package lockedmePackage;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeClass {
	
	public static final String folderPath="C:\\JavaFullStack\\ProjectPhase1\\LockedMeFiles";
	public static final String errorMessage="Some error occured. Please contact admin@lockecme.com";
	
	// This method checks for the existence and case sensitivity of the file
	public static boolean exists(File dir, String filename)
	{
	    String[] files = dir.list();
	    for(String file : files)
	        if(file.equals(filename))
	            return true;
	    return false;
	}
	//This method displays the menu
	public static void displayMainMenu() 
	{
		System.out.println("********************************************************************");
		System.out.println("\t\t Welcome to LockedMe.com ");
		System.out.println("\t\t Developed By : Ruchika Uppal ");
		System.out.println("********************************************************************");
		System.out.println("\t\tEnter your choise : ");
		System.out.println("\t\t1. Display all the files ");
		System.out.println("\t\t2. Business level operations (add,delete or search)");
		System.out.println("\t\t3. Exit");
		
	}
	//This method displays the sub-menu
	public static void displaySubMenu() 
	{
		System.out.println("\t\tBusiness level operations");
		System.out.println("\t\tEnter your choise : ");
		System.out.println("\t\t\t1. Add a new file");
		System.out.println("\t\t\t2. Delete a file");
		System.out.println("\t\t\t3. Search a file");
		System.out.println("\t\t\t4. Back to Main Menu");
	}
	
	// This method validates the user choice and performs the generic operations
	public static void genericOperations()
	{
		Scanner sc= new Scanner(System.in);
		displayMainMenu();
		try
		{	
			int choise=Integer.parseInt(sc.nextLine());
			
			switch(choise)
			{
				case 1 : 
					displayFiles();
					break;
				case 2 :
					displaySubMenu();
					businessLevelOperations();
					break;
				case 3 :
					System.exit(0);
					break;
				default :
					System.out.println("Invalid option");
					break;
			}
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		finally
		{
			sc.close();
		}
		
	}
	
	// This method validates the user choice and performs the generic operations
	public static void businessLevelOperations()
	{
		Scanner sc= new Scanner(System.in);
		try
		{
			
			int ch=Integer.parseInt(sc.nextLine());
			
			switch (ch)
			{
				case 1:
					addNewFile();
					break;
				case 2:
					deleteFile();
					break;
				case 3:
					searchFile();
					break;
				case 4:
					genericOperations();
					break;
				default :
					System.out.println("Invalid option");
					break;
			}
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		finally
		{
			sc.close();
		}
	}
	//This method displays the files in the directory
	public static void displayFiles() 
	{  
		try
		{
			File directory = new File(folderPath);
			if(directory.isDirectory())
			{
				File[] filesList = directory.listFiles();
				
				// sorting files in ascending order
				Arrays.sort(filesList);
				
			    for(var l : filesList)
				{
					System.out.println(l.getName());
				}
		    }		   
		}
		
		catch (Exception ex)
		{
			System.out.println(errorMessage);
		}
		
	}
		
	//This method creates a new file and allows the user to write to it	
	public static void addNewFile() 
	{
		Scanner sc= new Scanner(System.in);
		
		try
		{
			String fileName;
			System.out.println("Enter the file name to be created : ");
			fileName=sc.nextLine();
			
			int linesCount;
			System.out.println("Enter the no of lines you want to write into the file : ");
			linesCount=Integer.parseInt(sc.nextLine());
			
			FileWriter myWriter=new FileWriter (folderPath+"//"+fileName);
			for(int i=1; i<=linesCount;i++)
			{
				System.out.println("Start writing into the file " +fileName+" line : " +i);
				myWriter.write(sc.nextLine()+"\n");
			}
			System.out.println("File " +fileName+ " created and saved successfully in folder path " +folderPath);
			myWriter.close();
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		finally
		{
			sc.close();
		}
	}
	
	// This method searches for a user specified file
	public static void searchFile() 
	{
		File directory = new File(folderPath);
		
		Scanner sc= new Scanner(System.in);
		try
		{
			String fileName;
			
			System.out.println("Enter the file name to be searched : ");
			fileName=sc.nextLine();
			
			// checking if the user input is empty
			if(fileName.isEmpty())
				System.out.println("Sorry!! No file name entered");
			
			//checking the existence and case sensitivity of the file to be searched
			else if(exists(directory,fileName))
				System.out.println("File "+fileName+" is available. ");
					
			else
				  System.out.println("File does not exist.");
			
		}
		
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		
		finally
		{
			sc.close();
		}
	}
    //This method will delete the user specified file from the directory
	public static void deleteFile()
	{
		File directory = new File(folderPath);
		Scanner sc= new Scanner(System.in);
		try
		{
			String fileName;
			
			System.out.println("Enter the file name to be deleted : ");
			fileName=sc.nextLine();
			// checking if the user input is empty
			if(fileName.isEmpty())
				System.out.println("Sorry!! No file name entered");
			
			//checking the existence and case sensitivity of the file to be deleted
			else if(exists(directory,fileName))
			{	
				 File file= new File(folderPath+"\\"+fileName);
					
				 file.delete();
			     System.out.println("Successfully deleted "+fileName+" file. ");
			}
					
			else
				  System.out.println("File does not exist.");
			
		}
		
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		
		finally
		{
			sc.close();
		}
	}

	public static void main(String[] args) 
	{
		genericOperations();

	}

}
