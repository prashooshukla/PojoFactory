package org.prash.datafactory.impl;

import org.prash.datafactory.AddressDataValues;

public class DefaultAddressDataValues implements AddressDataValues {

    private static final String[] streetNames = {
            "Sardar Patel Marg", "Rajendra Nagar Road", "Shivaji Chowk", "Nehru Nagar Lane", "Tagore Street",
            "Gandhi Colony Road", "Patel Nagar Extension", "Subhash Chandra Bose Lane", "Lal Bahadur Shastri Path",
            "Vivekananda Avenue", "Ambedkar Nagar Lane", "Mahatma Gandhi Road", "Jawaharlal Nehru Street",
            "Rani Lakshmi Bai Path", "Bhagat Singh Marg", "Netaji Subhash Nagar", "Sarojini Naidu Lane",
            "Kasturba Gandhi Road", "Chandra Shekhar Azad Path", "Rajiv Gandhi Avenue", "Veer Savarkar Marg",
            "Lala Lajpat Rai Street", "Swami Vivekananda Path", "Atal Bihari Vajpayee Road", "Bal Gangadhar Tilak Lane",
            "Kalpana Chawla Avenue", "APJ Abdul Kalam Path", "Savitribai Phule Road", "Raja Ram Mohan Roy Street",
            "Srinivasa Ramanujan Lane", "Rahul Gandhi Path", "Manikarnika Tambe Street", "Lokmanya Tilak Marg",
            "Shyama Prasad Mukherjee Avenue", "Subramanya Bharathi Road", "Aryabhatta Path", "Chhatrapati Shivaji Nagar",
            "Pandit Jawaharlal Nehru Street", "Mother Teresa Lane", "Gopal Krishna Gokhale Road", "Rabindranath Tagore Avenue",
            "Vinayak Damodar Savarkar Marg", "Dr. BR Ambedkar Path", "Dr. Rajendra Prasad Street", "Dr. Zakir Hussain Nagar",
            "Sir Jagadish Chandra Bose Road", "Swami Vivekananda Extension", "Raja Ravi Varma Lane", "Vikram Sarabhai Path",
            "JRD Tata Marg", "CV Raman Street", "Kalidas Nagar", "Lakshmi Bai Street", "Savitribai Phule Extension",
            "Maharishi Valmiki Road", "Chakravarti Rajagopalachari Lane", "Abdul Kalam Azad Path", "Rani Lakshmi Bai Nagar",
            "Bhagat Singh Road", "Jawaharlal Nehru Colony", "Sardar Vallabhbhai Patel Street", "Lal Bahadur Shastri Nagar",
            "Indira Gandhi Avenue", "Acharya Vinoba Bhave Road", "Kavi Bhushan Path", "Munshi Premchand Street",
            "Kamala Nehru Lane", "Ravindra Nath Tagore Road", "Raja Ram Mohan Roy Nagar", "Savitribai Phule Path",
            "Bankim Chandra Chattopadhyay Marg", "Chaitanya Mahaprabhu Lane", "Harivansh Rai Bachchan Avenue",
            "Goswami Tulsidas Path", "Rani Durgavati Nagar", "Maharani Ahilyabai Holkar Street", "Guru Nanak Dev Path",
            "Bhagwan Das Marg", "Ramakrishna Paramhansa Avenue", "Paramahansa Yogananda Lane", "Shankaracharya Road",
            "Adi Shankaracharya Nagar", "Sant Tukaram Marg", "Namdev Tukaram Path", "Sant Kabir Nagar",
            "Guru Ravidas Street", "Meera Bai Avenue", "Surdas Path", "Guru Gobind Singh Lane", "Chhatrapati Shivaji Nagar",
            "King Shivaji Maharaj Road", "Queen Rani Lakshmi Bai Street", "Tatya Tope Marg", "Mangal Pandey Lane",
            "Lachit Borphukan Avenue", "Birsa Munda Path", "Udham Singh Nagar", "Sukhdev Thapar Marg",
            "Bhagat Singh Colony", "Vinayak Damodar Savarkar Nagar", "Subhas Chandra Bose Path", "Lal Bahadur Shastri Street",
            "Vivekananda Nagar", "Ramkrishna Paramhansa Road", "Kazi Nazrul Islam Lane", "Sarat Chandra Chattopadhyay Nagar",
            "Sister Nivedita Path", "Surendranath Banerjee Street", "Ishwar Chandra Vidyasagar Avenue",
            "Prafulla Chandra Ray Marg", "Raja Ram Mohan Roy Nagar", "Swami Vivekananda Path", "Jyotirao Phule Lane",
            "Savitribai Phule Nagar", "Dadabhai Naoroji Avenue", "Bal Gangadhar Tilak Road", "Gopal Krishna Gokhale Path",
            "Mahadev Govind Ranade Street", "Jamsetji Tata Nagar", "Dhirubhai Ambani Marg", "Nusserwanji Tata Path",
            "Begum Hazrat Mahal Road", "Bhikaji Cama Lane", "Annie Besant Street", "Madam Cama Avenue",
            "Sardar Vallabhbhai Patel Nagar", "Kanaklata Barua Path", "Bhupen Hazarika Street", "Hem Barua Nagar",
            "Maniram Dewan Path", "Ambikagiri Raichoudhury Lane", "Phani Sarma Path", "Mahendra Nath Deka Avenue",
            "Bhaskar Varman Road", "Bir Chilarai Path", "Kushal Konwar Avenue", "Sankardev Nagar", "Lachit Borphukan Lane",
            "Tarun Ram Phukan Marg", "Tulsi Das Street", "Kabir Marg", "Sant Tulsidas Lane", "Rahim Path",
            "Munshi Premchand Nagar", "Harivansh Rai Bachchan Lane", "Dushyant Kumar Avenue", "Suryakant Tripathi Nirala Road",
            "Sumitranandan Pant Marg", "Jai Shankar Prasad Lane", "Makhanlal Chaturvedi Path", "Gopaldas Neeraj Street",
            "Raghuvir Sahay Nagar", "Shyam Narayan Pandey Road", "Dharmvir Bharati Lane", "Amrita Pritam Avenue",
            "Saadat Hasan Manto Path", "Munshi Premchand Street", "Premchand Nagar", "Harishankar Parsai Lane",
            "Bhisham Sahni Marg", "Chandrakanta Pathak Road", "Vijaydan Detha Avenue", "Kesava Reddy Lane",
            "Jayamma Govinda Reddy Street", "Yeduguri Sandinti Jagan Mohan Reddy Nagar", "Nandamuri Taraka Rama Rao Path",
            "Mandala Parthasarathi Avenue", "U. V. Ramana Reddy Lane", "Uppalapati Venkata Krishnam Raju Road",
            "Muppavarapu Venkaiah Naidu Nagar", "Kotla Vijaya Bhaskara Reddy Path", "Daggubati Purandeswari Marg"
    };

