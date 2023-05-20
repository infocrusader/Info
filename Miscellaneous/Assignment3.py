# -*- coding: utf-8 -*-
"""
Created on Sun Apr 19 15:10:51 2020

@author: Sadiq Tijjani

"""


import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, f1_score
from sklearn.linear_model import LogisticRegression
from sklearn.utils import resample

#Load Dataset
haberman = pd.read_csv("haberman.csv")

column_names = ['Age', 'Year', 'Positive_Axillary_Nodes', 'Survival_Status']

haberman.columns = column_names

haberman.head()

r = haberman.shape
print("datapoints in the datset:",r[0])

print("features in the dataset:",r[1]-1)

r1 = haberman.columns
print("The features are:{},{} and {}".format(r1[0],r1[1],r1[2]))

r2 = haberman["Survival_Status"].value_counts()
print("The classes are:\n",r2)

#As we can see from the dataset analysis

    #The total number of rows in the dataset is 306.

   ## features in the dataset is 3(apart from class attribute).

    ##The features are: (i) Year_operation: The year in which the person was operated. (ii) Age_operation: The age of the person when he/she was operated. (iii) Axillary_nodes: Number of positive axillary nodes detected.

    ##There are 2 classes in the dataset are: (i)survived 5years or more from the date of operation. (ii)died within 5years from the date of operation.
    ##Survival status (class attribute)
##— 1 = the patient survived 5 years or longer
##— 2 = the patient died within 5 years
    #The class "Ptient survived 5 years or Longer" contains 224 datapoints and the class "Patient died within 5years" contains 81 datapoints.

    #By observing the ratio of number of datapoints between both of the classes, we conclude that Habermans Survival dataset is an Imbalanced dataset



y = haberman.Survival_Status

X = haberman.drop('Survival_Status', axis=1)

# setting up testing and training sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=27)

lr = LogisticRegression(solver='liblinear').fit(X_train, y_train)
 
# Prediction for training set
lr_pred = lr.predict(X_test)

# Checking accuracy
I = accuracy_score(y_test, lr_pred)
print("The old Acuuracy score  is:\n",I)    

# CVerifying unique values
predictions = pd.DataFrame(lr_pred)


predictions[0].value_counts()

# f1 score
J = f1_score(y_test, lr_pred)
print("The Old f1 score is:\n",J)

##Now i will use the Oversample technique
X2 = pd.concat([X_train, y_train], axis=1)

# separate minority and majority classes
surv5 = X2[X2.Survival_Status==1]
not_surv = X2[X2.Survival_Status==2]

# upsample minority
space_upsampled = resample(not_surv,replace=True, n_samples=len(surv5), random_state=27) 

# combine majority and upsampled minority
upsampled = pd.concat([surv5, space_upsampled])

# checkthe new class counts
upsampled.Survival_Status.value_counts()

y2_train = upsampled.Survival_Status
X2_train = upsampled.drop('Survival_Status', axis=1)

upsampled = LogisticRegression(solver='liblinear').fit(X2_train, y2_train)## RE-applying logistic regression

upsampled_pred = upsampled.predict(X_test)

F = accuracy_score(y_test, upsampled_pred)
    

G = f1_score(y_test, upsampled_pred)

print("The new Accuracy score is:\n",F)
print("The new f1 Score is:\n",G)


