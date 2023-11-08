
pragma solidity ^0.8.0;

contract StudentData{
    struct Student {
        string name;
        uint8 age;
        string dept;
    }

    Student[] public students;
    
    function addStudent(string memory _name,uint8 _age,string memory _dept) public {
        Student memory newStudent=Student(_name,_age,_dept);
        students.push(newStudent);
    }           //write

    function getStudentCount() public view returns  (uint) {
        return students.length;
    }

    function getStudent(uint index) public view returns (string memory, uint ,string memory) {
        Student memory bacche= students[index];
        return(bacche.name,bacche.age,bacche.dept);
    }   //read

    //Fallback
    receive() external payable{
        //a function that does not exist
        addStudent("XYZ",22,"CS");
    }
}


