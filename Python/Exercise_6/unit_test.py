import pytest

def identify_trend(price1, price2):
    if (price1 < price2):
        return "Bull up"
    elif (price1 > price2):
        return "Bear down"
    else:
        return "Flat price"

def test_positive_trend():
    assert identify_trend(40000, 42000) == "Bull up"

def test_negative_trend():
    assert identify_trend(45000, 44000) == "Bear down"

def test_no_change():
    assert identify_trend(0, 0) == "Flat price"