import axios from 'axios';

const USER_API_BASE_URL = 'http://127.0.0.1:8085/employee';

class ApiService {


    addEmployee(employee) {
        let axiosConfig = {
            headers: {
                'method': 'POST',
                'Content-Type':'application/json;charset=UTF-8',
                'Access-Control-Allow-Origin': "*",

            }
        };
        return axios.post(USER_API_BASE_URL+'/addEmployee', employee,axiosConfig);
    }


    fetchEmployees() {
        return axios.get(USER_API_BASE_URL+'/getEmployeeList');
    }

    fetchEmployeeById(employeeId) {
        return axios.get(USER_API_BASE_URL + '/' + employeeId);
    }

    deleteEmployee(employeeId) {
        let axiosConfig = {
            headers: {
                'method': 'POST',
                'Content-Type':'application/json;charset=UTF-8',
                'Access-Control-Allow-Origin': "*",

            }
        };
        return axios.post(USER_API_BASE_URL + '/deleteEmployee' , employeeId,axiosConfig);
    }

    editEmployee(employee) {
        return axios.put(USER_API_BASE_URL + '/' + employee.employeeId, employee);
    }


}

export default new ApiService();