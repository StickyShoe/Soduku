#!/usr/bin/env python
import sys

def main():
    mainSoduko = {}
    emptyPlaces = []
    filledCells = []
    colIndex = 0
    rowIndex = 0 
    inputLine = list(input().strip())
    print(inputLine)
    for rowIndex in range(0,9):
        for colIndex in range(0,9):
            num = inputLine[rowIndex *9 + colIndex]
            index = str(rowIndex) + str(colIndex)
            if (num == "0"):
                mainSoduko[index] = set()
                emptyPlaces.append(index)
            else:
                mainSoduko[index] = {int(num)}
                filledCells.append(index)
    print(mainSoduko)

# def input():

# def generatePossibilities():

# def 


if __name__ == "__main__":
    main()
