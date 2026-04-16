package asn5;


class BookNotFound extends Exception
{
	BookNotFound(String message)
	{
		super(message);
	}
}


class InvalidReturnDate extends Exception
{
	InvalidReturnDate(String message)
	{
		super(message);
	}
}


class BookNotIssued extends Exception
{
	BookNotIssued(String message)
	{
		super(message);
	}
}


class BookIssued extends Exception
{
	BookIssued(String message)
	{
		super(message);
	}
}


class Book
{
	String title;
	boolean isIssued;
	public Book(String title)
	{
		this.title=title;
		this.isIssued=false;
	}
}


class Lib
{
	Book[] books;
	Lib(Book[] books)
	{
		this.books=books;
	}
	
	Book search(String title) throws BookNotFound
	{
		for (Book b : books)
		{
			if(b.title.equalsIgnoreCase(title))
			{
				return b;
			}
		}
		throw new BookNotFound(title+" not found!");
	}
	
	void issueBook(String title) throws BookNotFound,BookIssued
	{
		Book b = search(title);
		if (b.isIssued)
		{
			throw new BookIssued("The book is already checked out!\n");
		}
		b.isIssued = true;
		System.out.println("Book checked out successfully: " + title);
	}
	
	void returnBook(String title, int daysLate) throws BookNotFound,BookNotIssued,InvalidReturnDate
	{
		Book b = search(title);
		if(!b.isIssued)
		{
			throw new BookNotIssued("Book was not issued\n");
		}
		if(daysLate<0)
		{
			throw new InvalidReturnDate("Invalid return date! Days late cannot be negative.");
		}
		b.isIssued=false;
		System.out.println("Book returned successfully: " + title + "\n");
		if (daysLate > 0)
		{
			System.out.println("Late Fee: "+daysLate*2+"\n");
		}
	}
}


public class library
{
	public static void main(String[] args)
	{
		Book[] bookList = {
			new Book("Java Programming"),
			new Book("Data Structures"),
			new Book("Operating Systems")
		};
		Lib lib = new Lib(bookList);
		
		try
		{
			lib.issueBook("Java Programming");
			lib.issueBook("Java Programming");
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		try
		{
			lib.returnBook("Java Programming", 5);
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		try
		{
			lib.issueBook("Java Programming");
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		try
		{
			lib.returnBook("Java Programming", -1);
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		try
		{
			lib.returnBook("Data Structures", 0);
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		try
		{
			lib.issueBook("Unknown Book");
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
