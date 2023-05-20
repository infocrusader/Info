# -*- coding: utf-8 -*-
"""
Created on Tue Mar 10 12:03:25 2020

@author: Sadiq Tijjani
"""
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix

def importdata(): 
              balance_data=pd.read_csv("Pokemon-yourtraining2.csv",sep= ",", header = None)
              print(len(balance_data))
              print(balance_data.shape)
              print(balance_data.head())
              return balance_data
          
def splitdataset(balance_data):
              x=balance_data.values[:,1:5]
              y=balance_data.values[:,0]
              x_train,x_test,y_train,y_test=train_test_split(
                  x,y,test_size=0.3,random_state=100)
              return x,y,x_train,x_test,y_train,y_test
          
def train_using_gini(x_train,x_test,y_train): 
              clf_gini = DecisionTreeClassifier(criterion = "gini",
              random_state = 100,max_depth=3, min_samples_leaf=5)
              clf_gini.fit(x_train,y_train)
              return clf_gini
          
def train_using_entropy(x_train,x_test,y_train): 
              clf_entropy=DecisionTreeClassifier(
              criterion = "entropy", random_state = 100,
              max_depth = 3, min_samples_leaf = 5)
              clf_entropy.fit(x_train,y_train)
              return clf_entropy
          
def prediction(x_test,clf_object):
              y_pred=clf_object.predict(x_test)
              print(f"Predicted values: {y_pred}")
              return y_pred
          
def cal_accuracy(y_test,y_pred):
              print(confusion_matrix(y_test,y_pred))
              print(accuracy_score(y_test,y_pred)*100)
              print(classification_report(y_test,y_pred))
              
data=importdata()


x,y,x_train,x_test,y_train,y_test=splitdataset(data)

clf_gini=train_using_gini(x_train,x_test,y_train)

clf_entropy=train_using_entropy(x_train,x_test,y_train)

y_pred_gini=prediction(x_test,clf_gini)
    
    
y_pred_entropy=prediction(x_test,clf_entropy)
    
    
cal_accuracy(y_test,y_pred_entropy)