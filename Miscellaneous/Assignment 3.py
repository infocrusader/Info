# -*- coding: utf-8 -*-
"""
Created on Sun Apr  5 16:06:46 2020

@author: Sadiq Tijjani
"""



  
import warnings
warnings.filterwarnings("ignore")
    
    # loading the libraries
from sklearn import decomposition, datasets
from sklearn import tree
from sklearn.pipeline import Pipeline
from sklearn.model_selection import GridSearchCV, cross_val_score
from sklearn.preprocessing import StandardScaler
    
    # Loading the iris dataset
dataset = datasets.load_iris()
X = dataset.data
y = dataset.target
    
    # Create an scaler object
sc = StandardScaler()
    
    # Create a pca object
pca = decomposition.PCA()
    
    # Creating a logistic regression object
decisiontree = tree.DecisionTreeClassifier()
    
    # Create a pipeline of three steps. First, standardize the data.
    # Second, tranform the data with PCA.
    # Third, train a Decision Tree Classifier on the data.
pipe = Pipeline(steps=[('sc', sc),('pca', pca),('decisiontree', decisiontree)])
    
    
    # Creating a list of integers from 1 to 30
n_components = list(range(1,X.shape[1]+1,1))
    
    # Create lists of parameter for Decision Tree Classifier
criterion = ['gini', 'entropy']
max_depth = [4,6,8,12]
    
    # Create a dictionary of all the parameter options 
    
parameters = dict(pca__n_components=n_components, decisiontree__criterion=criterion,decisiontree__max_depth=max_depth)
    
    
    # Creating a grid search object
clf = GridSearchCV(pipe, parameters)
    
   
clf.fit(X, y)
    
    # View The Best Parameters
print('Best Criterion:', clf.best_estimator_.get_params()['decisiontree__criterion'])
print('Best max_depth:', clf.best_estimator_.get_params()['decisiontree__max_depth'])
print('Best Number Of Components:', clf.best_estimator_.get_params()['pca__n_components'])
print(); print(clf.best_estimator_.get_params()['decisiontree'])
    
    # Use Cross Validation To Evaluate Model
CV_Result = cross_val_score(clf, X, y, cv=4, n_jobs=-1)
print(); print(CV_Result)
print(); print(CV_Result.mean())
print(); print(CV_Result.std())    
