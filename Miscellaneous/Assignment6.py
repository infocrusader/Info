# -*- coding: utf-8 -*-
"""
Created on Sat Dec 21 07:45:58 2019

@author: Sadiq Tijjani
"""

from collections import OrderedDict ##function to be used within the program

read = open("distance_matrix.txt",'r')## readm distance matrix file
dist = [] #into an array

for line in read:
 dist.append(eval(line))## store distances between all variables at end of array
 

for i in dist:## this will print The respective distances from the distance_matrix.txt
 print(i)
 

read2 = open("labels.txt",'r')## read labels text file
labels = []## into an array
for line in read2:
 labels = list(eval(line))##takes an iterable object as input and adds its elements to a newly created list.


print(labels)## this will print Respective Names from the labels.txt file 
o = OrderedDict()## introduncing OrderedDict library function
for i in range(len(labels)):
 o[labels[i]] = dist[i]## equates labels to distance under i variable,in the order they were inserted


alph = ['A','B','C','D','E','F','G'] ##defining list contents

temp = 0

for (a,b) in o.items():## for loop for the list with all dictionary keys with values.
 print(alph[temp],b,a)## This will print The respective row values mapped from the above files in rows

temp += 1

o2 = OrderedDict()## introducing function to use for column part
##for loop in alph
for i in range(len(alph)):
 o2[alph[i]] = list()## takes element and places in a new list
 
for _ in range(len(alph)):
 if i < len(dist[_]):## if i is less than the number of objects in dist
  o2[alph[i]].append(dist[_][i])##appends dist element at the end of alph list under i variable
 

for s,t in o2.items():
 print(s,t)## This will print "The respective column values mapped from the column part