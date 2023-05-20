#include "Employee.cpp"
#include <fstream> //This library will allow for input and output file operation
#include <vector>  //This will retrieve the data from the file
#include <sstream>  


int main() {
    Employee employee(13466534242,"James","Bond","double-o-7",3657);

    ifstream readin("Employee.csv");  //This function allows us to read the file

    string column, efield;

    vector<string> s;                //This will be the array of values for only one column

    vector<vector<string> > array;  //this will be the  two dimensional array array

    

    while (getline(readin,column) ) {  //This will the get next line in the file
        s.clear();

        stringstream ss(column);

        while (getline(ss,efield,',')) {  //This will break the line into comma fixed fields
        
            s.push_back(efield);  //This function will add each field to the one dimensional array array
        }

        array.push_back(s);  //This will merge the one-D array to the two-D array
    }

   string name,department, lastName;  
   int id, wage;   
   
   int count;  //This will hold the row index of the name, given that it is in the file

   bool check;   //This will allow us check if the given name exists in the file

   cout<<"Enter a Employee name: ";//output message asking user for data

   cin>>name;  //Allows for input of data from user

   //The if function searches the given name on the file; if it does, check returns true and holds the row index
   for(int i=1; i<11; i++) { 

       if(array[i][1] == name) {
           check = true;
           count = i;
       }
   }

   //This will check if the given name exists
   if(check==true) { 
       if(array[count][5] == "Yes") {  //This will notify user if employee already exists

           cout<<"This Employee "<<name<<" already works for the company.";
       }
       //This will make the hired part "Yes" in the vector then notify and clear the csv before re-writing from the vector,given that employee is not hired
       else { 
             ofstream file;
           array[count][5] = "Yes";
           cout<<"This Employee "<<name<<" has benn hired.";
           
           file.open("Employee.csv");
           file.clear();
           for(int i=0; i<11; i++) {  

           file <<array[i][0]<<","<<array[i][1]<<","<<array[i][2]<<","<<array[i][3]<<","<<array[i][4]<<","<<array[i][5]<<endl; 
           }
           file.close();
       }
   }
   else if(check==false) {  //if the name given by user does not exist, takes other properties from the user and adds it to the csv with clearing 
       cout<<"Enter lastName : ";

       cin>>lastName;

       cout<<"Enter id: ";

       cin>>id;

       cout<<"Enter department : ";

       cin>>department;

       cout<<"Enter wage : ";

       cin>>wage;

       ofstream file;

       file.open("Employee.csv"); 
       file.clear();
       for(int i=0; i<11; i++) {   //For loop initiates the use of the vector to write to the csv
       file <<array[i][0]<<","<<array[i][1]<<","<<array[i][2]<<","<<array[i][3]<<","<<array[i][4]<<","<<array[i][5]<<endl;
       }
       file <<id<<","<<name<<","<<lastName<<","<<department<<","<<wage<<","<<"Yes"<<endl;  //then writes the new Employee
       file.close();
   }
}