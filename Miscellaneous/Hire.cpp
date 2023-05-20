#include "Employee.cpp"
#include <fstream> //for input and output read/write file operation
#include <vector>  //to hold the data from the file
#include <sstream>  //stringstream


int main() {
    Employee employee(118200044,"Uğur","Horasan","CMPE",8000);
    ifstream in("Employee.csv");  //to read the file

    string line, field;

    vector<vector<string> > array;  //the 2D array
    vector<string> v;                //array of values for one line only

    while (getline(in,line) ) {  //get next line in file
        v.clear();
        stringstream ss(line);

        while (getline(ss,field,',')) {  //break line into comma delimitted fields
        
            v.push_back(field);  //add each field to the 1D array
        }

        array.push_back(v);  //add the 1D array to the 2D array
    }

   string name, lastName, departmant;  //From user
   int id, wage;   //From user
   bool ifExist;   //If the given name exist on the csv
   int trueIndex;  //the row index of the given name if it exists
   cout<<"Enter a Employee name: ";
   cin>>name;  //given by the user
   //searches if the given name exists on the csv; if it does, ifExist become true and holds the index(row)
   for(int i=1; i<11; i++) {   
       if(array[i][1] == name) {
           ifExist = true;
           trueIndex = i;
       }
   }

   //If the given name exists, search with the help of trueIndex
   if(ifExist==true) { 
       if(array[trueIndex][5] == "Yes") {  //If he/she is hired, notify
           cout<<"The Employee "<<name<<" had already been hired.";
       }
       //if he/she is not hired, make the hired part "Yes" on vector, notify and clear the csv before re-writing from the vector
       else {   
           array[trueIndex][5] = "Yes";
           cout<<"The Employee "<<name<<" is hired now.";
           ofstream myfile;
           myfile.open("Employee.csv");
           myfile.clear();
           for(int i=0; i<11; i++) {  //re-writing with comma
           myfile <<array[i][0]<<","<<array[i][1]<<","<<array[i][2]<<","<<array[i][3]<<","<<array[i][4]<<","<<array[i][5]<<endl; 
           }
           myfile.close();
       }
   }
   else if(ifExist==false) {  //if the name given by user does not exist, takes other properties from the user and adds it to the csv with clearing 
       cout<<"Enter a lastName : ";
       cin>>lastName;
       cout<<"Enter an id: ";
       cin>>id;
       cout<<"Enter a departmant : ";
       cin>>departmant;
       cout<<"Enter a wage : ";
       cin>>wage;
       ofstream myfile;
       myfile.open("Employee.csv"); 
       myfile.clear();
       for(int i=0; i<11; i++) {   //Uses the vector to write to the csv
       myfile <<array[i][0]<<","<<array[i][1]<<","<<array[i][2]<<","<<array[i][3]<<","<<array[i][4]<<","<<array[i][5]<<endl;
       }
       myfile <<id<<","<<name<<","<<lastName<<","<<departmant<<","<<wage<<","<<"Yes"<<endl;  //then writes the new Employee
       myfile.close();
   }
}