    private static final String[] addressSuffixes = {"Avenue", "Boulevard",
            "Circle", "Crescent", "Court", "Drive", "Heights", "Lane", "Park",
            "Path", "Parkway", "Place", "Road", "Ridge", "Run", "Square",
            "Street", "Station", "Terrace", "Trail", "Way", "Rd", "Ln", "St",
            "Blvd", "Ave", "Drv"};

    private static final String[] cities = {"Mumbai", "Delhi", "Bangalore", "Kolkata", "Chennai", "Hyderabad", "Pune", "Ahmedabad",
            "Jaipur", "Surat", "Lucknow", "Kanpur", "Nagpur", "Indore", "Thane", "Bhopal",
            "Visakhapatnam", "Patna", "Vadodara", "Ghaziabad", "Ludhiana", "Agra", "Nashik", "Faridabad",
            "Meerut", "Rajkot", "Kalyan-Dombivli", "Vasai-Virar", "Varanasi", "Srinagar", "Aurangabad", "Dhanbad",
            "Amritsar", "Navi Mumbai", "Allahabad", "Howrah", "Ranchi", "Gwalior", "Jabalpur", "Coimbatore",
            "Vijayawada", "Jodhpur", "Madurai", "Raipur", "Kota", "Guwahati", "Chandigarh", "Solapur",
            "Hubli-Dharwad", "Bareilly", "Moradabad", "Mysore", "Gurgaon", "Aligarh", "Jalandhar", "Tiruppur",
            "Bhubaneswar", "Salem", "Warangal", "Guntur", "Bhiwandi", "Saharanpur", "Gorakhpur", "Bikaner",
            "Amravati", "Noida", "Jamshedpur", "Bhilai", "Cuttack", "Firozabad", "Kochi", "Nellore",
            "Bhavnagar", "Dehradun", "Durgapur", "Asansol", "Rourkela", "Nanded", "Kolhapur", "Ajmer",
            "Akola", "Gulbarga", "Jamnagar", "Ujjain", "Loni", "Siliguri", "Jhansi", "Ulhasnagar",
            "Jammu", "Sangli-Miraj & Kupwad", "Mangalore", "Erode", "Belgaum", "Ambattur", "Tirunelveli",
            "Malegaon", "Gaya", "Jalgaon", "Udaipur", "Maheshtala", "Davanagere", "Kozhikode", "Kurnool",
            "Rajpur Sonarpur", "Rajahmundry", "Bokaro Steel City", "South Dumdum", "Bellary", "Patiala", "Gopalpur",
            "Agartala", "Bhagalpur", "Muzaffarnagar", "Bhatpara", "Panihati", "Latur", "Dhule", "Rohtak",
            "Sambalpur", "Korba", "Bhilwara", "Brahmapur", "Muzaffarpur", "Ahmednagar", "Mathura", "Kollam",
            "Avadi", "Kadapa", "Kamarhati", "Bilaspur", "Shahjahanpur", "Satara", "Bijapur", "Rampur",
            "Shivamogga", "Chandrapur", "Junagadh", "Thrissur", "Alwar", "Bardhaman", "Kulti", "Kakinada",
            "Nizamabad", "Parbhani", "Tumkur", "Khammam", "Ozhukarai", "Bihar Sharif", "Panipat", "Darbhanga",
            "Bally", "Aizawl", "Dewas", "Ichalkaranji", "Tirupati", "Sagar", "Ratlam", "Hapur",
            "Anantapur", "Arrah", "Karimnagar", "Etawah", "Ambernath", "North Dumdum", "Bharatpur", "Begusarai",
            "New Delhi", "Gandhidham", "Baranagar", "Tiruvottiyur", "Puducherry", "Sikar", "Thoothukudi", "Rewa",
            "Mirzapur", "Raichur", "Pali", "Ramagundam", "Haridwar", "Vijayanagaram", "Katihar", "Sri Ganganagar",
            "Karawal Nagar", "Nagercoil", "Mango", "Thanjavur", "Bulandshahr", "Uluberia", "Katni", "Sambhal",
            "Singrauli", "Nadiad", "Secunderabad", "Naihati", "Yamunanagar", "Bidar", "Pallavaram", "Bidhan Nagar",
            "Munger", "Panchkula", "Burhanpur", "Raurkela Industrial Township", "Kharagpur", "Dindigul", "Gandhinagar", "Hospet",
            "Nangloi Jat", "Malda", "Ongole", "Deoghar", "Chapra", "Haldia", "Khandwa", "Nandyal",
            "Morena", "Amroha", "Anand", "Bhind", "Bhuj", "Madhyamgram", "Bhiwani", "Berhampur",
            "Ambala", "Morbi", "Fatehpur", "Raebareli", "Khora", "Rajnandgaon", "Shivpuri", "Kanpur Cantonment",
            "Unnao", "Jaunpur", "Madanapalle", "Hugli-Chinsurah", "Dehri", "Chittoor", "Arrah", "Jaunpur",
            "Bankura", "Thanesar", "Vellore", "Sirsa", "Guna", "Jalna", "Khamgaon", "Madhyamgram",
            "Karwar", "Etah", "Ballia", "Kharar", "Amalner", "Halisahar", "Kanchipuram", "Sundernagar",
            "Rishra", "Hazaribagh", "Tinsukia", "Lakhimpur", "Lalitpur", "Pilibhit", "Palanpur", "Nowrangapur",
            "Shimoga", "Adoni", "Udupi", "Jagtial", "Dimapur", "Hindupur", "Sasaram", "Hinganghat",
            "Madhubani", "Bhind", "Buxar", "Bettiah", "Ganganagar", "Jehanabad", "Alandur", "Hosur",
            "Vapi", "Bally", "Silvassa", "Sultanpur", "Amreli", "Mehsana", "Vadnagar", "Bharuch",
            "Sawai Madhopur", "Porbandar", "Godhra", "Palanpur", "Veraval", "Dholka", "Bhuj", "Mehsana",
            "Mahesana", "Visnagar", "Kadi", "Modhera", "Prantij", "Vijapur", "Vadnagar", "Unjha"
    };

    public String[] getCities() {
        return cities;
    }

    public String[] getStreetNames() {
        return streetNames;
    }

    public String[] getAddressSuffixes() {
        return addressSuffixes;
    }

}
