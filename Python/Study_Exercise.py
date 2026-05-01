# Exercise 1
class LehmanCourse:
    def __init__(self,course_name, credit):
        self.course_name = course_name
        self.credit = credit
        self._student_count = 0

    def enroll_student(self):
        self._student_count += 1

    def display_info(self):
        print(f"Course Name: {self.course_name} | Number of Credits: {self.credit} | Student Count: {self._student_count}")
# End of class LehmanCourse

# Exercise 2
class LabCourse(LehmanCourse):
    def __init__(self,course_name, credit, lab_fee):
        super().__init__(course_name, credit)
        self.lab_fee = lab_fee

    def display_info(self):
        print(f"Course Name: {self.course_name} | Number of Credits: {self.credit} | Student Count: {self._student_count} | Lab Fee: ${self.lab_fee}")
# End of class LabCourse

# Exercise 3
class Professor():
    def get_role(self):
        return "Teaching and Research"

class Student():
    def get_role(self):
        return "Learning and Coding"

def print_role(person):
    print(person.get_role())

if __name__ == "__main__":
    course_1 = LehmanCourse("CMP 269", 4)
    course_2 = LabCourse("PHY 151", 1, 5)

    for i in range(57):
        if i % 2 == 0:
            course_1.enroll_student()
        else:
            course_2.enroll_student()

    course_1.display_info()
    course_2.display_info()
    print()

    professor = Professor()
    student = Student()

    print_role(professor)
    print_role(student)