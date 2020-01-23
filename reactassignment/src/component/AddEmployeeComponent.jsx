import React, { Component } from 'react'
import ApiService from "../service/ApiService";

class AddEmployeeComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            employeeId: '',
            firstName: '',
            lastName: '',
            email: '',
            hireDate: '',
            phoneNumber: '',
            salary: '',
            department: null,
            message: ''
        }
        this.saveEmployee = this.saveEmployee.bind(this);
    }


    goToEmployeeList = (event) => {
        this.props.history.push('/employee-list');
    }

    validateData = (e) => {
        let validDate  = true;
        let errorMsg = "";

        let firstName = this.state.firstName;
        if (firstName == null || firstName.trim() == "") {
           // alert("Plz Enter firstName");
            errorMsg = <strong style={{color: "red"}}>Plz Enter firstName</strong>;
            this.setState({message: errorMsg});
            return false;
        } else if (firstName != null && firstName.length <= 2) {
            // alert("Plz Enter lastName");
            errorMsg = <strong style={{color: "red"}}>First name should be more than 2 character</strong>;
            this.setState({message: errorMsg});
            return false;
        }

        let lastName = this.state.lastName;
        if (lastName == null || lastName.trim() == "") {
           // alert("Plz Enter lastName");
            errorMsg = <strong style={{color: "red"}}>Plz Enter lastName</strong>;
            this.setState({message: errorMsg});
            return false;
        } else if (lastName != null && lastName.length <= 2) {
            // alert("Plz Enter lastName");
            errorMsg = <strong style={{color: "red"}}>Last name should be more than 2 character</strong>;
            this.setState({message: errorMsg});
            return false;
        }

        let eMail = this.state.email;
        if (eMail == null || eMail.trim() == "" ) {
          //  alert("Plz Enter  eMail");
            errorMsg = <strong style={{color: "red"}}>Plz Enter eMail</strong>;
            this.setState({message: errorMsg});
            return false;
        }else if(! eMail.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i)){
           // alert("Plz Enter valid eMail");
            errorMsg = <strong style={{color: "red"}}>Email not valid</strong>;
            this.setState({message: errorMsg});
            return false;
        }

        let phoneNum = this.state.phoneNumber;
        if (!Number(phoneNum)) {
            errorMsg = <strong style={{color: "red"}}>Phone should be a number</strong>;
            this.setState({message: errorMsg});
            return false;
        }

        let salary = this.state.salary;
        if (!Number(salary)) {
           // alert("Your salary must be a number");
            errorMsg = <strong style={{color: "red"}}>Salary should be a number</strong>;
            this.setState({message: errorMsg});
            return false;
        }else if (salary <= 0){
            errorMsg = <strong style={{color: "red"}}>Salary should be grater than 0 </strong>;
            this.setState({message: errorMsg});
            return false;
        }

        return validDate;
    }

    saveEmployee = (e) => {
        e.preventDefault();
        let employee = {employeeId: this.state.employeeId,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            hireDate: this.state.hireDate,
            phoneNumber: this.state.phoneNumber,
            salary: this.state.salary};
        if(this.validateData(e)){
            let msg =  <strong style={{color: "green"}}>Employee added successfully</strong>;
            ApiService.addEmployee(employee)
                .then(res => {
                    this.setState({message : msg});
                    this.props.history.push('/employee-list');
                });
        }

    }

    handleSelectChange = (event) => {
        this.setState({
            department: event.target.value
        })
    }

    onChange = (e) =>   this.setState({ [e.target.name]: e.target.value });

    render() {
        return(
            <div>
                <h2 className="text-center">Add User</h2>
                <form>
                    <div>{this.state.message}</div>
                    <div className="form-group">
                        <label>First Name:</label>
                        <input type="text" placeholder="First Name" name="firstName" className="form-control" value={this.state.firstName} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Last Name:</label>
                        <input type="text" placeholder="Last Name" name="lastName" className="form-control" value={this.state.lastName} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Email:</label>
                        <input placeholder="email" name="email" className="form-control" value={this.state.email} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Hire Date:</label>
                        <input type="date" placeholder="hire Date" name="hireDate" className="form-control" value={this.state.hireDate} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Phone Number:</label>
                        <input placeholder="Phone Number" name="phoneNumber" className="form-control" value={this.state.phoneNumber} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Salary:</label>
                        <input type="number" placeholder="salary" name="salary" className="form-control" value={this.state.salary} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Department:</label>
                        <select value={this.state.department} onClick={this.handleSelectChange}>
                            <option value="1">Dep1</option>
                            <option value="2" >Dep2</option>
                            <option value="3">Dep3</option>
                        </select>
                    </div>

                    <button className="btn btn-success" onClick={this.saveEmployee}>Save</button>
                    <button className="btn btn-success" onClick={this.goToEmployeeList}>Back</button>
                </form>
            </div>
        );
    }
}

export default AddEmployeeComponent;