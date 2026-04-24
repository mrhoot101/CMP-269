# Exercise 1: Basics
def exercise_1_basics():
    course = "CMP 269"
    students = 29
    print(f"The course {course} has {students} students")

# Exercise 2 : Collecctions
def exercise_2_collections():
    color = ["green", "red", "blue", 'yelloe', "brown"]
    color.append("pink")
    grade = {
        "name" : "James",
        "gpa" : 3.5
    }
    print(color)
    print(grade["name"], grade["gpa"])

# Exercise 3: Logic
def exercise_3_logic():
    numbers = [1,2,3,4,5,6,7,8,9,10]
    evens = []

    for num in numbers:
        if num % 2 == 0:
            evens.append(num)
    
    print(evens)

name = "  main  "
if name == "  main  ":
    print("\n--- Exerice 1 ---")
    exercise_1_basics()
    print("\n--- Exerice 2 ---")
    exercise_2_collections()
    print("\n--- Exerice 3 ---")
    exercise_3_logic()
