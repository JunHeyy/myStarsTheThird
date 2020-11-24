import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ConcurrentModificationException;  

/**
 * Control class to handle all student related function.
 */
public class StudentController {
	
	Student student;
	String courseCode;
	int indexNum;

	/**
	 * register a course for the student - Call the function by passing in String matrics number and Int index
	 * @param s 						Student that the Course is to be registered to.
	 * @param newIndex 					Index to be registered; must belong to the Course to be registered.
	 * @param courseCode				Course code of the Course to be registered; Index to be registered must belong to this Course.
	 * @throws ClassNotFoundException	if mentioned classes are not found in the classpath.
	 * @throws IOException				if file cannot be read in.
	 * @throws FileNotFoundException	if file does not exist.
	 */
	public static Student addCourse(Student s, int newIndex, String courseCode) throws ClassNotFoundException, IOException, FileNotFoundException {

		ArrayList<Course> courseList = CourseManager.extractDB();
		ArrayList<Student> studentList = StudentManager.extractDB();
		Course courseToAdd = null;
		Index indexToAdd = null;

		for (Course c: courseList) {
			if (c.getCourseCode().equals(courseCode)) {
				courseToAdd = c;
			} 
		}
		if(courseToAdd ==null){
			System.out.println("The Course that you want does not exist");
			return s;
		}


		for (Index i : courseToAdd.getIndexList()) {
			if (i.getIndexNum().equals(newIndex)) {
				indexToAdd = i;
			}
		}
		if(courseToAdd  == null || indexToAdd == null){
			System.out.println("The Course/Index that you want to add does not exist");
			return s;
		}


		boolean toRegister = true;
		if (s.getRegisteredIndex().contains(indexToAdd)) {
			System.out.println("Course is already registered.");	
			toRegister = false;
		}
		else {
			ArrayList<Timeslot> toCheck = new ArrayList<Timeslot>();
			for (Index i: s.getRegisteredIndex()) {
				for (Lesson l: i.getLessons()) {
					for (Timeslot t: l.getTimeslots()) {
						if (t.getWeeks().equals("o") || t.getWeeks().equals("a")) {
							toCheck.add(t);
						}
						if (t.getWeeks().equals("e") || t.getWeeks().equals("a")) {
							toCheck.add(t);
						}
					}
				}
			}
			for (Lesson l2: indexToAdd.getLessons()) {
				for (Timeslot t2: l2.getTimeslots()) {
					if (toCheck.contains(t2)) {
						System.out.println("Course cannot be registered due to timetable clash.");
						toRegister = false;
					}
				}
			}
		}
		if (toRegister) {
			if (hasVacancies(newIndex)) {
				//Add new course into Index
				for (Student s3: studentList) {
					if (s3.equals(s)) {
						ArrayList<Index> registeredIndex = s3.getRegisteredIndex();
						System.out.println("Adding new index with index number " + indexToAdd.getIndexNum() + " With course code " + indexToAdd.getCourseCode());
						registeredIndex.add(indexToAdd);
						System.out.println("Course " + courseCode + " has been successfully added.");
						StudentManager.updateStudentDB(studentList);
					}
				}
				CourseManager.slotTaken(indexToAdd.getIndexNum(), indexToAdd.getCourseCode());
			}
			else {
				studentList = StudentManager.extractDB();
				Student waitStudent = null;
				for (Student s3: studentList) {
					if (s3.equals(s)) {
						System.out.println("You will be added to wait list since there are no vacancies");
						ArrayList<Index> waitIndex = s3.getWaitIndex();
						waitIndex.add(indexToAdd);
						s3.setWaitIndex(waitIndex);
						waitStudent = s3;
						StudentManager.updateStudentDB(studentList);
						break;
					}
				}

				// ArrayList<Index> waitIndex = waitStudent.getWaitIndex();
				// waitIndex.add(indexToAdd);

				courseList = CourseManager.extractDB();
				outer:
				for (Course c: courseList) {
					for (Index i3: c.getIndexList()) {
						if (i3.getIndexNum() == newIndex) {
							LinkedList<Student> indexWaitlist = i3.getWaitlist();
							indexWaitlist.add(waitStudent);
							// i3.setWaitlist(indexWaitlist);
							CourseManager.UpdateDB(courseList);
							break outer;
						}
					}
				}
			}
		}
		Student s2 = StudentManager.getStudent(s.getUsername());
		printCourseRegistered(s2);
		return s2;
	}
	
