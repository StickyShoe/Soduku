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

    # beggining of the generate possibilities method
    # with an extra smidge removing naked singles

    centrePoints = [(1,1),(1,4),(1,7),(4,1),(4,4),(4,7),(7,1),(7,4),(7,7)]
    centreList = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,0),(0,1),(1,-1),(1,0),(1,1)]
    
    for cell in emptyPlaces:

        stagingSet = set()
        xValue, yValue = [cell[0],cell[1]]
        centre = 0

        i = 0
        while centre == 0:
        # for point in centrePoints:  
            point = centrePoints[i]
            a = (int(xValue) - point[0])
            b = (int(yValue) - point[1])
            distance = ((a * a) + (b * b)) ** (0.5)
            if distance <= (2 ** (0.5)):
                centre = point
            i += 1

        for complement in range(0,9):

            rowCheck = xValue + str(complement)
            colCheck = str(complement) + yValue
            blockCheck = str(centre[0] + centreList[complement][0]) + str(centre[1] + centreList[complement][1])
            if rowCheck in filledCells:
                stagingSet = stagingSet.union(mainSoduko[rowCheck])
            if colCheck in filledCells:
                stagingSet = stagingSet.union(mainSoduko[colCheck])
            if blockCheck in filledCells:
                stagingSet = stagingSet.union(mainSoduko[blockCheck])

            if cell == "04":
                print(rowCheck,colCheck,stagingSet)
        
        insertSet = {1,2,3,4,5,6,7,8,9} - stagingSet

        if len(insertSet) == 1:
            emptyPlaces.remove(cell)
            filledCells.append(cell)

        mainSoduko[cell] = insertSet

    
    
    print(mainSoduko)
    print(emptyPlaces)
# def input():

# def generatePossibilities():

# def 


if __name__ == "__main__":
    main()
