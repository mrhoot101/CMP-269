import pandas as pd
import numpy as np

def get_messy_market_data():
    """Helper function providing the raw data for today's lab."""
    return pd.DataFrame({
        "Date": ["Mon", "Tue", "Wed", "Thu", "Fri"],
        "Open": [200.0, 202.5, np.nan, 201.0, 205.0],
        "Close": [203.0, np.nan, 199.0, 204.5, 208.0],
        "Volume": [1500000, 1800000, 1200000, np.nan, 2100000]
    })

def task_1_data_cleaning():
    """
    TASK 1: Clean the Data
    1. Load the messy data using get_messy_market_data().
    2. Print the number of missing values in each column.
    3. The 'Volume' column is missing Thursday's data. Fill it with a 0.
    4. For the 'Open' and 'Close' columns, drop any row that still has missing data.
    5. Return the cleaned DataFrame.
    """
    print("--- Task 1: Data Cleaning ---")
    df = get_messy_market_data()

    # TODO: Check missing values
    df_missing_values = df.isna().sum()
    print("Number of missing values in each category:")
    print(df_missing_values)

    # TODO: Fill Volume NaNs with 0
    df['Volume'] = df['Volume'].fillna(0)

    # TODO: Drop remaining NaNs
    df_cleaned = df.dropna()

    # TODO: Print and return the cleaned df
    print("\nCleaned DataFrame:")
    print(df_cleaned)
    return (df_cleaned)


def task_2_volatility_filtering(clean_df):
    """
    TASK 2: Filter for Volatility
    1. Accept the clean_df from Task 1.
    2. Create a new column called 'Price_Swing' representing the
       difference between 'Close' and 'Open' (Close - Open).
    3. Filter the DataFrame to only show days where the Price_Swing
       was greater than $2.00 OR less than -$2.00.
    """
    print("\n--- Task 2: Volatility Filtering ---")
    df = clean_df
    # TODO: Calculate Price_Swing
    df['Price_Swing'] = df['Close'] - df['Open']

    # TODO: Apply the multi-condition filter
    df_filltered = df[(df['Price_Swing'] > 2) | (df['Price_Swing'] < -2)]
    print(df_filltered)


def task_3_financial_summary(clean_df):
    """
    TASK 3: Basic Statistics
    1. Accept the clean_df from Task 1.
    2. Use the describe() method on the 'Close' column and print the result.
    3. Manually calculate and print the max 'Volume' for the week.
    """
    print("\n--- Task 3: Financial Summary ---")
    df = clean_df
    # TODO: Print describe() for Close
    print(df['Close'].describe())

    # TODO: Print max Volume
    max_value = df['Volume'].iloc[0]
    for volume in df['Volume']:
        if volume > max_value: max_value = volume

    print("\nMax 'Volume' for the Week:", max_value)





def task_4_algorithmic_metrics(clean_df):
    """
    TASK 4: Moving Averages & Returns
    1. Accept the clean_df from Task 1.
    2. Add a column 'Daily_Return' using pct_change() on the 'Close' column.
    3. Add a column '2_Day_MA' calculating the 2-day rolling mean of the 'Close' column.
    4. Print the final DataFrame.
    """
    print("\n--- Task 4: Algorithmic Metrics ---")
    df = clean_df

    # TODO: Add Daily_Return column
    df['Daily_Return'] = df['Close'].pct_change()

    # TODO: Add 2_Day_MA column
    df['2_Day_MA'] = df['Close'].rolling(2).mean()

    # TODO: Print final DataFrame
    print(df)


if __name__ == "__main__":
    # Uncomment these as you progress

    clean_df = task_1_data_cleaning()

    if clean_df is not None:
        task_2_volatility_filtering(clean_df.copy())
        task_3_financial_summary(clean_df.copy())
        task_4_algorithmic_metrics(clean_df.copy())