	/**
	 * Drop a course registered by the student - Call the function by passing in String matric number and String course code
	 * @param s									Student to remove Course from.
	 * @param courseCode 						Course code of the Course to be removed.
	 * @throws ClassNotFoundException			if mentioned classes are not found in the classpath.
	 * @throws IOException						if file cannot be read in.
	 * @throws ConcurrentModificationException	if multiple values of an ArrayList are being modified concurrently.
	 */
	public static Student removeCourse(Student s, String courseCode) throws ClassNotFoundException, IOException, ConcurrentModificationException {
		
		ArrayList<Student> studentList = StudentManager.extractDB();
		
		boolean removed = false;
		Index toDelete = null;

		ArrayList<Index> registeredIndex = s.getRegisteredIndex();
		for (Index i : registeredIndex) {
			if(i.getCourseCode().equals(courseCode)) {
				toDelete = i;
				CourseManager.slotGivenBack(toDelete.getIndexNum(), toDelete.getCourseCode());
				System.out.println("Course " + courseCode + " has been successfully removed.");
				removed = true;
				break;
			}
		}
		if (toDelete != null) {
			// System.out.println("Remove from student");
			for (Student s3: studentList) {
				if (s3.equals(s)) {
					registeredIndex = s3.getRegisteredIndex();
					registeredIndex.remove(toDelete);
					StudentManager.updateStudentDB(studentList);
				}
			}
		}
		if (!removed) {
			ArrayList<Index> waitIndex = s.getWaitIndex();
			for (Index i: waitIndex) {
				if (i.getCourseCode().equals(courseCode)) {
					toDelete = i;
					removed = true;
					break;
				}
			}
			if (toDelete != null) {
				System.out.println("Remove from student");
				for (Student s3: studentList) {
					if (s3.equals(s)) {
						waitIndex = s3.getWaitIndex();
						waitIndex.remove(toDelete);
						printCourseRegistered(s3);
						StudentManager.updateStudentDB(studentList);
						return s3;
					}
				}
			}
		}
		studentList = StudentManager.extractDB();
		outerloop:
		for (Course c: CourseManager.extractDB()) {
			for (Index i: c.getIndexList()) {
				if (c.getCourseCode().equals(courseCode) && i.getIndexNum().equals(toDelete.getIndexNum())) {
					LinkedList<Student> waitlist = i.getWaitlist();
					if (!waitlist.isEmpty()) {
						toDelete = i;
						Student toRegister = waitlist.remove();
						for (Student s4: studentList) {
							if (s4.equals(toRegister)) {
								Index toRemove = null;
								ArrayList<Index> removeWaitIndex = s4.getWaitIndex();
								for (Index i2: removeWaitIndex) {
									if (i2.equals(toDelete)) {
										toRemove = i2;
										break;
									}
								}
								removeWaitIndex.remove(toRemove);
								StudentManager.updateStudentDB(studentList);
								StudentManager.extractDB();
								ArrayList<Index> toRegisterIndex = s4.getRegisteredIndex();
								toRegisterIndex.add(i);
								StudentManager.updateStudentDB(studentList);
								CourseManager.slotTaken(i.getIndexNum(), i.getCourseCode());
								MailManager.sendFromGMail("from_email","password","to_email","Congratulations!",
									"Off waitlist. Now registered for " + i.getCourseCode());
								break;
							}
						}
					}
					else {
						System.out.println("No one on waitlist");
					}
					break outerloop;
				}
			}
		}
		if (!removed) System.out.println("Course is not registered!");
		Student s2 = StudentManager.getStudent(s.getUsername());
		printCourseRegistered(s2);
		return s2;
	}
	
