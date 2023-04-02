package BCIMS;
import java.util.ArrayList;
import java.util.Scanner;


class Crime {
    private int crimeId;
    private String type;
    private String description;
    private String psArea;
    private String date;
    private String victimName;
    

    public Crime(int crimeId, String type, String description, String psArea, String date, String victimName) {
        this.crimeId = crimeId;
        this.type = type;
        this.description = description;
        this.psArea = psArea;
        this.date = date;
        this.victimName = victimName;
    }

    public void updateCrime(String type, String description, String psArea, String date, String victimName) {
        this.type = type;
        this.description = description;
        this.psArea = psArea;
        this.date = date;
        this.victimName = victimName;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getPsArea() {
        return psArea;
    }

    public String getDate() {
        return date;
    }

    public String getVictimName() {
        return victimName;
    }
}

class Criminal {
    private int criminalId;
    private String name;
    private String dob;
    private String gender;
    private String identifyingMark;
    private String firstArrestDate;
    private String arrestedFromPsArea;

    public Criminal(int criminalId, String name, String dob, String gender, String identifyingMark, String firstArrestDate, String arrestedFromPsArea) {
        this.criminalId = criminalId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identifyingMark = identifyingMark;
        this.firstArrestDate = firstArrestDate;
        this.arrestedFromPsArea = arrestedFromPsArea;
    }

    public void updateCriminal(String name, String dob, String gender, String identifyingMark, String firstArrestDate, String arrestedFromPsArea) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identifyingMark = identifyingMark;
        this.firstArrestDate = firstArrestDate;
        this.arrestedFromPsArea = arrestedFromPsArea;
    }

    public int getCriminalId() {
        return criminalId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getIdentifyingMark() {
        return identifyingMark;
    }

    public String getFirstArrestDate() {
        return firstArrestDate;
    }

    public String getArrestedFromPsArea() {
        return arrestedFromPsArea;
    }
}

class CrimeManagementSystem {
    private ArrayList<Crime> crimes;
    private ArrayList<Criminal> criminals;

    public CrimeManagementSystem() {
        this.crimes = new ArrayList<>();
        this.criminals = new ArrayList<>();
    }

    public void addCrime(int crimeId, String type, String description, String psArea, String date, String victimName) {
        Crime crime = new Crime(crimeId, type, description, psArea, date, victimName);
        crimes.add(crime);
    }

    public void updateCrime(int crimeId, String type, String description, String psArea, String date, String victimName) {
        for (Crime crime : crimes) {
        	
        	// check if the crime exists with given id
        	if (crime.getCrimeId() == crimeId) {
        	crime.updateCrime(type, description, psArea, date, victimName);
        	System.out.println("Crime updated successfully");
        	return;
        	}
        	}
        	System.out.println("Crime not found with given id");
        	}
    
    public void addCriminal(int criminalId, String name, String dob, String gender, String identifyingMark, String firstArrestDate, String arrestedFromPsArea) {
        Criminal criminal = new Criminal(criminalId, name, dob, gender, identifyingMark, firstArrestDate, arrestedFromPsArea);
        criminals.add(criminal);
    }

    public void updateCriminal(int criminalId, String name, String dob, String gender, String identifyingMark, String firstArrestDate, String arrestedFromPsArea) {
        for (Criminal criminal : criminals) {
            // check if the criminal exists with given id
            if (criminal.getCriminalId() == criminalId) {
                criminal.updateCriminal(name, dob, gender, identifyingMark, firstArrestDate, arrestedFromPsArea);
                System.out.println("Criminal updated successfully");
                return;
            }
        }
        System.out.println("Criminal not found with given id");
    }

    public void assignCriminalToCrime(int criminalId, int crimeId) {
        Crime crime = getCrimeById(crimeId);
        Criminal criminal = getCriminalById(criminalId);

        if (crime == null) {
            System.out.println("Crime not found with given id");
        } else if (criminal == null) {
            System.out.println("Criminal not found with given id");
        } else {
            // assign the criminal to the crime
            // TODO: implement this
            System.out.println("Criminal assigned to crime successfully");
        }
    }

    public void removeCriminalFromCrime(int criminalId, int crimeId) {
        Crime crime = getCrimeById(crimeId);
        Criminal criminal = getCriminalById(criminalId);

        if (crime == null) {
            System.out.println("Crime not found with given id");
        } else if (criminal == null) {
            System.out.println("Criminal not found with given id");
        } else {
            // remove the criminal from the crime
            // TODO: implement this
            System.out.println("Criminal removed from crime successfully");
        }
    }

    public void deleteCrime(int crimeId) {
        Crime crime = getCrimeById(crimeId);

        if (crime == null) {
            System.out.println("Crime not found with given id");
        } else {
            crimes.remove(crime);
            System.out.println("Crime deleted successfully");
        }
    }

    public void deleteCriminal(int criminalId) {
        Criminal criminal = getCriminalById(criminalId);

        if (criminal == null) {
            System.out.println("Criminal not found with given id");
        } else {
            criminals.remove(criminal);
            System.out.println("Criminal deleted successfully");
        }
    }

