import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

def get_crypto_data():
    """Helper function to load mock crypto data."""
    return pd.DataFrame({
        "Day": [1, 2, 3, 4, 5, 6, 7],
        "Bitcoin": [40000, 42000, 41000, 45000, 44000, 46000, 48000],
        "Ethereum": [2500, 2600, 2550, 2800, 2750, 2900, 3100]
    })

def task_1_trend_line():
    """
    TASK 1: Matplotlib Line Chart
    1. Load the data using get_crypto_data().
    2. Use plt.plot() to chart Bitcoin prices over the 7 days.
    3. Add a title, x-axis label, and y-axis label.
    4. Call plt.show() to render it.
    """
    print("--- Task 1: Building a Trend Line ---")
    df = get_crypto_data()
    plt.plot(df['Day'], df['Bitcoin'], marker='o', color='red', linestyle='--')
    plt.title('Bitcoin Prices Trend')
    plt.xlabel('Day')
    plt.ylabel('Bitcoin Price')
    plt.show()


def task_2_seaborn_comparison():
    """
    TASK 2: Seaborn Bar Chart
    1. Create a simple DataFrame mapping 3 portfolios to their Total Value.
       (e.g., 'Portfolio A': 10000, 'Portfolio B': 15000, 'Portfolio C': 8000)
    2. Use sns.barplot() to display the comparison.
    3. Call plt.show() to render it.
    """
    print("--- Task 2: Seaborn Comparison ---")
    data = {
        'Portfolios': ['Portfolio A', 'Portfolio B', 'Portfolio C'],
        'Total Value': [10000, 15000, 8000]
    }
    df = pd.DataFrame(data)

    plt.figure(figsize = (8,4))
    sns.barplot(df, x='Portfolios', y='Total Value', hue='Total Value', legend=False)
    plt.title('Portfolio Comparison')
    plt.show()


if __name__ == "__main__":
    # Uncomment to test visuals during development
    task_1_trend_line()
    task_2_seaborn_comparison()