	/**
	 * Print all the course that is registered by the student - Call the function by passing in String Matrics number
	 * @param s 						Student whose Course list is to be printed.
	 * @throws ClassNotFoundException	if mentioned classes are not found in the classpath.
	 * @throws IOException				if file cannot be read in.
	 */
	public static void printCourseRegistered(Student s) throws ClassNotFoundException, IOException { 
		ArrayList<Course> courseList = CourseManager.extractDB();
		System.out.println("+-------------+-----------------------------------------------+-----+--------------+-------------+");
		System.out.println("| Course Code | Course Name                                   | AUs | Index Number | Status      |");
		System.out.println("+-------------+-----------------------------------------------+-----+--------------+-------------+");
		for (Index i: s.getRegisteredIndex()) {
			for (Course c: courseList) {
				if (c.getCourseCode().equals(i.getCourseCode())) {
					System.out.printf("| %-11s | %-45s | %-3d | %-12d | Registered  |\n", i.getCourseCode(), c.getCourseName(), c.getNumAUs(), i.getIndexNum());
				}
			}
		}
		for (Index i: s.getWaitIndex()) {
			for (Course c: courseList) {
				if (c.getCourseCode().equals(i.getCourseCode())) {
					System.out.printf("| %-11s | %-45s | %-3d | %-12d | Waitlist    |\n", i.getCourseCode(), c.getCourseName(), c.getNumAUs(), i.getIndexNum());
				}
			}
		}
		System.out.println("+-------------+-----------------------------------------------+-----+--------------+-------------+");

	}
		
	/**
	 * Change an existing index with another index. Old and new Index must belong to the same Course to be swapped.
	 * @param s 								Student who is swapping Indexes.
	 * @param newIndex							New Index, must belong to same Course as old Index.
	 * @param courseCode 						Course code of both old and new Indexes.
	 * @throws ClassNotFoundException			if mentioned classes are not found in the classpath.
	 * @throws IOException						if file cannot be read in.
	 * @throws ConcurrentModificationException	if multiple values of an ArrayList are being modified concurrently.
	 */
	public static Student changeAvailableIndex(Student s, int newIndex, String courseCode) throws ClassNotFoundException, IOException, ConcurrentModificationException { //tested

		ArrayList<Course> courseList = CourseManager.extractDB();
		ArrayList<Student> studentList = StudentManager.extractDB();

		boolean removed = false;
		Index toDelete = null;
		Course courseToAdd = null;
		Index indexToAdd = null;

		for (Course c: courseList) {
			if (c.getCourseCode().equals(courseCode)) {
				courseToAdd = c;
			} 
		}
		if(courseToAdd == null){
			System.out.println("Course does not exist!");
			return s;
		}

		for (Index i: courseToAdd.getIndexList()) {
			if (i.getIndexNum().equals(newIndex)) {
				indexToAdd =  i;
			}
		}
		if(indexToAdd == null){
			System.out.println("Index does not exist!");
			return s;
		}
		boolean toRegister = true;
		if (checkVacanciesForIndex(newIndex) > 0) {
			ArrayList<Timeslot> toCheck = new ArrayList<Timeslot>();
			for (Index i: s.getRegisteredIndex()) {
				if (i.getIndexNum() == indexToAdd.getIndexNum()) {
					System.out.println("Index is already registered.");	
					toRegister = false;
					return s;
				}
				if (i.getCourseCode().contains(courseCode)) {
					toDelete = i;
					toRegister = true;
					break;
				}
				System.out.println("Error!");
				System.out.println("Course " + courseCode + " registered under a different index or course is in the wait list.");
				toRegister = false;
				return s;
			}
			if(toDelete ==null ) System.out.println("You cannot change Courses that you are not registered for!");
			for (Index i: s.getRegisteredIndex()) {	
				if (!i.equals(toDelete)) {
					for (Lesson l: i.getLessons()) {
						for (Timeslot t: l.getTimeslots()) {
							if (t.getWeeks().equals("o") || t.getWeeks().equals("a")) {
								toCheck.add(t);
							}
							if (t.getWeeks().equals("e") || t.getWeeks().equals("a")) {
								toCheck.add(t);
							}
						}
					}
				}
			}
			for (Lesson l2: indexToAdd.getLessons()) {
				for (Timeslot t2: l2.getTimeslots()) {
					if (toCheck.contains(t2)) {
						System.out.println("Index cannot be changed due to timetable clash.");
						toRegister = false;
						return s;
					}
				}
			}
			
			if (toRegister) {
				ArrayList<Index> registeredIndex = s.getRegisteredIndex();
				for(Index i : registeredIndex) {
					if(i.getCourseCode().equals(courseCode)) {
						toDelete = i;
						CourseManager.slotGivenBack(toDelete.getIndexNum(), toDelete.getCourseCode());
						// System.out.println("Course " + courseCode + " has been successfully removed");
						removed = true;
					}
				}
				
				if (!removed) return s;	

				if (toDelete != null) {
					// System.out.println("Remove from student");
					for (Student s3: studentList) {
						if (s3.equals(s)) {
							registeredIndex = s3.getRegisteredIndex();
							registeredIndex.remove(toDelete);
							StudentManager.updateStudentDB(studentList);
						}
					}
				}				//Add new course into Index
				for (Student s3: studentList) {
					if (s3.equals(s)) {
						registeredIndex = s3.getRegisteredIndex();
						registeredIndex.add(indexToAdd);
						System.out.println("Index has been successfully changed.");
						StudentManager.updateStudentDB(studentList);
					}
				}
				CourseManager.slotTaken(indexToAdd.getIndexNum(), indexToAdd.getCourseCode());
			}
		}
		else {
			System.out.println("Index selected has no more vacancies.");
		}
		Student s2 = StudentManager.getStudent(s.getUsername());
		printCourseRegistered(s2);
		return s2;		
	}
    
