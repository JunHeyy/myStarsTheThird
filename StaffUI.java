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
		String matricNum, startDate, startTime, endDate, endTime;
		LocalDate sDate, eDate;
		LocalTime sTime, eTime;
		LocalDateTime startDateTime, endDateTime;

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

			while (true){
				try {
					choice = Integer.parseInt(sc.nextLine());
					break;
				}catch(Exception NumberFormatException) {
					System.out.println("Please enter choice again (1-7) and only integers");
				}

			}

            switch (choice) {
                case 1:
					try{
						System.out.print("Enter the student's matriculation number: ");
						matricNum = sc.nextLine();
						while(matricNum.charAt(0) != 'U' || matricNum.length() != 9 ){
							System.out.println("Matrics number must start with a 'U' and be exactly 9 characters");
							System.out.print("Enter the student's matriculation number again: ");
							matricNum = sc.nextLine();
						}
						System.out.print("Enter the access start date in yyyy-MM-dd format (e.g. 2020-01-30): ");
						startDate = sc.nextLine();
						System.out.print("Enter the access start time in 24hr HH:mm format (e.g. 13:30): ");
						startTime = sc.nextLine();
						System.out.print("Enter the access end date in yyyy-MM-dd format (e.g. 2020-01-30): ");
						endDate = sc.nextLine();
						System.out.print("Enter the access end time in 24hr HH:mm format (e.g. 13:30): ");
						endTime = sc.nextLine();
						sDate = LocalDate.parse(startDate, dateFormatter);
						sTime = LocalTime.parse(startTime, timeFormatter);
						eDate = LocalDate.parse(endDate, dateFormatter);
						eTime = LocalTime.parse(endTime, timeFormatter);
						startDateTime = LocalDateTime.of(sDate, sTime);
						endDateTime = LocalDateTime.of(eDate, eTime);
						StaffController.editStudentAccessPeriod(matricNum, startDateTime, endDateTime);
						break;
					} catch (Exception e){
						System.out.println("Invalid date or time format!");
						break;
					}
                case 2:
					try{
						System.out.print("Enter the student's username: ");
						String username = sc.nextLine();
						System.out.print("Enter the student's password: ");
						String password = sc.nextLine();
						System.out.print("Enter the student's name: ");
						String name = sc.nextLine();
						System.out.print("Enter the student's matriculation number: ");
						matricNum = sc.nextLine();
						while(matricNum.charAt(0) != 'U' || matricNum.length() != 9 ){
							System.out.println("Matrics number must start with a 'U' and be exactly 9 characters");
							System.out.print("Enter the student's matriculation number again: ");
							matricNum = sc.nextLine();
						}
						System.out.print("Enter the student's gender: ");
						char gender = sc.nextLine().charAt(0);
						if (gender!='M' && gender!='m' && gender!='F' && gender!='f'){
							System.out.println("Input gender must be either M or F");
							break;
						}
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
					} catch (NumberFormatException e1){
						System.out.println("Please key in only integers for integer only fields!");
						break;
					} catch (Exception e){
						System.out.println("Invalid date or time format!");
						break;
					}
				case 3:
					try {
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
									while (lecDay <1 || lecDay >7){
										System.out.println("Please enter only (1-7) where 1 = Monday, 7 = Sunday");
										lecDay = Integer.parseInt(sc.nextLine());
									}
									System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String lecStart = sc.nextLine();
									System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String lecEnd = sc.nextLine();
									int chooseWeek;
									String lecWeek = null;
									do {
										System.out.println("Select a week format for the lecture: ");
										System.out.println("(1) Odd weeks");
										System.out.println("(2) Even weeks");
										System.out.println("(3) All weeks");
										chooseWeek = Integer.parseInt(sc.nextLine());
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
											default:
												System.out.println("Please input a valid option!");
												break;
										}
									} while (chooseWeek > 3 && chooseWeek < 1);

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
									while (tutDay <1 || tutDay >7){
										System.out.println("Please enter only (1-7) where 1 = Monday, 7 = Sunday");
										tutDay = Integer.parseInt(sc.nextLine());
									}
									System.out.print("Enter the tutorial start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String tutStart = sc.nextLine();
									System.out.print("Enter the tutorial end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String tutEnd = sc.nextLine();

									int chooseWeek;
									String tutWeek = null;
									do {
										System.out.println("Select a week format for the tutorial: ");
										System.out.println("(1) Odd weeks");
										System.out.println("(2) Even weeks");
										System.out.println("(3) All weeks");
										chooseWeek = Integer.parseInt(sc.nextLine());
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
											default:
												System.out.println("Please input a valid option!");
												break;
										}
									} while (chooseWeek > 3 && chooseWeek < 1);

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
									while (labDay <1 || labDay >7){
										System.out.println("Please enter only (1-7) where 1 = Monday, 7 = Sunday");
										labDay = Integer.parseInt(sc.nextLine());
									}
									System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String labStart = sc.nextLine();
									System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String labEnd = sc.nextLine();

									int chooseWeek;
									String labWeek = null;
									do {
										System.out.println("Select a week format for the lab: ");
										System.out.println("(1) Odd weeks");
										System.out.println("(2) Even weeks");
										System.out.println("(3) All weeks");
										chooseWeek = Integer.parseInt(sc.nextLine());
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
											default:
												System.out.println("Please input a valid option!");
												break;
										}
									} while (chooseWeek > 3 && chooseWeek < 1);
									LocalTime labS = LocalTime.parse(labStart, timeFormatter);
									LocalTime labE = LocalTime.parse(labEnd, timeFormatter);
									labTimes.add(new Timeslot(labDay, labS, labE, labWeek));
								}
								lessonList.add(new Lesson("Lab", labVenue, labGroupId, labTimes));
							}
							indexList.add(new Index(indexNum, courseCode, maxSize, lessonList));
						}
						StaffController.addCourse(courseCode, courseName, school, numAUs, indexList);
					}
					catch(NumberFormatException NumberFormatException){
						System.out.println("Please key in only integers in the index!");
					}
					catch(DateTimeParseException DateTimeParseException){
						System.out.println("Please key in the appropriate format for datetime");
					}
					catch (Exception e) {
						System.out.println("Error in input format!");
					}
					break;

				case 4:
					try {
						ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
						System.out.print("Enter the course code: ");
						String courseCode = sc.nextLine();
						System.out.print("Enter the new index number to add: ");
						int newIndexNum = Integer.parseInt(sc.nextLine());
						System.out.print("Enter the maximum capacity for the index: ");
						int maxSize = Integer.parseInt(sc.nextLine());
						int format;
						do {
							System.out.println("Select the course format: ");
							System.out.println("(1) Lecture only ");
							System.out.println("(2) Lecture and Tutorial ");
							System.out.println("(3) Lecture, Tutorial and Lab ");
							format = Integer.parseInt(sc.nextLine());
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
									while (lecDay <1 || lecDay >7){
										System.out.println("Please enter only (1-7) where 1 = Monday, 7 = Sunday");
										lecDay = Integer.parseInt(sc.nextLine());
									}
									System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String lecStart = sc.nextLine();
									System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String lecEnd = sc.nextLine();
									int chooseWeek;
									String lecWeek = null;
									do {
										System.out.println("Select a week format for the lecture: ");
										System.out.println("(1) Odd weeks");
										System.out.println("(2) Even weeks");
										System.out.println("(3) All weeks");
										chooseWeek = Integer.parseInt(sc.nextLine());
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
											default:
												System.out.println("Please input a valid option!");
												break;
										}
									} while (chooseWeek > 3 && chooseWeek < 1);
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
									while (tutDay <1 || tutDay >7){
										System.out.println("Please enter only (1-7) where 1 = Monday, 7 = Sunday");
										tutDay = Integer.parseInt(sc.nextLine());
									}
									System.out.print("Enter the tutorial start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String tutStart = sc.nextLine();
									System.out.print("Enter the tutorial end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String tutEnd = sc.nextLine();
									int chooseWeek;
									String tutWeek = null;
									do {
										System.out.println("Select a week format for the tutorial: ");
										System.out.println("(1) Odd weeks");
										System.out.println("(2) Even weeks");
										System.out.println("(3) All weeks");
										chooseWeek = Integer.parseInt(sc.nextLine());
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
											default:
												System.out.println("Please input a valid option!");
												break;
										}
									} while (chooseWeek > 3 && chooseWeek < 1);
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
									while (labDay < 1 || labDay > 7){
										System.out.println("Please enter only (1-7) where 1 = Monday, 7 = Sunday");
										labDay = Integer.parseInt(sc.nextLine());
									}
									System.out.print("Enter the lecture start time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String labStart = sc.nextLine();
									System.out.print("Enter the lecture end time for timeslot " + (j+1) + " in 24hr HH:mm format (e.g. 13:30): ");
									String labEnd = sc.nextLine();
									int chooseWeek;
									String labWeek = null;
									do {
										System.out.println("Select a week format for the lab: ");
										System.out.println("(1) Odd weeks");
										System.out.println("(2) Even weeks");
										System.out.println("(3) All weeks");
										chooseWeek = Integer.parseInt(sc.nextLine());
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
											default:
												System.out.println("Please input a valid option!");
												break;
										}
									} while (chooseWeek > 3 && chooseWeek < 1);
									LocalTime labS = LocalTime.parse(labStart, timeFormatter);
									LocalTime labE = LocalTime.parse(labEnd, timeFormatter);
									labTimes.add(new Timeslot(labDay, labS, labE, labWeek));
								}
								lessonList.add(new Lesson("Lab", labVenue, labGroupId, labTimes));
							}
						} while (format > 3 && format < 1);
						Index toAdd = new Index(newIndexNum, courseCode, maxSize, lessonList);
						StaffController.addIndex(courseCode, toAdd);
					}
					catch(NumberFormatException NumberFormatException){
						System.out.println("Please key in only integers in the index!");
					}
					catch(DateTimeParseException DateTimeParseException){
						System.out.println("Please key in the appropriate format for datetime");
					}
					catch (Exception e) {
						System.out.println("Error in input format!");
					}
					break;
				case 5:
					System.out.print("Enter the course code: ");
					String oldCourseCode = sc.nextLine();
					StaffController.updateCourse(oldCourseCode);
					break;
                case 6:
					try{
						System.out.print("Enter the index number to be checked: ");
						int indexToCheck = Integer.parseInt(sc.nextLine());
						StaffController.printVacancies(indexToCheck);
						break;
					} catch (NumberFormatException e){
						System.out.println("Please key in only integers for integer only fields!");
						break;
					}
                case 7:
					try{
						System.out.print("Enter the index number to be searched: ");
						int indexToSearch = Integer.parseInt(sc.nextLine());
						StaffController.printStudentByIndex(indexToSearch);
						break;
					} catch (NumberFormatException e1){
						System.out.println("Please key in only integers for integer only fields!");
						break;
					}
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