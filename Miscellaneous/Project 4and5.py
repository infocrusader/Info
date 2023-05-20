# -*- coding: utf-8 -*-
"""
Created on Sun Apr 26 11:22:35 2020

@author: Sadiq Tijjani
"""

from sklearn.datasets import load_boston
import matplotlib.pyplot as plt
import pandas as pd
from sklearn import metrics
from sklearn import model_selection
from sklearn.tree import DecisionTreeRegressor
from sklearn.model_selection import GridSearchCV
 
##Loading dataset naming and extracting useful parameters
data = load_boston()
dataf = pd.DataFrame(data.data, columns=data.feature_names)
medv = data.target
data = dataf[['RM', 'LSTAT', 'PTRATIO']]


 ##Creating function with mean squared error method to provide performance metric for predictions
def performance_metric(y_true, y_predict):
    
 error = metrics.mean_squared_error(y_true, y_predict)
 
 return error
 ##Creating the function for use in the regressor
def fit_model(data, target):
 regressor = DecisionTreeRegressor()
 
 param_grid = {'max_depth':(1,2,3)}
 
 score_function = metrics.make_scorer(performance_metric, False)
 
 reg = GridSearchCV(regressor, param_grid, scoring = score_function, cv = 3)
 
 reg.fit(data, target)
 
 return reg.best_estimator_
 ##Train and Test dataset,then input client parameter for prediction
boston = load_boston()

X_train, X_test, y_train, y_test = model_selection.train_test_split(boston.data, boston.target, test_size=0.3, random_state=42)

regression = fit_model(X_train, y_train)

#CRIM, ZN, INDUS, CHAS, NOX, RM, AGE, DIS, RAD, TAX, PTRATIO, B, LSTAT
client = [[11.95, 0.00, 18.100, 0, 0.6590, 5.6090, 90.00, 1.385, 24, 680.0, 20.20, 332.09, 12.13]]

predict_house = regression.predict(client)[0]
 
print("The value predicted for the client's home: {0:.2f}".format(predict_house), "(No Feature Selection)")
 
#print(data.head()) keep 'RM', 'LSTAT', 'PTRATIO'
##Train and test dataset then run it through the fit_model function i created. then make predictions
X_train_f, X_test_f, y_train_f, y_test_f = model_selection.train_test_split(data, medv, test_size=0.3, random_state=42)
regression_f = fit_model(X_train_f, y_train_f)
client = [[5.6090, 12.13, 20.20]]
predict_house2 = regression_f.predict(client)[0]
print("New Value Predicted for client's home: {0:.2f}".format(predict_house2), "(Features Selected)")
print()
 ##Below i fulfill the parameters for visualising
y_pred = regression.predict(X_test)
plt.figure()
plt.title("Decision Tree Regressor (Model Actual vs Precited) without the selected features")
plt.xlabel('TEST SET')
plt.ylabel('MEDV')
plt.plot(y_pred, 'o-', color="b", label="Predicted MEDV")
plt.plot(y_test, 'o-', color="y", label="Actual MEDV")
 
y_pred_f = regression_f.predict(X_test_f)
plt.figure()
plt.title("Decision Tree Regressor (Model Actual vs Precited) with the Selected Features")
plt.xlabel('TEST SET')
plt.ylabel('MEDV')
plt.plot(y_pred_f, 'o-', color="r", label="Predicted MEDV")
plt.plot(y_test_f, 'o-', color="b", label="Actual MEDV")