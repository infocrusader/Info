#include <iostream>
#include <string>
using namespace std;

class Employee {
    private:  //private properties
    string eName, eLastName, eDepartment;
        int eId, eHourlyWage;
        
    public:  //public overloaded constructors, setters-getters and show(toString)
        Employee(){}
        Employee(int eId, string eName, string eLastName, string eDepartment, int eHourlyWage) {
            this->eId=eId;
            this->eName=eName;
            this->eLastName=eLastName;
            this->eDepartment=eDepartment;
            this->eHourlyWage=eHourlyWage;
        }
    void setEId(int x) {
        this->eId=x;
    }
    int getEId() {
        return this->eId;
    }
    void setEHourlyWage(int x) {
        this->eHourlyWage=x;
    }
    int getEHourlyWage() {
        return this->eHourlyWage;
    }
    void setEName(string x) {
        this->eName=x;
    }
    string getEName() {
        return this->eName;
    }
    void setELastName(string x) {
        this->eLastName=x;
    }
    string getELastName() {
        return this->eLastName;
    }
    void setEDepartment(string x) {
        this->eDepartment=x;
    }
    string getEDepartment() {
        return this->eDepartment;
    }

    void show() {   
        cout<<"Id is "<<this->eId<<", Name is "<<this->eName<<", LastName is "<<this->eLastName<<", Department is "<<this->eDepartment
        <<", HourlyWage is "<<this->eHourlyWage;
    }
};