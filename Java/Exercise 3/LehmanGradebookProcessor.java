package Exercise_3;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LehmanGradebookProcessor {

	public static void main(String[] args) {
		boolean condition = true;

//		System.out.println();

		try (Scanner sc = new Scanner(new FileReader("myFile1/students.txt"));
				PrintWriter out = new PrintWriter(new File("grades_report.txt"))) {
			while (condition) {
				try {
					String nameStudent = sc.next();
					double average = (Integer.parseInt(sc.next()) + Integer.parseInt(sc.next())
							+ Integer.parseInt(sc.next())) / 3;
					if (average < 60) {
						out.print(("Student: " + nameStudent + " | Average: " + average));
						throw new LowGradeException();
					}
					out.println(("Student: " + nameStudent + " | Average: " + average));

					if (!sc.hasNextLine()) {
						condition = false;
					}
				} catch (InputMismatchException e) {
					System.err.println("Wrong input");
					sc.nextLine();
				} catch (NumberFormatException e) {
					System.err.println("Wrong storage");
					sc.nextLine();
				} catch (LowGradeException e) {
					out.println(" Warning");
				}
			}
		}  catch (Exception e) {
			e.getMessage();
		} finally {
			System.out.println("Processing Complete");
		}

	}

}
