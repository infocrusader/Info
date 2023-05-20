# -*- coding: utf-8 -*-
"""
Created on Sat Dec 14 19:44:17 2019

@author: Sadiq Tijjani
"""

import pandas as pd #introducing library function for reading files

read = pd.read_csv("distance_matrix.txt", sep="\n", header= None) #Read distance matrix file

read2 = pd.read_csv("labels.txt", sep=",", header= None) #Read labels file

def method(read,read2):#Using read and read2 to create method
    #Below we will get the values from distance matrix file with constant row value and changing column value
    arrange = [read[0][0], read[0][1], read[0][2], read[0][3], read[0][4], read[0][5], read[0][6]]
    
    for i in range(len(arrange)):
        #The for loop will replace commas and brackets for quotation marks
        arrange[i] = arrange[i].replace(',', "")
        
        arrange[i] = arrange[i].replace('[', "")
        
        arrange[i] = arrange[i].replace(']', "")
    #we get the values for constant column variable and changing row variable
    conform = [read2[0][0], read2[1][0], read2[2][0], read2[3][0], read2[4][0], read2[5][0], read2[6][0]]
    
    for i in range(len(conform)):
        #The for loop given the i variable is equal to 0 will replace bracket with quotation marks
        if (i == 0):
            conform[i] = conform[i].replace('(', "")
          #given that i is equal to the last number in the conform variable replace ) and ' '' ' 
        if (i == len(conform) - 1):
            conform[i] = conform[i].replace(')', "")
            conform[i] = conform[i].replace('"', "")
             #Generate values up to 7 and then initiate for loop
    matrixer = [[0 for t in range(7)] for o in range(7)]
    
    fillin = [[" "], [" "," "], [" "," "," "], [" "," "," "," "], [" "," "," "," "," "], [" "," "," "," "," "," "]]

    for i in range(7):
        if (i == 6):#equating matrix array values to arrange and conform values through for loop
            matrixer[i] = arrange[i], conform[i]
        else:
            matrixer[i] = arrange[i], fillin[5 - i], conform[i]# cases when i is not equal to six, this will fill in the spaces

    for i in range(len(matrixer)):
        #removing all the [] , () and ' '' '
        matrixer[i] = str(matrixer[i]).replace('[',"").replace('(',"").replace(')',"").replace(']',"").replace(',',"").replace("'","")
        
        print(matrixer[i])#To display in console

method(read,read2)# invokes method to be run!