	/**
	 * swap an index with another student - Call the function by passing in String own matric number, Int own index, Int peer index, String peer matric number and String peer password
	 * @param s 						Student initiating the swap.
	 * @param ownIndex 					Index of Course to be swapped from initiator to peer.
	 * @param peerIndex 				Index of Course to be swapped from peer to initiator.
	 * @param peerMatricNum 			Matriculation number of the other Student (peer).
	 * @param peerPw 					Raw password (unhashed) of the other Student (peer).
	 * @throws ClassNotFoundException	if mentioned classes are not found in the classpath.
	 * @throws IOException				if file cannot be read in.
	 */
	public static Student swapIndex(Student s, int ownIndex, int peerIndex, String peerMatricNum, String peerPw) throws ClassNotFoundException, IOException {

		Student currUser = s;
		ArrayList<Student> studentList = StudentManager.extractDB();
		if (s.getMatricNum().equals(peerMatricNum)) {
			System.out.println("Can't swap index with yourself!");
			return s;
		}
		for (Student s2: studentList) {
			for (Student p : studentList) {
				if(s2.equals(s) && p.getMatricNum().equals(peerMatricNum)) {
					if (p.getPassword().equals(Hashing.hashPassword(peerPw))) {
						ArrayList<Index> indexList1 = s2.getRegisteredIndex();
						ArrayList<Index> indexList2 = p.getRegisteredIndex();	
						boolean swapped = false;
						out:
						for (Index own: s2.getRegisteredIndex()) {
							for (Index peer: p.getRegisteredIndex()) {
								if (own.getIndexNum().equals(ownIndex) && peer.getIndexNum().equals(peerIndex) && own.getCourseCode().equals(peer.getCourseCode())) {									
									indexList1.remove(own);
									indexList2.remove(peer);
									indexList1.add(peer);
									indexList2.add(own);
									swapped = true;
									System.out.println("Indexes have been successfully swapped.");
									StudentManager.updateStudentDB(studentList);
									currUser = s2;
									break out;
								}
							}
						}
						if (!swapped) {
							System.out.println("You have attempted to swap different courses or swap courses in the waiting list!");
							return currUser;	
						}
					}
					else {
						System.out.println("Incorrect password.");
						return currUser;
					}
				}
			}		
		}	
		studentList = StudentManager.extractDB();
		for (Student s2: studentList) {
			if (s2.equals(s)) {
				currUser = s2;
			}
		}
		printCourseRegistered(currUser);
		return currUser;
	}
	
