import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.time.*;
import java.time.format.*;

/**
 * Boundary class to display user interface for staff functions.
 */
class StaffUI{

	public static void display() throws ClassNotFoundException, IOException, FileNotFoundException {
		int choice;
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        do {
            System.out.println("Menu: ");
            System.out.println("(1) Edit student access period ");
            System.out.println("(2) Add a student ");
			System.out.println("(3) Add a course ");
			System.out.println("(4) Add an index to an existing course ");
			System.out.println("(5) Update a course ");
            System.out.println("(6) Check available slots for an index number ");
            System.out.println("(7) Print student list by index number ");
            System.out.println("(8) Print student list by course ");
			System.out.println("(9) Print all courses");
            System.out.println("(10) Log off");

            System.out.print("Select an option: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the student's matriculation number: ");
                    String matricNum = sc.nextLine();
                    System.out.print("Enter the access start date in yyyy-MM-dd format (e.g. 2020-01-30): ");
					String startDate = sc.nextLine();
					System.out.print("Enter the access start time in 24hr HH:mm format (e.g. 13:30): ");
                    String startTime = sc.nextLine();
                    System.out.print("Enter the access end date in yyyy-MM-dd format (e.g. 2020-01-30): ");
                    String endDate = sc.nextLine();
                    System.out.print("Enter the access end time in 24hr HH:mm format (e.g. 13:30): ");
					String endTime = sc.nextLine();
					LocalDate sDate = LocalDate.parse(startDate, dateFormatter);
					LocalTime sTime = LocalTime.parse(startTime, timeFormatter);
					LocalDate eDate = LocalDate.parse(endDate, dateFormatter);
					LocalTime eTime = LocalTime.parse(endTime, timeFormatter);
					LocalDateTime startDateTime = LocalDateTime.of(sDate, sTime);
					LocalDateTime endDateTime = LocalDateTime.of(eDate, eTime);
                    StaffController.editStudentAccessPeriod(matricNum, startDateTime, endDateTime);
                    break;
                case 2:
					System.out.print("Enter the student's username: ");
					String username = sc.nextLine();
					System.out.print("Enter the student's password: ");
					String password = sc.nextLine();
					System.out.print("Enter the student's name: ");
					String name = sc.nextLine();
					System.out.print("Enter the student's matriculation number: ");
					matricNum = sc.nextLine();
					System.out.print("Enter the student's gender: ");
					char gender = sc.nextLine().charAt(0);
					System.out.print("Enter the student's nationality: ");
					String nationality = sc.nextLine();
					System.out.print("Enter the student's year of study: ");
					int yearOfStudy = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the student's access start date in yyyy-MM-dd format (e.g. 2020-01-30): ");
					startDate = sc.nextLine();
					System.out.print("Enter the student's access start time in 24hr HH:mm format (e.g. 13:30): ");
                    startTime = sc.nextLine();
                    System.out.print("Enter the student's access end date in yyyy-MM-dd format (e.g. 2020-01-30): ");
                    endDate = sc.nextLine();
                    System.out.print("Enter the student's access end time in 24hr HH:mm format (e.g. 13:30): ");
					endTime = sc.nextLine();
					sDate = LocalDate.parse(startDate, dateFormatter);
					sTime = LocalTime.parse(startTime, timeFormatter);
					eDate = LocalDate.parse(endDate, dateFormatter);
					eTime = LocalTime.parse(endTime, timeFormatter);
					startDateTime = LocalDateTime.of(sDate, sTime);
					endDateTime = LocalDateTime.of(eDate, eTime);
					StaffController.addStudent(username, password, name, matricNum, gender, nationality, yearOfStudy, startDateTime, endDateTime);
					break;
                case 3:
					System.out.print("Enter the course code: ");
					String courseCode = sc.nextLine();
					System.out.print("Enter the course name: ");
					String courseName = sc.nextLine();
					System.out.print("Enter the host school: ");
					String school = sc.nextLine();
					System.out.print("Enter the number of AUs: ");
					int numAUs = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the number of indexes to add: ");
					int numIndex = Integer.parseInt(sc.nextLine());
					ArrayList<Index> indexList = new ArrayList<Index>();
					for (int i = 0; i < numIndex; i++) {
						System.out.print("Enter the index number: ");
						int indexNum = Integer.parseInt(sc.nextLine());
						System.out.print("Enter the maximum capacity for the index: ");
						int maxSize = Integer.parseInt(sc.nextLine());
						System.out.println("Select the course format: ");
						System.out.println("(1) Lecture only ");
						System.out.println("(2) Lecture and Tutorial ");
						System.out.println("(3) Lecture, Tutorial and Lab ");
						int format = Integer.parseInt(sc.nextLine());
						ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
						if (format >= 1) {
							System.out.print("Enter the lecture group ID: ");
							String lecGroupId = sc.nextLine();
							System.out.print("Enter the lecture venue: ");
							String lecVenue = sc.nextLine();
							ArrayList<Timeslot> lecTimes = new ArrayList<Timeslot>();
							System.out.print("Enter the number of lectures per week: ");
							int numLecTimeslots = Integer.parseInt(sc.nextLine());	
							for (int j = 0; j < numLecTimeslots; j++) {
								System.out.print("Enter the lecture day for timeslot " + (j+1) + " (as a number where 1 = Monday, 7 = Sunday): ");
								int lecDay = Integer.parseInt(sc.nextLine());
								System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
								String lecStart = sc.nextLine();
								System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
								String lecEnd = sc.nextLine();
								System.out.println("Select a week format for the lecture: ");
								System.out.println("(1) Odd weeks");
								System.out.println("(2) Even weeks");
								System.out.println("(3) All weeks");
								int chooseWeek = Integer.parseInt(sc.nextLine());
								String lecWeek = null;
								switch (chooseWeek) {
									case 1:
										lecWeek = "o";
										break;
									case 2:
										lecWeek = "e";
										break;
									case 3:
										lecWeek = "a";
										break;
								}	
								LocalTime lecS = LocalTime.parse(lecStart, timeFormatter);
								LocalTime lecE = LocalTime.parse(lecEnd, timeFormatter);
								lecTimes.add(new Timeslot(lecDay, lecS, lecE, lecWeek));
							}
							lessonList.add(new Lesson("Lec", lecVenue, lecGroupId, lecTimes));
						}
						if (format >= 2) {
							System.out.print("Enter the tutorial group ID: ");
							String tutGroupId = sc.nextLine();
							System.out.print("Enter the tutorial venue: ");
							String tutVenue = sc.nextLine();
							ArrayList<Timeslot> tutTimes = new ArrayList<Timeslot>();
							System.out.print("Enter the number of tutorials per week: ");
							int numTutTimeslots = Integer.parseInt(sc.nextLine());	
							for (int j = 0; j < numTutTimeslots; j++) {
								System.out.print("Enter the tutorial day for timeslot " + (j+1) + " (as a number where 1 = Monday, 7 = Sunday): ");
								int tutDay = Integer.parseInt(sc.nextLine());
								System.out.print("Enter the tutorial start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
								String tutStart = sc.nextLine();
								System.out.print("Enter the tutorial end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
								String tutEnd = sc.nextLine();
								System.out.println("Select a week format for the tutorial: ");
								System.out.println("(1) Odd weeks");
								System.out.println("(2) Even weeks");
								System.out.println("(3) All weeks");
								int chooseWeek = Integer.parseInt(sc.nextLine());
								String tutWeek = null;
								switch (chooseWeek) {
									case 1:
										tutWeek = "o";
										break;
									case 2:
										tutWeek = "e";
										break;
									case 3:
										tutWeek = "a";
										break;
								}	
								LocalTime tutS = LocalTime.parse(tutStart, timeFormatter);
								LocalTime tutE = LocalTime.parse(tutEnd, timeFormatter);
								tutTimes.add(new Timeslot(tutDay, tutS, tutE, tutWeek));
							}
							lessonList.add(new Lesson("Tut", tutVenue, tutGroupId, tutTimes));
						}
						if (format >= 3) {
							System.out.print("Enter the lab group ID: ");
							String labGroupId = sc.nextLine();
							System.out.print("Enter the lab venue: ");
							String labVenue = sc.nextLine();
							ArrayList<Timeslot> labTimes = new ArrayList<Timeslot>();
							System.out.print("Enter the number of labs per week: ");
							int numLabTimeslots = Integer.parseInt(sc.nextLine());	
							for (int j = 0; j < numLabTimeslots; j++) {
								System.out.print("Enter the lab day for timeslot " + (j+1) + " (as a number where 1 = Monday, 7 = Sunday): ");
								int labDay = Integer.parseInt(sc.nextLine());
								System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
								String labStart = sc.nextLine();
								System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
								String labEnd = sc.nextLine();
								System.out.println("Select a week format for the lab: ");
								System.out.println("(1) Odd weeks");
								System.out.println("(2) Even weeks");
								System.out.println("(3) All weeks");
								int chooseWeek = Integer.parseInt(sc.nextLine());
								String labWeek = null;
								switch (chooseWeek) {
									case 1:
										labWeek = "o";
										break;
									case 2:
										labWeek = "e";
										break;
									case 3:
										labWeek = "a";
										break;
								}	
								LocalTime labS = LocalTime.parse(labStart, timeFormatter);
								LocalTime labE = LocalTime.parse(labEnd, timeFormatter);
								labTimes.add(new Timeslot(labDay, labS, labE, labWeek));
							}
							lessonList.add(new Lesson("Lab", labVenue, labGroupId, labTimes));
						}
						indexList.add(new Index(indexNum, courseCode, maxSize, lessonList));
					}
					StaffController.addCourse(courseCode, courseName, school, numAUs, indexList);
					break;
				case 4:
					System.out.print("Enter the course code: ");
					courseCode = sc.nextLine();
					System.out.print("Enter the new index number to add: ");
					int newIndexNum = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the maximum capacity for the index: ");
					int maxSize = Integer.parseInt(sc.nextLine());
					System.out.println("Select the course format: ");
					System.out.println("(1) Lecture only ");
					System.out.println("(2) Lecture and Tutorial ");
					System.out.println("(3) Lecture, Tutorial and Lab ");
					int format = Integer.parseInt(sc.nextLine());
					ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
					if (format >= 1) {
						System.out.print("Enter the lecture group ID: ");
						String lecGroupId = sc.nextLine();
						System.out.print("Enter the lecture venue: ");
						String lecVenue = sc.nextLine();
						ArrayList<Timeslot> lecTimes = new ArrayList<Timeslot>();
						System.out.print("Enter the number of lectures per week: ");
						int numLecTimeslots = Integer.parseInt(sc.nextLine());	
						for (int j = 0; j < numLecTimeslots; j++) {
							System.out.print("Enter the lecture day for timeslot " + (j+1) + " (as a number where 1 = Monday, 7 = Sunday): ");
							int lecDay = Integer.parseInt(sc.nextLine());
							System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
							String lecStart = sc.nextLine();
							System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
							String lecEnd = sc.nextLine();
							System.out.println("Select a week format for the lecture: ");
							System.out.println("(1) Odd weeks");
							System.out.println("(2) Even weeks");
							System.out.println("(3) All weeks");
							int chooseWeek = Integer.parseInt(sc.nextLine());
							String lecWeek = null;
							switch (chooseWeek) {
								case 1:
									lecWeek = "o";
									break;
								case 2:
									lecWeek = "e";
									break;
								case 3:
									lecWeek = "a";
									break;
							}	
							LocalTime lecS = LocalTime.parse(lecStart, timeFormatter);
							LocalTime lecE = LocalTime.parse(lecEnd, timeFormatter);
							lecTimes.add(new Timeslot(lecDay, lecS, lecE, lecWeek));
						}
						lessonList.add(new Lesson("Lec", lecVenue, lecGroupId, lecTimes));
					}
					if (format >= 2) {
						System.out.print("Enter the tutorial group ID: ");
						String tutGroupId = sc.nextLine();
						System.out.print("Enter the tutorial venue: ");
						String tutVenue = sc.nextLine();
						ArrayList<Timeslot> tutTimes = new ArrayList<Timeslot>();
						System.out.print("Enter the number of tutorials per week: ");
						int numTutTimeslots = Integer.parseInt(sc.nextLine());	
						for (int j = 0; j < numTutTimeslots; j++) {
							System.out.print("Enter the tutorial day for timeslot " + (j+1) + " (as a number where 1 = Monday, 7 = Sunday): ");
							int tutDay = Integer.parseInt(sc.nextLine());
							System.out.print("Enter the tutorial start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
							String tutStart = sc.nextLine();
							System.out.print("Enter the tutorial end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
							String tutEnd = sc.nextLine();
							System.out.println("Select a week format for the tutorial: ");
							System.out.println("(1) Odd weeks");
							System.out.println("(2) Even weeks");
							System.out.println("(3) All weeks");
							int chooseWeek = Integer.parseInt(sc.nextLine());
							String tutWeek = null;
							switch (chooseWeek) {
								case 1:
									tutWeek = "o";
									break;
								case 2:
									tutWeek = "e";
									break;
								case 3:
									tutWeek = "a";
									break;
							}	
							LocalTime tutS = LocalTime.parse(tutStart, timeFormatter);
							LocalTime tutE = LocalTime.parse(tutEnd, timeFormatter);
							tutTimes.add(new Timeslot(tutDay, tutS, tutE, tutWeek));
						}
						lessonList.add(new Lesson("Tut", tutVenue, tutGroupId, tutTimes));
					}
					if (format >= 3) {
						System.out.print("Enter the lab group ID: ");
						String labGroupId = sc.nextLine();
						System.out.print("Enter the lab venue: ");
						String labVenue = sc.nextLine();
						ArrayList<Timeslot> labTimes = new ArrayList<Timeslot>();
						System.out.print("Enter the number of labs per week: ");
						int numLabTimeslots = Integer.parseInt(sc.nextLine());	
						for (int j = 0; j < numLabTimeslots; j++) {
							System.out.print("Enter the lab day for timeslot " + (j+1) + " (as a number where 1 = Monday, 7 = Sunday): ");
							int labDay = Integer.parseInt(sc.nextLine());
							System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
							String labStart = sc.nextLine();
							System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
							String labEnd = sc.nextLine();
							System.out.println("Select a week format for the lab: ");
							System.out.println("(1) Odd weeks");
							System.out.println("(2) Even weeks");
							System.out.println("(3) All weeks");
							int chooseWeek = Integer.parseInt(sc.nextLine());
							String labWeek = null;
							switch (chooseWeek) {
								case 1:
									labWeek = "o";
									break;
								case 2:
									labWeek = "e";
									break;
								case 3:
									labWeek = "a";
									break;
							}	
							LocalTime labS = LocalTime.parse(labStart, timeFormatter);
							LocalTime labE = LocalTime.parse(labEnd, timeFormatter);
							labTimes.add(new Timeslot(labDay, labS, labE, labWeek));
						}
						lessonList.add(new Lesson("Lab", labVenue, labGroupId, labTimes));
					}
					Index toAdd = new Index(newIndexNum, courseCode, maxSize, lessonList);
					StaffController.addIndex(courseCode, toAdd);
					break;
				case 5:
					System.out.print("Enter the course code: ");
					String oldCourseCode = sc.nextLine();
					StaffController.updateCourse(oldCourseCode);
					break;
                case 6:
					System.out.print("Enter the index number to be checked: ");
					int indexToCheck = Integer.parseInt(sc.nextLine());
					StaffController.printVacancies(indexToCheck);
					break;
                case 7:
					System.out.print("Enter the index number to be searched: ");
					int indexToSearch = Integer.parseInt(sc.nextLine());
					StaffController.printStudentByIndex(indexToSearch);
					break;
				case 8:
					System.out.print("Enter the course code to be searched: ");
					String courseToSearch = sc.nextLine();
					StaffController.printStudentByCourse(courseToSearch);
					break;
				case 9:
					StaffController.printAllCourses();
					break;
				case 10:
                    System.out.println("Quitting program...");
                    break;
                default:
                    System.out.println("Invalid input! Please select a valid choice.");
                    break;
            }
        } while (choice != 10);
    }	
}