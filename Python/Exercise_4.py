import pandas as pd

def task_1_series_creation():
    """
    TASK 1: Create a Series
    1. Create a dictionary mapping 4 Lehman building names to their floor counts.
       (e.g., "Gillet": 4, "Carman": 3, "Music": 3, "Library": 4)
    2. Convert this dictionary into a Pandas Series.
    3. Print the Series.
    """
    print("--- Task 1: Building Series ---")
    lehman_building_floor_count = {"Gillet": 4, "Carman": 3, "Music": 3, "Library": 4}
    lehman_building_series = pd.Series(lehman_building_floor_count)
    print(lehman_building_series)


def task_2_dataframe_creation():
    """
    TASK 2: Create a DataFrame
    1. Create a dictionary of lists containing data for at least 3 courses:
       - 'CourseCode': ['CMP168', 'CMP269', 'CMP338']
       - 'Credits': [4, 4, 4]
       - 'Enrolled': [25, 30, 20]
    2. Convert this into a Pandas DataFrame.
    3. Print the DataFrame.
    """
    print("\n--- Task 2: Course DataFrame ---")
    courses_data = {
        'CourseCode': ['CMP168', 'CMP269', 'CMP338'],
        'Credits': [4, 4, 4],
        'Enrolled': [25, 30, 20]
    }
    courses_df = pd.DataFrame(courses_data)
    print(courses_df)

def task_3_data_manipulation():
    """
    TASK 3: Filtering and Math
    1. Using the same data from Task 2, create the DataFrame here again.
    2. Filter the DataFrame to only show courses with more than 20 students enrolled.
    3. Calculate and print the total number of students across ALL courses (use the .sum() method).
    """
    print("\n--- Task 3: Filtering and Math ---")
    courses_data = {
        'CourseCode': ['CMP168', 'CMP269', 'CMP338'],
        'Credits': [4, 4, 4],
        'Enrolled': [25, 30, 20]
    }
    courses_df = pd.DataFrame(courses_data)
    courses_st_20_plus = courses_df[courses_df['Enrolled'] > 20]
    print(f"Classes with more than 20 students: {courses_st_20_plus}")

    total_number_of_students = courses_df['Enrolled'].sum()
    print(f"\nTotal number of students accorss all courses: {total_number_of_students}")

def task_4_csv_integration():
    """
    TASK 4: The Pandas CSV Advantage
    1. Create a simple DataFrame representing stock data (Symbols and Prices).
    2. Use df.to_csv('stocks.csv', index=False) to save it.
    3. Use pd.read_csv('stocks.csv') to read it back into a new variable called df_loaded.
    4. Print df_loaded to prove it worked!
    """
    print("\n--- Task 4: Easy CSV I/O ---")
    stocks_data = {
        'Data': ['2026-05-07', '2026-05-07', '2026-05-07', '2026-05-07'],
        'Open': [230.8000, 230.6000, 230.6500, 230.7500],
        'High': [230.8200, 230.7900, 230.7300, 230.9000],
        'Low': [230.7000, 230.5300, 230.5390, 230.2910],
        'Close': [230.7100, 230.7900, 230.7300, 230.6500],
        'Volume': [236, 361, 92, 321]
    }
    stocks_data_df = pd.DataFrame(stocks_data)
    stocks_data_cvs = stocks_data_df.to_csv('stocks.csv', index=False)
    df_loaded = pd.read_csv('stocks.csv')
    print(df_loaded)



if __name__ == "__main__":
    # Uncomment these as you work through the assignment
    task_1_series_creation()
    task_2_dataframe_creation()
    task_3_data_manipulation()
    task_4_csv_integration()