	/**
	 * Check for the number of vacancies in an Index.
	 * @param indexNum Index to be checked.
	 * @return the number of vacancies remaining for the Index.
	 * @throws ClassNotFoundException	if mentioned classes are not found in the classpath.
	 * @throws IOException				if file cannot be read in.
	 */
	public static int checkVacanciesForIndex(int indexNum) throws ClassNotFoundException, IOException {
        ArrayList<Course> courseList = CourseManager.extractDB();
        for (Course c: courseList) {
        	ArrayList<Index> indexList = c.getIndexList();
            for(Index i: indexList) {
                if(i.getIndexNum() == indexNum) {
                    int vacancies = i.getMaxSize() - i.getNumStudents();

                    return vacancies;
                }
            }
		}
		return 0;
	}

	/**
	 * Print number of vacancies remaining for the selected Index.
	 * @param indexNum Index to print vacancies for.
	 * @throws ClassNotFoundException	if mentioned classes are not found in the classpath.
	 * @throws IOException				if file cannot be read in.
	 */
	public static void printVacancies(int indexNum) throws ClassNotFoundException, IOException {
		String courseCode = null;
		String courseName = null;
		Index indexToPrint = null;
		ArrayList<Course> courseList = CourseManager.extractDB();
		for (Course c: courseList) {
			for (Index i: c.getIndexList()) {
				if (i.getIndexNum() == indexNum) {
					courseCode = i.getCourseCode();
					indexToPrint = i;
					courseName = c.getCourseName();
					break;
				}
			}
		}
		int vacancies = checkVacanciesForIndex(indexNum);
		if(indexToPrint == null) System.out.println("Index does not exist!");
		else {
			System.out.println("+-------------+-----------------------------------------------+--------------+-----------+");
			System.out.println("| Course Code | Course Name                                   | Index Number | Vacancies |");
			System.out.println("+-------------+-----------------------------------------------+--------------+-----------+");
			System.out.printf("| %-11s | %-45s | %-12s |  %d/%-6d |\n", courseCode, courseName, indexNum, vacancies, indexToPrint.getMaxSize());
			System.out.println("+-------------+-----------------------------------------------+--------------+-----------+");
		}
	}

	/**
	 * Check if there are vacancies remaining for the a selected Index.
	 * @param indexNum Index to be checked.
	 * @return whether there are vacancies remaining for this Index (boolean)
	 * @throws ClassNotFoundException	if mentioned classes are not found in the classpath.
	 * @throws IOException				if file cannot be read in.
	 */
	public static boolean hasVacancies(int indexNum) throws ClassNotFoundException, IOException {
		return checkVacanciesForIndex(indexNum) > 0 ? true : false;
	}
	
	// public static boolean checkCourseRegistered(String matricNum, String courseCode) throws ClassNotFoundException, IOException {
	// 	ArrayList <Student> studentList = StudentManager.extractDB();
	// 	for(Student s : studentList){
	// 		if(s.getMatricNum().equals(matricNum)) {
	// 			for(Integer i : s.getRegisteredIndex()) {
	// 				if(IndexToCourseCode(i).equals(courseCode)){
	// 					System.out.println("Coursecode already registered");
	// 					return false;
	// 				}
	// 			}
	// 		}
	// 	} return true;
	// }
	
	// public void checkVacancies(int indexNum) throws ClassNotFoundException, IOException {
	// 	ArrayList<Course> courseList = CourseManager.extractDB();
	// 	for (Course c : courseList) {
	// 		ArrayList<Index> indexList = c.getIndexList();
	// 		for(Index i :indexList) {
	// 			if(i.getIndexNum() == indexNum) {
	// 				int vacancies = i.getMaxSize() - i.getNumStudents();
	// 				System.out.printf("Vacancies left %d for Course Index: %s\n", vacancies, indexNum);
	// 				break;
	// 			}
	// 		}
	// 	}
	// }
	
	// private static String IndexToCourseCode(int IndexNum) {
		
	// 	ArrayList<Course> courseList = CourseManager.extractDB();
	// 	for(Course c: courseList) {
	// 		for(Index i : c.getIndexList()) {
	// 			if(i.getIndexNum() == IndexNum) {
	// 				return i.getCourseCode();
	// 			}
	// 		}
	// 	}
	// 	return "CourseCode not found";
	// }
}