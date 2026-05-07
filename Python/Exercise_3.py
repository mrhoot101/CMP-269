import requests
import json
import os

def task_1_append_logger():
    """
    TASK 1: The Persistent Logger
    Goal: Use the 'append' mode to add timestamps to a file.
    Instructions:
    1. Open a file named 'session_log.txt' in append mode ('a').
    2. Prompt the user for a short note.
    3. Write that note to the file on a new line.
    4. Read the entire file and print it to show the history.
    """
    print("--- Task 1: Append Logger ---")
    try:
        note = input("Enter a note for the log: ")
        with open(f"session_log.txt", "a") as file: #Appends info to file
            file.write(f"{note}\n")
        with open(f"session_log.txt", "r") as file: #Read info from file
            for line in file:
                print(line, end="")
    except FileNotFoundError:
        print("Error: session_log.txt not found.")
    except Exception as e:
        print(f"An error occurred: {e}.")

def task_2_word_count_utility():
    """
    TASK 2: The File Analyzer
    Goal: Read a file and perform basic data analysis.
    Instructions:
    1. Create a file 'lehman_motto.txt' with the text:
       "Knowledge is Power. Go Lightning! Python makes data easy."
    2. Read the file and count how many words are in it.
    3. Print the word count.
    """
    print("\n--- Task 2: Word Count Utility ---")
    with open(f"lehman_motto.txt", "r") as file:
        line = file.readline()     # Gets line

        number_of_words = len(line.split()) # Splits the line and counts the items
        print(number_of_words)

def task_3_api_status_checker():
    """
    TASK 3: API Resilience
    Goal: Handle different HTTP status codes.
    Instructions:
    1. Attempt to fetch data from: https://jsonplaceholder.typicode.com/posts/101
    2. (Note: This ID might not exist or return a specific status).
    3. If status is 200, print the data.
    4. If status is 404, print "Error: Post not found."
    5. Use a try-except block to catch network timeout errors.
    """
    print("\n--- Task 3: API Status Checker ---")

    try:
        response = requests.get("https://jsonplaceholder.typicode.com/posts/101")

        if response.status_code == 200:
            data = response.json()
            print(data)
        elif response.status_code == 404:
            print("Error: Post not found.")
        else:
            print("Failed. Status Code:", response.status_code)

    except TimeoutError as t:
        print(f"Timeout error: {t}.")
    except Exception as e:
        print(f"An error occurred: {e}.")

def task_4_data_filtering():
    """
    TASK 4: JSON Data Processing
    Goal: Filter specific info from a JSON response.
    Instructions:
    1. Fetch a list of users from: https://jsonplaceholder.typicode.com/users
    2. Loop through the users and print only the names of users
       who live in a suite (check if 'suite' in the address contains "Suite").
    """
    print("\n--- Task 4: Data Filtering ---")
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/users")
        if response.status_code == 200:
            data = response.json()
            for person in data:
                address = person["address"]
                if "Suite" in address["suite"]: # If it has a Suite number it will print the name
                    print(person["name"])

    except TimeoutError as t:
        print(f"Timeout error: {t}.")
    except Exception as e:
        print(f"An error occurred: {e}.")

def task_5_integration_report():
    """
    TASK 5: The Integration Challenge
    Goal: Fetch API data and save it to a local file.
    Instructions:
    1. Fetch data from: https://jsonplaceholder.typicode.com/posts/1
    2. Extract the 'title' and 'body'.
    3. Save this information into a file named 'api_report.txt' in a
       clean, readable format.
    4. Print "Report Generated" once finished.
    """
    print("\n--- Task 5: Integration Report ---")
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/posts/1")

        if response.status_code == 200:
            data = response.json()

            with open("api_report.txt", "w") as file:
                file.write(f"Title: {data['title']}\n") #Writes the title

                for line in data['body'].split("\n"):
                    file.write("\n"+line.capitalize()) #Writes the body
                # file.write(f"\n\nBody: {data['body']}") #Writes the body
                print(f"Report Generated")

    except TimeoutError as t:
        print(f"Timeout error: {t}.")
    except Exception as e:
        print(f"Error: {e}.")


if __name__ == "__main__":
    # You can uncomment these as you complete them to test your code
    task_1_append_logger()
    task_2_word_count_utility()
    task_3_api_status_checker()
    task_4_data_filtering()
    task_5_integration_report()
