package org.prash.datafactory.impl;

import org.prash.datafactory.NameDataValues;

public class DefaultNameDataValues implements NameDataValues {

	private static final String[] suffixes = { "II", "III", "Phd", "Jr", "Sr" };
	private static final String[] prefixes = { "Mr", "Mrs", "Ms" };
	private static final String[] firstNames = { "Prashoo", "Aaditya", "Aadya", "Aahana", "Aarav", "Aarushi", "Aarush", "Aarohi", "Abhay", "Abhinav", "Aditi",
            "Advik", "Ahaan", "Aishwarya", "Aisha", "Akhil", "Akshara", "Amaira", "Aman", "Amar", "Amaya",
            "Amisha", "Amrita", "Anahita", "Ananya", "Anay", "Anika", "Aniket", "Anisha", "Anjali", "Anjana",
            "Anvi", "Anvita", "Anya", "Aparna", "Aradhya", "Arnav", "Aryan", "Arya", "Atharv", "Avani",
            "Avantika", "Avinash", "Bhavana", "Bhavesh", "Bhumika", "Chaitanya", "Darsh", "Dev", "Devansh",
            "Devika", "Dhruv", "Dhruvi", "Disha", "Diya", "Farhan", "Gayatri", "Gaurav", "Gauri", "Geeta",
            "Hema", "Ira", "Ishan", "Isha", "Ishaan", "Ishani", "Ishir", "Ishita", "Jai", "Jaya",
            "Jiya", "Juhi", "Kabir", "Kajal", "Kalyani", "Kavya", "Kirti", "Kiara", "Kriti", "Krisha",
            "Krish", "Krishna", "Kunal", "Kush", "Lavanya", "Mahi", "Mahesh", "Mahek", "Manav", "Manya",
            "Maya", "Mayank", "Mehak", "Mehul", "Mihir", "Mira", "Mohit", "Nakul", "Naman", "Namrata",
            "Nandini", "Naveen", "Navya", "Neha", "Nehal", "Niharika", "Nikita", "Nikunj", "Nirav", "Nishant",
            "Nisha", "Nishit", "Nitya", "Nupur", "Om", "Pari", "Paridhi", "Parth", "Pooja", "Poonam",
            "Prachi", "Pranav", "Pranay", "Pranjal", "Pranvi", "Pratyush", "Preeti", "Priya", "Priyanka", "Rachit",
            "Rahul", "Raj", "Rajat", "Rajesh", "Rakesh", "Rani", "Ravi", "Ria", "Ridhi", "Rishi",
            "Rishabh", "Ritika", "Ritu", "Rohan", "Rudra", "Ruhi", "Saanvi", "Sahana", "Sahil", "Samaira",
            "Samir", "Samarth", "Sana", "Sanaya", "Sanvi", "Sanya", "Sara", "Sarvesh", "Sarthak", "Shaurya",
            "Shiv", "Shivam", "Shlok", "Simran", "Sia", "Siddharth", "Sneha", "Soham", "Suhani", "Sukriti",
            "Suman", "Surya", "Swara", "Tanay", "Tanisha", "Tanishka", "Tanishq", "Tara", "Trisha", "Uday",
            "Urvashi", "Utkarsh", "Vaibhav", "Vaishali", "Vansh", "Vanya", "Ved", "Vedant", "Veer", "Vidhi",
            "Vidya", "Vihaan", "Vikas", "Vikram", "Vivaan", "Vivek", "Yash", "Yashika", "Yashvi", "Yuvaan",
            "Yuvan", "Yuvraj", "Zara", "Zoya" };

	private static final String[] lastNames = {  "Agarwal", "Ahluwalia", "Bajaj", "Balasubramanian", "Banerjee", "Batra", "Bhalla", "Bhatnagar",
            "Chandra", "Chatterjee", "Chopra", "Das", "Datta", "Deol", "Dewan", "Dutta", "Gandhi",
            "Ganguly", "Garg", "Gill", "Goswami", "Gupta", "Iyer", "Jain", "Jha",
            "Joshi", "Kapoor", "Khanna", "Khatri", "Kumar", "Mahajan", "Malhotra", "Mehta",
            "Mehra", "Mukherjee", "Nair", "Nanda", "Padmanabhan", "Pandey", "Patel", "Patil",
            "Pillai", "Rai", "Raj", "Rana", "Ranganathan", "Rao", "Rastogi", "Reddy",
            "Saini", "Sarin", "Saxena", "Sengupta", "Shah", "Sharma", "Shroff", "Singh",
            "Sinha", "Somayaji", "Srivastava", "Subramanian", "Suri", "Tandon", "Thakur", "Trivedi",
            "Varma", "Verma", "Vohra", "Yadav", "Chakraborty", "Deshpande", "Dhawan", "Gosain",
            "Joshi", "Kakkar", "Kaul", "Kher", "Kothari", "Koul", "Lal", "Malik",
            "Mathur", "Menon", "Mistry", "Mittal", "Mukhopadhyay", "Nagpal", "Narayan", "Pandit",
            "Pant", "Parekh", "Prasad", "Rajagopal", "Ramachandran", "Rangan", "Ranganath", "Sachdev",
            "Sanyal", "Sen", "Shankar", "Shanmugam", "Shetty", "Shukla", "Sundaram", "Talwar",
            "Thakkar", "Tiwari", "Uppal", "Venkataraman", "Venkatesh", "Verma", "Vyas", "Yadav",
            "Anand", "Babu", "Bakshi", "Chadha", "Chandra", "Chopra", "Dasgupta", "Deshmukh",
            "Dhawan", "Dubey", "Ganguly", "Ghosh", "Gowda", "Gupta", "Iyengar", "Iyer",
            "Jacob", "Jain", "Jha", "Kamble", "Kannan", "Kapoor", "Kaul", "Kulkarni",
            "Kurian", "Mahajan", "Malhotra", "Mehta", "Mittal", "Mukherjee", "Murthy", "Nag",
            "Naidu", "Nair", "Namboothiri", "Pai", "Panicker", "Patel", "Patil", "Pillai",
            "Prasad", "Rangan", "Rao", "Reddy", "Sarin", "Saxena", "Shah", "Sharma",
            "Shenoy", "Shetty", "Sinha", "Soni", "Srinivasan", "Subramanian", "Tandon", "Tiwari",
            "Trivedi", "Varma", "Vohra", "Yadav", "Khan", "Joshi", "Shah", "Malik",
            "Singh", "Rao", "Patel", "Kaur", "Gupta", "Kumar", "Sharma", "Ali",
            "Choudhary", "Khan", "Ahmed", "Yadav", "Sharma", "Shah", "Soni", "Singh"
	};

	public String[] getFirstNames() {
		return firstNames;
	}

	public String[] getLastNames() {
		return lastNames;
	}

	public String[] getPrefixes() {
		return prefixes;
	}

	public String[] getSuffixes() {
		return suffixes;
	}

}