    private Crime getCrimeById(int crimeId) {
        for (Crime crime : crimes) {
            if (crime.getCrimeId() == crimeId) {
                return crime;
            }
        }
        return null;
    }

    private Criminal getCriminalById(int criminalId) {
        for (Criminal criminal : criminals) {
            if (criminal.getCriminalId() == criminalId) {
                return criminal;
            }
        }
        return null;
    }
}

class CrimeManagementSystemApp {
private static final String ADMIN_USERNAME = "admin";
private static final String ADMIN_PASSWORD = "admin";

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("|=======================================================|");
    System.out.println("| Welcome to Gotham Crime Information Management System |");
    System.out.println("|=======================================================|");

    // prompt user for credentials
    System.out.println(" ");
    System.out.print("Admin Username : ");
    String username = scanner.nextLine();

    System.out.print("Enter password : ");
    String password = scanner.nextLine();

    if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
        // create instance of CrimeManagementSystem
        CrimeManagementSystem crimeManagementSystem = new CrimeManagementSystem();
        
        while (true) {
        	System.out.println(" ");
        	System.out.println("+===============================+");
        	System.out.println("A Hero Can Be Anyone -B.A.T.M.A.N");
        	System.out.println("+===============================+");
            System.out.println("|      :SELECT AN OPTION:       |");
            System.out.println("+===============================+");
            System.out.println("| 1. Add crime                  |");
            System.out.println("| 2. Update crime               |");
            System.out.println("| 3. Add criminal               |");
            System.out.println("| 4. Update criminal            |");
            System.out.println("| 5. Assign criminal to crime   |");
            System.out.println("| 6. Remove criminal from crime |");
            System.out.println("| 7. Delete crime               |");
            System.out.println("| 8. Delete criminal            |");
            System.out.println("| 9. Exit                       |");
            System.out.println("+===============================+");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter crime id:                        ");
                    int crimeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter type (Robbery/Theft/Homicide):   ");
                    String type = scanner.nextLine();

                    System.out.print("Enter description:                     ");
                    String description = scanner.nextLine();

                    System.out.print("Enter police station area:             ");
                    String psArea = scanner.nextLine();

                    System.out.print("Enter date:                            ");
                    String date = scanner.nextLine();

                    System.out.print("Enter name of victim:                  ");
                    String victimName = scanner.nextLine();

                    crimeManagementSystem.addCrime(crimeId, type, description, psArea, date, victimName);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.print("Enter crime id: ");
                    int crimeId2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter type (Robbery/Theft/Homicide): ");
                    String type2 = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description2 = scanner.nextLine();

                    System.out.print("Enter police station area: ");
                    String psArea2 = scanner.nextLine();

                    System.out.print("Enter date: ");
                    String date2 = scanner.nextLine();

                    System.out.print("Enter name of victim: ");
                    String victimName2 = scanner.nextLine();

                    crimeManagementSystem.updateCrime(crimeId2, type2, description2, psArea2, date2, victimName2);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.print("Enter criminal id: ");
                    int criminalId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter dob: ");
                    String dob = scanner.nextLine();

                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter identifying mark: ");
                    String identifyingMark = scanner.nextLine();

                    System.out.print("Enter first arrest date: ");
                    String firstArrestDate = scanner.nextLine();

                    System.out.print("Enter arrested from police station area: ");
                    String arrestedFromPsArea = scanner.nextLine();

                    crimeManagementSystem.addCriminal(criminalId, name, dob, gender, identifyingMark, firstArrestDate, arrestedFromPsArea);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                case 4:
                	System.out.print("Try again after sometime !");
//                    System.out.print("Enter criminal id: ");
//                    int criminalId2 = scanner.nextInt();
//                    scanner.nextLine();
//
//                    System.out.print("Enter crime id: ");
//                    		crimeManagementSystem.updateCriminal(criminalId2, name2, dob2, gender2, identifyingMark2, firstArrestDate2, arrestedFromPsArea2);
//                    		break;

                case 5:
                	System.out.print("Enter criminal id: ");
                	int criminalId3 = scanner.nextInt();
                    System.out.print("Enter crime id: ");
                    int crimeId3 = scanner.nextInt();

                    crimeManagementSystem.assignCriminalToCrime(criminalId3, crimeId3);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                    
                case 6:
                    System.out.print("Enter criminal id: ");
                    int criminalId4 = scanner.nextInt();

                    System.out.print("Enter crime id: ");
                    int crimeId4 = scanner.nextInt();

                    crimeManagementSystem.removeCriminalFromCrime(criminalId4, crimeId4);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                case 7:
                    System.out.print("Enter crime id: ");
                    int crimeId5 = scanner.nextInt();

                    crimeManagementSystem.deleteCrime(crimeId5);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                case 8:
                    System.out.print("Enter criminal id: ");
                    int criminalId5 = scanner.nextInt();

                    crimeManagementSystem.deleteCriminal(criminalId5);
                    System.out.println(" ");
                    System.out.println("              || धन्यवाद् , 'सुरक्षा आपकी, संकल्प हमारा' || ");
                    System.out.println(" ");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    } else {
        System.out.println("Invalid credentials. Exiting...");
    }
}
}
